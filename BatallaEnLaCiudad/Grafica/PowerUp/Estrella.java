package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Estrella extends PowerUp{

	public Estrella (int x, int y,Logica l){
		super(x,y,4);
		logica=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpEstrella.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1){
			logica.powerUpEstrella();
			System.out.println("PowerUp ESTRELLA");
		}
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
