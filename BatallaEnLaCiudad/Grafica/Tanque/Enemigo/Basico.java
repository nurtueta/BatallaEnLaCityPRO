package Grafica.Tanque.Enemigo;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Basico extends Enemigo{

	/*Constructor*/
	
	public Basico(int x,int y,int d,Logica l){
		super(x,y);
		profundidad=4;
		posicionImagen(d);
		logica=l;
		vida=1;
		velMovimiento=1;
		velDisparo=1;
		puntaje=500;
	}
	
	/*Comandos*/
	
	//pongo la imagen en la direccion del tanque
	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/starFighterDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/starFighterIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/starFighterArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/starFighterAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	/*Consultas*/
	
	public void colicion(ComponenteGrafico x) {
		if(x.getEjecutor().daniaEnemigo()){
			vida = 0;
			logica.enemigoMurio(); 
		}
	}

	public int getPuntos() {
		return 100;
	}
	
}
