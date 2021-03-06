package Grafica.Tanque.Enemigo;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Poder extends Enemigo{
	
	public Poder(int x,int y,int d,Logica l){
		super(x,y);
		profundidad=4;
		logica=l;
		posicionImagen(d);
		vida=1;
		velMovimiento=2;
		velDisparo=3;
	}

	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/PoderDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/PoderIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/PoderArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/PoderAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public void colicion(ComponenteGrafico x) {
		if(x.daniaEnemigo()){
			vida=0;
			logica.enemigoMurio(); 
		}
	}
	
	public int getPuntos() {
		return 300;
	}

}
