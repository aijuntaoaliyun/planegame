package individual;
import frame.addname;
public class mainAircraft extends stuff_father {
    private int  bullet_type =0;
	private int  health_point=15;
	private int  Explosionflashing_time=-1;
	public mainAircraft(float xCoordinate,float yCoordinate,float width,float hight) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.isDead=false;
		this.xspeed=2.2f;
		this.yspeed=3f;	
		this.stuff_type=1;
		this.width=width;
		this.hight=hight;
		this.bullet_type=1;
	}
	
	public void getshot() {
		//System.out.println("Œ“÷–µØ¡À");
		
		this.health_point--;
		this.Explosionflashing_time=50;
		
		
	}
	public void addhealth() {
		if(this.health_point<15) {
			this.health_point++;
		}
		
	}
	public int get_bullet_type() {
		return this.bullet_type;
	}
	public void setBullet_type(int type) {
	    this.bullet_type=type;
	}
	public int getHealth_point() {
		return this.health_point;
	}
	public void  Explosionflashing_time_down() {
		this.Explosionflashing_time--;
		
	}
	public int get_Explosionflashing_time() {
		return this.Explosionflashing_time;
	}

	
	
	
}
