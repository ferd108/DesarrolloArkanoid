package fxArkanoid;

import javafx.scene.shape.Rectangle;

public class Plataforma extends Rectangle
{
	private int Y = 650;
	
	public Plataforma()
	{	
	this.setX(290);
	this.setY(650);
	this.setWidth(100);
	this.setHeight(20);
	this.setArcWidth(50);
	this.setArcHeight(50);
	}
	public int getTopY() {
		return Y;
	
	}
	

}
