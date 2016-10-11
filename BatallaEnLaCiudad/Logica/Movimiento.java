package Logica;

import javax.swing.JFrame;

import Grafica.*;
import Tanque.*;


public abstract class Movimiento extends Thread{
	
	protected GUI grafica;
	
	public Movimiento(GUI miGUI)
	{
		grafica = miGUI;
	}
	
	
	public void setGrafica(GUI g)
	{
		grafica = g;
	}
	
	public abstract void posicionar();
	
	public abstract void inicio();
	
}
