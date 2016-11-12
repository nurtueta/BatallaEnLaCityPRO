package Grafica.Tanque.Jugador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Grafica.main;
import Grafica.Tanque.Tanque;
import Logica.Logica;
import Logica.Hilo.HiloTiempoEspera;
import Logica.Hilo.Movimiento.MovimientoBalas;
import Logica.Hilo.Movimiento.MovimientoFluidoTanque;

public class Jugador extends Tanque{
	
	/*Variables*/
	
	protected boolean casco;
	protected Nivel nivel;
	
	/*Constructor*/
	
	public Jugador(int x,int y,Logica l){
		super(x,y);
		profundidad=4;
		logica=l;
		posicionImagen(1);
		casco=false;
		nivel = new Nivel1();
	}
	
	/*Comandos*/

	public void posicionImagen(int i){
		direccion = i;
		ImageIcon fot=new ImageIcon();
		switch (i){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/XWingDerecha.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/XWingIzquierda.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/XWingArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/XWingAbajo.png"));
				break;
		}
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public void usaCasco(boolean x){
		casco=x;
	}
	
	/*Consultas*/
	
	public void colicion(int deQuienEs) {
		if(deQuienEs==0){
			if(!casco){
				nivel.bajarVida();
				if(nivel.getVida()==0){
					ImageIcon fot=new ImageIcon(getClass().getResource("/Imagenes/explosion.gif"));
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
					this.setIcon(icono);
					java.net.URL url = main.class.getResource("/archivo/R2D2Scream.wav");
				    AudioClip clip = Applet.newAudioClip(url);
				    logica.stopMusic();
				    clip.play();
				    new HiloTiempoEspera(2000);
				    clip.play();		
					logica.finalizarJuego(false);
				}
				else
					bajarNivel();
			}
		}
	}
	
	public void setDireccion(int d){
		direccion=d;
	}
	
	public void subirNivel(){
		nivel = nivel.mejorarNivel();
	}
	
	public void bajarNivel(){
		Nivel nuevoNivel = new Nivel1();
	}
		
	public int getVida(){
		return nivel.getVida();
	}
	
	public int getDisparosSimultaneos(){
		return nivel.getDisparosSimultaneos();
	}
	
	public int getVelMovimiento(){
		return nivel.getVelocidadMov();
	}
	
	public int getVelocidadDisparo(){
		return nivel.getVelocidadDisparo();
	}
	
	public int getNivel(){
		return nivel.getNivel();
	}
	
	public void puedeMover(){
		puedeMover=true;
	}
	
	public boolean getPuedeMover(){
		return puedeMover;
	}
	
}
