package Logica;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
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
							
<<<<<<< HEAD
							this.sleep(50);
							
=======
							this.sleep(30);
							ArrayList<ComponenteGrafico> eliminar=new ArrayList<ComponenteGrafico>();
>>>>>>> origin/master
							for(ComponenteGrafico bala: balas)
							{
								movio=bala.mover();
								if(!movio)
									eliminar.add(bala);
							}
							
<<<<<<< HEAD
							grafica.eliminarBalas();
							//grafica.eliminarEnemigos();
=======
							for(ComponenteGrafico bala: eliminar){
								balas.remove(bala);
								miLogica.eliminarBala(bala);
							}
								
							miLogica.actualizarPanel();
>>>>>>> origin/master
						
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}

	public void addBala(Disparo x) {
		balas.add(x);
	}
	
	public void addEnemigo(Enemigo x){}


}
