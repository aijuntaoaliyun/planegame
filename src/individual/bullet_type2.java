package individual;

import java.util.Random;

public class bullet_type2  extends stuff_father {
    public bullet_type2() {
		Random r=new Random();
    	this.stuff_type=6;
    	int x=r.nextInt(this.panel.getWidth()-100)+50;// 50      panel.width-50 Ö®¼ä
    	this.xCoordinate=x;
    	this.yCoordinate=-20;
    	this.yspeed=0.7f;
    	this.width=31;
    	this.hight=31;
    }
    
    public void move(){
    	this.yCoordinate+=this.yspeed;
    }
}
