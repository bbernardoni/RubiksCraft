package net.minecraft.src;

public class ItemCube extends ItemBlock {
    public ItemCube(int i, Block block) {
        super(i);
        setHasSubtypes(true);
    }
    
    public int getMetadata(int i) {
    	return i;
    }
    
    public String getItemNameIS(ItemStack itemstack) {
    	return super.getItemName()+"."+itemstack.getItemDamage();
	}
}