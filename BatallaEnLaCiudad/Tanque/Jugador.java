package Tanque;

import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	
	/*Constructor*/
	
	public Jugador(){
		super();
		posicionImagen(1);
	}
	
	/*Comandos*/
	
	//seteo la posicion del tanque
	public void posicionImagen(int i){
		switch (i){
			case 1:
				this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueDer.png")));
				break;
			case 2:
				this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueIzq.png")));
				break;
			case 3:
				this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueArriba.png")));
				break;
			case 4:
				this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueAbajo.png")));
				break;
		}
	}
	
	//seteo la vida del tanque
	public void setVida(int v){
		vida=v;
	}
	
	//seteo el powerUp del tanque
	public void setPowerUpDeTanque(int pu){
		powerUpDeTanque=pu;
	}
	
	//seteo la posicion en Y
	public void setFila(int f){
		setY(f);
	}
		
	//seteo la posicion en X
	public void setColumna(int c){
		setX(c);
	}
	
	//indico la direccion del tanque
	public void setDireccion(int d) {
		posicionImagen(d);
	}
	
	/*Consultas*/
	
	//devuelvo si es posible movel a la posicion
	public boolean movimientoPosible() {
		return false;
	}
	
	//devuelvo la posicion en X
	public int getColumna(){
		return getX();
	}
	
	//devuelvo la posicion en Y
	public int getFila(){
		return getY();
	}
	
	//devuelvo el powerUp del tanque
	public int getPowerUpDeTanque(){
		return powerUpDeTanque;
	}
	
	//devuelvo la vida del tanque
	public int getVida(){
		return vida;
	}
}
