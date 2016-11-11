package Logica.Hilos;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Piso;
import Logica.Logica;

public class MovimientoFluido extends Movimiento {
		
	int x;
	int y;
	int d;
	int velocidad;
	int pixel;
	
	
	protected ComponenteGrafico componente;

	public MovimientoFluido(ComponenteGrafico x,int d,Logica l){
		super(null);
		this.x=x.getPosicionX();
		this.y=x.getPosicionY();
		this.d=d;
		velocidad=30/x.getVelMovimiento();
		pixel=5;
		miLogica=l;
		componente=x;
	}
	
	public void run()
	{
		try
		{
			boolean movio=false;
			miLogica.getComponente(x, y).setDireccion(d);
			switch (d){
				case 1: if(x<(20-1))
							if(miLogica.getComponente(x+1, y).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x+1, y).setMovimientoPosible();
							}
						break;
				case 2: if(x>0)
							if(miLogica.getComponente(x-1, y).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x-1, y).setMovimientoPosible();
							}
						break;
				case 3: if(y>0)
							if(miLogica.getComponente(x, y-1).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x, y-1).setMovimientoPosible();
							}
						break;
				case 4: if(y<(20-1))
							if(miLogica.getComponente(x, y+1).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x, y+1).setMovimientoPosible();
							}
						break;
			}
			componente.posicionImagen(d);
			if(movio){
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
				switch(d){
					case 1:
						miLogica.setComponente(x+1, y, componente);
						miLogica.setComponente(x, y,new Piso(x,y));
						x++;
						break;
					case 2:
						miLogica.setComponente(x-1, y, componente);
						miLogica.setComponente(x, y,new Piso(x,y));
						x--;
						break;
					case 3:
						miLogica.setComponente(x, y-1, componente);
						miLogica.setComponente(x, y,new Piso(x,y));
						y--;
						break;						
					case 4:
						miLogica.setComponente(x, y+1, componente);
						miLogica.setComponente(x, y,new Piso(x,y));
						y++;
						break;	
				}
				componente.setPosicionX(x);
				componente.setPosicionY(y);
			}
			componente.setPuedeMover();
			this.stop();
		}catch(InterruptedException e){ e.printStackTrace();}
		
	}

	public void addBala(ComponenteGrafico x) {
	}
	
	public void addEnemigo(ComponenteGrafico x){}

}

