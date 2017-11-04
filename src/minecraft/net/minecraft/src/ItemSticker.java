package net.minecraft.src;

import java.util.List;

public class ItemSticker extends Item{

	public static final String stickerNames[] = {
        "Small", "Medium", "Big", "Bigger", "Biggest"};
	
	protected ItemSticker(int par1) {
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabMisc);
		maxStackSize = 64;
        setHasSubtypes(true);
        setMaxDamage(0);
	}

	public String getItemNameIS(ItemStack itemstack) {
        return "item.sticker."+stickerNames[itemstack.getItemDamage()];
	}
	
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 5; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
