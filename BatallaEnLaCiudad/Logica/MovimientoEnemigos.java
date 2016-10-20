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
							
							ArrayList<ComponenteGrafico> eliminar=new ArrayList<ComponenteGrafico>();
							
							for(ComponenteGrafico enemigo: enemigos)
							{
								Random rnd= new Random(); 
								direccion = (int) (rnd.nextInt(5)+1);
								if(direccion==5)
									miLogica.crearDisparoEnemigo(enemigo);
								if(enemigo.getVida()==0)
									eliminar.add(enemigo);
								else
									miLogica.mover(enemigo,direccion);
								//disparo random del enemigo
							}
							
							for(ComponenteGrafico enemigo: eliminar)
							{
								enemigos.remove(enemigo);
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
