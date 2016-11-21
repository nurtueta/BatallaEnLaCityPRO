package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Timer extends PowerUp{

	public Timer(int x, int y,Logica l){
		super(x,y,l);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTimer.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public boolean movimientoPosible(){
		vida=0;
		logica.addPuntaje(500);
		logica.powerUpTimer();
		logica.eliminarPowerUp(this);
		return true;
	}
}
