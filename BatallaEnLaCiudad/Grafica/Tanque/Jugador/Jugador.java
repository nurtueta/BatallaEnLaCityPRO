package Grafica.Tanque.Jugador;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Grafica.Tanque.Tanque;
import Logica.Logica;
import Logica.Hilos.MovimientoBalas;
import Logica.Hilos.MovimientoFluido;

public class Jugador extends Tanque{
	
	/*Variables*/
	
	protected boolean casco;
	protected int state;
	
	/*Constructor*/
	
	public Jugador(int x,int y,Logica l){
		super(x,y);
		profundidad=4;
		logica=l;
		posicionImagen(1);
		casco=false;
		velMovimiento=2;
		velDisparo=1;
		disparosSimultaneos=1;
		vida=1;
		deQuienEs=1;
		state=1;
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
	
	public void usaCasco(boolean x){
		casco=x;
	}
	
	/*Consultas*/
	
	public void colicion(int deQuienEs) {
		if(deQuienEs==0){
			if(!casco)
				vida--;
		}
	}
	
	public void setDireccion(int d){
		direccion=d;
	}
	
	public void subirNivel(){
		switch(state){
		case 1:
			velMovimiento=3;
			velDisparo=2;
			disparosSimultaneos=1;
			vida=1;
			deQuienEs=1;
			state=2;
			break;
		case 2:
			velMovimiento=2;
			velDisparo=2;
			disparosSimultaneos=2;
			vida=2;
			deQuienEs=1;
			state=3;
			break;
		case 3:
			velMovimiento=2;
			velDisparo=3;
			disparosSimultaneos=3;
			vida=4;
			deQuienEs=2;
			state=4;
			break;
		}
	}
	
	public void bajarNivel(){
		switch(state){
		case 2:
			velMovimiento=2;
			velDisparo=1;
			disparosSimultaneos=1;
			vida=1;
			deQuienEs=1;
			state=1;
			break;
		case 3:
			velMovimiento=3;
			velDisparo=2;
			disparosSimultaneos=1;
			vida=1;
			deQuienEs=1;
			state=2;
			break;
		case 4:
			velMovimiento=2;
			velDisparo=2;
			disparosSimultaneos=2;
			vida=2;
			deQuienEs=1;
			state=3;
			break;
		}
	}

	public int getState(){
		return state;
	}
	
	public void setState(int i){
		switch(i){
		case 1:
			velMovimiento=2;
			velDisparo=1;
			disparosSimultaneos=1;
			vida=1;
			deQuienEs=1;
			state=1;
			break;
		case 2:
			velMovimiento=3;
			velDisparo=2;
			disparosSimultaneos=1;
			vida=1;
			deQuienEs=1;
			state=2;
			break;
		case 3:
			velMovimiento=2;
			velDisparo=2;
			disparosSimultaneos=2;
			vida=2;
			deQuienEs=1;
			state=3;
			break;
		case 4:
			velMovimiento=2;
			velDisparo=3;
			disparosSimultaneos=3;
			vida=4;
			deQuienEs=2;
			state=4;
			break;
		}
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}