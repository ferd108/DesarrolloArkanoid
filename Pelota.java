package fxArkanoid;

import javafx.scene.shape.Circle;

public class Pelota extends Circle
{
	private static final int DIAMETER = 40;
	private boolean estado;
	private double angulo;
	private double sentido;
	private Plataforma plataforma;
	
	public Pelota (double x, double y, double radio, double angulo, Plataforma plataforma)
	{
		System.out.println("Constructor de la Pelota");
		this.setCenterX(340);
		this.setCenterY(500);
		this.setRadius(y - radio);
		this.plataforma = plataforma;
		this.estado = false;
		this.angulo = angulo;
		this.sentido = 10;
	}
	
	public void mover(double alto, double ancho)
	{
		if (estado)
		{
			double x = this.getCenterX();
			double y = this.getCenterY();

			if (Math.abs(angulo) <= 45)
			{
				if (x-this.getRadius() <= 0 || x+this.getRadius() >= ancho)
				{
					this.angulo = -this.angulo;
					this.sentido = -this.sentido;
				}
				else if (y-this.getRadius() <= 0 || y+this.getRadius() >= alto)
					this.angulo = -this.angulo;

				x += sentido;
				y += sentido * Math.tan(Math.toRadians(angulo));
			}
			else if (Math.abs(angulo) > 45)
			{
				if (x-this.getRadius() <= 0 || x+this.getRadius() >= ancho)
				{
					this.angulo = -this.angulo;
				}
				else if (y-this.getRadius() <= 0 || y+this.getRadius() >= alto)
				{
					this.angulo = -this.angulo;
					this.sentido = -this.sentido;
				}
				x += sentido / Math.tan(Math.toRadians(angulo));
				y += sentido;
			}
			else if (Math.abs(angulo) == 90)
			{
				if (y-this.getRadius() <= 0 || y+this.getRadius() >= alto)
				{
					this.sentido = -this.sentido;
				}
				y += sentido;
			}
			if (plataforma.getBoundsInParent().intersects(this.getBoundsInParent())) 
			{	
				if (angulo <= 45) {
					if (x - this.getRadius() <= plataforma.getX() + plataforma.getWidth()
							|| x + this.getRadius() >= plataforma.getX()) {
						sentido = -sentido;
						angulo = -angulo;
					} else if (y - this.getRadius() <= plataforma.getY() + plataforma.getHeight()
							|| y + this.getRadius() >= plataforma.getY()) {
						angulo = -angulo;
						y = plataforma.getTopY() - DIAMETER;
					}
					x += sentido;
					y += sentido * Math.tan(Math.toRadians(angulo));
				} else {
					if (x - this.getRadius() <= plataforma.getX() + plataforma.getWidth()
							|| x + this.getRadius() >= plataforma.getX()) {
						angulo = -angulo;
					} else if (y - this.getRadius() <= plataforma.getY() + plataforma.getHeight()
							|| y + this.getRadius() >= plataforma.getY()) {
						sentido = -sentido;
						angulo = -angulo;
					}
					x += sentido / Math.tan(Math.toRadians(angulo));
					y += sentido;
				}
			}
			


			this.setCenterX(x);
			this.setCenterY(y);
		}
	}

	public void cambiaEstado()
	{
		this.estado = !this.estado;
	}

	public boolean getEstado()
	{
		return this.estado;
	}
	
	
	}
		
	
	




	