package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

public class GuiButtonHeight extends GuiButton{
	
	protected int offset;
	
	public GuiButtonHeight(int par1, int par2, int par3, int par4, int par5, String par6Str){
    	this(par1, par2, par3, par4, par5, 0, par6Str);
    }
    public GuiButtonHeight(int par1, int par2, int par3, int par4, int par5, int par6, String par7Str){
        super(par1, par2, par3, par4, par5, par7Str);
        this.offset = par6;
    }
    
    public void drawButton(Minecraft par1Minecraft, int par2, int par3){
        if (this.drawButton)
        {
            FontRenderer var4 = par1Minecraft.fontRenderer;
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1Minecraft.renderEngine.getTexture("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var5 = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int var6 = this.getHoverState(var5);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, offset, 46 + var6 * 20 + offset, this.width / 2, this.height / 2);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2 - offset, 46 + var6 * 20 + offset, this.width / 2, this.height / 2);
            this.drawTexturedModalRect(this.xPosition, this.yPosition + this.height / 2, offset, 66 + var6 * 20 - this.height / 2 - offset, this.width / 2, this.height / 2);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition + this.height / 2, 200 - this.width / 2 - offset, 66 + var6 * 20 - this.height / 2 - offset, this.width / 2, this.height / 2);
            this.mouseDragged(par1Minecraft, par2, par3);
            int var7 = 14737632;

            if (!this.enabled)
            {
                var7 = -6250336;
            }
            else if (var5)
            {
                var7 = 16777120;
            }

            this.drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, var7);
        }
    }
}
