package individual;

import java.util.Random;

import frame.mainPanel;

public class Enemy_aircraft extends stuff_father {
   // public static mainPanel panel;
    public static int moveway;

   
	public Enemy_aircraft(float xCoordinate,float yCoordinate) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.isDead=false;
		this.isexploded=false;
	
		this.xspeed=1.2f;
		this.yspeed=1.2f;	
		this.stuff_type=2;
		this.width=44;
		this.hight=48;
		
		/* Random r=new Random(panel.getWidth());
		 xCoordinate =r.nextInt(800);
		 yCoordinate=-20;
		 */
		if(xCoordinate>panel.getWidth()/2) {
			this.moveway=1;
			
		}else {
			this.moveway=0;
		}
	}
	public void move() {
		if(moveway==0) {
			yCoordinate+=yspeed;
			xCoordinate+=xspeed;
		}
		else {
			yCoordinate+=yspeed;
			xCoordinate-=xspeed;
		}
		if(yCoordinate>=21&&yCoordinate<22.2) {
		this.panel.addEnemybullet(new Enemy_bullet(this.xCoordinate+22,this.yCoordinate+45) );
		}//当飞机到达这个位置，发射子弹
		if(yCoordinate>=221&&yCoordinate<222.2) {
			this.panel.addEnemybullet(new Enemy_bullet(this.xCoordinate+22,this.yCoordinate+45) );
			}//当飞机到达这个位置，发射子弹
		
	}
	

	
	
}
