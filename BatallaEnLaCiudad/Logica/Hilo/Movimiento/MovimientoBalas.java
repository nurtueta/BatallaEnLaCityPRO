package Logica.Hilo.Movimiento;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Grafica.Tanque.*;
import Logica.Logica;

public class MovimientoBalas extends Movimiento{
	
	protected ArrayList<ComponenteGrafico> balasIngresar;
	boolean agregarBala;
	ArrayList<ComponenteGrafico> eliminar;
	
	public MovimientoBalas(Logica l){
		super(l);
		balasIngresar=new ArrayList<ComponenteGrafico>();
		agregarBala=true;//lo uso para saber si puede agregar una bala a la lista
	}
	
	public void run()
	{	
		while(!miLogica.finDelJuego()){
				eliminar=new ArrayList<ComponenteGrafico>();
				agregarBala=false;
				try {
					sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(ComponenteGrafico bala: balas){	
					if(bala.getVida()!=0)
						bala.mover(bala.getDireccion());
					else
						eliminar.add(bala);
				}
				agregarBala=true;
				
				for(ComponenteGrafico bala: eliminar)
					balas.remove(bala);
				
				for(ComponenteGrafico bala: balasIngresar)
					balas.add(bala);
				
				balasIngresar=new ArrayList<ComponenteGrafico>();
			}
	}

	public void addBala(ComponenteGrafico x) {
		if(agregarBala)
			balas.add(x);
		else
			balasIngresar.add(x);
	}
	
}
