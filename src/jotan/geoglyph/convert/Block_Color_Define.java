package jotan.geoglyph.convert;

import java.awt.Color;

import org.bukkit.Material;

public class Block_Color_Define {

	public enum Block_Type{
		WOOL,CONCRETE,CONCRETE_POWDER,TERRACOTTA,
		STONE,DIRT,
		PLANKS,ORE,
		WOOD,SAND,
		SPONGE,
		PURPUR,MARINE,
		DECORATION,
		SHULKER_BOX,GLAZED_TERRACOTTA,
		REDSTONE,

		OTHERS,ALL;
	}

	public enum Block_Color{

		//CONCRETE DEFINE
		WHITE_CONCRETE(0xf9ffff,Material.WHITE_CONCRETE,Block_Type.CONCRETE),
		LIGHT_GRAY_CONCRETE(0x9c9d97,Material.LIGHT_GRAY_CONCRETE,Block_Type.CONCRETE),
		GRAY_CONCRETE(0x474f52,Material.GRAY_CONCRETE,Block_Type.CONCRETE),
		BLACK_CONCRETE(0x1d1c21,Material.BLACK_CONCRETE,Block_Type.CONCRETE),
		YELLOW_CONCRETE(0xffd83d,Material.YELLOW_CONCRETE,Block_Type.CONCRETE),
		ORANGE_CONCRETE(0xf9801d,Material.ORANGE_CONCRETE,Block_Type.CONCRETE),
		RED_CONCRETE(0xb02e26,Material.RED_CONCRETE,Block_Type.CONCRETE),
		BROWN_CONCRETE(0x825432,Material.BROWN_CONCRETE,Block_Type.CONCRETE),
		LIME_CONCRETE(0x80c71f,Material.LIME_CONCRETE,Block_Type.CONCRETE),
		GREEN_CONCRETE(0x5d7c15,Material.GREEN_CONCRETE,Block_Type.CONCRETE),
		LIGHT_BLUE_CONCRETE(0x3ab3da,Material.LIGHT_BLUE_CONCRETE,Block_Type.CONCRETE),
		CYAN_CONCRETE(0x169c9d,Material.CYAN_CONCRETE,Block_Type.CONCRETE),
		BLUE_CONCRETE(0x3c44a9,Material.BLUE_CONCRETE,Block_Type.CONCRETE),
		PINK_CONCRETE(0xf38caa,Material.PINK_CONCRETE,Block_Type.CONCRETE),
		MAGENTA_CONCRETE(0xc64fbd,Material.MAGENTA_CONCRETE,Block_Type.CONCRETE),
		PURPLE_CONCRETE(0x8932b7,Material.PURPLE_CONCRETE,Block_Type.CONCRETE),

