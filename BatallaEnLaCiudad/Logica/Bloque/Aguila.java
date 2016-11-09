package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Aguila extends Celda {
	
	public Aguila(int x, int y){
		
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/emblemarepublica.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=25;
	}

	public void colicion(int deQuienEs) {
		vida=0;
	}

}
