package individual;

public class Enemy_bullet extends  stuff_father {
	
public static mainAircraft target;
 public  Enemy_bullet (float xCoordinate,float yCoordinate) {
	 this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.width=7;
		this.hight=20;
		this.xspeed=0f;
		this.yspeed=1.5f;	
		this.stuff_type=5;
		float x=target.getX();
		 float y=target.getY();
		 //����Ĵ���ʱ��ʵ���ӵ������ȷ����һ����������ڱ�
		 
		 float b1=0;
		 if(y-yCoordinate<0.00001) {
			 b1=1;
		 }else {
			 b1=y-yCoordinate;
		 }
		 float b=(x-xCoordinate)/b1; 
		 
		 //����b����̫���ӵ��ĺ����ٶ�̫��=��
		 if(b>1.5) {
			 b=1.5f;
		 }if(b<-1.5)
		 {
			 b=-1.5f;
		 }
		 this.xspeed=yspeed*b;
 }
 
 public void move() {
	 this.xCoordinate+=this.xspeed;
	 this.yCoordinate+=this.yspeed;
	 
	 
 }
}
