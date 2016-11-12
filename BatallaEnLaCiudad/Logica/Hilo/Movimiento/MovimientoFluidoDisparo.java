package Logica.Hilo.Movimiento;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Piso;
import Grafica.Tanque.*;
import Logica.Logica;

public class MovimientoFluidoDisparo extends Movimiento{
	
	int x;
	int y;
	int d;
	int velocidad;
	int pixel;	
	
	protected ComponenteGrafico componente;
	
	public MovimientoFluidoDisparo(ComponenteGrafico x,int d,Logica l){
		super(l);
		this.x=x.getPosicionX();
		this.y=x.getPosicionY();
		this.d=d;
		if(x.getVelocidadDisparo()==1)
			velocidad=13;
		else
			if(x.getVelocidadDisparo()==2)
				velocidad=10;
			else
				velocidad=7;
		pixel=2;
		componente=x;
	}
	
	public void run()
	{	
		try{
			boolean movio=true;
			boolean seCreo=true;
			switch (d){
				case 1: if(x<(19)){
							if(!miLogica.getComponente(x+1, y).movimientoPosibleDisparo()){
								movio=false;
								x++;
							}
						}else
							seCreo=false;
						break;
				case 2: if(x>0){
							if(!miLogica.getComponente(x-1, y).movimientoPosibleDisparo()){
								movio=false;
								x--;
							}
						}else
							seCreo=false;
						break;
				case 3: if(y>0){
							if(!miLogica.getComponente(x, y-1).movimientoPosibleDisparo()){
								movio=false;
								y--;
							}
						}else
							seCreo=false;
						break;
				case 4: if(y<(19)){
							if(!miLogica.getComponente(x, y+1).movimientoPosibleDisparo()){
								movio=false;
								y++;
							}
						}else
							seCreo=false;
						break;
			}
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
				case 1: if(x<(19)){
							if(!miLogica.getComponente(x+1, y).movimientoPosibleDisparo()){
								movio=false;
								x++;
							}
						}else
							seCreo=false;
						break;
				case 2: if(x>0){
							if(!miLogica.getComponente(x-1, y).movimientoPosibleDisparo()){
								movio=false;
								x--;
							}
						}else
							seCreo=false;
						break;
				case 3: if(y>0){
							if(!miLogica.getComponente(x, y-1).movimientoPosibleDisparo()){
								movio=false;
								y--;
							}
						}else
							seCreo=false;
						break;
				case 4: if(y<(19)){
							if(!miLogica.getComponente(x, y+1).movimientoPosibleDisparo()){
								movio=false;
								y++;
							}
						}else
							seCreo=false;
						break;
				}
				if(movio){
					switch(d){
					case 1:
						x++;
						componente.setPosicionX(x);
						break;
					case 2:
						x--;
						componente.setPosicionX(x);
						break;
					case 3:
						y--;
						componente.setPosicionY(y);
						break;						
					case 4:
						y++;
						componente.setPosicionY(y);
						break;	
					}
					miLogica.actualizarPanel();
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
			if(!movio && seCreo){
				miLogica.eliminarColicion(x,y,componente.getDeQuienEs());
				miLogica.eliminarGrafico(componente);
				componente.colicion(0);
			}else
				if(!seCreo){
					miLogica.eliminarGrafico(componente);
					componente.colicion(0);
				}else{
					componente.puedeMover();
				}
			miLogica.actualizarPanel();
			
		}catch(InterruptedException e){ e.printStackTrace();}
	}

}