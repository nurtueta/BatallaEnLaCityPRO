package Logica.Hilo.Movimiento;

import java.util.ArrayList;

import Grafica.*;
import Grafica.Tanque.*;
import Logica.Logica;


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
	
	public void addBala(ComponenteGrafico x){}
	
	public void addEnemigo(ComponenteGrafico x){}
	
	public  ArrayList<ComponenteGrafico> getBalas(){
		return balas;
	}
	
	public  ArrayList<ComponenteGrafico> getEnemigos(){
		return enemigos;
	}
	
}
