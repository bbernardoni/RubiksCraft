package net.minecraft.src;

public class mod_RubiksCraft extends BaseMod{
	
	public static final Item sticker = new ItemSticker(5280).setItemName("sticker");
	public static final Item face = new ItemFace(5281).setItemName("face");
	public static final Block cubeSim = new BlockCubeSim(170).setBlockName("cubeSim").setHardness(5F);
	public static final Block cube1 = new BlockCube(171).setBlockName("cube1").setHardness(0.8F);
	public static final Block cube2 = new BlockCube(172).setBlockName("cube2").setHardness(0.8F);
	public static final Block cube3 = new BlockCube(173).setBlockName("cube3").setHardness(0.8F);
	public static final Block cube4 = new BlockCube(174).setBlockName("cube4").setHardness(0.8F);
	public static final Block cube5 = new BlockCube(175).setBlockName("cube5").setHardness(0.8F);
	public static final Block cube6 = new BlockCube(176).setBlockName("cube6").setHardness(0.8F);
	public static final Block cube7 = new BlockCube(177).setBlockName("cube7").setHardness(0.8F);
	public static final Block cube8 = new BlockCube(178).setBlockName("cube8").setHardness(0.8F);
	public static final Block cube9 = new BlockCube(179).setBlockName("cube9").setHardness(0.8F);
	public static final Block cube10 = new BlockCube(180).setBlockName("cube10").setHardness(0.8F);
	public static final Block cube11 = new BlockCube(181).setBlockName("cube11").setHardness(0.8F);
	public static final Block cube12 = new BlockCube(182).setBlockName("cube12").setHardness(0.8F);
	public static final Block cube13 = new BlockCube(183).setBlockName("cube13").setHardness(0.8F);
	public static final Block cube14 = new BlockCube(184).setBlockName("cube14").setHardness(0.8F);
	public static final Block cube15 = new BlockCube(185).setBlockName("cube15").setHardness(0.8F);
	public static final Block cube16 = new BlockCube(186).setBlockName("cube16").setHardness(0.8F);
	public static final Block cube17 = new BlockCube(187).setBlockName("cube17").setHardness(0.8F);
	public static final Block cube18 = new BlockCube(188).setBlockName("cube18").setHardness(0.8F);
	public static final Block cube19 = new BlockCube(189).setBlockName("cube19").setHardness(0.8F);
	public static final Block cube20 = new BlockCube(190).setBlockName("cube20").setHardness(0.8F);
	public static final Block cubes[] = {null, 
		cube1, cube2, cube3, cube4, cube5, cube6, cube7, cube8, cube9, cube10, 
		cube11, cube12, cube13, cube14, cube15, cube16, cube17, cube18, cube19, cube20};
	public static final String stickerNames[] = {
        "Small", "Medium", "Big", "Bigger", "Biggest"};
	
