package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Logica;

public class VidaTanque extends PowerUp{

	public VidaTanque(int x, int y,Logica l){
<<<<<<< HEAD
		super(x,y,5);
		logica=l;
=======
		super(x,y,5,l);
//		this.deQuienEs=9; //9 indica que es un powerup
		//manejo=l;
>>>>>>> origin/master
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTanque.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1)
			miLogica.subirVida();
	}
	
}
