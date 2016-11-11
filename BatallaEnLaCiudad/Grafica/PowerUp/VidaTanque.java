package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Logica;

public class VidaTanque extends PowerUp{

	public VidaTanque(int x, int y,Logica l){
		super(x,y,5,l);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTanque.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1)
			logica.powerUpTanque();
	}
	
}
