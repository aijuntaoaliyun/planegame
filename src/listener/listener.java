package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class listener extends KeyAdapter {
	//�����ж��Ƿ��£��������£������ӵ��ı�Ǳ�����
	static boolean left; 
	static boolean right;
	static boolean up;
	static boolean down;
	static boolean j_key;
     public static int gap=0;
     public static int gap1=0;
	public static boolean enter; //���ڿ��ƿ�ʼ��Ϸ��
	public static boolean real_up; 
	public static boolean real_down;
    public static int r=0;
    public static int r1=0;
	public void keyPressed(KeyEvent e) {
		
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				break;
			case KeyEvent.VK_UP:    //Ϊ�˰����ƶ����ǲ�������ʱ��һֱ�ƶ�
				if(this.gap<=0) {   //����Ǹ�ѡ��
					real_up=true;
					gap=5;
				}
				
				 break;
			case KeyEvent.VK_DOWN:    //Ϊ�˰����ƶ����ǲ�������ʱ��һֱ�ƶ�
				if(this.gap1<=0) {
					real_down=true;
					gap1=5;
				}
				
				 break;
			case KeyEvent.VK_D:
				right = true;
				break;

			case KeyEvent.VK_W:
				up = true;
				break;

			case KeyEvent.VK_S:
				down = true;
				break;

			case KeyEvent.VK_J:
				j_key = true;
				break;

			

			case KeyEvent.VK_ENTER:
				enter = true;
				break;
			}
		
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;

		case KeyEvent.VK_D:
			right = false;
			break;

		case KeyEvent.VK_W:
			up = false;
			break;

		case KeyEvent.VK_S:
			down = false;
			break;

		case KeyEvent.VK_J:
			j_key = false;
			break;

	
		case KeyEvent.VK_UP:
			 real_up=false;	
			
			 break;
		case KeyEvent.VK_DOWN:
			 real_down=false;	
			
			 break;
	
			
		case KeyEvent.VK_ENTER:
		    enter = false;
			break;
		}
	}

}

