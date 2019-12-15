package individual;

public class mainAircraft_bullet extends stuff_father {

	public mainAircraft_bullet (float xCoordinate,float yCoordinate) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.width=7;
		this.hight=20;
		this.xspeed=0f;
		this.yspeed=5.5f;	
		this.stuff_type=3;
	}
	public void move() {
		yCoordinate-=yspeed;
	}
	
}
