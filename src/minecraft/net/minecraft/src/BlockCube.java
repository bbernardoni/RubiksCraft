package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockCube extends Block{
	
	protected BlockCube(int par1) {
		super(par1, 0, Material.cloth);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	protected int damageDropped(int par1){
        return par1;
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		int cubeS = world.getBlockId(x, y, z) - 170;
		int stickerS = world.getBlockMetadata(x, y, z) + 1;
		int dist = (stickerS+1)*cubeS+1;
		for(int i=0; i<dist; i++){
			for(int j=0; j<dist; j+=stickerS+1){
				world.setBlockAndMetadata(x, y+i, z+j, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x, y+j, z+i, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+i, y, z+j, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+j, y, z+i, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+i, y+j, z, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+j, y+i, z, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+dist-1, y+i, z+j, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+dist-1, y+j, z+i, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+i, y+dist-1, z+j, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+j, y+dist-1, z+i, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+i, y+j, z+dist-1, Block.cloth.blockID, 15);
				world.setBlockAndMetadata(x+j, y+i, z+dist-1, Block.cloth.blockID, 15);
			}
		}
		for(int i=0; i<cubeS; i++){
			for(int j=0; j<cubeS; j++){
				for(int k=0; k<stickerS; k++){
					for(int l=0; l<stickerS; l++){
						int distI = (stickerS+1)*i+1+k;
						int distJ = (stickerS+1)*j+1+l;
						world.setBlockAndMetadata(x, y+distI, z+distJ, Block.cloth.blockID, 0);
						world.setBlockAndMetadata(x+distI, y, z+distJ, Block.cloth.blockID, 14);
						world.setBlockAndMetadata(x+distI, y+distJ, z, Block.cloth.blockID, 5);
						world.setBlockAndMetadata(x+dist-1, y+distI, z+distJ, Block.cloth.blockID, 4);
						world.setBlockAndMetadata(x+distI, y+dist-1, z+distJ, Block.cloth.blockID, 1);
						world.setBlockAndMetadataWithNotify(x+distI, y+distJ, z+dist-1, Block.cloth.blockID, 11);
					}
				}
			}
		}
        return true;
    }
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 5; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
