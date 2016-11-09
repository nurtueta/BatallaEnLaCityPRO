package Logica;

import java.util.ArrayList;
import java.util.Random;

import Grafica.ComponenteGrafico;
import Tanque.Enemigo;

public class MovimientoEnemigos extends Movimiento{

	int direccion;
	Random rnd;
	ArrayList<ComponenteGrafico> eliminar;

	public MovimientoEnemigos(Logica l)
	{
		super(l);
		rnd= new Random(); 
	}
	
	public void run()
	{
		
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		try{
			while(!miLogica.finDelJuego())
			{
				this.sleep(300);
				eliminar=new ArrayList<ComponenteGrafico>();
				
				for(ComponenteGrafico enemigo: enemigos)
				{
					this.sleep(5);
					direccion = (int) (rnd.nextInt(4)+1);
					if(enemigo.getVida()==0)
						eliminar.add(enemigo);
					else
						enemigo.mover(direccion);
				}
				this.sleep(300);

				for(ComponenteGrafico enemigo: eliminar)
				{
					miLogica.eliminarGrafico(enemigo);
					enemigos.remove(enemigo);
				}
				
				for(ComponenteGrafico enemigo: enemigos)
				{
					miLogica.crearDisparo(enemigo);
				}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		eliminar=new ArrayList<ComponenteGrafico>();
		for(ComponenteGrafico enemigo: enemigos){
			eliminar.add(enemigo);
		}
		
		for(ComponenteGrafico enemigo: eliminar)
		{
			miLogica.eliminarGrafico(enemigo);
			enemigos.remove(enemigo);
		}
		
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x) {
		enemigos.add(x);
	}
}
