package Grafica.Tanque.Enemigo;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Logica.Logica;

public class Blindado extends Enemigo{
	
	public Blindado(int x,int y,int d,Logica l){
		super(x,y);
		profundidad=4;
		posicionImagen(d);
		logica=l;
		vida=4;
		velMovimiento=1;
		velDisparo=2;
		puntaje=800;
	}
	
	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/destructorDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/destructorIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/destructorArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/destructorAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public void colicion(int deQuienEs) {
		if(deQuienEs!=0){
			vida--;
			if(vida==0)
				logica.enemigoMurio(); 
		}
	}
	
	public int getPuntos(){
		return 400;
	}
}