		//CONCRETE POWDER
		WHITE_CONCRETE_POWDER(0xd3d4d5,Material.WHITE_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		LIGHT_GRAY_CONCRETE_POWDER(0x8f8f89,Material.LIGHT_GRAY_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		GRAY_CONCRETE_POWDER(0x474b4f,Material.GRAY_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		BLACK_CONCRETE_POWDER(0x17191e,Material.BLACK_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		YELLOW_CONCRETE_POWDER(0xd9ba34,Material.YELLOW_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		ORANGE_CONCRETE_POWDER(0xd37a1d,Material.ORANGE_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		RED_CONCRETE_POWDER(0x9d322f,Material.RED_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		BROWN_CONCRETE_POWDER(0x734e31,Material.BROWN_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		LIME_CONCRETE_POWDER(0x74b027,Material.LIME_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		GREEN_CONCRETE_POWDER(0x596d29,Material.GREEN_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		LIGHT_BLUE_CONCRETE_POWDER(0x46a9c7,Material.LIGHT_BLUE_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		CYAN_CONCRETE_POWDER(0x228a92,Material.CYAN_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		BLUE_CONCRETE_POWDER(0x41449b,Material.BLUE_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		PINK_CONCRETE_POWDER(0xd58fa9,Material.PINK_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		MAGENTA_CONCRETE_POWDER(0xb34dab,Material.MAGENTA_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),
		PURPLE_CONCRETE_POWDER(0x7834a4,Material.PURPLE_CONCRETE_POWDER,Block_Type.CONCRETE_POWDER),

		//WOOL DEFINE
		WHITE_WOOL(0xd9dbdc,Material.WHITE_WOOL,Block_Type.WOOL),
		LIGHT_GRAY_WOOL(0x84847d,Material.LIGHT_GRAY_WOOL,Block_Type.WOOL),
		GRAY_WOOL(0x3a3f42,Material.GRAY_WOOL,Block_Type.WOOL),
		BLACK_WOOL(0x131317,Material.BLACK_WOOL,Block_Type.WOOL),
		YELLOW_WOOL(0xe7b824,Material.YELLOW_WOOL,Block_Type.WOOL),
		ORANGE_WOOL(0xe06d11,Material.ORANGE_WOOL,Block_Type.WOOL),
		RED_WOOL(0x952420,Material.RED_WOOL,Block_Type.WOOL),
		BROWN_WOOL(0x6a4225,Material.BROWN_WOOL,Block_Type.WOOL),
		LIME_WOOL(0x68ac17,Material.LIME_WOOL,Block_Type.WOOL),
		GREEN_WOOL(0x4e6519,Material.GREEN_WOOL,Block_Type.WOOL),
		LIGHT_BLUE_WOOL(0x36a2ca,Material.LIGHT_BLUE_WOOL,Block_Type.WOOL),
		CYAN_WOOL(0x148087,Material.CYAN_WOOL,Block_Type.WOOL),
		BLUE_WOOL(0x313592,Material.BLUE_WOOL,Block_Type.WOOL),
		PINK_WOOL(0xdd84a0,Material.PINK_WOOL,Block_Type.WOOL),
		MAGENTA_WOOL(0xb040a7,Material.MAGENTA_WOOL,Block_Type.WOOL),
		PURPLE_WOOL(0x7127a0,Material.PURPLE_WOOL,Block_Type.WOOL),

		//TERACOTTA DEFINE
		WHITE_TERRACOTTA(0xceae9e,Material.WHITE_TERRACOTTA,Block_Type.TERRACOTTA),
		LIGHT_GRAY_TERRACOTTA(0x85685f,Material.LIGHT_GRAY_TERRACOTTA,Block_Type.TERRACOTTA),
		GRAY_TERRACOTTA(0x382922,Material.GRAY_TERRACOTTA,Block_Type.TERRACOTTA),
		BLACK_TERRACOTTA(0x241610,Material.BLACK_TERRACOTTA,Block_Type.TERRACOTTA),
		YELLOW_TERRACOTTA(0xb78222,Material.YELLOW_TERRACOTTA,Block_Type.TERRACOTTA),
		ORANGE_TERRACOTTA(0x9e5224,Material.ORANGE_TERRACOTTA,Block_Type.TERRACOTTA),
		RED_TERRACOTTA(0x8d3b2d,Material.RED_TERRACOTTA,Block_Type.TERRACOTTA),
		BROWN_TERRACOTTA(0x4c3222,Material.BROWN_TERRACOTTA,Block_Type.TERRACOTTA),
		LIME_TERRACOTTA(0x657333,Material.LIME_TERRACOTTA,Block_Type.TERRACOTTA),
		GREEN_TERRACOTTA(0x4b5229,Material.GREEN_TERRACOTTA,Block_Type.TERRACOTTA),
		LIGHT_BLUE_TERRACOTTA(0x6f6a87,Material.LIGHT_BLUE_TERRACOTTA,Block_Type.TERRACOTTA),
		CYAN_TERRACOTTA(0x555959,Material.CYAN_TERRACOTTA,Block_Type.TERRACOTTA),
		BLUE_TERRACOTTA(0x493a5a,Material.BLUE_TERRACOTTA,Block_Type.TERRACOTTA),
		PINK_TERRACOTTA(0x9e4d4d,Material.PINK_TERRACOTTA,Block_Type.TERRACOTTA),
		MAGENTA_TERRACOTTA(0x93566a,Material.MAGENTA_TERRACOTTA,Block_Type.TERRACOTTA),
		PURPLE_TERRACOTTA(0x744554,Material.PURPLE_TERRACOTTA,Block_Type.TERRACOTTA),

		TERRACOTTA(0x965d41,Material.TERRACOTTA,Block_Type.TERRACOTTA),


		//STONE DEFINE
		STONE(0x7d7d7d,Material.STONE,Block_Type.STONE),
		GRANITE(0x926554,Material.GRANITE,Block_Type.STONE),
		POLISHED_GRANITE(0x996857,Material.POLISHED_GRANITE,Block_Type.STONE),
		DIORITE(0xbebebe,Material.DIORITE,Block_Type.STONE),
		POLISHED_DIORITE(0xc5c5c7,Material.POLISHED_DIORITE,Block_Type.STONE),
		ANDESITE(0x868686,Material.ANDESITE,Block_Type.STONE),
		POLISHED_ANDESITE(0x808384,Material.POLISHED_ANDESITE,Block_Type.STONE),
		DEEPSLATE(0x545457,Material.DEEPSLATE,Block_Type.STONE),
		COBBLED_DEEPSLATE(0x4a4a4d,Material.COBBLED_DEEPSLATE,Block_Type.STONE),
		POLISHED_DEEPSLATE(0x474747,Material.POLISHED_DEEPSLATE,Block_Type.STONE),
		CALCITE(0xdedfdb,Material.CALCITE,Block_Type.STONE),
		TUFF(0x6d6e68,Material.TUFF,Block_Type.STONE),
		DRIPSTONE_BLOCK(0x83685a,Material.DRIPSTONE_BLOCK,Block_Type.STONE),
		COBBLESTONE(0x797979,Material.COBBLESTONE,Block_Type.STONE),
		BEDROCK(0x5b5b5b,Material.BEDROCK,Block_Type.STONE),

		SMOOTH_STONE(0x9b9b9b,Material.SMOOTH_STONE,Block_Type.STONE),
		BRICKS(0x8b584a,Material.BRICKS,Block_Type.STONE),
		MOSSY_COBBLESTONE(0x646d55,Material.MOSSY_COBBLESTONE,Block_Type.STONE),
		OBSIDIAN(0x0e0a17,Material.OBSIDIAN,Block_Type.STONE),
		NETHERRACK(0x602525,Material.NETHERRACK,Block_Type.STONE),
		BASALT(0x4f5054,Material.BASALT,Block_Type.STONE),
		POLISHED_BASALT(0x646364,Material.POLISHED_BASALT,Block_Type.STONE),
		SMOOTH_BASALT(0x47474d,Material.SMOOTH_BASALT,Block_Type.STONE),
		STONE_BRICKS(0x787778,Material.STONE_BRICKS,Block_Type.STONE),
		MOSSY_STONE_BRICKS(0x72776a,Material.MOSSY_STONE_BRICKS,Block_Type.STONE),
		CRACKED_STONE_BRICKS(0x727172,Material.CRACKED_STONE_BRICKS,Block_Type.STONE),
		CHISELED_STONE_BRICKS(0x767576,Material.CHISELED_STONE_BRICKS,Block_Type.STONE),
		DEEPSLATE_BRICKS(0x454444,Material.DEEPSLATE_BRICKS,Block_Type.STONE),
		CRACKED_DEEPSLATE_BRICKS(0x3e3d3c,Material.CRACKED_DEEPSLATE_BRICKS,Block_Type.STONE),
		DEEPSLATE_TILES(0x373736,Material.DEEPSLATE_TILES,Block_Type.STONE),
		CRACKED_DEEPSLATE_TILES(0x333231,Material.CRACKED_DEEPSLATE_TILES,Block_Type.STONE),
		CHISELED_DEEPSLATE(0x373737,Material.CHISELED_DEEPSLATE,Block_Type.STONE),

		NETHER_BRICKS(0x2b1519,Material.NETHER_BRICKS,Block_Type.STONE),
		CRACKED_NETHER_BRICKS(0x251216,Material.CRACKED_NETHER_BRICKS,Block_Type.STONE),
		CHISELED_NETHER_BRICKS(0x30181c,Material.CHISELED_NETHER_BRICKS,Block_Type.STONE),
		END_STONE(0xd8db99,Material.END_STONE,Block_Type.STONE),
		END_STONE_BRICKS(0xd8dd9d,Material.END_STONE_BRICKS,Block_Type.STONE),

		RED_NETHER_BRICKS(0x430608,Material.RED_NETHER_BRICKS,Block_Type.STONE),

		CRYING_OBSIDIAN(0x290a4b,Material.CRYING_OBSIDIAN,Block_Type.STONE),
		BLACKSTONE(0x282226,Material.BLACKSTONE,Block_Type.STONE),
		GILDED_BLACKSTONE(0x342725,Material.GILDED_BLACKSTONE,Block_Type.STONE),
		POLISHED_BLACKSTONE(0x353038,Material.POLISHED_BLACKSTONE,Block_Type.STONE),
		CHISELED_POLISHED_BLACKSTONE(0x37323a,Material.CHISELED_POLISHED_BLACKSTONE,Block_Type.STONE),
		POLISHED_BLACKSTONE_BRICKS(0x2e282e,Material.POLISHED_BLACKSTONE_BRICKS,Block_Type.STONE),
		CRACKED_POLISHED_BLACKSTONE_BRICKS(0x292327,Material.CRACKED_POLISHED_BLACKSTONE_BRICKS,Block_Type.STONE),
		//DIRT DEFINE
		GRASS_BLOCK(0x526b32,Material.GRASS_BLOCK,Block_Type.DIRT),
		DIRT(0x805c40,Material.DIRT,Block_Type.DIRT),
		COARSE_DIRT(0x79563c,Material.COARSE_DIRT,Block_Type.DIRT),
		PODZOL(0x5b3e18,Material.PODZOL,Block_Type.DIRT),
		ROOTED_DIRT(0x8a6348,Material.ROOTED_DIRT,Block_Type.DIRT),
		CRIMSON_NYLIUM(0x811f1f,Material.CRIMSON_NYLIUM,Block_Type.DIRT),
		WARPED_NYLIUM(0x2a7064,Material.WARPED_NYLIUM,Block_Type.DIRT),
		MYCELIUM(0x6d6061,Material.MYCELIUM,Block_Type.DIRT),

		//SAND DEFINE
		SAND(0xd8cca0,Material.SAND,Block_Type.SAND),
		RED_SAND(0xb9631f,Material.RED_SAND,Block_Type.SAND),
		GRAVEL(0x837e7d,Material.GRAVEL,Block_Type.SAND),
		SANDSTONE(0xd0c79e,Material.SANDSTONE,Block_Type.SAND),
		CHISELED_SANDSTONE(0xd0c79e,Material.CHISELED_SANDSTONE,Block_Type.SAND),
		CUT_SANDSTONE(0xd0c79e,Material.CUT_SANDSTONE,Block_Type.SAND),
		SMOOTH_RED_SANDSTONE(0xa85a1d,Material.SMOOTH_RED_SANDSTONE,Block_Type.SAND),
		SMOOTH_SANDSTONE(0xd0c79e,Material.SMOOTH_SANDSTONE,Block_Type.SAND),

		CLAY(0x9ea4b0,Material.CLAY,Block_Type.SAND),
		SOUL_SAND(0x513e32,Material.SOUL_SAND,Block_Type.SAND),
		SOUL_SOIL(0x4c392e,Material.SOUL_SOIL,Block_Type.SAND),

		RED_SANDSTONE(0xb05d1d,Material.RED_SANDSTONE,Block_Type.SAND),
		CHISELED_RED_SANDSTONE(0xb15e1d,Material.CHISELED_RED_SANDSTONE,Block_Type.SAND),
		CUT_RED_SANDSTONE(0xb25f1e,Material.CUT_RED_SANDSTONE,Block_Type.SAND),

		//PLANKS DEFINE
		OAK_PLANKS(0xa48550,Material.OAK_PLANKS,Block_Type.PLANKS),
		SPRUCE_PLANKS(0x725430,Material.SPRUCE_PLANKS,Block_Type.PLANKS),
		BIRCH_PLANKS(0xbeae78,Material.BIRCH_PLANKS,Block_Type.PLANKS),
		JUNGLE_PLANKS(0x9f7250,Material.JUNGLE_PLANKS,Block_Type.PLANKS),
		ACACIA_PLANKS(0xa55931,Material.ACACIA_PLANKS,Block_Type.PLANKS),
		DARK_OAK_PLANKS(0x412a14,Material.DARK_OAK_PLANKS,Block_Type.PLANKS),
		CRIMSON_PLANKS(0x612e43,Material.CRIMSON_PLANKS,Block_Type.PLANKS),
		WARPED_PLANKS(0x296560,Material.WARPED_PLANKS,Block_Type.PLANKS),

		BOOKSHELF(0x987b4a,Material.BOOKSHELF,Block_Type.PLANKS),


		//ORE DEFINE
		COAL_ORE(0x636362,Material.COAL_ORE,Block_Type.ORE),
		DEEPSLATE_COAL_ORE(0x414142,Material.DEEPSLATE_COAL_ORE,Block_Type.ORE),
		IRON_ORE(0x8a8179,Material.IRON_ORE,Block_Type.ORE),
		DEEPSLATE_IRON_ORE(0x746d67,Material.DEEPSLATE_IRON_ORE,Block_Type.ORE),
		COPPER_ORE(0x797975,Material.COPPER_ORE,Block_Type.ORE),
		DEEPSLATE_COPPER_ORE(0x5b625b,Material.DEEPSLATE_COPPER_ORE,Block_Type.ORE),
		GOLD_ORE(0x958868,Material.GOLD_ORE,Block_Type.ORE),
		DEEPSLATE_GOLD_ORE(0x78694a,Material.DEEPSLATE_GOLD_ORE,Block_Type.ORE),
		REDSTONE_ORE(0x946969,Material.REDSTONE_ORE,Block_Type.ORE),
		DEEPSLATE_REDSTONE_ORE(0x6e4445,Material.DEEPSLATE_REDSTONE_ORE,Block_Type.ORE),
		EMERALD_ORE(0x5f896a,Material.EMERALD_ORE,Block_Type.ORE),
		DEEPSLATE_EMERALD_ORE(0x487155,Material.DEEPSLATE_EMERALD_ORE,Block_Type.ORE),
		LAPIS_ORE(0x5c6e93,Material.LAPIS_ORE,Block_Type.ORE),
		DEEPSLATE_LAPIS_ORE(0x4a5a7d,Material.DEEPSLATE_LAPIS_ORE,Block_Type.ORE),
		DIAMOND_ORE(0x729594,Material.DIAMOND_ORE,Block_Type.ORE),
		DEEPSLATE_DIAMOND_ORE(0x4c7272,Material.DEEPSLATE_DIAMOND_ORE,Block_Type.ORE),
		NETHER_GOLD_ORE(0x7a3d2a,Material.NETHER_GOLD_ORE,Block_Type.ORE),
		NETHER_QUARTZ_ORE(0x845953,Material.NETHER_QUARTZ_ORE,Block_Type.ORE),

		ANCIENT_DEBRIS(0x563a32,Material.ANCIENT_DEBRIS,Block_Type.ORE),
		COAL_BLOCK(0x101010,Material.COAL_BLOCK,Block_Type.ORE),
		RAW_IRON_BLOCK(0xa18368,Material.RAW_IRON_BLOCK,Block_Type.ORE),
		RAW_COPPER_BLOCK(0x99694e,Material.RAW_COPPER_BLOCK,Block_Type.ORE),
		RAW_GOLD_BLOCK(0xd8a42d,Material.RAW_GOLD_BLOCK,Block_Type.ORE),
		AMETHYST_BLOCK(0x8460c0,Material.AMETHYST_BLOCK,Block_Type.ORE),
		BUDDING_AMETHYST(0x7b58b2,Material.BUDDING_AMETHYST,Block_Type.ORE),
		IRON_BLOCK(0xdedede,Material.IRON_BLOCK,Block_Type.ORE),
		COPPER_BLOCK(0xbc694d,Material.COPPER_BLOCK,Block_Type.ORE),
		GOLD_BLOCK(0xf8d941,Material.GOLD_BLOCK,Block_Type.ORE),
		DIAMOND_BLOCK(0x6af1e4,Material.DIAMOND_BLOCK,Block_Type.ORE),
		NETHERITE_BLOCK(0x464245,Material.NETHERITE_BLOCK,Block_Type.ORE),
		EXPOSED_COPPER(0x9d7b64,Material.EXPOSED_COPPER,Block_Type.ORE),
		WEATHERED_COPPER(0x6a996c,Material.WEATHERED_COPPER,Block_Type.ORE),
		OXIDIZED_COPPER(0x52a688,Material.OXIDIZED_COPPER,Block_Type.ORE),
		CUT_COPPER(0xbc694f,Material.CUT_COPPER,Block_Type.ORE),
		EXPOSED_CUT_COPPER(0x967763,Material.EXPOSED_CUT_COPPER,Block_Type.ORE),
		WEATHERED_CUT_COPPER(0x698f6b,Material.WEATHERED_CUT_COPPER,Block_Type.ORE),
		OXIDIZED_CUT_COPPER(0x4e967c,Material.OXIDIZED_CUT_COPPER,Block_Type.ORE),
		WAXED_COPPER_BLOCK(0xbb684c,Material.WAXED_COPPER_BLOCK,Block_Type.ORE),
		WAXED_EXPOSED_COPPER(0x9e7c65,Material.WAXED_EXPOSED_COPPER,Block_Type.ORE),
		WAXED_WEATHERED_COPPER(0x6a996c,Material.WAXED_WEATHERED_COPPER,Block_Type.ORE),
		WAXED_OXIDIZED_COPPER(0x52a788,Material.WAXED_OXIDIZED_COPPER,Block_Type.ORE),
		WAXED_CUT_COPPER(0xbd694f,Material.WAXED_CUT_COPPER,Block_Type.ORE),
		WAXED_EXPOSED_CUT_COPPER(0x9a7864,Material.WAXED_EXPOSED_CUT_COPPER,Block_Type.ORE),
		WAXED_WEATHERED_CUT_COPPER(0x6a8f6a,Material.WAXED_WEATHERED_CUT_COPPER,Block_Type.ORE),
		WAXED_OXIDIZED_CUT_COPPER(0x4d957c,Material.WAXED_OXIDIZED_CUT_COPPER,Block_Type.ORE),

		LAPIS_BLOCK(0x1b3a81,Material.LAPIS_BLOCK,Block_Type.ORE),
		SMOOTH_QUARTZ(0xdcd6d0,Material.SMOOTH_QUARTZ,Block_Type.ORE),
		EMERALD_BLOCK(0x2fcf5e,Material.EMERALD_BLOCK,Block_Type.ORE),
		CHISELED_QUARTZ_BLOCK(0xe3dcd0,Material.CHISELED_QUARTZ_BLOCK,Block_Type.ORE),
		QUARTZ_BLOCK(0xe5dcd3,Material.QUARTZ_BLOCK,Block_Type.ORE),
		QUARTZ_BRICKS(0xe4dcd2,Material.QUARTZ_BRICKS,Block_Type.ORE),
		QUARTZ_PILLAR(0xe9e1d9,Material.QUARTZ_PILLAR,Block_Type.ORE),

		//WOOD DEFINE
		OAK_LOG(0x967948,Material.OAK_LOG,Block_Type.WOOD),
		SPRUCE_LOG(0x6b4f2e,Material.SPRUCE_LOG,Block_Type.WOOD),
		BIRCH_LOG(0xb5a572,Material.BIRCH_LOG,Block_Type.WOOD),
		JUNGLE_LOG(0x996e4b,Material.JUNGLE_LOG,Block_Type.WOOD),
		ACACIA_LOG(0x9d542e,Material.ACACIA_LOG,Block_Type.WOOD),
		DARK_OAK_LOG(0x402913,Material.DARK_OAK_LOG,Block_Type.WOOD),
		CRIMSON_STEM(0x693249,Material.CRIMSON_STEM,Block_Type.WOOD),
		WARPED_STEM(0x30716d,Material.WARPED_STEM,Block_Type.WOOD),

		STRIPPED_OAK_LOG(0x9c7e4b,Material.STRIPPED_OAK_LOG,Block_Type.WOOD),
		STRIPPED_SPRUCE_LOG(0x6a4f2e,Material.STRIPPED_SPRUCE_LOG,Block_Type.WOOD),
		STRIPPED_BIRCH_LOG(0xb3a370,Material.STRIPPED_BIRCH_LOG,Block_Type.WOOD),
		STRIPPED_JUNGLE_LOG(0x986d49,Material.STRIPPED_JUNGLE_LOG,Block_Type.WOOD),
		STRIPPED_ACACIA_LOG(0x9b532d,Material.STRIPPED_ACACIA_LOG,Block_Type.WOOD),
		STRIPPED_DARK_OAK_LOG(0x3e2812,Material.STRIPPED_DARK_OAK_LOG,Block_Type.WOOD),
		STRIPPED_CRIMSON_STEM(0x693248,Material.STRIPPED_CRIMSON_STEM,Block_Type.WOOD),
		STRIPPED_WARPED_STEM(0x2f706b,Material.STRIPPED_WARPED_STEM,Block_Type.WOOD),

		STRIPPED_OAK_WOOD(0xac8d55,Material.STRIPPED_OAK_WOOD,Block_Type.WOOD),
		STRIPPED_SPRUCE_WOOD(0x6f5531,Material.STRIPPED_SPRUCE_WOOD,Block_Type.WOOD),
		STRIPPED_BIRCH_WOOD(0xbaa770,Material.STRIPPED_BIRCH_WOOD,Block_Type.WOOD),
		STRIPPED_JUNGLE_WOOD(0xa27c50,Material.STRIPPED_JUNGLE_WOOD,Block_Type.WOOD),
		STRIPPED_ACACIA_WOOD(0xa65738,Material.STRIPPED_ACACIA_WOOD,Block_Type.WOOD),
		STRIPPED_DARK_OAK_WOOD(0x5c482e,Material.STRIPPED_DARK_OAK_WOOD,Block_Type.WOOD),
		STRIPPED_CRIMSON_HYPHAE(0x823655,Material.STRIPPED_CRIMSON_HYPHAE,Block_Type.WOOD),
		STRIPPED_WARPED_HYPHAE(0x368e8c,Material.STRIPPED_WARPED_HYPHAE,Block_Type.WOOD),

		OAK_WOOD(0x664f2f,Material.OAK_WOOD,Block_Type.WOOD),
		SPRUCE_WOOD(0x36220f,Material.SPRUCE_WOOD,Block_Type.WOOD),
		BIRCH_WOOD(0xd0cecb,Material.BIRCH_WOOD,Block_Type.WOOD),
		JUNGLE_WOOD(0x4f3f17,Material.JUNGLE_WOOD,Block_Type.WOOD),
		ACACIA_WOOD(0x5f5950,Material.ACACIA_WOOD,Block_Type.WOOD),
		DARK_OAK_WOOD(0x372a18,Material.DARK_OAK_WOOD,Block_Type.WOOD),
		CRIMSON_HYPHAE(0x56171b,Material.CRIMSON_HYPHAE,Block_Type.WOOD),
		WARPED_HYPHAE(0x363749,Material.WARPED_HYPHAE,Block_Type.WOOD),

		//SPONGE DEFINE
		SPONGE(0xb7b446,Material.SPONGE,Block_Type.SPONGE),
		WET_SPONGE(0x99a340,Material.WET_SPONGE,Block_Type.SPONGE),

		//PURPUR DEFINE
		PURPUR_BLOCK(0x9e759e,Material.PURPUR_BLOCK,Block_Type.PURPUR),
		PURPUR_PILLAR(0x9f779f,Material.PURPUR_PILLAR,Block_Type.PURPUR),

		//MARINE DEFINE
		PRISMARINE(0x639c93,Material.PRISMARINE,Block_Type.MARINE),
		PRISMARINE_BRICKS(0x62ab9e,Material.PRISMARINE_BRICKS,Block_Type.MARINE),
		DARK_PRISMARINE(0x335a4a,Material.DARK_PRISMARINE,Block_Type.MARINE),
		SEA_LANTERN(0xd0dfd6,Material.SEA_LANTERN,Block_Type.MARINE),

		//DECORATION DEFINE
		MOSS_BLOCK(0x52662a,Material.MOSS_BLOCK,Block_Type.DECORATION),
		CRAFTING_TABLE(0x754729,Material.CRAFTING_TABLE,Block_Type.DECORATION),
		FURNACE(0x737373,Material.FURNACE,Block_Type.DECORATION),
		JUKEBOX(0x5e3f2d,Material.JUKEBOX,Block_Type.DECORATION),
		BROWN_MUSHROOM_BLOCK(0x8b674b,Material.BROWN_MUSHROOM_BLOCK,Block_Type.DECORATION),
		RED_MUSHROOM_BLOCK(0xbc2d2b,Material.RED_MUSHROOM_BLOCK,Block_Type.DECORATION),
		MUSHROOM_STEM(0xbcb6ac,Material.MUSHROOM_STEM,Block_Type.DECORATION),
		END_PORTAL_FRAME(0x50634d,Material.END_PORTAL_FRAME,Block_Type.DECORATION),
		DIRT_PATH(0x7e6737,Material.DIRT_PATH,Block_Type.DECORATION),
		LOOM(0x7d6b59,Material.LOOM,Block_Type.DECORATION),
		COMPOSTER(0x533418,Material.COMPOSTER,Block_Type.DECORATION),
		BARREL(0x81613a,Material.BARREL,Block_Type.DECORATION),
		SMOKER(0x454545,Material.SMOKER,Block_Type.DECORATION),
		BLAST_FURNACE(0x474647,Material.BLAST_FURNACE,Block_Type.DECORATION),
		CARTOGRAPHY_TABLE(0x796851,Material.CARTOGRAPHY_TABLE,Block_Type.DECORATION),
		FLETCHING_TABLE(0xbeb08a,Material.FLETCHING_TABLE,Block_Type.DECORATION),
		SMITHING_TABLE(0x2f3039,Material.SMITHING_TABLE,Block_Type.DECORATION),
		STONECUTTER(0x585858,Material.STONECUTTER,Block_Type.DECORATION),
		BEE_NEST(0xcda952,Material.BEE_NEST,Block_Type.DECORATION),
		BEEHIVE(0xa38450,Material.BEEHIVE,Block_Type.DECORATION),
		HONEYCOMB_BLOCK(0xd68c1d,Material.HONEYCOMB_BLOCK,Block_Type.DECORATION),
		LODESTONE(0x828384,Material.LODESTONE,Block_Type.DECORATION),
		RESPAWN_ANCHOR(0x0c0713,Material.RESPAWN_ANCHOR,Block_Type.DECORATION),

		//SHULKER DEFINE
		SHULKER_BOX(0x805880,Material.SHULKER_BOX,Block_Type.SHULKER_BOX),
		WHITE_SHULKER_BOX(0xc4c8c9,Material.WHITE_SHULKER_BOX,Block_Type.SHULKER_BOX),
		LIGHT_GRAY_SHULKER_BOX(0x75756d,Material.LIGHT_GRAY_SHULKER_BOX,Block_Type.SHULKER_BOX),
		GRAY_SHULKER_BOX(0x33373a,Material.GRAY_SHULKER_BOX,Block_Type.SHULKER_BOX),
		BLACK_SHULKER_BOX(0x18181c,Material.BLACK_SHULKER_BOX,Block_Type.SHULKER_BOX),
		YELLOW_SHULKER_BOX(0xdbab1d,Material.YELLOW_SHULKER_BOX,Block_Type.SHULKER_BOX),
		ORANGE_SHULKER_BOX(0xd2620a,Material.ORANGE_SHULKER_BOX,Block_Type.SHULKER_BOX),
		RED_SHULKER_BOX(0x831e1c,Material.RED_SHULKER_BOX,Block_Type.SHULKER_BOX),
		BROWN_SHULKER_BOX(0x613c21,Material.BROWN_SHULKER_BOX,Block_Type.SHULKER_BOX),
		LIME_SHULKER_BOX(0x5ea014,Material.LIME_SHULKER_BOX,Block_Type.SHULKER_BOX),
		GREEN_SHULKER_BOX(0x485c1a,Material.GREEN_SHULKER_BOX,Block_Type.SHULKER_BOX),
		LIGHT_BLUE_SHULKER_BOX(0x3098bd,Material.LIGHT_BLUE_SHULKER_BOX,Block_Type.SHULKER_BOX),
		CYAN_SHULKER_BOX(0x12717b,Material.CYAN_SHULKER_BOX,Block_Type.SHULKER_BOX),
		BLUE_SHULKER_BOX(0x2a2c82,Material.BLUE_SHULKER_BOX,Block_Type.SHULKER_BOX),
		PINK_SHULKER_BOX(0xd17390,Material.PINK_SHULKER_BOX,Block_Type.SHULKER_BOX),
		MAGENTA_SHULKER_BOX(0x9e3395,Material.MAGENTA_SHULKER_BOX,Block_Type.SHULKER_BOX),
		PURPLE_SHULKER_BOX(0x601e8f,Material.PURPLE_SHULKER_BOX,Block_Type.SHULKER_BOX),

		//GLAZED TERRACOTTA
		WHITE_GLAZED_TERRACOTTA(0xaac3c5,Material.WHITE_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		LIGHT_GRAY_GLAZED_TERRACOTTA(0x899fa1,Material.LIGHT_GRAY_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		GRAY_GLAZED_TERRACOTTA(0x4c5255,Material.GRAY_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		BLACK_GLAZED_TERRACOTTA(0x461b1d,Material.BLACK_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		YELLOW_GLAZED_TERRACOTTA(0xdfbb5c,Material.YELLOW_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		ORANGE_GLAZED_TERRACOTTA(0xbb823e,Material.ORANGE_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		RED_GLAZED_TERRACOTTA(0xa8332e,Material.RED_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		BROWN_GLAZED_TERRACOTTA(0x805f43,Material.BROWN_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		LIME_GLAZED_TERRACOTTA(0x99b82f,Material.LIME_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		GREEN_GLAZED_TERRACOTTA(0x657d35,Material.GREEN_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		LIGHT_BLUE_GLAZED_TERRACOTTA(0x5a9fc5,Material.LIGHT_BLUE_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		CYAN_GLAZED_TERRACOTTA(0x27666d,Material.CYAN_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		BLUE_GLAZED_TERRACOTTA(0x314b9c,Material.BLUE_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		PINK_GLAZED_TERRACOTTA(0xdf93ac,Material.PINK_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		MAGENTA_GLAZED_TERRACOTTA(0xbc59ac,Material.MAGENTA_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),
		PURPLE_GLAZED_TERRACOTTA(0x683090,Material.PURPLE_GLAZED_TERRACOTTA,Block_Type.GLAZED_TERRACOTTA),

		//REDSTONE DEFINE
		TNT(0x613636,Material.TNT,Block_Type.REDSTONE),
		PISTON(0x907449,Material.PISTON,Block_Type.REDSTONE),
		STICKY_PISTON(0x658f4f,Material.STICKY_PISTON,Block_Type.REDSTONE),
		OBSERVER(0x6c6c6c,Material.OBSERVER,Block_Type.REDSTONE),
		DISPENSER(0x767575,Material.DISPENSER,Block_Type.REDSTONE),
		DROPPER(0x747474,Material.DROPPER,Block_Type.REDSTONE),
		TARGET(0xd39f93,Material.TARGET,Block_Type.REDSTONE),
		REDSTONE_LAMP(0x673c20,Material.REDSTONE_LAMP,Block_Type.REDSTONE),
		NOTE_BLOCK(0x5c3926,Material.NOTE_BLOCK,Block_Type.REDSTONE),

		//OTHERS DEFINE
		SNOW_BLOCK(0xf4fbf8,Material.SNOW_BLOCK,Block_Type.OTHERS),
		PUMPKIN(0xbc7115,Material.PUMPKIN,Block_Type.OTHERS),
		CARVED_PUMPKIN(0xbb7013,Material.CARVED_PUMPKIN,Block_Type.OTHERS),
		JACK_O_LANTERN(0xbb6f13,Material.JACK_O_LANTERN,Block_Type.OTHERS),
		GLOWSTONE(0xb18859,Material.GLOWSTONE,Block_Type.OTHERS),
		MELON(0x6a8c1d,Material.MELON,Block_Type.OTHERS),
		HAY_BLOCK(0xa68b0b,Material.HAY_BLOCK,Block_Type.OTHERS),
		PACKED_ICE(0x8bb1f5,Material.PACKED_ICE,Block_Type.OTHERS),
		MAGMA_BLOCK(0x873b1f,Material.MAGMA_BLOCK,Block_Type.OTHERS),
		NETHER_WART_BLOCK(0x700201,Material.NETHER_WART_BLOCK,Block_Type.OTHERS),
		WARPED_WART_BLOCK(0x167576,Material.WARPED_WART_BLOCK,Block_Type.OTHERS),
		BONE_BLOCK(0xc5c2a4,Material.BONE_BLOCK,Block_Type.OTHERS),

		DEAD_TUBE_CORAL(0x7c7571,Material.DEAD_TUBE_CORAL,Block_Type.OTHERS),
		DEAD_BRAIN_CORAL(0x756e6b,Material.DEAD_BRAIN_CORAL,Block_Type.OTHERS),
		DEAD_BUBBLE_CORAL(0x7a726d,Material.DEAD_BUBBLE_CORAL,Block_Type.OTHERS),
		DEAD_FIRE_CORAL(0x807873,Material.DEAD_FIRE_CORAL,Block_Type.OTHERS),
		DEAD_HORN_CORAL(0x827974,Material.DEAD_HORN_CORAL,Block_Type.OTHERS),

		BLUE_ICE(0x72a3f2,Material.BLUE_ICE,Block_Type.OTHERS),
		DRIED_KELP_BLOCK(0x39402c,Material.DRIED_KELP_BLOCK,Block_Type.OTHERS);

		private final int rgb;
		private final Material material;
		private final Block_Type type;
		Block_Color(int r,Material m,Block_Type t) {
			rgb=r;
			material=m;;
			type = t;
		}

		public Color getColor() {
			return new Color(rgb);
		}

		public int getR() {
			return getColor().getRed() ;
		}

		public int getG() {
			return getColor().getGreen();
		}

		public int getB() {
			return getColor().getBlue();
		}

		public Material getMaterial() {
			return material;
		}

		public Block_Type getType() {
			return type;
		}
	}

}
