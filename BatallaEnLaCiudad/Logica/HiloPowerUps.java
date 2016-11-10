package Logica;

import java.util.ArrayList;

import Grafica.*;
import PowerUp.PowerUp;
import Tanque.*;


public class HiloPowerUps extends Thread{
	
	protected Logica miLogica;
	protected PowerUp miPowerUp;
	protected ArrayList<PowerUp> eliminar;
	protected int tiempo;
	
	public HiloPowerUps(Logica l,PowerUp p)
	{
		miLogica = l;
		miPowerUp = p;
		eliminar = new ArrayList<PowerUp> ();
		tiempo = 5;
	}
	
	public void setLogica(Logica l)
	{
		miLogica = l;
	}
	
	public void addPowerUp(PowerUp p){
		miPowerUp.add(p);
	}
	
	public void inicio() {
		this.start();
	}
	
	public void run(){
		try{
			
			while (tiempo > 0){
	
			this.sleep(5000);
				
				tiempo--;
				
				ComponenteGrafico j = miLogica.getJugador();
				int jugadorX = j.getPosicionX();
				int jugadorY = j.getPosicionY();
				int powerX = miPowerUp.getPosicionX();
				int powerY = miPowerUp.getPosicionY();
				
				if(jugadorX == powerX && jugadorY == powerY){
						miPowerUp.colicion(j.getDeQuienEs());
						miLogica.eliminarColicion(powerX, powerY, miPowerUp.getDeQuienEs());
					}
				}		
						
		}catch(InterruptedException e){ e.printStackTrace();}
		
		miLogica.eliminarPowerUps();
		
	}
	
	
}
