package jotan.geoglyph;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import jotan.geoglyph.convert.Block_Color_Convert;
import jotan.geoglyph.convert.Block_Color_Convert.Block_Color_Target_Data;
import jotan.geoglyph.convert.Block_Color_Define.Block_Color;
import jotan.geoglyph.convert.Block_Color_Define.Block_Type;
import jotan.geoglyph.convert.Image_Convert;
import jotan.geoglyph.convert.Image_Convert.Block_Data;
import jotan.geoglyph.convert.Image_Convert.GeoglyphDirection;
import jotan.geoglyph.convert.Image_Convert.Place_Speed;
import jotan.geoglyph.convert.Image_Convert_Minecraft;

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


	public static HashMap<UUID,List<Block_Data>> geoglyph_data = new HashMap<UUID,List<Block_Data>>();
	public static HashMap<UUID,Place_Speed> place_speed_uuid = new HashMap<>();

	public static HashMap<UUID,Integer> data_ready_repeat_id = new HashMap<UUID,Integer>();
	public static HashMap<UUID,Integer> block_place_id = new HashMap<UUID,Integer>();

	public static void reset_variables(Player p) {
		block_place_id.remove(p.getUniqueId());
		geoglyph_data.remove(p.getUniqueId());
		place_speed_uuid.remove(p.getUniqueId());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = new ArrayList<String>();
		if(!command.getName().equalsIgnoreCase("geoglyph")) return null;

		if(args.length == 1) {
			if("gen".startsWith(args[0].toLowerCase())) list.add("gen");
			if("gen_mono".startsWith(args[0].toLowerCase())) list.add("gen_mono");
			if("cancel".startsWith(args[0].toLowerCase())) list.add("cancel");
			if("near_block".startsWith(args[0].toLowerCase())) list.add("near_block");

		}else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(Block_Type bt : Block_Type.values()){
					if(bt.toString().startsWith(args[1].toUpperCase())) list.add(bt.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[R]");
			}else if(args[0].equalsIgnoreCase("gen_mono")) {
				list.add("[Resize %]");
			}
		}else if(args.length == 3) {
			if(args[0].equalsIgnoreCase("gen")) {
				list.add("[Resize %]");
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[G]");
			}else if(args[0].equalsIgnoreCase("gen_mono")) {
				for(GeoglyphDirection gd : GeoglyphDirection.values()){
					if(gd.toString().startsWith(args[2].toUpperCase())) list.add(gd.toString());
				}
			}
		}else if(args.length == 4) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(GeoglyphDirection gd : GeoglyphDirection.values()){
					if(gd.toString().startsWith(args[3].toUpperCase())) list.add(gd.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[B]");
			}else if(args[0].equalsIgnoreCase("gen_mono")) {
				for(Place_Speed gd : Place_Speed.values()){
					if(gd.toString().startsWith(args[3].toUpperCase())) list.add(gd.toString());
				}
			}
		}else if(args.length == 5) {
			if(args[0].equalsIgnoreCase("gen")) {
				for(Place_Speed gd : Place_Speed.values()){
					if(gd.toString().startsWith(args[4].toUpperCase())) list.add(gd.toString());
				}
			}else if(args[0].equalsIgnoreCase("near_block")) {
				list.add("[0~" + String.valueOf(Block_Color.values().length-1) + "]");
			}else if(args[0].equalsIgnoreCase("gen_mono")) {
				list.add("[URL]");
			}
		}else if(args.length == 6) {
			if(args[0].equalsIgnoreCase("gen")) {
				list.add("[URL]");
			}
		}

		return list;
	}

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

				Main.sendMessage(p,"Image conversion start.");

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
						Main.sendMessage(p,ChatColor.RED + "Unkown type : " + block_type);
						Main.geoglyph_data.remove(p.getUniqueId());
						return true;
					}
					if(block_type.startsWith("!")) bt.remove(btx);
					else bt.add(btx);
				}

				double rate=1;
				try {
					rate = Double.parseDouble(args[2])/100;
					if(rate < 0) {
						Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[2]);
						Main.geoglyph_data.remove(p.getUniqueId());
						return true;
					}
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[2]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				GeoglyphDirection direction = GeoglyphDirection.HORIZONTAL;
				try {
					direction = GeoglyphDirection.valueOf(args[3].toUpperCase());
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[3]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				Place_Speed speed = Place_Speed.MIDDLE;
				try {
					speed = Place_Speed.valueOf(args[4].toUpperCase());
					Main.place_speed_uuid.put(p.getUniqueId(), speed);
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[4]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				BufferedImage image = Image_Convert.get_Image_from_URL(args[5]);
				if(image==null) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[5]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				Image_Convert_Minecraft.convert_Image_command(p, image, rate, Block_Color_Convert.get_Block_Color(bt), direction);

				int repeat_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						if(geoglyph_data.get(p.getUniqueId()).size() > 0) {
							plugin.getLogger().info("Started Geoglyph task for " + p.getName() + ".");
							sendMessage(p,"Start placing blocks.");
							Bukkit.getScheduler().cancelTask(data_ready_repeat_id.get(p.getUniqueId()));
							Image_Convert_Minecraft.place_geoglyph(p,true,place_speed_uuid.get(p.getUniqueId()));
						}else if(geoglyph_data.get(p.getUniqueId()) == null) {
							Bukkit.getScheduler().cancelTask(data_ready_repeat_id.get(p.getUniqueId()));
							sendMessage(p,ChatColor.RED + "Due to error, the block placing task was canceled.");
							reset_variables(p);
						}
					}


				}, 0, 20);

				data_ready_repeat_id.put(p.getUniqueId(), repeat_id);
			}else if(args[0].equalsIgnoreCase("gen_mono")) {
				if(geoglyph_data.containsKey(p.getUniqueId())) {
					sendMessage(p,ChatColor.RED + "Sorry.Your queue is on running.");
					sendMessage(p,ChatColor.RED + "Please wait until its end.");
					return true;
				}

				geoglyph_data.put(p.getUniqueId(), new ArrayList<Block_Data>());

				Main.sendMessage(p,"Image conversion start.");
				double rate=1;
				try {
					rate = Double.parseDouble(args[1])/100;
					if(rate < 0) {
						Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[1]);
						Main.geoglyph_data.remove(p.getUniqueId());
						return true;
					}
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[1]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				GeoglyphDirection direction = GeoglyphDirection.HORIZONTAL;
				try {
					direction = GeoglyphDirection.valueOf(args[2].toUpperCase());
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[2]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				Place_Speed speed = Place_Speed.MIDDLE;
				try {
					speed = Place_Speed.valueOf(args[3].toUpperCase());
					Main.place_speed_uuid.put(p.getUniqueId(), speed);
				}catch(Exception e) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[3]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				BufferedImage image = Image_Convert.get_Image_from_URL(args[4]);
				if(image==null) {
					Main.sendMessage(p,ChatColor.RED + "Invalid value : " + args[4]);
					Main.geoglyph_data.remove(p.getUniqueId());
					return true;
				}

				Image_Convert_Minecraft.convert_Image_command(p, image, rate, new ArrayList<Block_Color>(Arrays.asList(Block_Color.BLACK_CONCRETE,Block_Color.WHITE_CONCRETE)), direction);

				int repeat_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						if(geoglyph_data.get(p.getUniqueId()).size() > 0) {
							plugin.getLogger().info("Started Geoglyph task for " + p.getName() + ".");
							sendMessage(p,"Start placing blocks.");
							Bukkit.getScheduler().cancelTask(data_ready_repeat_id.get(p.getUniqueId()));
							Image_Convert_Minecraft.place_geoglyph(p,true,place_speed_uuid.get(p.getUniqueId()));
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

				List<Block_Color_Target_Data> near_block = Block_Color_Convert.get_from_Near(new Color(r,g,b));
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
