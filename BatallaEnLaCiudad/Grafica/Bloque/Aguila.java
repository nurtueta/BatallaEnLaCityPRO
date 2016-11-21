package Grafica.Bloque;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Aguila extends Bloque {
	
	public Aguila(int x, int y,Logica l){
		
		super(x,y,l);
		profundidad=2;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/emblemarepublica.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
	}

	public boolean movimientoPosibleDisparo() {
		return false;
	}

	public void colicion(ComponenteGrafico x) {
		logica.finalizarJuego(false);
	}

	public boolean mejorar() {
		return false;
	}
}
