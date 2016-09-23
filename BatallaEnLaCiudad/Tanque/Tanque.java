package Tanque;

import Logica.GameObject;

public abstract class Tanque extends GameObject {

	abstract int getVida();
	
	abstract void setVida(int v);
	
	abstract int getPosFila();
	
	abstract void setPosFila(int f);
	
	abstract int getPosColumna();
	
	abstract void setPosColumna(int c);
	
	abstract int getTipo();
}
