package ihm;

public class fenetre {
	
	protected int width, height, posX, posY;
	protected String title="COLOR SWITCHER";
	
	public fenetre(){
		width=450;
		height=300;
		posX=0;
		posY=0;
	}
	
	public void setWidth(int w){
		width=w;
	}
	
	public void setHeight(int h) {
		height=h;
	}
	
	public void setPosX(int x) {
		posX=x;
	}
	
	public void setPosY(int y){
		posY=y;
	}

}
