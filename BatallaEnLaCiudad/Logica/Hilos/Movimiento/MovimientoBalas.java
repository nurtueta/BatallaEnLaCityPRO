package Logica.Hilos.Movimiento;

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
		boolean movio;
		try{
			while(!miLogica.finDelJuego()){
				this.sleep(100);
				if(!miLogica.finDelJuego()){
					eliminar=new ArrayList<ComponenteGrafico>();
					agregarBala=false;
					for(ComponenteGrafico bala: balas){	
						movio=bala.mover(bala.getDireccion());
						if(!movio){
							eliminar.add(bala);
						}
					}
					agregarBala=true;
					
					for(ComponenteGrafico bala: balasIngresar)
						balas.add(bala);
					balasIngresar=new ArrayList<ComponenteGrafico>();
		
					for(ComponenteGrafico bala: eliminar)
						balas.remove(bala);
				}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		eliminar=new ArrayList<ComponenteGrafico>();
	}

	public void addBala(ComponenteGrafico x) {
		if(agregarBala)
			balas.add(x);
		else
			balasIngresar.add(x);
	}
	
	public void addEnemigo(ComponenteGrafico x){}


}
