package fxArkanoid;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.MalformedURLException;

public class fxArkanoidController {
	
	@FXML
	private Pane paneCancha;
	private Button botonComenzar;
	private Pelota pelota;
	private Plataforma plataforma;
	private AnimationTimer timerPelota;
	private Bloques bloques;

	
	@FXML
	public void initialize() throws MalformedURLException
	{
		System.out.println("FxPlataformaController initializer");

		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);
		
		File file2 = new File("img/bloque.png");
		String localUrl2 = file2.toURI().toURL().toString();
		Image img2 = new Image(localUrl2);
		
		bloques = new Bloques();
		bloques.setFill(new ImagePattern(img2));
		paneCancha.getChildren().add(bloques);
		
		File file1 = new File("img/plataforma.png");
		String localUrl1 = file1.toURI().toURL().toString();
		Image img1 = new Image(localUrl1);
		
		plataforma = new Plataforma();
		plataforma.setFill(new ImagePattern(img1));
		paneCancha.getChildren().add(plataforma);
		
		File file = new File("img/pelota.png");
		String localUrl = file.toURI().toURL().toString();
		Image img = new Image(localUrl);
		
		pelota = new Pelota(340, 25, 10, 80, plataforma);
		pelota.setFill(new ImagePattern(img));
		paneCancha.getChildren().add(pelota);
		
		timerPelota = new AnimationTimerPelota(pelota, paneCancha);
		timerPelota.start();
		
		
		

	}

	@FXML
	public void botonComenzarHnd()
	{
		System.out.println("Boton Comenzar Presionado");
		pelota.cambiaEstado();
		if (pelota.getEstado())
			botonComenzar.setText("Pausar");
		else
			botonComenzar.setText("Comenzar");
	}
	

		@FXML
		public void botonSalirHnd()
		{
			System.out.println("Boton Salir presionado.");
			System.exit(0);
		}		
	
	@FXML
	public void keyMoveHnd(KeyEvent key)
	{
		double x = plataforma.getX();
		double y = plataforma.getY();

		switch(key.getCode())
		{
		case LEFT:
		case KP_LEFT:
			x-=50;
			break;
		case RIGHT:
		case KP_RIGHT:
			x+=50;
			break;
		default:
			System.out.println("KeyMoveHnd:" + key.getCode() );
			break;
		}
		
		key.consume();	
		
		plataforma.setX(x);
		plataforma.setY(y);
	}}
	
	
	
	

