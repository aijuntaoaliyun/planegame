package listener;


import frame.mainPanel;
import individual.mainAircraft;
import individual.mainAircraft_bullet;
import individual.stuff_father;

public class move {
 public  static mainPanel Panel;
//���ڼ��������ӵ���Ƶ�ʣ�
//����һֱ����j����Ҳ���Ƿ����ӵ�������
 //���һֱ����j���������ӵ���Ƶ�ʣ�
 //����ҳ��ˢ��Ƶ�ʣ�mainPanel �����while���� ��Ƶ��
 //���ɵ�̫���ˣ�Ҫ����
 private   int Gap_myplane_bullet=0;
 private stuff_father stuff; 
 public move(stuff_father stuff) {
	 this.stuff=stuff;
 }
 
 public void  moving() {
	           //�ĸ������£�ִ����һ�顣
	  
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
						if(Gap_myplane_bullet<=0) { //�����䵯����
				        	   mainAircraft_bullet bullet=new mainAircraft_bullet(stuff.getX()+17,stuff.getY());
								Panel.addmypanelbullet(bullet);  
								Gap_myplane_bullet=10;
				        }
					}else if(this.Panel.myplane.get_bullet_type()==2) {//�Ե�����֮�����ӵ��β��������任�ӵ�����λ�ã�
						if(Gap_myplane_bullet<=0) { //�����䵯����
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