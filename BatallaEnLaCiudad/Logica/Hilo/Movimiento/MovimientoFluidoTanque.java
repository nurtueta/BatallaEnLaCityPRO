package Logica.Hilo.Movimiento;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Piso;
import Logica.Logica;

public class MovimientoFluidoTanque extends Movimiento {
		
	int x;
	int y;
	int d;
	int velocidad;
	int pixel;
	
	
	protected ComponenteGrafico componente;

	public MovimientoFluidoTanque(ComponenteGrafico x,int d,Logica l){
		super(l);
		this.x=x.getPosicionX();
		this.y=x.getPosicionY();
		this.d=d;
		if(x.getVelMovimiento()==1)
			velocidad=70;
		else
			if(x.getVelMovimiento()==2)
				velocidad=50;
			else
				velocidad=30;
		pixel=5;
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
								miLogica.getComponente(x+1, y).setMovimientoPosible(false);
							}
						break;
				case 2: if(x>0)
							if(miLogica.getComponente(x-1, y).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x-1, y).setMovimientoPosible(false);
							}
						break;
				case 3: if(y>0)
							if(miLogica.getComponente(x, y-1).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x, y-1).setMovimientoPosible(false);
							}
						break;
				case 4: if(y<(20-1))
							if(miLogica.getComponente(x, y+1).movimientoPosible()){
								movio=true;
								miLogica.getComponente(x, y+1).setMovimientoPosible(false);
							}
						break;
			}
			componente.posicionImagen(d);
			if(movio){
				for(int i=0;i<5;i++){
					switch (d) {
						case 1:
							componente.setX(componente.getX()+pixel);
							sleep(velocidad);
							break;
						case 2:
							componente.setX(componente.getX()-pixel);
							sleep(velocidad);
							break;
						case 3:
							componente.setY(componente.getY()-pixel);
							sleep(velocidad);
							break;
						case 4:
							componente.setY(componente.getY()+pixel);
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
			
			componente.puedeMover();

			sleep(10);
			this.stop();
		}catch(InterruptedException e){ e.printStackTrace();}
		
	}

}