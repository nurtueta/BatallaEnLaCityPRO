package Logica;

import java.applet.Applet;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.applet.Applet;
import java.applet.AudioClip;
import Grafica.StarWarsIntro;
import Logica.Bloque.Celda;

public class Disparo extends Celda{
	/**
	 * 
	 */
	protected int deQuienEs;
	
	protected Logica manejo;
	
	public Disparo(int x,int y,int d,Logica l,int deQuienEs)
	{	
		super(x,y);
		profundidad=3;
		
		
		java.net.URL url = StarWarsIntro.class.getResource("/archivo/StarWarsBlasterSoundEffect.wav");
	    AudioClip clip = Applet.newAudioClip(url);
	    clip.play();
	    clip.stop();
		
		this.deQuienEs=deQuienEs;
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
		return false;
	}

	public void recibirDisparo() {
		
	}

	public void eliminar() {
		
	}

	public void posicionImagen(int i) {
		
	}
	
	public boolean mover(int direcion)
	{	boolean seMovio=true;
		if(this.getPosicionX()==0 || this.getPosicionY()==0 || 
				this.getPosicionX()==(manejo.getMapaLogico().length-1) ||
				this.getPosicionY()==(manejo.getMapaLogico().length-1))
			seMovio=false;
		else
			switch (direccion) {
				case 1: this.setPosicionX(getPosicionX()+1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())     
						seMovio=false;
					
					break;
				case 2: 
					this.setPosicionX(getPosicionX()-1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())
						seMovio=false;
					break;
				case 3: 
					this.setPosicionY(getPosicionY()-1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())	
						seMovio=false;
					break;
				case 4: 
					this.setPosicionY(getPosicionY()+1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())
						seMovio=false;
					break;
				}
		manejo.actualizarPanel();
		return seMovio;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}

	public void colicion(int deQuienEs) {
		
	}
}
