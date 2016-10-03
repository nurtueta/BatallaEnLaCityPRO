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
	
	//seteo la posicion del tanque
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
		setPosicionY(f);
	}
		
	//seteo la posicion en X
	public void setColumna(int c){
		setPosicionX(c);
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
		return getPosicionX();
	}
	
	//devuelvo la posicion en Y
	public int getFila(){
		return getPosicionY();
	}
	
	//devuelvo el powerUp del tanque
	public int getPowerUpDeTanque(){
		return powerUpDeTanque;
	}
	
	//devuelvo la vida del tanque
	public int getVida(){
		return vida;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}
}
