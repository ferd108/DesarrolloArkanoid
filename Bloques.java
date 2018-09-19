package fxArkanoid;

import java.util.Random;

import javafx.scene.shape.Rectangle;

public class Bloques extends Rectangle
{
	double x = getX();
	Random rm=new Random();
	int i,num;
	
	int Bloques []=new int[10];{
	for(i=0;i<Bloques.length;i++) {
		num=rm.nextInt(9);
		Bloques[i]=num;
		if(x == 30)
		{  
			x += 60;
		}
	}}
	
	public Bloques()
	{	
	this.setX(30);
	this.setY(30);
	this.setWidth(50);
	this.setHeight(50);
	 
	//inge no pudimos terminar el codigo estuvimos todos los dias intentando hacerlo pero no nos alcanzo el tiempo
		
	}
}

	



