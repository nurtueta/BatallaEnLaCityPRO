package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Arbol extends Celda{

	
	public Arbol(int x,int y) {
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/arboles.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
		profundidad=4;
		
	}

	public void colicion(int deQuienEs) {
		
	}

}
