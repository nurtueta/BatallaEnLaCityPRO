package Tanque;

import Grafica.ComponenteGrafico;
import Logica.GameObject;

public abstract class Tanque extends ComponenteGrafico {

	abstract int getVida();
	
	abstract void setVida(int v);
	
	abstract int getFila();
	
	abstract void setFila(int f);
	
	abstract int getColumna();
	
	abstract void setColumna(int c);
	
	abstract int getTipo();
}
