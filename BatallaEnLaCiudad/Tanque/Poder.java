package Tanque;

import Logica.Logica;

public class Poder extends Enemigo{

	private static final long serialVersionUID = 1L;
	protected Logica manejo;
	
	public Poder(int x,int y,Logica l,int d){
		super(x,y);
		manejo=l;
		posicionImagen(d);
		vida=200;
	}

	public int getVida() {
		return vida;
	}

	
	public void setVida(int v) {
		vida=v;
	}
	
	public boolean movimientoPosible() {
		return false;
	}

	
	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}

	public boolean mover() {
		return false;
	}

	public boolean movimientoPosibleDisparo() {
		return false;
	}
}
