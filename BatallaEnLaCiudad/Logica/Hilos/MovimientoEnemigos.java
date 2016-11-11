package Logica.Hilos;

import java.util.ArrayList;
import java.util.Random;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class MovimientoEnemigos extends Movimiento{

	protected ArrayList<ComponenteGrafico> enemigosIngresar;
	int direccion;
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
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		try{
			while(!miLogica.finDelJuego()){
					
					sleep(400);
					if(!miLogica.finDelJuego()){
						eliminar=new ArrayList<ComponenteGrafico>();
						agregarEnemigo=false;
						for(ComponenteGrafico enemigo: enemigos){
							direccion = (int) (rnd.nextInt(4)+1);
							if(enemigo.getVida()==0)
								eliminar.add(enemigo);
							else
								enemigo.mover(direccion);
						}
						agregarEnemigo=true;
						
						for(ComponenteGrafico enemigo: eliminar){
							miLogica.eliminarGrafico(enemigo);
							enemigos.remove(enemigo);
						}
						
						for(ComponenteGrafico bala: enemigosIngresar)
							enemigos.add(bala);
						enemigosIngresar=new ArrayList<ComponenteGrafico>();
					}
					sleep(400);
					if(!miLogica.finDelJuego()){
						agregarEnemigo=false;
						for(ComponenteGrafico enemigo: enemigos){
							miLogica.crearDisparoEnemigo(enemigo);
						}
						agregarEnemigo=true;
						
						for(ComponenteGrafico bala: enemigosIngresar)
							enemigos.add(bala);
						enemigosIngresar=new ArrayList<ComponenteGrafico>();
					}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
	}

	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x) {
		if(agregarEnemigo)
			enemigos.add(x);
		else
			enemigosIngresar.add(x);
	}
}
