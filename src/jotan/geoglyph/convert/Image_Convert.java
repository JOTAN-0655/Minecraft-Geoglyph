package jotan.geoglyph.convert;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.bukkit.Material;

import jotan.geoglyph.Main;
import jotan.geoglyph.convert.Block_Color_Convert.Block_Color_Target_Data;
import jotan.geoglyph.convert.Block_Color_Define.Block_Color;
import jotan.geoglyph.convert.Block_Color_Define.Block_Type;

public class Image_Convert {

	public enum GeoglyphDirection{
		HORIZONTAL,VERTICAL,DIAGONAL
	}

	public enum Place_Speed{
		VERY_SLOW(1),SLOW(5),MIDDLE(10),FAST(20),VERY_FAST(40),ULTRA_FAST(100),INSTANT(-1);

		final int speed;
		Place_Speed(int i) {
			speed=i;
		}
		public int getSpeed() {
			return speed;
		}
	}

	public static class Block_Data{
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public Material getMaterial() {
			return material;
		}
		public void setMaterial(Material material) {
			this.material = material;
		}
		private int x;
		private int y;
		private int z;
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		private Material material;
	}

	public static List<Block_Data> convert_Image(BufferedImage image,List<Block_Type> bt,GeoglyphDirection direction){
		List<Block_Data> data = new ArrayList<Block_Data>();

		for(int y = 0; y < image.getHeight();y++) { for(int x = 0; x < image.getWidth();x++) {

			Block_Color bc = Block_Color.RED_CONCRETE;
			try {
				bc = get_Image_Color(image, x, y,bt);
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			Block_Data bd = new Block_Data();
			bd.setX(x);
			switch(direction) {
			case HORIZONTAL:
				bd.setZ(y);
				break;
			case DIAGONAL:
				bd.setZ(y);
				bd.setY(-y);
				break;
			default:
				bd.setY(-y);
				break;
			}
			bd.setMaterial(bc.getMaterial());
			data.add(bd);

			Block_Data base = new Block_Data();
			base.setX(x);
			base.setZ(y);
			base.setY(bd.getY()-1);
			base.setMaterial(Material.STONE);
			data.add(base);

		}}

		return data;
	}

	public static BufferedImage get_Image_from_URL(String urlx) {
        try
        {
            URL url = new URL(urlx);
            BufferedImage image = ImageIO.read(url);

            return image;

            //If successful, process the message
        } catch (Exception e) {
            e.printStackTrace();

            Main.getInstance().getLogger().severe("SORRY. This image cannot be handled. : " + urlx);

            return null;
        }
	}

	public static int clamp_Range(int x) {
		int r = x;
		if(r<0) r=0;
		if(r>255) r=255;
		return r;
	}
	public static Color error_diffuse_Color(Block_Color_Target_Data data,Color col,double mul) {
		int r = (int) (col.getRed() - data.get_Diff_R()*mul);
		int g = (int) (col.getGreen() - data.get_Diff_G()*mul);
		int b = (int) (col.getBlue() - data.get_Diff_B()*mul);
		r=clamp_Range(r);
		g=clamp_Range(g);
		b=clamp_Range(b);

		return new Color(r,g,b);
	}

	public static Block_Color get_Image_Color(BufferedImage original,int x ,int y,List<Block_Type> bt) throws NoSuchAlgorithmException
    {
		Color pixel_color = new Color(original.getRGB(x, y));

		Block_Color_Target_Data near = Block_Color_Target_Data.get_Most_Near(pixel_color, bt);

		if(original.getWidth() > x + 1 && original.getHeight() > y)
			original.setRGB(x+1, y, error_diffuse_Color(near,new Color(original.getRGB(x+1, y)),7.0/16.0).getRGB());
		if(original.getWidth() > x && original.getHeight() > y + 1)
			original.setRGB(x, y+1, error_diffuse_Color(near,new Color(original.getRGB(x, y+1)),5.0/16.0).getRGB());
		if(original.getWidth() > x + 1 && original.getHeight() > y + 1)
			original.setRGB(x+1, y+1, error_diffuse_Color(near,new Color(original.getRGB(x+1, y+1)),3.0/16.0).getRGB());
		if(0 <= x - 1 && original.getHeight() > y + 1)
			original.setRGB(x-1, y+1, error_diffuse_Color(near,new Color(original.getRGB(x-1, y+1)),1.0/16.0).getRGB());
		return near.getBlock_color();

    }

}
