package net.minecraft.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

public class GuiCubeSim extends GuiScreen{
	
	int cube[][] = new int[6][9];
	int state = 0;
	float time = 0;
	long start = 0;
	ArrayList<Float> times = new ArrayList<Float>();
	int cs[] = {0xffffffff, 0xffffff00, 0xff00ff00, 0xffff0000, 0xff0000ff, 0xffff8000};
	
	public void initGui(){
		controlList.clear();
		controlList.add(new GuiButtonHeight(0, (width-256)/2+14, (height-176)/2+25, 75, 12, 1, "Scramble"));
		controlList.add(new GuiButtonHeight(1, (width-256)/2+14, (height-176)/2+11, 88, 12, 1, "Options"));
		try {
		    BufferedReader in = new BufferedReader(new FileReader(Minecraft.getMinecraftDir() + "/mods/mod_RubiksCraft/times.txt"));
		    String str;
		    while ((str = in.readLine()) != null) {
		    	times.add(Float.parseFloat(str));
		    }
		    in.close();
		} catch (IOException e) {}
		try {
		    BufferedReader in = new BufferedReader(new FileReader(Minecraft.getMinecraftDir() + "/mods/mod_RubiksCraft/options.txt"));
		    String str;
		    for (int i=0; i<6; i++) {
		    	str = in.readLine();
		    	cs[i]=(Integer.parseInt(str));
		    }
		    in.close();
		} catch (IOException e) {}
		solveCube();
	}
	
	public void onGuiClosed(){
		try{
			File file = new File(ModLoader.getMinecraftInstance().getMinecraftDir() + "/mods/mod_RubiksCraft");
			file.mkdirs();
		    BufferedWriter out = new BufferedWriter(new FileWriter(file + "/times.txt"));
		    for(int i = 0;i < times.size();i++)
		    	out.write(""+times.get(i)+"\n");
		    out.close();
		}catch (Exception ex){}
	}

	protected void keyTyped(char c, int i){
		CubeMoves cm = new CubeMoves();
        switch(state){
        case 0:
        	switch(i){
            case 1:
                mc.displayGuiScreen(null);
                mc.setIngameFocus();
                break;
            case 57:
            	cube = cm.scrambleCube(cube, 50);
            	state = 1;
            	time = 0;
            	break;
            default:}
        	break;
        case 1:
        	switch(i){
            case 1:		mc.displayGuiScreen(null); 		mc.setIngameFocus();		break;
            case 14:	state = 0;						solveCube();		start=0;break;
            case 36:	cube = cm.U(cube);									start();break;
	        case 33:	cube = cm.Ui(cube);	        						start();break;
	        case 31:   	cube = cm.D(cube);	        						start();break;
	        case 38:   	cube = cm.Di(cube);	        						start();break;
	        case 23:   	cube = cm.R(cube);	        						start();break;
	        case 37:   	cube = cm.Ri(cube);	        						start();break;
	        case 32:   	cube = cm.L(cube);	        						start();break;
	        case 18:   	cube = cm.Li(cube);	        						start();break;
	        case 35:   	cube = cm.F(cube);	        						start();break;
	        case 34:   	cube = cm.Fi(cube);	        						start();break;
	        case 17:   	cube = cm.B(cube);	        						start();break;
	        case 24:   	cube = cm.Bi(cube);	        						start();break;
	        case 48:   	cube = cm.M(cube);	       	 						start();break;
	        case 20:   	cube = cm.Mi(cube);	        						start();break;
	        case 39:   	cube = cm.U(cube); 	cube = cm.Ei(cube);	cube = cm.Di(cube);	break;
	        case 30:   	cube = cm.Ui(cube);	cube = cm.E(cube); 	cube = cm.D(cube); 	break;
	        case 21:   	cube = cm.R(cube); 	cube = cm.Mi(cube);	cube = cm.Li(cube);	break;
	        case 49:   	cube = cm.Ri(cube);	cube = cm.M(cube); 	cube = cm.L(cube); 	break;
	        case 25:   	cube = cm.F(cube);	cube = cm.S(cube); 	cube = cm.Bi(cube);	break;
	        case 16:   	cube = cm.Fi(cube);	cube = cm.Si(cube);	cube = cm.B(cube); 	break;
	        case 22:  	cube = cm.R(cube);	cube = cm.Mi(cube);				start();break;
	        case 50:   	cube = cm.Ri(cube);	cube = cm.M(cube);				start();break;
	        case 47:   	cube = cm.L(cube); 	cube = cm.M(cube);			    start();break;
	        case 19:   	cube = cm.Li(cube);	cube = cm.Mi(cube);			    start();break;
            default:}
        	int k = 0;
        	for(int j=0; j<6; j++){
        		int[] d = new int[9];
        		Arrays.fill(d, cube[j][1]);
		        if(Arrays.equals(cube[j], d)==true)
		        	k++;
        	}
        	if(k==6&&state==1){
        		start = 0;
        		state = 0;
        		times.add(time);
        		solveCube();
        	}
        	break;
        default:}
    }
	
	public void start() {
    	if (start == 0){
    		start = System.currentTimeMillis();
    	}
    }
	
	protected void actionPerformed(GuiButton guibutton){
		switch(guibutton.id){
		case 0:
			if(guibutton.displayString == "Scramble"){
				CubeMoves cm = new CubeMoves();
				cube = cm.scrambleCube(cube, 50);
	        	state = 1;
	        	time = 0;
			}else{
				start = 0;
        		state = 0;
        		solveCube();
			}
			break;
		case 1:
			mc.displayGuiScreen(new GuiCubeSettings());
			break;
		default:}
	}
	
	public void drawScreen(int i, int j, float f){
		drawDefaultBackground();
		mc.renderEngine.bindTexture(mc.renderEngine.getTexture("/RubiksCraft/cubeSimGui.png"));
        drawTexturedModalRect((width-256)/2, (height-176)/2, 0, 0, 256, 176);
        time = new CubeDrawTimes().drawTimes(width, height, fontRenderer, start, time, times, state);
		new CubeDraw().drawCube(width, height, cube);
		if(state == 0)
			((GuiButton)controlList.get(0)).displayString = "Scramble";
		else
			((GuiButton)controlList.get(0)).displayString = "Reset";
		super.drawScreen(i, j, f);
	}
	
	public void solveCube(){
		for(int i=0; i<6; i++)
			Arrays.fill(cube[i], cs[i]);
	}
}
