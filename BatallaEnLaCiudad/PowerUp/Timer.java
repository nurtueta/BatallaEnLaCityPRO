package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Timer extends PowerUp{

	public Timer(int x, int y){
		super(x,y);
		this.deQuienEs=9; //9 indica que es un powerup
		//manejo=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTimer.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public void colision(int quienEs){
		//Detiene temporalmente a todos los tanques enemigos.
	} 
	
}
