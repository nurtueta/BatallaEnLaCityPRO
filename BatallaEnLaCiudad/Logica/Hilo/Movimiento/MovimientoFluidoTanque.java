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
			velocidad=15;
		else
			if(x.getVelMovimiento()==2)
				velocidad =12;
			else
				velocidad=9;
		pixel=2;
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
				int pixelX=componente.getX();
				int pixelY=componente.getY();
				for(int i=0;i<7;i++){
					switch (d) {
						case 1:
							pixelX+=pixel;
							componente.setX(pixelX);
							sleep(velocidad);
							break;
						case 2:
							pixelX-=pixel;
							componente.setX(pixelX);
							sleep(velocidad);
							break;
						case 3:
							pixelY-=pixel;
							componente.setY(pixelY);
							sleep(velocidad);
							break;
						case 4:
							pixelY+=pixel;
							componente.setY(pixelY);
							sleep(velocidad);
							break;
					}
					miLogica.actualizarPanel();
				}
				switch (d){
				case 1:
					componente.setPosicionX(x+1);
					componente.setX(pixelX);
					miLogica.setComponente(componente);
					miLogica.setComponente(new Piso(x,y,miLogica));
					break;
				case 2: 
					componente.setPosicionX(x-1);
					componente.setX(pixelX);
					miLogica.setComponente(componente);
					miLogica.setComponente(new Piso(x,y,miLogica));
					break;
				case 3: 
					componente.setPosicionY(y-1);
					componente.setY(pixelY);
					miLogica.setComponente(componente);
					miLogica.setComponente(new Piso(x,y,miLogica));
					break;
				case 4: 
					componente.setPosicionY(y+1);
					componente.setY(pixelY);
					miLogica.setComponente(componente);
					miLogica.setComponente(new Piso(x,y,miLogica));
					break;
				}
				if(componente.getVida()!=0){
					for(int i=0;i<8;i++){
						switch (d) {
							case 1:
								pixelX+=pixel;
								componente.setX(pixelX);
								sleep(velocidad);
								break;
							case 2:
								pixelX-=pixel;
								componente.setX(pixelX);
								sleep(velocidad);
								break;
							case 3:
								pixelY-=pixel;
								componente.setY(pixelY);
								sleep(velocidad);
								break;
							case 4:
								pixelY+=pixel;
								componente.setY(pixelY);
								sleep(velocidad);
								break;
						}
						miLogica.actualizarPanel();
					}
				}
			}
			
			componente.puedeMover();

			sleep(10);
			this.stop();
		}catch(InterruptedException e){ e.printStackTrace();}
		
	}

}