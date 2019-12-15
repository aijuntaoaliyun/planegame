package individual;

import java.util.Random;

public class addHealth_point extends stuff_father {
  public addHealth_point() {
	  Random r=new Random();
  	this.stuff_type=7;
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
