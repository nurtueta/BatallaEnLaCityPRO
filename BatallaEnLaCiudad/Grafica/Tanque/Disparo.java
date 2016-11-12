package Grafica.Tanque;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Grafica.ComponenteGrafico;
import Logica.Logica;
import Logica.Hilo.Movimiento.*;

public class Disparo extends ComponenteGrafico{
	/**
	 * 
	 */
	protected int deQuienEs;
	protected Movimiento hiloFluido;
	protected boolean puedeMover;
	protected int deQuienEsElDisparo;
	
	public Disparo(int x,int y,int d,Logica l)
	{	
		super(x,y);
		profundidad=3;
		vida=1;
		puedeMover=true;
		logica=l;
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
		return false;
	}

	/**
	 * Muevo el disparo de A a B, hasta que no termina de mover no puedo volverlo a mover.
	 */
	public void mover(int direcion){	
		if(puedeMover){
			hiloFluido=new MovimientoFluidoDisparo(this, direcion,logica);
			puedeMover=false;
			hiloFluido.start();
		}
	}
	
	public void puedeMover(){
		puedeMover=true;
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}

	public void colicion(int deQuienEs) {
		vida=0;
	}

	public boolean mejorar() {
		return false;
	}
	
	/**
	 * Setea quien fue el q disparo la bala
	 */
	public void setEjecutor(int x){
		deQuienEsElDisparo=x;
	}
	
	/**
	 * Devuelve quien disparo la bala
	 */
	public int getEjecutor(){
		return deQuienEsElDisparo;
	}
	
}
