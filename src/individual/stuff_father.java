package individual;

import frame.mainPanel;

public class stuff_father {
	public static mainPanel panel=null; //������Ҫ�õ�mainPanel 
										//��������Եȵ�
	
	protected float xCoordinate;	//x��λ��

	protected float yCoordinate;	//y��λ��
	protected boolean isDead;
	protected int stuff_type =0;    //����ȷ������һ�� ����
									//�ҷɻ������ǵл��������ӵ�
	protected float xspeed;			//x��仯���ٶ�
	protected float yspeed;			//y��仯���ٶ�
	protected float width;			//ͼƬ���
	protected float hight;			//ͼƬ�ĸ߶�
	protected boolean isexploded=false;//�Ƿ���ʾ��ɱ�ը
	protected int explode_time=12;  //���ڿ��Ʊ�ըʱ����ʾ��һ����Ƭ
	protected boolean isout=false;   //�Ƿ�ɳ�����Ϸ��ʾ����
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



