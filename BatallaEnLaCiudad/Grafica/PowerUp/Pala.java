package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Pala extends PowerUp{

	public Pala(int x, int y,Logica l){
		super(x,y,l);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpPala.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs != 0){
			vida=0;
			logica.powerUpPala();
		}
	}

	
}
