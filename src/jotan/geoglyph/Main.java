package jotan.geoglyph;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import jotan.geoglyph.convert.Block_Color_Convert.Block_Color_Target_Data;
import jotan.geoglyph.convert.Block_Color_Define.Block_Color;
import jotan.geoglyph.convert.Block_Color_Define.Block_Type;
import jotan.geoglyph.convert.Image_Convert;
import jotan.geoglyph.convert.Image_Convert.Block_Data;
import jotan.geoglyph.convert.Image_Convert.GeoglyphDirection;
import jotan.geoglyph.convert.Image_Convert.Place_Speed;

public class Main extends JavaPlugin implements Listener{

	static Main plugin;
	public static Main getInstance() {
		return plugin;
	}

	@Override
	public void onEnable() {
		plugin = this;
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("Enabled Minecraft Geoglyph");
	}

	public static void sendMessage(Player p,String message) {
		p.sendMessage("[" + ChatColor.GREEN + "Minecraft" + ChatColor.YELLOW + "Geoglyph" + ChatColor.RESET + "]" + message);
	}


	static HashMap<UUID,List<Block_Data>> geoglyph_data = new HashMap<UUID,List<Block_Data>>();
	static HashMap<UUID,Integer> data_ready_repeat_id = new HashMap<UUID,Integer>();
	static HashMap<UUID,Integer> block_place_id = new HashMap<UUID,Integer>();
	static HashMap<UUID,Place_Speed> place_speed_uuid = new HashMap<>();
	public static void reset_variables(Player p) {
		block_place_id.remove(p.getUniqueId());
		geoglyph_data.remove(p.getUniqueId());
		place_speed_uuid.remove(p.getUniqueId());
	}

