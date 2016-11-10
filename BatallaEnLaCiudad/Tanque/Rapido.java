package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Logica;

public class Rapido extends Enemigo{

	private static final long serialVersionUID = 1L;
	
	public Rapido(int x,int y,int d,Logica l){
		super(x,y);
		posicionImagen(d);
		logica=l;
		vida=1;
		velMovimiento=3;
		velDisparo=2;
		puntaje=800;
	}

	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/RapidoDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/RapidoIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/RapidoArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/RapidoAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public void colicion(int deQuienEs) {
		if(deQuienEs>=1&&deQuienEs<=4){
			vida=0;
			logica.enemigoMurio(); 
		}
	}
	
	public int getPuntos() {
		return 200;
	}
	
}
