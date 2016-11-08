package Logica;

import java.util.ArrayList;

import Grafica.*;
import PowerUp.PowerUp;
import Tanque.*;


public class HiloPowerUps extends Thread{
	
	protected Logica miLogica;
	protected PowerUp miPowerUp;
	protected int tiempo;
	
	public HiloPowerUps(Logica l,PowerUp p)
	{
		miLogica = l;
		miPowerUp = p;
		tiempo = 5;
	}
	
	public void setLogica(Logica l)
	{
		miLogica = l;
	}
	
	public void setPowerUp(PowerUp p){
		miPowerUp = p;
	}
	
	public void inicio() {
		this.start();
	}
	
	public void run(){
		try{
			
			while (tiempo > 0){
	
				this.sleep(50);
				
				tiempo--;
			
			}

			miLogica.eliminarPowerUp(miPowerUp);
			
		}catch(InterruptedException e){ e.printStackTrace();}
		
		this.stop();
		
	}
	
	
}
