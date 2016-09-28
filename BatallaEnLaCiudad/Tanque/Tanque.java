package Tanque;

import Grafica.ComponenteGrafico;
import Logica.GameObject;

public abstract class Tanque extends ComponenteGrafico {
	
	protected int vida;
	protected int powerUpDeTanque;
	protected int posFila;
	protected int posColumna;
	
	public	Tanque(){
		vida=100;
		powerUpDeTanque=0;
		posFila=1;
		posColumna=1;
	}

	abstract int getVida();
	
	abstract void setVida(int v);
	
	abstract int getFila();
	
	abstract void setFila(int f);
	
	abstract int getColumna();
	
	abstract void setColumna(int c);
	
}
