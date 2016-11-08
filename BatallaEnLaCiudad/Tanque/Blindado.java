package Tanque;

import Logica.Logica;

public class Blindado extends Enemigo{

	private static final long serialVersionUID = 1L;
	protected Logica manejo;
	
	public Blindado(int x,int y,Logica l,int d){
		super(x,y);
		manejo=l;
		posicionImagen(d);
		vida=400;
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

	public void colicion(int deQuienEs) {
		if(deQuienEs==1){
			vida-=100;
			System.out.println("vida del enemigo impactado : "+vida);
			
			if (vida == 0)
				manejo.enemigoMurio();
		}
	}
}