	public static void place_geoglyph(Player p,Boolean send_message,Place_Speed speed) {
		Location p_loc = p.getLocation();
		int task_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				int blocks = speed.getSpeed();
				List<Block_Data> block_data = geoglyph_data.get(p.getUniqueId());
				if(blocks == -1) blocks = block_data.size();
				for(int i = 0; i < blocks;i++) {
					if(block_data.size() == 0) {
						Bukkit.getScheduler().cancelTask(block_place_id.get(p.getUniqueId()));
						reset_variables(p);
						plugin.getLogger().info("Geoglyph task for " + p.getName() + " end.");
						Player message=Bukkit.getServer().getPlayer(p.getUniqueId());
						if(message!=null) {
							sendMessage(message,ChatColor.GREEN + "Block placing complete!");
						}

						return;
					}

					Player message=Bukkit.getServer().getPlayer(p.getUniqueId());
					if(message!=null) {
						if(block_data.size() % 1000 == 0) {
							sendMessage(message,"Left blocks : " + ChatColor.GREEN + block_data.size());
						}
					}

					Location block_loc;
					Block_Data bd = block_data.get(0);
					block_loc=p_loc.clone().add(bd.getX(), bd.getY(), bd.getZ());
					Block bl = p.getWorld().getBlockAt(block_loc);
					BlockState state = bl.getState();
					state.setType(bd.getMaterial());
					state.update(true);

					block_data.remove(0);
				}
			}

		}, 0, 1);


		block_place_id.put(p.getUniqueId(), task_id);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = new ArrayList<String>();
		if(!command.getName().equalsIgnoreCase("geoglyph")) return null;

		if(args.length == 1) {
			if("gen".startsWith(args[0].toLowerCase())) list.add("gen");
			if("cancel".startsWith(args[0].toLowerCase())) list.add("cancel");
			if("near_block".startsWith(args[0].toLowerCase())) list.add("near_block");

		}else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(Block_Type bt : Block_Type.values()){
					if(bt.toString().startsWith(args[1].toUpperCase())) list.add(bt.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[R]");
			}
		}else if(args.length == 3) {
			if(args[0].equalsIgnoreCase("gen")) {
				list.add("[Resize %]");
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[G]");
			}
		}else if(args.length == 4) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(GeoglyphDirection gd : GeoglyphDirection.values()){
					if(gd.toString().startsWith(args[3].toUpperCase())) list.add(gd.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[B]");
			}
		}else if(args.length == 5) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(Place_Speed gd : Place_Speed.values()){
					if(gd.toString().startsWith(args[4].toUpperCase())) list.add(gd.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[0~" + String.valueOf(Block_Color.values().length-1) + "]");
			}
		}else if(args.length == 6) {
			if(args[0].equalsIgnoreCase("gen")) {
				list.add("[URL]");
			}
		}

		return list;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player == false) return true;
		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("geoglyph")) {
			if(args.length == 0) {
				sendMessage(p,ChatColor.RED + "You must enter the URL of image");
				return true;
			}

			if(args[0].equalsIgnoreCase("cancel")) {
				if(geoglyph_data.get(p.getUniqueId()) == null) {
					sendMessage(p,ChatColor.RED + "You cannnot cancel.There is no queue.");
				}else {
					sendMessage(p,ChatColor.YELLOW + "Block placing canceled!");

					Bukkit.getScheduler().cancelTask(block_place_id.get(p.getUniqueId()));
					reset_variables(p);

				}
			}
			else if(args[0].equalsIgnoreCase("gen")) {
				if(geoglyph_data.containsKey(p.getUniqueId())) {
					sendMessage(p,ChatColor.RED + "Sorry.Your queue is on running.");
					sendMessage(p,ChatColor.RED + "Please wait until its end.");
					return true;
				}

				geoglyph_data.put(p.getUniqueId(), new ArrayList<Block_Data>());

				Bukkit.getScheduler().scheduleAsyncDelayedTask(this, new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						sendMessage(p,"Image conversion start.");

						String[] block_types = args[1].toUpperCase().split(",");
						List<Block_Type> bt = new ArrayList<Block_Type>();
						for(String block_type : block_types) {

							if(block_type.equals("ALL")) {
								for(Block_Type btc : Block_Type.values()) {
									if(btc.equals(Block_Type.ALL)) continue;
									bt.add(btc);
								}
								continue;
							}

							Block_Type btx = Block_Type.valueOf(block_type.toUpperCase().replace("!", ""));
							if(btx==null) {
								sendMessage(p,ChatColor.RED + "Unkown type : " + block_type);
								geoglyph_data.remove(p.getUniqueId());
								return;
							}
							if(block_type.startsWith("!")) bt.remove(btx);
							else bt.add(btx);
						}

						double rate=1;
						try {
							rate = Double.parseDouble(args[2])/100;
							if(rate < 0) {
								sendMessage(p,ChatColor.RED + "Invalid value : " + args[2]);
								geoglyph_data.remove(p.getUniqueId());
								return;
							}
						}catch(Exception e) {
							sendMessage(p,ChatColor.RED + "Invalid value : " + args[2]);
							geoglyph_data.remove(p.getUniqueId());
							return;
						}

						GeoglyphDirection direction = GeoglyphDirection.HORIZONTAL;
						try {
							direction = GeoglyphDirection.valueOf(args[3].toUpperCase());
						}catch(Exception e) {
							sendMessage(p,ChatColor.RED + "Invalid value : " + args[3]);
							geoglyph_data.remove(p.getUniqueId());
							return;
						}

						Place_Speed speed = Place_Speed.MIDDLE;
						try {
							speed = Place_Speed.valueOf(args[4].toUpperCase());
							place_speed_uuid.put(p.getUniqueId(), speed);
						}catch(Exception e) {
							sendMessage(p,ChatColor.RED + "Invalid value : " + args[4]);
							geoglyph_data.remove(p.getUniqueId());
							return;
						}

						BufferedImage image = Image_Convert.get_Image_from_URL(args[5]);
						if(image==null) {
							sendMessage(p,ChatColor.RED + "Invalid value : " + args[5]);
							geoglyph_data.remove(p.getUniqueId());
							return;
						}
						int resize_width = (int)(image.getWidth()*rate);
						int resize_height = (int)(image.getHeight()*rate);

						BufferedImage resized = new BufferedImage(resize_width,resize_height , BufferedImage.TYPE_3BYTE_BGR);

						resized.createGraphics().drawImage(image.getScaledInstance(
								resize_width, resize_height, Image.SCALE_AREA_AVERAGING)
								  ,0, 0, resize_width, resize_height, null);

						image = resized;

						List<Block_Data> block_locations = Image_Convert.convert_Image(image,  bt,direction);
						geoglyph_data.put(p.getUniqueId(), block_locations);
						plugin.getLogger().info("Image conversion task for " + p.getName() + " end.");
						if(p.isValid()) sendMessage(p,"Image conversion end.");
					}


				});

				int repeat_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						if(geoglyph_data.get(p.getUniqueId()).size() > 0) {
							plugin.getLogger().info("Started Geoglyph task for " + p.getName() + ".");
							sendMessage(p,"Start placing blocks.");
							Bukkit.getScheduler().cancelTask(data_ready_repeat_id.get(p.getUniqueId()));
							place_geoglyph(p,true,place_speed_uuid.get(p.getUniqueId()));
						}else if(geoglyph_data.get(p.getUniqueId()) == null) {
							Bukkit.getScheduler().cancelTask(data_ready_repeat_id.get(p.getUniqueId()));
							sendMessage(p,ChatColor.RED + "Due to error, the block placing task was canceled.");
							reset_variables(p);
						}
					}


				}, 0, 20);

				data_ready_repeat_id.put(p.getUniqueId(), repeat_id);
			}else if(args[0].equalsIgnoreCase("near_block")) {
				int r,g,b;
				try {
					r = Integer.parseInt(args[1]);
					g = Integer.parseInt(args[2]);
					b = Integer.parseInt(args[3]);
				}catch(Exception e) {
					sendMessage(p,ChatColor.RED + "Invalid value is contained.");
					return true;
				}

				List<Block_Color_Target_Data> near_block = Block_Color_Target_Data.get_from_Near(new Color(r,g,b));
				int count = near_block.size();
				if(args.length > 4) {
					try {
						count = Integer.parseInt(args[4]);
						if(count < 0) throw new Exception();
						if(count > near_block.size()-1) throw new Exception();
					}catch(Exception e) {
						sendMessage(p,ChatColor.RED + "Invalid value is contained.");
						return true;
					}
				}

				sendMessage(p,"------------Color Table------------");

				for(int i = 0; i < count;i++){
					Block_Color_Target_Data bl = near_block.get(i);
					sendMessage(p, ChatColor.GRAY + "NAME : " + ChatColor.RESET + bl.getBlock_color().getMaterial().toString()
								+ " , " + ChatColor.GRAY + "Diff : "
								+ ChatColor.RED + "R : " + ChatColor.RESET + bl.get_Diff_R() + " , "
								+ ChatColor.GREEN + "G : " + ChatColor.RESET + bl.get_Diff_G() + " , "
								+ ChatColor.BLUE + "B : " + ChatColor.RESET + bl.get_Diff_B());
				}
			}





		}

		return true;
	}

}
