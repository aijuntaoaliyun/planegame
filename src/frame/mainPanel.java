package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import listener.move;
import individual.Enemy2_aircraft;
import individual.Enemy_aircraft;
import individual.Enemy_bullet;
import individual.addHealth_point;
import individual.bullet_type2;
import individual.mainAircraft;
import individual.mainAircraft_bullet;
import individual.stuff_father;
import listener.listener;
import javax.swing.JTextField;
import java.util.LinkedList;
import java.util.Random;
public  class mainPanel extends JPanel implements Runnable {
	private Thread gameThread;
	///飞机声明
	public static mainAircraft myplane=null;
	public static move myplane_move;
    public static  int myplane_bullet_type=1;
    ///图片声明
	public static Image bgImage = null;
	public static BufferedImage enemyAircraft_I=null;
	public static BufferedImage mianAircraft_I=null ;
	public static BufferedImage mypanelbullet_I=null ;
	public static BufferedImage mypanel_explode_I=null ;
	public static BufferedImage mypanel_explode_I1=null ;
	public static BufferedImage mypanel_explode_I2=null ;
	public static BufferedImage mypanel_explode_I3=null ;
	public static BufferedImage bullet_type_I=null ;
	public static BufferedImage diji_I=null ;
	public static BufferedImage diji_I1=null ;
	public static BufferedImage diji_I2=null ;
	public static BufferedImage diji_bullet_I=null ;
	public static BufferedImage bg_I1=null ;
	public static BufferedImage enter_I=null ;
	public static BufferedImage bg_I2=null ;
	public static BufferedImage restart_I=null ;
	public static BufferedImage end_I=null ;
	public static BufferedImage add_Health_point_I=null ;
	public static int score=0;
	//存储生命
	public static LinkedList list_Enemy;//用于保存敌机
	public static LinkedList list_myplane_bullet;//用于保存敌机
	public static LinkedList list_Enemy2;//用于保存敌机
    public static LinkedList  list_Enemy_bullet;
    public static LinkedList  list_bullet_type;
    public static LinkedList    list_addHealth_point;
	public static int gameState =0; 
	public int enter_time=0;
	public int choose_resart_end=0;
	public int getChoose=0;
    public int  choose=0;
    public final int T=150;
    public int gap_for_myplane=T;
	//public JTextField name;
	public mainPanel() throws IOException
	{
		addname.panel=this;
		
		//初始化类中的static变量
		Enemy_aircraft.panel=this;
		Enemy2_aircraft.panel=this;
		stuff_father.panel=this;
		move.Panel=this;
		this.setSize(800, 600);;
//图片
		bgImage = Toolkit.getDefaultToolkit().getImage(
			mainPanel.class.getResource("bgi.jpg"));
		mianAircraft_I=ImageIO.read(mainPanel.class.getResource("mianAircraft_I2.gif"));
		enemyAircraft_I=ImageIO.read(mainPanel.class.getResource("enamy1.gif"));
		mypanelbullet_I=ImageIO.read(mainPanel.class.getResource("myplane_bullet1.gif"));
		mypanel_explode_I=ImageIO.read(mainPanel.class.getResource("enemy_ex.gif"));
		mypanel_explode_I1=ImageIO.read(mainPanel.class.getResource("enemy_ex1.gif"));
		mypanel_explode_I2=ImageIO.read(mainPanel.class.getResource("enemy_ex2.gif"));
		mypanel_explode_I3=ImageIO.read(mainPanel.class.getResource("enemy_ex3.gif"));
		diji_I=ImageIO.read(mainPanel.class.getResource("diji.gif"));
		diji_I1=ImageIO.read(mainPanel.class.getResource("diji1.gif"));
		diji_I2=ImageIO.read(mainPanel.class.getResource("diji2.gif"));
		diji_bullet_I=ImageIO.read(mainPanel.class.getResource("Enemy_bullet.gif"));
		bg_I1=ImageIO.read(mainPanel.class.getResource("bg_I1.bmp"));
		enter_I=ImageIO.read(mainPanel.class.getResource("enter_I.gif"));
		bg_I2=ImageIO.read(mainPanel.class.getResource("bg_I2.png"));
		restart_I=ImageIO.read(mainPanel.class.getResource("restart_I.gif"));
		end_I=ImageIO.read(mainPanel.class.getResource("end_I.gif"));
		bullet_type_I=ImageIO.read(mainPanel.class.getResource("bullet_type_I.gif"));
		add_Health_point_I=ImageIO.read(mainPanel.class.getResource("addHealth_point_I.gif"));
		// 
		 new addname();
		//实例化存储介质
		list_Enemy=new LinkedList();
		list_myplane_bullet=new LinkedList();
		list_Enemy2=new LinkedList();
		list_Enemy_bullet=new LinkedList();
		list_bullet_type=new LinkedList();
		list_addHealth_point=new LinkedList();
          this.addKeyListener(new listener());
      	  setFocusable(true);
      	  gameThread = new Thread(this);
      	  gameThread.start();
	}
	
