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
		try{
			while(!miLogica.finDelJuego())
			{
				this.sleep(100);
				ArrayList<ComponenteGrafico> eliminar=new ArrayList<ComponenteGrafico>();
				if(!balas.isEmpty())
					for(ComponenteGrafico bala: balas){	
						movio=bala.mover(bala.getDireccion());
						if(!movio){
							eliminar.add(bala);
						}
					}
				if(!eliminar.isEmpty())
					for(ComponenteGrafico bala: eliminar){
						
						miLogica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),bala.getDeQuienEs());
						miLogica.eliminarGrafico(bala);
						balas.remove(bala);
						
					}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		balas.add(x);
	}
	
	public void addEnemigo(ComponenteGrafico x){}


}
