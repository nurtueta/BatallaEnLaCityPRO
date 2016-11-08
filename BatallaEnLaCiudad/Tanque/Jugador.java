package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	
	/*Constructor*/
	
	public Jugador(int x,int y){
		super(x,y);
		posicionImagen(1);
		vida=50;
	}
	
	/*Comandos*/
	/**
	 * Genera la imagen en la que el tanque mira.
	 * @param i direccion en la que mira el tanque (actua como setter de 'direccion')
	 */
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
	
	
	/**
	 * Establece la vida del Jugador.
	 * @param v cantidad de vida a establecer.
	 */
	public void setVida(int v){
		vida=v;
	}
	
	/**
	 * Agrega un powerUp al tanque
	 * @param pu powerUp que se le transferira al tanque
	 */
	public void setPowerUpDeTanque(int pu){
		powerUpDeTanque=pu;
	}
	
	/*Consultas*/
	
	public boolean movimientoPosible() {
		return false;
	}
	
	//devuelvo el powerUp del tanque
	public int getPowerUpDeTanque(){
		return powerUpDeTanque;
	}

	public void recibirDisparo() {
		
	}

	public boolean mover() {
		return false;
	}
	
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	public int disparosSimultaneos(){
		//esto debe ser un metodo abstracto cuando Jugador se convierta en clase abstracta s/State
		return 0;
	}

	public int velocidadDisparo(){
		//esto debe ser un metodo abstracto cuando Jugador se convierta en clase abstracta s/State
		return 0;
	}
	
	public void colicion(int deQuienEs) {
		//pruebo de quien es el disparo que recive	
		if(deQuienEs==0){
			vida-=50;
			System.out.println("te queda "+vida+" de vida");
		}
		
	}
}
