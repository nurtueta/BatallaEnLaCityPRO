package Grafica.Tanque.Jugador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Grafica.main;
import Grafica.Tanque.Disparo;
import Grafica.Tanque.Tanque;
import Logica.Logica;
import Logica.Hilo.HiloTiempoEspera;
import Logica.Hilo.Movimiento.MovimientoFluidoTanque;

public class Jugador extends Tanque{
	
	/*Variables*/
	
	protected boolean casco;
	protected Nivel nivel; //Indica el nivel del jugador
	
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
	
	/**
	 * Activa o desactiva el casco que lo hace invulnerable
	 */
	public void usaCasco(boolean x){
		casco=x;
	}
	
	/*Consultas*/
	/**
	 * coliciono el jugador, si tiene mas de nivel 1 y se murio, lo creo de nuevo. si es nivel perfi el juego.
	 */
	public void colicion(ComponenteGrafico x) {
		if(x!=this){
			if(!casco){
				nivel.bajarVida();
				if(nivel.getVida()==0){
					if(getNivel()>1){
						logica.crearJugador();
					}else{
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
		if(nivel.getNivel()!=4)
			nivel = nivel.mejorarNivel();
	}
	
	public void bajarNivel(){
		nivel = new Nivel1();
	}
		
	public int getVida(){
		return nivel.getVida();
	}
	
	public void aumentarVida(){
		nivel.aumentarVida();
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
	
	/**
	 * Mueve el tanque y lo desabilita hasta que termina de moverse
	 */
	public void mover(int direccion) {
		if(puedeMover){
			hiloFluido=new MovimientoFluidoTanque(this, direccion,logica);
			puedeMover=false;
			hiloFluido.start();
		}
	}	
	
	public ComponenteGrafico crearDisparo(){
		ComponenteGrafico bala=null;
		if(disparosAndando<getDisparosSimultaneos()){
			boolean seMovio=true;
			boolean seCreo=true;
			bala= new Disparo(0,0,direccion,logica);
			switch (direccion) {
				case 1: 
					if(miX!=19){
						bala.setPosicionX(miX+1);
						bala.setPosicionY(miY);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())     
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 2: 
					if(miX!=0){
						bala.setPosicionX(miX-1);
						bala.setPosicionY(miY);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 3: 
					if(miY!=0){
						bala.setPosicionY(miY-1);
						bala.setPosicionX(miX);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())	
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 4: 
					if(miY!=19){
						bala.setPosicionY(miY+1);
						bala.setPosicionX(miX);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())
							seMovio=false;
					}else
						seCreo=false;
					break;
			}
			if(seMovio){
				bala.setEjecutor(this);
				disparosAndando++;
			}
			if(!seMovio && seCreo){
				bala.setEjecutor(this);
				logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),this);
				bala=null;
			}
			if(!seCreo)
				bala=null;
		}
		return bala;
	}
	
}
