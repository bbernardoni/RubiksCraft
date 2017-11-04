package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class CubeDraw{
	
	int c[][] = new int[6][9];
	
	public void drawCube(int w, int h, int cu[][]){
		c = cu;
		drawPoly(new int[]{(w-256)/2+118,(h-176)/2+14,-43,43,-42,43,1,0}, 0xff000000);
		drawPoly(new int[]{(w-256)/2+241,(h-176)/2+76,-44,44,-43,44,1,0}, 0xff000000);
        drawSlantedRFace((w-256)/2+118, (h-176)/2+16, 0); //U
        drawSlantedRFace((w-256)/2+179, (h-176)/2+77, 1); //D
		drawFlatFace((w-256)/2+16, (h-176)/2+59, 2); //L
		drawFlatFace((w-256)/2+77, (h-176)/2+59, 3); //F
        drawSlantedUFace((w-256)/2+138, (h-176)/2+57, 4); //R
		drawFlatFace((w-256)/2+181, (h-176)/2+16, 5); //B
	}
	
	private void drawFlatFace(int posX, int posY, int face) {
		for(int i=0; i<60; i+=20)
			for(int j=0; j<60; j+=20)
				drawRect(posX+i, posY+j, 19, 19, c[face][i/20+j/20*3]);
	}

	private void drawSlantedRFace(int posX, int posY, int face) {
		for(int j=0; j<42; j+=14)
			for(int i=0; i<60; i+=20)
				drawPoly(new int[]{posX+i-j+1,posY+j,-13,13,6,13,19,0}, c[face][i/20+j/14*3]);
	}

	private void drawSlantedUFace(int posX, int posY, int face) {
		for(int i=0; i<42; i+=14)
			for(int j=0; j<60; j+=20)
				drawPoly(new int[]{posX+i,posY+j-i+1,0,19,13,6,13,-13}, c[face][i/14+j/20*3]);
	}
	
	public static void drawRect(int par1, int par2, int par3, int par4, int par5){
        drawPoly(new int[]{par1,par2,0,par4,par3,par4,par3,0}, par5);
    }
	public static void drawPoly(int par1[], int par5){
        float f = (float)(par5 >> 24 & 0xff) / 255F;
        float f1 = (float)(par5 >> 16 & 0xff) / 255F;
        float f2 = (float)(par5 >> 8 & 0xff) / 255F;
        float f3 = (float)(par5 & 0xff) / 255F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(f1, f2, f3, f);
        tessellator.startDrawingQuads();
        tessellator.addVertex(par1[0], par1[1], 0.0D);
        tessellator.addVertex(par1[0]+par1[2], par1[1]+par1[3], 0.0D);
        tessellator.addVertex(par1[0]+par1[4], par1[1]+par1[5], 0.0D);
        tessellator.addVertex(par1[0]+par1[6], par1[1]+par1[7], 0.0D);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
