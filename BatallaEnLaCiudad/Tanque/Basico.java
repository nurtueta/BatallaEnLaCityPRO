package Tanque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;
import TDALista.EmptyListException;
import TDALista.Position;
import TDALista.PositionList;

public class Basico extends Enemigo{

	/*Constructor*/
	private static final long serialVersionUID = 1L;
	protected Logica manejo;
	
	public Basico(int x,int y,Logica l){
		super(x,y);
		manejo=l;
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/tanqueDer.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		//posicionImagen(1);
	}
	
	/*Comandos*/
	
	//pongo la imagen en la direccion del tanque
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
		boolean movio=true;
		direccion = (int) (Math.random()*4+1);
		//this.setPosicionY(getPosicionY()+1);
		switch (direccion) {
			case 1: 
				if(manejo.getComponente(this.getPosicionX()+1, this.getPosicionY()).movimientoPosible())
					this.setPosicionX(getPosicionX()+1);
				else
					movio= false;
				break;
			case 2: 
				if(manejo.getComponente(this.getPosicionX()-1, this.getPosicionY()).movimientoPosible())
					this.setPosicionX(getPosicionX()-1);
				else
					movio=false;
				break;
			case 3: 
				if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()-1).movimientoPosible())
					this.setPosicionY(getPosicionY()-1);
				else
					movio=false;
					break;
			case 4: 
				if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()+1).movimientoPosible())
					this.setPosicionY(getPosicionY()+1);
				else
					movio=false;
					break;
			}
		 	posicionImagen(direccion);
		
		return true;

	}
	
}
