package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class VidaTanque extends PowerUp{

	public VidaTanque(int x, int y,Logica l){
		super(x,y,l);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTanque.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs!=0){
			vida=0;
			logica.addPuntaje(500);
			logica.powerUpTanque();
		}
	}

	
}
