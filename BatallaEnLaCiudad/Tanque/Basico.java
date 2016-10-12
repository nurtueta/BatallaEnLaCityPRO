package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import TDALista.EmptyListException;
import TDALista.Position;
import TDALista.PositionList;

public class Basico extends Enemigo{

	/*Constructor*/
	private static final long serialVersionUID = 1L;
	protected Position<ComponenteGrafico> posEnLista;
	
	public Basico(int x,int y,PositionList<ComponenteGrafico> miLista){
		super(x,y);
		miLista.addLast(this);
		try {
			posEnLista = miLista.last();
		} catch (EmptyListException e) {e.printStackTrace();}
		
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/tanqueDer.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		//posicionImagen(1);
	}
	
	/*Comandos*/
	
	//pongo la imagen en la direccion del tanque
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
	public void setVida(int v) {
		// TODO Auto-generated method stub
		vida=v;
	}

	//seteo la posicion en Y
	public void setFila(int f) {
		//setPosicionY(f);
	}

	//seteo la posicion en X
	public void setColumna(int c) {
		//setPosicionX(c);
	}

	//seteo la direccion del tanque
	public void setDireccion(int d) {
		//posicionImagen(d);
	}
	
	/*Consultas*/
	
	//devuelvo si puedo mover a esta posicion
	public boolean movimientoPosible() {
		return false;
	}
	
	//devuelvo la posicion en X
	public int getColumna() {
		return 0;
		//return getPosicionX();
	}
	
	//devuelvo la posicion en Y
	public int getFila() {
		return 0;
		//return getPosicionY();
	}//¿¿
	
	//devuelvo la vida del tanque
	public int getVida() {
		return vida;
	}

	@Override
	public void eliminar() {
		
	}

	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mover()
	{
		this.setPosicionY(getPosicionY()+1);
		/*switch (direccion) {
			case 1: 
					this.setPosicionX(getPosicionX()+1);
					
					break;
			case 2: 
					this.setPosicionX(getPosicionX()-1);
					break;
			case 3: 
					this.setPosicionY(getPosicionY()-1);
					break;
			case 4: 
					this.setPosicionY(getPosicionY()+1);
					break;
			}
		 	*/
		
		return false;

	}
	
}