	public void  run()
	{long Gap=1;
    
	myplane=new mainAircraft((float)(this.getWidth()/2.0),(float)(this.getHeight()-44.0-40),(float)(48.0),(float)44.0);

	myplane_move=new move(myplane);
	Enemy_bullet.target=myplane;
	  
	while(Gap>0)
	{  
	  	
		if(this.gameState==0) {
			
			this.enter_time++;
			if(this.enter_time>61) {
				this.enter_time=0;
			}
			
			if(listener.enter) {
				this.gameState=1;
			}
		}
		
	if(this.gameState==1) {
		
		if(Gap>0&&Gap<=2500) {//随着时间的增长生成敌机的速度越来越快
			if(Gap%500==1) {
				creatEnemy(list_Enemy);
				createnemy2();	
			}
		}else if(Gap>2500&&Gap<=5000) {
			if(Gap%400==1) {
				creatEnemy(list_Enemy);
				createnemy2();	
			}
		}else if(Gap>5000&&Gap<=8500){
			if(Gap%300==1) {
				creatEnemy(list_Enemy);
				createnemy2();	
			}
		}else if(Gap>8500&&Gap<=12000){
			if(Gap%200==1) {
				creatEnemy(list_Enemy);
				createnemy2();	
			}
		}else {
			if(Gap%150==1) {
				creatEnemy(list_Enemy);
				createnemy2();	
			}
		}
			
		if(Gap%800==1) {
			creatBullettype();
		}
		if(Gap%1000==1) {
			creataddHealth();
		}
		
			
			if(Gap%500==1) {
			
				
			}
			
			//敌机移动
			moveEnemy(list_Enemy);
			moveEnemy(list_Enemy2);
			moveEnemy(list_bullet_type);
			moveEnemy(list_addHealth_point);
			if(this.myplane.getHealth_point()>0) {
				myplane_move.moving();//我的飞机移动
				myplane_enemybullet(myplane,list_Enemy_bullet);
				myplane_enemy2(myplane,list_Enemy2);
				myplane_enemy(myplane,list_Enemy);
				myplane_bullet_type(myplane,list_bullet_type);
				myplane_addHealth_point(myplane,list_addHealth_point);

			}
			
			movepanelbullet(list_myplane_bullet);//我的飞机的子弹移动
			moveEnemybullet(list_Enemy_bullet);
		
			enemy_mypanebullet(list_Enemy,list_myplane_bullet);		//敌机与子弹相遇处理
			enemy_mypanebullet(list_Enemy2,list_myplane_bullet);
		
			ifout(list_bullet_type);
			ifout(list_Enemy);                                      //子弹和飞机是否飞出区域
			ifout(list_myplane_bullet);
			ifout(list_Enemy2);
			ifout(list_Enemy_bullet);
			ifout(list_addHealth_point);
		    
			clearDead(list_Enemy);                                   //删除飞出区域，已经爆炸的飞机
			clearDead(list_myplane_bullet);
			clearDead(list_Enemy2);
			clearDead(list_Enemy_bullet);
			clearDead(list_bullet_type);
			clearDead(list_addHealth_point);
			
		    if(this.myplane.getHealth_point()<=0) {
		    	
		    //	this.gameState=3;
		    	
		    	if(gap_for_myplane<=0) {  //为了停留在死了之后，没有任何飞机子弹补给，只有一个背景。
		    		addname.addName_score();
		    		list_Enemy.clear();
			    	list_Enemy2.clear();
			    	list_Enemy_bullet.clear();
			    	list_bullet_type.clear();
			    	list_addHealth_point.clear();
		    		this.gameState=2;
		    		
		    	}
		    	 gap_for_myplane--;
		    }
		   
	}
	
	if(this.gameState==2) {
		
		if(listener.real_down) {
			this.choose_resart_end++;
		}
		if(listener.real_up) {
			this.choose_resart_end--;
		}
		this.choose=Math.abs(this.choose_resart_end)%2;
		if(this.choose==0) {
			this.getChoose=0;
			
		}else {
			this.getChoose=1;
		}
		if(listener.enter) {
			if(this.getChoose==0) {
			    this.gameState=1;
				myplane=new mainAircraft((float)(this.getWidth()/2.0),(float)(this.getHeight()-44.0-40),(float)(48.0),(float)44.0);
				myplane_move=new move(myplane);
				Enemy_bullet.target=myplane;
				gap_for_myplane=T;
				this.score=0;
				Gap=0;//难度从0开始
			}else {
				System.exit(0);
			}
		}
		
	//	System.out.println(this.getChoose);
		listener.real_up=false;
		listener.real_down=false;
		listener.gap--;
		listener.gap1--;
	}
	try {
		Thread.sleep(10);
	} catch (Exception e) {

	}
	repaint();
	Gap++;	
		
		
	}	

	//循环结束
	if(Gap==Long.MAX_VALUE-10) {
		Gap=0;
	}
		
	}
	
