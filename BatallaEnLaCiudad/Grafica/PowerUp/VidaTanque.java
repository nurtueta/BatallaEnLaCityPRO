package Grafica.PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class VidaTanque extends PowerUp{

	public VidaTanque(int x, int y,Logica l){
		super(x,y,5);
		logica=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTanque.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	@Override
	public void colicion(int deQuienEs) {
		if(deQuienEs == 1){
			logica.powerUpTanque();
			System.out.println("PowerUp VIDATANQUE");
		}
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
