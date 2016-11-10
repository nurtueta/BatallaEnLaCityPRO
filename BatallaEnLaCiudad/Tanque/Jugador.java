package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.MovimientoBalas;
import Logica.MovimientoFluido;

public abstract class Jugador extends Tanque{
	
	/*Variables*/
	
	protected int casco;
	
	/*Constructor*/
	
	public Jugador(int x,int y){
		super(x,y);
		posicionImagen(1);
		casco=0;
		deQuienEs=1;
	}
	
	/*Comandos*/

	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/XWingDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/XWingIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/XWingArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/XWingAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public void setPowerUpDeTanque(int pu){
		casco=pu;
	}
	
	/*Consultas*/
	
	public void colicion(int deQuienEs) {
		if(deQuienEs==0){
			if(casco==0)
				vida--;
		}
	}
	
	public void setDireccion(int d){
		direccion=d;
	}

}
