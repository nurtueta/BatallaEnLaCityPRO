package Logica.Hilo.Movimiento;

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

	public	MovimientoFluido(){
		super(null);
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
						x++;
						componente.setPosicionX(x);
						miLogica.setComponente(componente);
						miLogica.setComponente(new Piso(x-1,y,miLogica));
						break;
					case 2:
						x--;
						componente.setPosicionX(x);
						miLogica.setComponente(componente);
						miLogica.setComponente(new Piso(x+1,y,miLogica));
						break;
					case 3:
						y--;
						componente.setPosicionY(y);
						miLogica.setComponente(componente);
						miLogica.setComponente(new Piso(x,y+1,miLogica));
						break;						
					case 4:
						y++;
						componente.setPosicionY(y);
						miLogica.setComponente(componente);
						miLogica.setComponente(new Piso(x,y-1,miLogica));
						break;	
				}
				
				
			}
			componente.setPuedeMover();
			this.stop();
		}catch(InterruptedException e){ e.printStackTrace();}
		
	}

	public void addBala(ComponenteGrafico x) {
	}
	
	public void addEnemigo(ComponenteGrafico x){}

}

