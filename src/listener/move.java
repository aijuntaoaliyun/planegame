package listener;


import frame.mainPanel;
import individual.mainAircraft;
import individual.mainAircraft_bullet;
import individual.stuff_father;

public class move {
 public  static mainPanel Panel;
//用于减少生成子弹的频率，
//假设一直按着j键（也就是发射子弹键），
 //如果一直按着j键，产生子弹的频率，
 //就是页面刷新频率：mainPanel 里面的while（） 的频率
 //生成的太快了，要控制
 private   int Gap_myplane_bullet=0;
 private stuff_father stuff; 
 public move(stuff_father stuff) {
	 this.stuff=stuff;
 }
 
 public void  moving() {
	           //哪个键按下，执行那一块。
	  
				if (listener.left) {
					stuff.setX(stuff.getX()-stuff.getxSpeed());
					if (stuff.getX() < 0)
						stuff.setX(0);
				}
				if (listener.right) {
				
					stuff.setX(stuff.getX()+stuff.getxSpeed());
					if (stuff.getX()> Panel.getWidth() - stuff.getWidth())
						stuff.setX(Panel.getWidth() - stuff.getWidth());
				}
				if (listener.up) {
				
					stuff.setY(stuff.getY()-stuff.getySpeed());
					if (stuff.getY() < 0)
						stuff.setY(0);
				}
				if (listener.down) {
					stuff.setY(stuff.getY()+stuff.getySpeed());
					if (stuff.getY() > Panel.getHeight() - stuff.getHight()-40)
						 stuff.setY(Panel.getHeight() - stuff.getHight()-40);
				}
		
				if(listener.j_key) {
					if(this.Panel.myplane.get_bullet_type()==1) {
						if(Gap_myplane_bullet<=0) { //减少射弹数量
				        	   mainAircraft_bullet bullet=new mainAircraft_bullet(stuff.getX()+17,stuff.getY());
								Panel.addmypanelbullet(bullet);  
								Gap_myplane_bullet=10;
				        }
					}else if(this.Panel.myplane.get_bullet_type()==2) {//吃到补给之后，增加单次产弹量并变换子弹生成位置，
						if(Gap_myplane_bullet<=0) { //减少射弹数量
							 mainAircraft_bullet bullet=new mainAircraft_bullet(stuff.getX()+17,stuff.getY());
							 mainAircraft_bullet bullet1=new mainAircraft_bullet(stuff.getX()+34,stuff.getY());
							 mainAircraft_bullet bullet2=new mainAircraft_bullet(stuff.getX(),stuff.getY());
								Panel.addmypanelbullet(bullet);  
								Panel.addmypanelbullet(bullet1); 
								Panel.addmypanelbullet(bullet2); 
								Gap_myplane_bullet=10;
				        }
						
					}
				        
						
					}
				Gap_myplane_bullet--;
}}