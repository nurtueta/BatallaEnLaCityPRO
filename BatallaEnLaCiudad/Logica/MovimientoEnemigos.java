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
<<<<<<< HEAD
							
							this.sleep(300);
=======
							this.sleep(500);
>>>>>>> origin/master
							
							for(ComponenteGrafico enemigo: enemigos)
							{
								movio=enemigo.mover();
								
								miLogica.actualizarPanel();	
							}
							
<<<<<<< HEAD
							//grafica.eliminarBalas();
							//grafica.eliminarEnemigos();
						
=======
>>>>>>> origin/master
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}


	public void addBala(Disparo x) {
		
	}
	
	public void addEnemigo(Enemigo x) {
		enemigos.add(x);
	}

}
