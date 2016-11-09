package Logica;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Tanque.*;

public class MovimientoBalas extends Movimiento{
	
	protected ArrayList<ComponenteGrafico> balasIngresar;
	boolean agregarBala;
	
	public MovimientoBalas(Logica l){
		super(l);
		balasIngresar=new ArrayList<ComponenteGrafico>();
		agregarBala=true;
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
				agregarBala=false;
				for(ComponenteGrafico bala: balas){	
					movio=bala.mover(bala.getDireccion());
					if(!movio){
						eliminar.add(bala);
					}
				}
				agregarBala=true;
				for(ComponenteGrafico bala: balasIngresar){
					balas.add(bala);
				}
				for(ComponenteGrafico bala: eliminar){
					balas.remove(bala);
				}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		if(agregarBala)
			balas.add(x);
		else
			balasIngresar.add(x);
	}
	
	public void addEnemigo(ComponenteGrafico x){}


}
