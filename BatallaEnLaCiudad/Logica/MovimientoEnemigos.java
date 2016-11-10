package Logica;

import java.util.ArrayList;
import java.util.Random;

import Grafica.ComponenteGrafico;
import Tanque.Enemigo;

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
	
	public void run()
	{
		
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		try{
			while(!miLogica.finDelJuego())
			{
				this.sleep(200);
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
				}
				this.sleep(200);
				if(!miLogica.finDelJuego()){
					agregarEnemigo=false;
					for(ComponenteGrafico enemigo: enemigos){
						this.sleep(20);
						miLogica.crearDisparo(enemigo);
					}
					agregarEnemigo=true;
					for(ComponenteGrafico bala: enemigosIngresar)
						enemigos.add(bala);
				}
			}
		}catch(InterruptedException e){ e.printStackTrace();}
		eliminar=new ArrayList<ComponenteGrafico>();
		for(ComponenteGrafico enemigo: enemigos)
			eliminar.add(enemigo);
		
		for(ComponenteGrafico enemigo: eliminar){
			miLogica.eliminarGrafico(enemigo);
			enemigos.remove(enemigo);
		}
		
		this.stop();
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
