package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.MovimientoBalas;
import Logica.MovimientoFluido;

public abstract class Jugador extends Tanque{
	
	/*Variables*/
	
	protected int casco;
	
	/*Constructor*/
	
	public Jugador(int x,int y){
		super(x,y);
		posicionImagen(1);
		casco=0;
		deQuienEs=1;
	}
	
	/*Comandos*/

	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/tanqueDer.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/tanqueIzq.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/tanqueArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/tanqueAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public void setPowerUpDeTanque(int pu){
		casco=pu;
	}
	
	/*Consultas*/
	
	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	public void colicion(int deQuienEs) {
		if(deQuienEs==0){
			if(casco==0)
				vida--;
		}
	}
	
	public void setDireccion(int d){
		direccion=d;
	}
	
	public ComponenteGrafico crearDisparo(){
		ComponenteGrafico bala= new Disparo(0,0,direccion,logica,deQuienEs);
			boolean puedeCrear=true;
			switch(direccion){
				case 1:
					if(!logica.getComponente(miX+1, miY).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX+1);
					bala.setPosicionY(miY);
					break;
				case 2:
					if(!logica.getComponente(miX-1, miY).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX-1);
					bala.setPosicionY(miY);
					break;
				case 3:
					if(!logica.getComponente(miX, miY-1).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX);
					bala.setPosicionY(miY-1);
					break;
				case 4:
					if(!logica.getComponente(miX, miY+1).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX);
					bala.setPosicionY(miY+1);
					break;
			}
			if(!puedeCrear){
				logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),deQuienEs);
				bala=null;
			}
		return bala;
	}
	
}
