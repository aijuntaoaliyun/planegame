package individual;

import frame.mainPanel;

public class stuff_father {
	public static mainPanel panel=null; //由于需要用到mainPanel 
										//里面的属性等等
	
	protected float xCoordinate;	//x轴位置

	protected float yCoordinate;	//y轴位置
	protected boolean isDead;
	protected int stuff_type =0;    //用于确定是哪一类 是玩
									//家飞机，还是敌机，还是子弹
	protected float xspeed;			//x轴变化的速度
	protected float yspeed;			//y轴变化的速度
	protected float width;			//图片宽度
	protected float hight;			//图片的高度
	protected boolean isexploded=false;//是否显示完成爆炸
	protected int explode_time=12;  //用于控制爆炸时，显示那一张照片
	protected boolean isout=false;   //是否飞出，游戏显示区域
	public boolean state_out() {
		return this.isout;
	}
	public boolean set_outstate() {
		return this.isout=true;
	}
	public void setX(float X) {
		this.xCoordinate=X;
	}
	public void setY(float Y) {
		this.yCoordinate=Y;
	}
	public int getExplode_time() {
		return this.explode_time;
	}
	public int getType() {
		return this.stuff_type;
	}
	public void left()
	{
		xCoordinate-=xspeed;
	}
	public void explode() {
		if(this.explode_time<=0) {
			this.isexploded=true;
			this.panel.score++;
		}
		
		this.explode_time--;
	}
	public void right() 
	{
		yCoordinate-=yspeed;
	}
	public float getX() {
		return this.xCoordinate;
	}

	public float getY() {
		return this.yCoordinate;
	}
	public float getxSpeed() {
		return this.xspeed;
	}
	public float getySpeed() {
		return this.yspeed;
	}
	public void Dead(){
		
		this.isDead=true;
	}
	public boolean getDeadState(){
		return this.isDead;
	}
    public float getWidth() 
    {
    	return this.width;
    }
    public float getHight() 
    {
    	return this.hight;
    }

	public boolean getExplodestate() {
		
		return this.isexploded;
	}
}



