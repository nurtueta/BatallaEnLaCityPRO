package Logica;

import java.util.ArrayList;
import java.util.Random;

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
								Random rnd= new Random(); 
								direccion = (int) (rnd.nextInt(4)+1);
								if(direccion==5)
									miLogica.crearDisparoEnemigo(enemigo);
								
								miLogica.mover(enemigo,direccion);
								//disparo random del enemigo
									
							}
							
							

							miLogica.actualizarPanel();	
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}


	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x) {
		enemigos.add(x);
	}

}
