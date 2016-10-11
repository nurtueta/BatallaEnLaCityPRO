package Logica;

import javax.swing.JFrame;

import Grafica.GUI;
import TDALista.*;
import Tanque.*;

public class MovimientoBalas extends Movimiento{
		
	public MovimientoBalas(GUI miGUI)
	{
		super(miGUI);
	}
	
	public void run()
	{
		PositionList<Disparo> moviendo = grafica.getBalas();
		
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		
		while (true)
		{
			
		}
	}
	
	public void posicionar() 
	{
			
	}

	
	public void inicio() 
	{
		
	}

}
