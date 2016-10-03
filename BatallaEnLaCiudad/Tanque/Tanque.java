package Tanque;

import Grafica.ComponenteGrafico;
import Logica.Bloque.Celda;

public abstract class Tanque extends Celda {
	
	/*Variables*/
	
	protected int vida;
	protected int powerUpDeTanque;
	
	/*Constructor*/
	
	public	Tanque(int x,int y){
		super(x,y);
		vida=100;
		powerUpDeTanque=0;
		
	}
	public	boolean movimientoPosible(){
		return false;
		
	}

	/*Comandos*/
	/*
	public abstract void setDireccion(int d);
	
	public abstract void setVida(int v);
	
	public abstract void setFila(int f);
	
	public abstract void setColumna(int c);
	
	/*Consultas*/
	/*
	public abstract int getVida();
	
	public abstract int getFila();
	
	public abstract int getColumna();
	*/
}
