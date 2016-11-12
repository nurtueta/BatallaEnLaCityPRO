package Logica.Hilo.Movimiento;

import java.util.ArrayList;
import java.util.Random;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class MovimientoEnemigos extends Movimiento{

	protected ArrayList<ComponenteGrafico> enemigosIngresar;
	int direccion;
	int accion;
	Random rnd;
	boolean agregarEnemigo;
	ArrayList<ComponenteGrafico> eliminar;

	public MovimientoEnemigos(Logica l)
	{
		super(l);
		rnd= new Random(); 
		enemigosIngresar=new ArrayList<ComponenteGrafico>();
		agregarEnemigo=true;//lo uso para saber si puede agregar un enemigo a la lista
	}
	
	public void run()
	{
		try{
			while(!miLogica.finDelJuego() && !miLogica.eliminarTodosLosEnemigos()){
					if(!miLogica.getDetenerTanque()){
						eliminar=new ArrayList<ComponenteGrafico>();
						agregarEnemigo=false;
						for(ComponenteGrafico enemigo: enemigos){
							sleep(20);
							direccion = (int) (rnd.nextInt(4)+1);
							accion= (int) (rnd.nextInt(4));
							
								if(enemigo.getVida()==0)
									eliminar.add(enemigo);
								else
									if(accion!=0){
										enemigo.mover(direccion);
									}else{
										if(enemigo.getPuedeMover()){
											miLogica.crearDisparoEnemigo(enemigo);
											sleep(20);
										}
							}
						}
						agregarEnemigo=true;
						
						for(ComponenteGrafico enemigo: eliminar)
							enemigos.remove(enemigo);
						
						for(ComponenteGrafico bala: enemigosIngresar)
							enemigos.add(bala);
						
						enemigosIngresar=new ArrayList<ComponenteGrafico>();		
					}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		eliminar=new ArrayList<ComponenteGrafico>();
		for(ComponenteGrafico enemigo: enemigos){
			eliminar.add(enemigo);
			miLogica.eliminarGrafico(enemigo);
		}
		for(ComponenteGrafico enemigo: eliminar)
			enemigos.remove(enemigo);
			
		stop();
	}
	
	public void addEnemigo(ComponenteGrafico x) {
		if(agregarEnemigo)
			enemigos.add(x);
		else
			enemigosIngresar.add(x);
	}
}
