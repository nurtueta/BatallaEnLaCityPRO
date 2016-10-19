package Logica;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Tanque.Enemigo;

public class MovimientoEnemigos extends Movimiento{

	int direccion;

	public MovimientoEnemigos(Logica l)
	{
		super(l);
	}
	
	public void run()
	{
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		
		
			try
			{
				while(!miLogica.finDelJuego())
				{
							
							this.sleep(1000);
							
							
							
							for(ComponenteGrafico enemigo: enemigos)
							{
								direccion = (int) (Math.random()*1+1);
								if(direccion==1)
									miLogica.crearDisparoEnemigo(enemigo);
								
								miLogica.moverEnemigo(enemigo,direccion);
								//disparo random del enemigo
									
							}
							
							

							miLogica.actualizarPanel();	
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}


	public void addBala(Disparo x) {
		
	}
	
	public void addEnemigo(Enemigo x) {
		enemigos.add(x);
	}

}
