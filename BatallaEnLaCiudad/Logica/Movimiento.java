package Logica;

import java.util.ArrayList;

import Grafica.*;
import Tanque.*;


public abstract class Movimiento extends Thread{
	
	protected Logica miLogica;
	protected ArrayList<ComponenteGrafico> balas;
	protected ArrayList<ComponenteGrafico> enemigos;
	
	public Movimiento(Logica logic)
	{
		miLogica = logic;
		balas=new ArrayList<ComponenteGrafico>();
		enemigos=new ArrayList<ComponenteGrafico>();
	}
	
	
	public void setLogica(Logica l)
	{
		miLogica = l;
	}
	
	public void inicio() {
		this.start();
	}
	
	public abstract void addBala(ComponenteGrafico x);
	
	public abstract void addEnemigo(ComponenteGrafico x,int i);
	
	public  ArrayList<ComponenteGrafico> getBalas(){
		return balas;
	}
	
	public  ArrayList<ComponenteGrafico> getEnemigos(){
		return enemigos;
	}
	
}
