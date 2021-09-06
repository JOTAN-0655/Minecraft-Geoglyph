package jotan.geoglyph.convert;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jotan.geoglyph.convert.Block_Color_Define.Block_Color;
import jotan.geoglyph.convert.Block_Color_Define.Block_Type;

public class Block_Color_Convert {

	public static class Block_Color_Target_Data{
		private Block_Color block_color;
		private Color target_color;
		Block_Color_Target_Data(Block_Color bc,Color col){
			block_color = bc;
			target_color = col;
		}

		public Block_Color getBlock_color() {
			return block_color;
		}
		public void setBlock_color(Block_Color block_color) {
			this.block_color = block_color;
		}

		public Color getTarget_color() {
			return target_color;
		}
		public void setTarget_color(Color target_color) {
			this.target_color = target_color;
		}

		//difference with target_color
		public int get_Diff_R() {
			return block_color.getR() - target_color.getRed();
		}
		public int get_Diff_G() {
			return block_color.getG() - target_color.getGreen();
		}
		public int get_Diff_B() {
			return block_color.getB() - target_color.getBlue();
		}
		public int get_Diff_Dist() {
			return get_Diff_R()*get_Diff_R() + get_Diff_G()*get_Diff_G() + get_Diff_B()*get_Diff_B();
		}

		public static List<Block_Color_Target_Data> get_from_Near(Color col){
			List<Block_Color_Target_Data> list = new ArrayList<Block_Color_Target_Data>();
			List<Block_Color> choose = new ArrayList<Block_Color>(Arrays.asList(Block_Color.values()));

			while(true) {
				Block_Color_Target_Data sel = null;
				for(Block_Color bl : choose) {
					Block_Color_Target_Data bl_data = new Block_Color_Target_Data(bl,col);
					if(sel == null) {
						sel = bl_data;
						continue;
					}
					if(sel.get_Diff_Dist() > bl_data.get_Diff_Dist()) {
						sel = bl_data;
					}
				}
				list.add(sel);
				choose.remove(sel.getBlock_color());
				if(choose.size() == 0) break;
			}

			return list;
		}

		public static Block_Color_Target_Data get_Most_Near(Color col,List<Block_Type> filter) {
			Block_Color_Target_Data sel = new Block_Color_Target_Data(Block_Color.ACACIA_LOG,col);
			for(Block_Color bc : Block_Color.values()) {
				Block_Color_Target_Data comp = new Block_Color_Target_Data(bc,col);
				if(filter!=null) {
					if(!filter.contains(bc.getType())) continue;
				}
				if(comp.get_Diff_Dist() < sel.get_Diff_Dist()) sel = comp;
			}
			return sel;
		}
	}

}
