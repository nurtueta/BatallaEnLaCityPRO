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
		ArrayList<ComponenteGrafico> eliminar;
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		try{
			while(!miLogica.finDelJuego())
			{
				this.sleep(1000);
				eliminar=new ArrayList<ComponenteGrafico>();
				
				for(ComponenteGrafico enemigo: enemigos)
				{
					Random rnd= new Random(); 
					direccion = (int) (rnd.nextInt(8)+1);
					if(direccion>=5)
						miLogica.crearDisparoEnemigo(enemigo);
					else
						if(enemigo.getVida()==0)
							eliminar.add(enemigo);
						else
							miLogica.iniciarMovimientoEnemigo(1,enemigo, direccion);
				}
				
				for(ComponenteGrafico enemigo: eliminar)
				{
					balas.remove(enemigo);
				}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		eliminar=new ArrayList<ComponenteGrafico>();
		for(ComponenteGrafico enemigo: enemigos){
			eliminar.add(enemigo);
		}
		
		for(ComponenteGrafico enemigo: eliminar)
		{
			miLogica.eliminarEnemigo(enemigo);
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
