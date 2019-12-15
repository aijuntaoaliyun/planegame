package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class listener extends KeyAdapter {
	//用于判断是否按下，左右上下，发射子弹的标记变量。
	static boolean left; 
	static boolean right;
	static boolean up;
	static boolean down;
	static boolean j_key;
     public static int gap=0;
     public static int gap1=0;
	public static boolean enter; //用于控制开始游戏。
	public static boolean real_up; 
	public static boolean real_down;
    public static int r=0;
    public static int r1=0;
	public void keyPressed(KeyEvent e) {
		
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				break;
			case KeyEvent.VK_UP:    //为了按下移动但是不能随着时钟一直移动
				if(this.gap<=0) {   //最后那个选项
					real_up=true;
					gap=5;
				}
				
				 break;
			case KeyEvent.VK_DOWN:    //为了按下移动但是不能随着时钟一直移动
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

