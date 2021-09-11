package jotan.geoglyph.convert;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import jotan.geoglyph.Main;
import jotan.geoglyph.convert.Block_Color_Define.Block_Color;
import jotan.geoglyph.convert.Image_Convert.Block_Data;
import jotan.geoglyph.convert.Image_Convert.GeoglyphDirection;
import jotan.geoglyph.convert.Image_Convert.Place_Speed;

public class Image_Convert_Minecraft {

	@SuppressWarnings("deprecation")
	public static void convert_Image_command(Player p,BufferedImage image,double rate,List<Block_Color> bc,GeoglyphDirection direction) {
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				int resize_width = (int)(image.getWidth()*rate);
				int resize_height = (int)(image.getHeight()*rate);

				BufferedImage resized = new BufferedImage(resize_width,resize_height , BufferedImage.TYPE_3BYTE_BGR);

				resized.createGraphics().drawImage(image.getScaledInstance(
						resize_width, resize_height, Image.SCALE_AREA_AVERAGING)
						  ,0, 0, resize_width, resize_height, null);

				List<Block_Data> block_locations = Image_Convert.convert_Image(resized,  bc,direction);
				Main.geoglyph_data.put(p.getUniqueId(), block_locations);
				Main.getInstance().getLogger().info("Image conversion task for " + p.getName() + " end.");
				if(p.isValid()) Main.sendMessage(p,"Image conversion end.");
			}


		});
	}

	public static void place_geoglyph(Player p,Boolean send_message,Place_Speed speed) {
		Location p_loc = p.getLocation();
		int task_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				int blocks = speed.getSpeed();
				List<Block_Data> block_data = Main.geoglyph_data.get(p.getUniqueId());
				if(blocks == -1) blocks = block_data.size()+1;
				for(int i = 0; i < blocks;i++) {
					if(block_data.size() == 0) {
						Bukkit.getScheduler().cancelTask(Main.block_place_id.get(p.getUniqueId()));
						Main.reset_variables(p);
						Main.getInstance().getLogger().info("Geoglyph task for " + p.getName() + " end.");
						Player message=Bukkit.getServer().getPlayer(p.getUniqueId());
						if(message!=null) {
							Main.sendMessage(message,ChatColor.GREEN + "Block placing complete!");
						}

						return;
					}

					Player message=Bukkit.getServer().getPlayer(p.getUniqueId());
					if(message!=null) {
						if(block_data.size() % 1000 == 0) {
							Main.sendMessage(message,"Left blocks : " + ChatColor.GREEN + block_data.size());
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


		Main.block_place_id.put(p.getUniqueId(), task_id);
	}

}