	public void load()
	{
		sticker.iconIndex = ModLoader.addOverride("/gui/items.png" , "/RubiksCraft/sticker.png");
		face.iconIndex = ModLoader.addOverride("/gui/items.png" , "/RubiksCraft/face.png");
		for(int i = 1; i<=20; i++){
			cubes[i].blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/RubiksCraft/cube"+i+".png");
			ModLoader.registerBlock(cubes[i]);
			Item.itemsList[170+i] = new ItemCube(170+i-256, cubes[i]).setItemName("cube"+i);
		}
		cubeSim.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/RubiksCraft/cubeSim.png");
		ModLoader.addName(cubeSim, "Cube Simulator");	ModLoader.registerBlock(cubeSim);
		
		for(int i = 0; i < stickerNames.length; i++)
			ModLoader.addLocalization("item.sticker."+stickerNames[i]+".name", stickerNames[i]+" Sticker");
		for(int i = 0; i < stickerNames.length; i++)
			for(int j = 2; j <= 20; j++)
				ModLoader.addLocalization("item.face."+(j+i*32)+".name", stickerNames[i]+" "+j+"x"+j+" Face");
		for(int i = 0; i < stickerNames.length; i++)
			for(int j = 1; j <= 20; j++)
				ModLoader.addLocalization("tile.cube"+j+"."+i+".name", stickerNames[i]+" "+j+"x"+j+" Cube");
		ModLoader.addLocalization("item.face.0.name", "You Cheated Face");
		
		ModLoader.addRecipe(new ItemStack(sticker,1,0), new Object[]{	" * ", "*&*", " * ", 
			Character.valueOf('*'), new ItemStack(Block.cloth, 1, 15), 
			Character.valueOf('&'), new ItemStack(Block.cloth, 1, 0)});
		ModLoader.addRecipe(new ItemStack(sticker,1,1), new Object[]{	"*&", "&&", 
			Character.valueOf('*'), new ItemStack(sticker,1,0), 
			Character.valueOf('&'), new ItemStack(Block.cloth, 1, 0)});
		ModLoader.addRecipe(new ItemStack(sticker,1,2), new Object[]{	"* &", "  &", "&&&", 
			Character.valueOf('*'), new ItemStack(sticker,1,1), 
			Character.valueOf('&'), new ItemStack(Block.cloth, 1, 0)});
		ModLoader.addRecipe(new ItemStack(sticker,1,3), new Object[]{	"*&&", "& &", "&&&", 
			Character.valueOf('*'), new ItemStack(sticker,1,2), 
			Character.valueOf('&'), new ItemStack(Block.cloth, 1, 0)});
		ModLoader.addRecipe(new ItemStack(sticker,1,4), new Object[]{	"*&&", "&&&", "&&&", 
			Character.valueOf('*'), new ItemStack(sticker,1,3), 
			Character.valueOf('&'), new ItemStack(Block.cloth, 1, 0)});
		for(int i = 0; i < stickerNames.length; i++){
			ModLoader.addRecipe(new ItemStack(face,1,32*i+1), new Object[]{	"&&", "&&", 
				Character.valueOf('&'), new ItemStack(sticker,1,i)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+2), new Object[]{	"&&&", "&&&", "&&&",
				Character.valueOf('&'), new ItemStack(sticker,1,i)});
			for(int j = 1; j < 10; j++)
				ModLoader.addRecipe(new ItemStack(face,1,32*i+j*2+1), new Object[]{	"&&", "&&", 
					Character.valueOf('&'), new ItemStack(face,1,32*i+j)});
			for(int j = 1; j < 6; j++)
				ModLoader.addRecipe(new ItemStack(face,1,32*i+j*3+2), new Object[]{	"&&&", "&&&", "&&&",
					Character.valueOf('&'), new ItemStack(face,1,32*i+j)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+4), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+1), 
				Character.valueOf('&'), new ItemStack(face,1,i+2)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+6), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+2), 
				Character.valueOf('&'), new ItemStack(face,1,i+3)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+10), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+4), 
				Character.valueOf('&'), new ItemStack(face,1,i+5)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+12), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+5), 
				Character.valueOf('&'), new ItemStack(face,1,i+6)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+16), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+7), 
				Character.valueOf('&'), new ItemStack(face,1,i+8)});
			ModLoader.addRecipe(new ItemStack(face,1,32*i+18), new Object[]{	"&*", "*&", 
				Character.valueOf('*'), new ItemStack(face,1,i+8), 
				Character.valueOf('&'), new ItemStack(face,1,i+9)});
		}
		for(int i = 0; i < stickerNames.length; i++){
			ModLoader.addRecipe(new ItemStack(cube1,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(sticker,1,i)});
			ModLoader.addRecipe(new ItemStack(cube2,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+1)});
			ModLoader.addRecipe(new ItemStack(cube3,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+2)});
			ModLoader.addRecipe(new ItemStack(cube4,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+3)});
			ModLoader.addRecipe(new ItemStack(cube5,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+4)});
			ModLoader.addRecipe(new ItemStack(cube6,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+5)});
			ModLoader.addRecipe(new ItemStack(cube7,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+6)});
			ModLoader.addRecipe(new ItemStack(cube8,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+7)});
			ModLoader.addRecipe(new ItemStack(cube9,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+8)});
			ModLoader.addRecipe(new ItemStack(cube10,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+9)});
			ModLoader.addRecipe(new ItemStack(cube11,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+10)});
			ModLoader.addRecipe(new ItemStack(cube12,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+11)});
			ModLoader.addRecipe(new ItemStack(cube13,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+12)});
			ModLoader.addRecipe(new ItemStack(cube14,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+13)});
			ModLoader.addRecipe(new ItemStack(cube15,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+14)});
			ModLoader.addRecipe(new ItemStack(cube16,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+15)});
			ModLoader.addRecipe(new ItemStack(cube17,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+16)});
			ModLoader.addRecipe(new ItemStack(cube18,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+17)});
			ModLoader.addRecipe(new ItemStack(cube19,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+18)});
			ModLoader.addRecipe(new ItemStack(cube20,1,i), new Object[]{	"&& ", "& &", " &&",
				Character.valueOf('&'), new ItemStack(face,1,i*32+19)});
		}
		ModLoader.addRecipe(new ItemStack(cubeSim,1), new Object[]{	"&&&", "&*&", "&&&",
			Character.valueOf('&'), new ItemStack(Item.redstone,1),
			Character.valueOf('*'), new ItemStack(cube3,1)});
	}
	
	public String getVersion()
	{
		return "1.3.1";
	}
}
