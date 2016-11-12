package Logica.Hilo.PowerUp;

import java.util.ArrayList;

import Grafica.*;
import Grafica.Bloque.Piso;
import Grafica.PowerUp.PowerUp;
import Grafica.Tanque.*;
import Logica.Logica;


public class HiloPowerUp extends Thread{
	
	protected Logica miLogica;
	
	public HiloPowerUp(Logica l)
	{
		miLogica=l;
	}
	
	
}
