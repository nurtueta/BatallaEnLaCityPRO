package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Logica;

public class Timer extends PowerUp{

	public Timer(int x, int y,Logica l){
<<<<<<< HEAD
		super(x,y,6);
		logica=l;
=======
		super(x,y,6,l);
//		this.deQuienEs=9; //9 indica que es un powerup
		//manejo=l;
>>>>>>> origin/master
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTimer.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1)
			miLogica.detenerEnemigos();
	}
	
}
