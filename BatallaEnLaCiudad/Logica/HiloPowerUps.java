package Logica;

import java.util.ArrayList;

import Grafica.*;
import PowerUp.PowerUp;
import Tanque.*;


public class HiloPowerUps extends Thread{
	
	protected Logica miLogica;
	protected ArrayList<PowerUp> misPowerUp;
	protected ArrayList<PowerUp> eliminar;
	protected int tiempo;
	
	public HiloPowerUps(Logica l,PowerUp p)
	{
		miLogica = l;
		misPowerUp = new ArrayList<PowerUp> ();
		eliminar = new ArrayList<PowerUp> ();
		misPowerUp.add(p);
		tiempo = 5;
	}
	
	public void setLogica(Logica l)
	{
		miLogica = l;
	}
	
	public void addPowerUp(PowerUp p){
		misPowerUp.add(p);
	}
	
	public void inicio() {
		this.start();
	}
	
	public void run(){
		try{
			
			while (tiempo > 0){
	
				this.sleep(1000);
				
				tiempo--;
				
				ComponenteGrafico j = miLogica.getJugador();
				int jugadorX = j.getPosicionX();
				int jugadorY = j.getPosicionY();
				
				for(PowerUp p : misPowerUp){
					int powerX = p.getPosicionX();
					int powerY = p.getPosicionY();
					
					if(jugadorX == powerX && jugadorY == powerY){
						p.colicion(j.getDeQuienEs());
						miLogica.eliminarColicion(powerX, powerY, p.getDeQuienEs());
					}
				}		
			
			}

			for(PowerUp p : misPowerUp){
				miLogica.eliminarGrafico(p);
				eliminar.add(p);
			}
			
			for(PowerUp p: eliminar)
				misPowerUp.remove(p);
			
		}catch(InterruptedException e){ e.printStackTrace();}
		
		miLogica.eliminarPowerUps();
		
	}
	
	
}
