package Logica;

import Grafica.ComponenteGrafico;

public class MovimientoFluido extends Movimiento {
		
	int x;
	int y;
	int d;
	int velocidad;
	int pixel;
	
	boolean puedeMover;

	public MovimientoFluido(Logica l,int x,int y,int d){
		super(l);
		miLogica=l;
		this.x=x;
		this.y=y;
		this.d=d;
		velocidad=10;
		pixel=5;
		puedeMover=false;
	}
	
	public void run()
	{
		try
		{
			
			switch (d) {
				case 1:
					if(miLogica.getComponente(x+1, y).movimientoPosible())
						puedeMover=true;;
					break;
				case 2:
					if(miLogica.getComponente(x-1, y).movimientoPosible())
						puedeMover=true;;
					break;
				case 3:
					if(miLogica.getComponente(x, y-1).movimientoPosible())
						puedeMover=true;;
					break;
				case 4:
					if(miLogica.getComponente(x, y+1).movimientoPosible())
						puedeMover=true;;
					break;
			}
				
			if(puedeMover){
				for(int i=0;i<5;i++){
					switch (d) {
						case 1:
							miLogica.getComponente(x, y).setX(miLogica.getComponente(x, y).getX()+pixel);
							sleep(velocidad);
							break;
						case 2:
							miLogica.getComponente(x, y).setX(miLogica.getComponente(x, y).getX()-pixel);
							sleep(velocidad);
							break;
						case 3:
							miLogica.getComponente(x, y).setY(miLogica.getComponente(x, y).getY()-pixel);
							sleep(velocidad);
							break;
						case 4:
							miLogica.getComponente(x, y).setY(miLogica.getComponente(x, y).getY()+pixel);
							sleep(velocidad);
							break;
					}
					miLogica.actualizarPanel();
				}
				
			}
			miLogica.mover(miLogica.getComponente(x, y), d);
			this.stop();
				
				
		}catch(InterruptedException e){ e.printStackTrace();}
		
	}

	public void addBala(ComponenteGrafico x) {
	}
	
	public void addEnemigo(ComponenteGrafico x){}


	
}
