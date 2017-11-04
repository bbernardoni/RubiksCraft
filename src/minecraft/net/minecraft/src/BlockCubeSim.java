package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class BlockCubeSim extends Block{
	
	protected BlockCubeSim(int par1) {
		super(par1, 0, Material.iron);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		ModLoader.getMinecraftInstance().displayGuiScreen(new GuiCubeSim());
		return true;
	}
}
