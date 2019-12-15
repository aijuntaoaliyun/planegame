package individual;

import frame.mainPanel;

public class Enemy2_aircraft extends stuff_father {
	 public static mainPanel panel;
	    public static int moveway;
	   
	    private boolean choosepic=false;
	    private boolean left=true;
		public Enemy2_aircraft(float xCoordinate,float yCoordinate) {
			this.xCoordinate=xCoordinate;
			this.yCoordinate=yCoordinate;
			this.isDead=false;
	
			this.xspeed=1.2f;
			this.yspeed=1.0f;	
			this.stuff_type=4;
			this.width=55;
			this.hight=58;
			if(this.xCoordinate>this.panel.getWidth()/2) {
				this.left=true;
			}else {
				this.left=false;
			}
		
			
		} 
		public  void move() {
			if(this.yCoordinate<this.panel.getHeight()/3) {
				this.yCoordinate+=yspeed;
			}
			else if(this.left) {
				this.choosepic=true;
				this.yCoordinate+=yspeed;
				this.xCoordinate-=0.8*yspeed;
			}else {
				this.choosepic=true;
				this.yCoordinate+=yspeed;
				this.xCoordinate+=0.8*yspeed;
			}
			
		}
		public boolean getChoosepic() {
			return this.choosepic;
		}
		public boolean getLeft() {
			return this.left;
		}
		
		
		
		
	
	
}
