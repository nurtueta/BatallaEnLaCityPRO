package Logica;

import java.util.ArrayList;

import javax.swing.JFrame;

import Grafica.ComponenteGrafico;
import Grafica.GUI;
import TDALista.*;
import Tanque.*;

public class MovimientoBalas extends Movimiento{
		
	public MovimientoBalas(Logica l){
		super(l);
	}
	
	public void run()
	{
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		
			boolean movio;
			try
			{
				while(!miLogica.finDelJuego())
				{
							
							this.sleep(20);
							ArrayList<ComponenteGrafico> eliminar=new ArrayList<ComponenteGrafico>();
							for(ComponenteGrafico bala: balas)
							{
								movio=bala.mover();
								if(!movio)
									eliminar.add(bala);
							}
							
							for(ComponenteGrafico bala: eliminar){
								balas.remove(bala);
								miLogica.eliminarBala(bala);
							}
								
							miLogica.actualizarPanel();
						
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}

	public void addBala(Disparo x) {
		balas.add(x);
	}
	
	public void addEnemigo(Enemigo x){}


}
