package Logica;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Tanque.Enemigo;

public class MovimientoEnemigos extends Movimiento{


	public MovimientoEnemigos(Logica l)
	{
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
							this.sleep(500);
							
							for(ComponenteGrafico enemigo: enemigos)
							{
								movio=enemigo.mover();
								
								miLogica.actualizarPanel();	
							}
							
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}


	public void addBala(Disparo x) {
		
	}
	
	public void addEnemigo(Enemigo x) {
		enemigos.add(x);
	}

}
