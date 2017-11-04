package net.minecraft.src;

import java.util.ArrayList;

public class CubeDrawTimes{
	String add = "";
	
	public float drawTimes(int w, int h, FontRenderer fr, long start, float time, ArrayList<Float> times, int state){
		String str = "";
		if(start!=0){time=(System.currentTimeMillis() - start)/(float)1000;	str = ""+(int)time;}
        else if(state==0 && time==0)										str = "Ready";
        else if(state==0)													str = ""+time;
        else																str = "0";
        drawCenteredString(fr, str, (w-256)/2+44, (h-176)/2+41, 0xffffffff);
        if(times.size()>0){
	        drawCenteredString(fr, "Times: "+times.size()+" - Best: "+smallest(times)+" - Worst: "+largest(times), (w-256)/2+128, (h-176)/2+133, 0xffffffff);
		    if(times.size()>=5){
		    	str = cur(times,5);
		        drawCenteredString(fr, add+str, (w-256)/2+128, (h-176)/2+151, 0xffffffff);
		        str = best(times,5);
		        drawCenteredString(fr, add+str, (w-256)/2+128, (h-176)/2+160, 0xffffffff);
	        	drawCenteredString(fr, avgs(times), (w-256)/2+128, (h-176)/2+142, 0xffffffff);
		    }
        }
        return time;
	}
	
	public String avgs(ArrayList<Float> times){
		String str = "";
		if(times.size()>=12)
			str += "Cur Avg12: " + cur(times,12) + " - Best Avg12: " + best(times,12);
		else
			str = "Cur Avg5: " + cur(times,5) + " - Best Avg5: " + best(times,5);
		return str;
	}
	public String best(ArrayList<Float> times, int n){
		float smallest = Float.MAX_VALUE;
		int k = 0;
		String str = "";
		for(int i=0; i<=times.size()-n; i++){
			float f = 0;
			for(int j=0; j<n; j++)
				f += times.get(j+i);
			f -= largest(new ArrayList(times.subList(i, i+n-1)));
			f -= smallest(new ArrayList(times.subList(i, i+n-1)));
			if(f<smallest){
            	smallest = f;
            	k = i;
			}
		}
		for(int i=0; i<n; i++)
			str += "" + times.get(k+i) + " ";
		add = str+"= ";
		return ""+(float)Math.round(smallest/(n-2)*1000)/1000;
	}
	public String cur(ArrayList<Float> times, int n){
		float f = 0;
		String str = "";
		for(int i=-n; i<0; i++){
			f += times.get(times.size()+i);
			str += "" + times.get(times.size()+i) + " ";
		}
		f -= largest(new ArrayList(times.subList(times.size()-n, times.size()-1)));
		f -= smallest(new ArrayList(times.subList(times.size()-n, times.size()-1)));
		add = str+"= ";
		return ""+(float)Math.round(f/(n-2)*1000)/1000;
	}
	public float largest(ArrayList<Float> times){
		float largest = times.get(0);
        for(int i=1; i<times.size(); i++)
            if(times.get(i)>largest)
            	largest = times.get(i);
        return largest;
	}
	public float smallest(ArrayList<Float> times){
		float smallest = times.get(0);
        for(int i=1; i<times.size(); i++)
            if(times.get(i)<smallest)
            	smallest = times.get(i);
        return smallest;
	}
	
	public void drawCenteredString(FontRenderer par1FontRenderer, String par2Str, int par3, int par4, int par5){
        par1FontRenderer.drawStringWithShadow(par2Str, par3 - par1FontRenderer.getStringWidth(par2Str) / 2, par4, par5);
    }
}
