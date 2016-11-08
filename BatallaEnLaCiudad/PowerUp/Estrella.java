package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Estrella extends PowerUp{

	public Estrella (int x, int y){
		super(x,y);
//		this.deQuienEs=9; //9 indica que es un powerup
		//manejo=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpEstrella.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public void colision(int quienEs){
		//Aumenta el nivel del tanque del jugador. Al ser destruido, el jugador vuelve al nivel 1.
	}
	
}