	public void paint(Graphics g) 
	{	super.paint(g);
	    if(this.gameState==0) {
	    //	System.out.println("看见了吗");
	    	g.drawImage(bg_I1,0,0,800,600,this);
	    	if(this.enter_time>=0&&this.enter_time<=15) {
	    		g.drawImage(enter_I, 450+90, 350+60, 200, 200, this);
	    	}else if(this.enter_time>15&&this.enter_time<=30) {
	    		g.drawImage(enter_I, 455+90, 355+60, 190, 190, this);
	    	}else if(this.enter_time>30&&this.enter_time<=45) {
	    		g.drawImage(enter_I, 460+90, 360+60, 180, 180, this);
	    	
	    	}else if(this.enter_time>45&&this.enter_time<=61) {
	    		g.drawImage(enter_I, 465+90, 365+60, 170, 170, this);
	    	}
	        g.setFont(new Font("宋体", Font.BOLD, 15));
	      g.setColor(Color.WHITE);
	      g.drawString("enter:开始", 20, 20);	
	      g.drawString("W S A D：控制方向",20,60);
	      g.drawString("J:发射子弹", 20, 100);
	      
	      
	    }
	    if(this.gameState==1) {
	    	g.fillRect(0, 0, 800,600);
			g.drawImage(bgImage,0,0,800,600,this);
			 
	        if(myplane.getHealth_point()<=0) {
	        	contralboom(myplane,g);   ////我的飞机爆炸
	        }else {
	            if(myplane.get_Explosionflashing_time()>0) {
	            	if(myplane.get_Explosionflashing_time()>40) {
	            		myplane.Explosionflashing_time_down();
	            	}else if(myplane.get_Explosionflashing_time()>30&&myplane.get_Explosionflashing_time()<=40) {
	            		g.drawImage(mianAircraft_I,(int)myplane.getX(),(int)myplane.getY(),(int)myplane.getWidth(),(int)myplane.getHight(),this);
	            		myplane.Explosionflashing_time_down();
	            	}else if(myplane.get_Explosionflashing_time()>20&&myplane.get_Explosionflashing_time()<=30) {
	            		myplane.Explosionflashing_time_down();
	            	}else if(myplane.get_Explosionflashing_time()>10&&myplane.get_Explosionflashing_time()<=20) {
	            		g.drawImage(mianAircraft_I,(int)myplane.getX(),(int)myplane.getY(),(int)myplane.getWidth(),(int)myplane.getHight(),this);
	            		myplane.Explosionflashing_time_down();
	            	}else if(myplane.get_Explosionflashing_time()>=0&&myplane.get_Explosionflashing_time()<=10) {
	            		myplane.Explosionflashing_time_down();
	            	}
	            }else {
	        		g.drawImage(mianAircraft_I,(int)myplane.getX(),(int)myplane.getY(),(int)myplane.getWidth(),(int)myplane.getHight(),this);

	            }
	        }
		    //显示敌机的位置
			for(int i=0;i<list_Enemy.size();i++) {
				Enemy_aircraft enemy=(Enemy_aircraft) list_Enemy.get(i);
			if(!enemy.getDeadState()) {
				 g.drawImage(enemyAircraft_I,(int)enemy.getX(),(int)enemy.getY(),(int)enemy.getWidth(),(int)enemy.getHight(),this);

			}else if(enemy.getDeadState()&&!enemy.getExplodestate()){
				contralboom(enemy,g);
			}
			 
			}
		
			for (int i=0;i<list_Enemy2.size();i++) {
				Enemy2_aircraft enemy=(Enemy2_aircraft) list_Enemy2.get(i);
				if(!enemy.getDeadState()) {
					if(!enemy.getChoosepic()) {
						 g.drawImage(diji_I,(int)enemy.getX(),(int)enemy.getY(),(int)enemy.getWidth(),(int)enemy.getHight(),this);

					}else if(enemy.getLeft()) {
						 g.drawImage(diji_I1,(int)enemy.getX(),(int)enemy.getY(),(int)enemy.getWidth(),(int)enemy.getHight(),this);
					}else {
						 g.drawImage(diji_I2,(int)enemy.getX(),(int)enemy.getY(),(int)enemy.getWidth(),(int)enemy.getHight(),this);

					}

				}else if(enemy.getDeadState()&&!enemy.getExplodestate()){
					contralboom(enemy,g);
				}

			} 
			//显示我的飞机的子弹的位置
			for(int i=0;i<list_myplane_bullet.size();i++) {
				
				mainAircraft_bullet bullet=(mainAircraft_bullet) list_myplane_bullet.get(i);
				if(!bullet.getDeadState()) {
					g.drawImage(mypanelbullet_I, (int)bullet.getX(),(int) bullet.getY(),(int) bullet.getWidth(), (int)bullet.getHight(), this);
				}
			}
			//显示敌机的子弹
			
	        for(int i=0;i<list_Enemy_bullet.size();i++) {
				
	        	Enemy_bullet bullet=(Enemy_bullet) list_Enemy_bullet.get(i);
				if(!bullet.getDeadState()) {
					g.drawImage(diji_bullet_I, (int)bullet.getX(),(int) bullet.getY(),(int) bullet.getWidth(), (int)bullet.getHight(), this);
				}
			}
	        	for(int i=0;i<list_bullet_type.size();i++) {
				
	        		bullet_type2 bullet=(bullet_type2) list_bullet_type.get(i);
				if(!bullet.getDeadState()) {
					g.drawImage(bullet_type_I, (int)bullet.getX(),(int) bullet.getY(),(int) bullet.getWidth(), (int)bullet.getHight(), this);
				}
			}
	        	
	        	for(int i=0;i<list_addHealth_point.size();i++) {
					
	        		addHealth_point bullet=(addHealth_point) list_addHealth_point.get(i);
				if(!bullet.getDeadState()) {
					g.drawImage(add_Health_point_I, (int)bullet.getX(),(int) bullet.getY(),(int) bullet.getWidth(), (int)bullet.getHight(), this);
				}
			}
	        	
	        
	        g.setColor(Color.blue);
	        g.fillRect( 0,this.getHeight()-40,this.getWidth(),5);
	        g.setColor(Color.gray);
	        g.fillRect( 0,this.getHeight()-35,this.getWidth(),35);
	        g.setColor(Color.WHITE);
	        g.setFont(new Font("宋体", Font.BOLD, 20));
	        g.drawString("生命值:" , 320+70, 590);
	        g.drawString("子弹: 无限" , 0, 590);
	        g.drawString("歼敌数："+this.score , 180, 590);

	        g.setColor(Color.CYAN);
	        drawHealthPoint(g,myplane.getHealth_point());
	        g.setColor(Color.WHITE);
	        g.drawRect(410+70, 573, 300, 22);
	    }
	    if(this.gameState==2) {
	  
	    	if(this.getChoose==0) {
	    		g.drawImage(bg_I2,0,0,800,600,this);
		    	g.setColor(Color.white);
		    	g.fillOval(625, 190, 105, 105);
		     //	g.setColor(Color.RED);
			  //  g.fillRect(625, 310, 105, 105);
		    	g.drawImage(restart_I, 630, 195, 95, 95, this);
		    	g.drawImage(end_I, 630, 315, 95, 95, this);
	    	}else {
	    		g.drawImage(bg_I2,0,0,800,600,this);
		    	//g.setColor(Color.white);
		    	//g.fillOval(625, 190, 105, 105);
		     g.setColor(Color.RED);
			   g.fillRect(625, 310, 105, 105);
		    	g.drawImage(restart_I, 630, 195, 95, 95, this);
		    	g.drawImage(end_I, 630, 315, 95, 95, this);
	    	
	    	}
	    	g.setFont(new Font("宋体", Font.BOLD, 20));
	    	g.setColor(Color.WHITE);
	    	g.drawString("重玩,结束选择：”↑“  ”↓“ 键" , 0,30);
	    	g.drawString("确定：”enter“ 键" , 0,60);

	    	g.drawString("姓名--------歼敌数" , 0,100);
	    	for (int i=0;i<10;i++) {
	    		if(addname.players_score[i]==0) {
	    			break;
	    		}
	    		g.drawString(addname.players_name[i], 0, 100+i*40+40);
	    		g.drawString(""+addname.players_score[i], 125, 100+i*40+40);
                //System.out.println(addname.players_score[i]);
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	//g.setColor(Color.WHITE);
	    	//g.drawOval(630, 195, 95, 95);
	     	//g.setColor(Color.red);
		   // g.drawRect(630, 315, 95, 95);
	    }
		
        

	}
	
	public void  drawHealthPoint(Graphics g,int h) {
		int x=0;
		if(h>12) {
			g.setColor(Color.GREEN);
		}
		else if(h>8&&h<=12) {
			g.setColor(Color.CYAN);
		}else if(h>4&&h<=8) {
			g.setColor(Color.YELLOW);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(410+70, 573, h*20, 22);
	}
	
	     
	
	//清除已经死掉的飞机，子弹
	public void clearDead(LinkedList list) {
		int list_size=list.size();
		for (int j=0;j<list_size;j++) {
			stuff_father stuff=(stuff_father)list.removeFirst();
		      if(stuff.getType()==2||stuff.getType()==4) {
		    	
		    	  if(stuff.state_out()||stuff.getExplodestate()) {
		    		 
		    		  continue;
		    	  }else{
		    		  list.addLast(stuff);
		    		 
		    	  }
		   
			}
		      else if(stuff.getType()==3||stuff.getType()==6||stuff.getType()==5||stuff.getType()==7) {
		    	   
		    	  if(stuff.getDeadState()) {
		    		  continue;
		    	  }else {
		    		  list.addLast(stuff);
		    	  }
		      }
		      
		    
		}
	}
	//爆炸显示
	public void contralboom(stuff_father stuff1,Graphics g) {
	
		
		
		
		switch(stuff1.getExplode_time()) {
		case 0:
		case 1:{
			
		}
		case 2:{
		
		}
		case 3:{
			g.drawImage(mypanel_explode_I1,(int)stuff1.getX(),(int)stuff1.getY(),(int)stuff1.getWidth(),(int)stuff1.getHight(),this);
			stuff1.explode();break;
		}
		case 4:{
			
		}case 5:
		case 6:{
			g.drawImage(mypanel_explode_I,(int)stuff1.getX(),(int)stuff1.getY(),(int)stuff1.getWidth(),(int)stuff1.getHight(),this);
			stuff1.explode();break;
		}
		case 7:
		case 8:{
			
		}
		case 9:{
			g.drawImage(mypanel_explode_I2,(int)stuff1.getX(),(int)stuff1.getY(),(int)stuff1.getWidth(),(int)stuff1.getHight(),this);
			stuff1.explode();break;
		}
		case 10:
		case 11:
		case 12:{
			g.drawImage(mypanel_explode_I3,(int)stuff1.getX(),(int)stuff1.getY(),(int)stuff1.getWidth(),(int)stuff1.getHight(),this);
			stuff1.explode();break;
		}
		}
	}
	//创建敌机
	public void creatEnemy(LinkedList list) {
		
		Random r=new Random();
		int amount =r.nextInt(4)+3;
		int x=r.nextInt(this.getWidth()+100)-50;
		int y=-20;
		if(x<=this.getWidth()) {
			for (int i=0;i<amount;i++) {
				Enemy_aircraft enemy=	new Enemy_aircraft(x-i*(55),y-i*(20));
				
				list.add(enemy);
			}	
		}
		
		else {
			for (int i=0;i<amount;i++) {
				list.add(new Enemy_aircraft(x+i*(60),y-i*(60)));
			}	
		}
		
		
		
	}
	
	public void moveEnemy(LinkedList list) { ///可以移动bullet——type
		for(int i=0;i<list.size();i++) {
			
			stuff_father Enemy=(stuff_father)list.get(i);
			if(Enemy.getType()==2) {
				Enemy_aircraft enemy2=(Enemy_aircraft) Enemy;
				enemy2.move();
			}
			else if(Enemy.getType()==4) {
				Enemy2_aircraft enemy4=(Enemy2_aircraft) Enemy;
				enemy4.move();
			}else if(Enemy.getType()==6) {
				bullet_type2 bullet_type=(bullet_type2)Enemy;
				bullet_type.move();
			}else if(Enemy.getType()==7) {
				addHealth_point health=(addHealth_point)Enemy;
				health.move();
			
		}
			}
	}
	public void addmypanelbullet(mainAircraft_bullet bullet) {
		this.list_myplane_bullet.add(bullet);
	}
	public void addEnemybullet(Enemy_bullet bullet) {
		this.list_Enemy_bullet.add(bullet);
	}
	public void movepanelbullet(LinkedList list) {
		for(int i=0;i<list.size();i++) {
			mainAircraft_bullet bullet=(mainAircraft_bullet)list.get(i);
			bullet.move();
		}
	}
	public void moveEnemybullet(LinkedList list) {
		for(int i=0;i<list.size();i++) {
			Enemy_bullet bullet=(Enemy_bullet)list.get(i);
			bullet.move();
		}
	}
	//判断敌机是否中弹，然后改变子弹和飞机的状态
	public void enemy_mypanebullet(LinkedList list_enemy,LinkedList list_bullet) {
		
		for (int i=0;i<list_enemy.size();i++) {
			
			stuff_father enemy_f=(stuff_father)list_enemy.get(i);
			if(enemy_f.getType()==2) {
				Enemy_aircraft	enemy=(Enemy_aircraft) enemy_f;
				for (int j=0;j<list_bullet.size();j++) {
					mainAircraft_bullet bullet=(mainAircraft_bullet)list_bullet.get(j);
					if(isstuffmeet(bullet,enemy)) {
					//	System.out.println("11");
						if(bullet.getDeadState()) {
							continue;
						}
						bullet.Dead();
						enemy.Dead();
					}
				}
			}else if(enemy_f.getType()==4) {
				Enemy2_aircraft enemy=(Enemy2_aircraft) enemy_f;
				for (int j=0;j<list_bullet.size();j++) {
					mainAircraft_bullet bullet=(mainAircraft_bullet)list_bullet.get(j);
					if(isstuffmeet(bullet,enemy)) {
						if(bullet.getDeadState()) {
							continue;
						}
						bullet.Dead();
						enemy.Dead();
					}
				}
			}
			
			
		}
	}
	
	public void  myplane_enemybullet(mainAircraft A,LinkedList list_enemybullet) {
		for (int i=0;i<list_enemybullet.size();i++) {
			Enemy_bullet bullet=(Enemy_bullet) list_enemybullet.get(i);
			if(isstuffmeet(A,bullet)) {
				if(bullet.getDeadState()) {
					continue;
				}
				bullet.Dead();
				A.getshot();
				A.setBullet_type(1);
			}
		}
	}
	public void  myplane_enemy2(mainAircraft A,LinkedList list_enemybullet) {
		for (int i=0;i<list_enemybullet.size();i++) {
			Enemy2_aircraft bullet=(Enemy2_aircraft) list_enemybullet.get(i);
			if(isstuffmeet(A,bullet)) {
				if(bullet.getDeadState()) {
					continue;
				}
				bullet.Dead();
				A.getshot();
				A.setBullet_type(1);
			}
		}
	}
	public void  myplane_bullet_type(mainAircraft A,LinkedList list_enemybullet) {
		for (int i=0;i<list_enemybullet.size();i++) {
			bullet_type2 bullet=(bullet_type2) list_enemybullet.get(i);
			if(isstuffmeet(A,bullet)) {
				if(bullet.getDeadState()) {
					continue;
				}
				myplane.setBullet_type(2);
				bullet.Dead();
			}
		}
	}
	public void  myplane_addHealth_point(mainAircraft A,LinkedList list_enemybullet) {
		for (int i=0;i<list_enemybullet.size();i++) {
			addHealth_point bullet=(addHealth_point) list_enemybullet.get(i);
			if(isstuffmeet(A,bullet)) {
				if(bullet.getDeadState()) {
					continue;
				}
				myplane.addhealth();
				bullet.Dead();
			}
		}
	}

	
	public void  myplane_enemy(mainAircraft A,LinkedList list_enemybullet) {
		for (int i=0;i<list_enemybullet.size();i++) {
			Enemy_aircraft bullet=(Enemy_aircraft) list_enemybullet.get(i);
			if(isstuffmeet(A,bullet)) {
				if(bullet.getDeadState()) {//一个敌机或子弹只能使战机剪掉一格血
					continue;
				}
				bullet.Dead();
				A.getshot();
				A.setBullet_type(1);
			}
		}
	}
	
	//判断两个物件是否
	public boolean isstuffmeet(stuff_father A,stuff_father B) {
		float A_X=A.getX();
		float A_Y=A.getY();
		float B_X=B.getX();
		float B_Y=B.getY();
		
	if(((A_X-10<B.getWidth()+B_X)&&(A_X+10>B_X))||(((A_X+A.getWidth())>B_X)&&(A_X+A.getWidth())<(B_X+B.getWidth())) ){
			
			if((A_Y-10<(B_Y+B.getHight()))&&A_Y+A.getHight()+10>B_Y+B.getHight()||(A_Y-10<B_Y&&A_Y+A.getHight()>B_Y) ){
				
				return true;
				
			}else {
				return false;
			}
		}else {
			return false;
		} 
		
		/*if((B_X<A_X+A.getWidth()&&B_X>A_X)&&(B_Y+B.getHight()<A_Y+A.getHight()&&B_Y+B.getHight()>A_Y)) {
			return true;
		}else if((B_X+B.getWidth()<A_X+A.getWidth()&&B_X+B.getWidth()>A_X)&&(B_Y+B.getHight()<A_Y+A.getHight()&&B_Y+B.getHight()>A_Y)) {
			return true;
		}else if(((B_X<A_X+A.getWidth()&&B_X>A_X)&&(B_Y<A_Y+A.getHight()&&B_Y>A_Y))) {
			return true;
		}else if((B_X+B.getWidth()<A_X+A.getWidth()&&B_X+B.getWidth()>A_X)&&(B_Y<A_Y+A.getHight()&&B_Y>A_Y)) {
			return true;
		}else {
			return false;
		}   */
		
	}
	
	public void ifout(LinkedList list) {
		for (int j=0;j<list.size();j++) {
			stuff_father stuff=(stuff_father)list.get(j);
			if(stuff.getType()==3) {
				if(stuff.getY()<0) {
					stuff.Dead();
				}
			}else {
				if(stuff.getY()>this.getHeight()) {

					stuff.set_outstate();
				}
			}
		}
	}
    public void createnemy2() {
    	float x=this.getWidth();
    	for(int i =0;i<6;i++) {
    		list_Enemy2.add(new Enemy2_aircraft(x/2-55+60*i,-20));
    	}
    	for(int i =0;i<5;i++) {
    		list_Enemy2.add(new Enemy2_aircraft(x/2-55-60*i,-20));
    	}
    }
    public void creatBullettype() {
    	list_bullet_type.add(new bullet_type2());
    }
    public void creataddHealth() {
    	list_addHealth_point.add(new addHealth_point());
    }

}
