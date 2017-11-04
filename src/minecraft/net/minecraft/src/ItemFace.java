package net.minecraft.src;

import java.util.List;

public class ItemFace extends Item{

	
	protected ItemFace(int par1) {
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabMisc);
		maxStackSize = 64;
        setHasSubtypes(true);
        setMaxDamage(0);
	}

	public String getItemNameIS(ItemStack itemstack) {
		return "item.face."+(itemstack.getItemDamage()+1);
	}
	
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 5; i++)
			for(int j = 1; j < 20; j++)
				par3List.add(new ItemStack(par1, 1, j+i*32));
    }
}
