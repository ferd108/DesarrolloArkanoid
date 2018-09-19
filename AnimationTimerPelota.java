package fxArkanoid;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class AnimationTimerPelota extends AnimationTimer
{

	private Pelota pelota;
	private Pane paneCancha;
	

	public AnimationTimerPelota(Pelota pelota, Pane paneCancha)
	{
		System.out.println("Constructor de AnimationTimerPelota");	
		this.pelota = pelota;
		this.paneCancha = paneCancha;
		
	
	}

	@Override
	public void handle(long arg0)
	{
		pelota.mover(paneCancha.getHeight(), paneCancha.getWidth());
	}

}
