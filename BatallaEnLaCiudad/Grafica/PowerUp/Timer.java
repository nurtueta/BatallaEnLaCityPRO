package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Timer extends PowerUp{

	public Timer(int x, int y,Logica l){
		super(x,y,6);
		logica=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTimer.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1){
			logica.powerUpTimer();
			System.out.println("PowerUp TIMER");
		}
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}