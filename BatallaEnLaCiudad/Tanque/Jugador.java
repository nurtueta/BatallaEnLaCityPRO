package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	
	/*Constructor*/
	
	public Jugador(int x,int y){
		super(x,y);
		posicionImagen(1);
	}
	
	/*Comandos*/
	/**
	 * Genera la imagen en la que el tanque mira.
	 * @param i direccion en la que mira el tanque
	 */
	public void posicionImagen(int i){
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
	
	/**
	 * En un eje XY estaablece la posicion Y
	 * @param f posicion Y a establecer
	 */
	public void setFila(int f){
		setPosicionY(f);
	}
		
	/**
	 * En un eje XY establece la posicion X
	 * @param c  posicion X a establecer
	 */
	public void setColumna(int c){
		setPosicionX(c);
	}
	
	/**
	 * Establece para que lado mira el Jugador
	 * @param d direccion en la que mira el tanque
	 */
	public void setDireccion(int d) {
		posicionImagen(d);
	}
	
	/*Consultas*/
	
	@Override
	public boolean movimientoPosible() {
		return false;
	}
	
	/**
	 * En un eje XY devuelve la posicion X
	 * @return posicion X del Jugador
	 */
	public int getColumna(){
		return getPosicionX();
	}
	
	/**
	 * En un eje XY devuelve la posicion Y
	 * @return posicion Y del Jugador
	 */
	public int getFila(){
		return getPosicionY();
	}
	
	//devuelvo el powerUp del tanque
	public int getPowerUpDeTanque(){
		return powerUpDeTanque;
	}
	
	/**
	 * Devuelve un valor entero representando la vida del Jugador.
	 * @return vida actual del Jugador
	 */
	public int getVida(){
		return vida;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}
}
