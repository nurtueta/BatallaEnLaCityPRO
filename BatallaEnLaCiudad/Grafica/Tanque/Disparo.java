package Grafica.Tanque;

import java.applet.Applet;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.applet.Applet;
import java.applet.AudioClip;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Bloque;
import Logica.Logica;
import Logica.Hilo.Movimiento.Movimiento;
import Logica.Hilo.Movimiento.MovimientoFluidoDisparo;
import Logica.Hilo.Movimiento.MovimientoFluidoTanque;

public class Disparo extends ComponenteGrafico{
	/**
	 * 
	 */
	protected int deQuienEs;
	protected Movimiento hiloFluido;
	protected boolean puedeMover;
	
	public Disparo(int x,int y,int d,Logica l,int deQuienEs)
	{	
		super(x,y);
		profundidad=3;
		vida=1;
		puedeMover=true;
		this.deQuienEs=deQuienEs;
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

	public void recibirDisparo() {
		
	}

	public void eliminar() {
		
	}

	public void posicionImagen(int i) {
		
	}
	
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
	
	public boolean puedoIngresarPowerUp(){
		return false;
	}
}
