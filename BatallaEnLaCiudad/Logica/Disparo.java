package Logica;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Logica.Bloque.Celda;

public class Disparo extends Celda{
	/**
	 * 
	 */
	protected int direccion;
	
	protected Logica manejo;
	
	public Disparo(int x,int y,int d,Logica l)
	{	
		super(x,y);
		manejo=l;
		direccion = d;
		ImageIcon fot = new ImageIcon();
		switch (direccion){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaDerecha.png"));
				this.setPosicionX(x+1);
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaIzquierda.png"));
				if(x!=0)
					this.setPosicionX(x-1);
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaArriba.png"));
				if(y!=0)
				this.setPosicionY(y-1);
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaAbajo.png"));
				
				this.setPosicionY(y+1);
				break;
		}
		
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirDisparo() {
		
	}

	public void eliminar() {
		
	}

	public void posicionImagen(int i) {
		
	}
	
	public boolean mover()
	{	boolean seMovio=true;
		if(this.getPosicionX()==0 || this.getPosicionY()==0 || 
				this.getPosicionX()==(manejo.getMapaLogico().length-1) ||
				this.getPosicionY()==(manejo.getMapaLogico().length-1))
			seMovio=false;
		else
			switch (direccion) {
				case 1: 
					if(manejo.getComponente(this.getPosicionX()+1, this.getPosicionY()).movimientoPosibleDisparo())     
						this.setPosicionX(getPosicionX()+1);
					else
						seMovio=false;
					
					break;
				case 2: 
					if(manejo.getComponente(this.getPosicionX()-1, this.getPosicionY()).movimientoPosibleDisparo())
						this.setPosicionX(getPosicionX()-1);
					else
						seMovio=false;
					break;
				case 3: 
					if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()-1).movimientoPosibleDisparo())	
						this.setPosicionY(getPosicionY()-1);
					else
						seMovio=false;
					break;
				case 4: 
					if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()+1).movimientoPosibleDisparo())
						this.setPosicionY(getPosicionY()+1);
					else
						seMovio=false;
						//le saco vida
						//manejo.getComponente(this.getPosicionX(), this.getPosicionY()+1).setVida(getVida()-10);
					break;
				}
		return seMovio;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}

	@Override
	public void colicion() {
		// TODO Auto-generated method stub
		
	}
	
}
