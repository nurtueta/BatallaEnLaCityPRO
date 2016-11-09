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
	protected	static java.net.URL url = StarWarsIntro.class.getResource("/archivo/StarWarsBlasterSoundEffect.wav");
	protected static AudioClip clip = Applet.newAudioClip(url);
	protected Logica manejo;
	
	public Disparo(int x,int y,int d,Logica l,int deQuienEs)
	{	
		super(x,y);
		profundidad=3;
		
		clip.play();
		
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
		switch (direccion) {
			case 1: 
				if(getPosicionX()!=19){
					this.setPosicionX(getPosicionX()+1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())     
						seMovio=false;
				}else
					seMovio=false;
				break;
			case 2: 
				if(getPosicionX()!=0){
					this.setPosicionX(getPosicionX()-1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())
						seMovio=false;
				}else
					seMovio=false;
				break;
			case 3: 
				if(getPosicionY()!=0){
					this.setPosicionY(getPosicionY()-1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())	
						seMovio=false;
				}else
					seMovio=false;
				break;
			case 4: 
				if(getPosicionY()!=19){
					this.setPosicionY(getPosicionY()+1);
					if(!manejo.getComponente(this.getPosicionX(), this.getPosicionY()).movimientoPosibleDisparo())
						seMovio=false;
				}else
					seMovio=false;
				break;
		}
		if(!seMovio){
			manejo.eliminarColicion(getPosicionX(),getPosicionY(),deQuienEs);
			manejo.eliminarGrafico(this);
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
