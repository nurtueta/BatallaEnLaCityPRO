package Logica;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.ComponenteGrafico;
import Logica.Bloque.Celda;
import Logica.Bloque.Piso;
import TDALista.EmptyListException;
import TDALista.Position;
import TDALista.PositionList;

public class Disparo extends Celda{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int direccion;
	
	protected Logica manejo;
	
	public Disparo(int x,int y,PositionList<ComponenteGrafico> miLista,Logica l)
	{	
		
		super(x,y);
		miLista.addLast(this);
		manejo=l;
		
		try {
			posEnLista = miLista.last();
		} catch (EmptyListException e) {e.printStackTrace();}
		
		direccion = manejo.getJugador().getDireccion();
		ImageIcon fot = new ImageIcon();
		switch (direccion){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaDerecha.png"));
				this.setPosicionX(x+1);
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaIzquierda.png"));
				this.setPosicionX(x-1);
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaArriba.png"));
				this.setPosicionY(y-1);
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaAbajo.png"));
				this.setPosicionY(y+1);
				break;
		}
		
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png")));
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public Position<ComponenteGrafico> getPosEnLista ()
	{
		return posEnLista;
	}
	
	public Disparo getDisparo(){
		return this;
	}
	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recibirDisparo() {
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posicionImagen(int i) {
		// TODO Auto-generated method stub		
	}
	
	public boolean mover()
	{	boolean seMovio=true;
		switch (direccion) {
			case 1: 
				if(manejo.getComponente(this.getPosicionX()+1, this.getPosicionY()).movimientoPosible())     
					this.setPosicionX(getPosicionX()+1);
				else
					seMovio=false;
				break;
			case 2: 
				if(manejo.getComponente(this.getPosicionX()-1, this.getPosicionY()).movimientoPosible())
					this.setPosicionX(getPosicionX()-1);
				else
					seMovio=false;
				break;
			case 3: 
				if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()-1).movimientoPosible())	
					this.setPosicionY(getPosicionY()-1);
				else
					seMovio=false;
				break;
			case 4: 
				if(manejo.getComponente(this.getPosicionX(), this.getPosicionY()+1).movimientoPosible())
					this.setPosicionY(getPosicionY()+1);
				else
					seMovio=false;
					//le saco vida
					//manejo.getComponente(this.getPosicionX(), this.getPosicionY()+1).setVida(getVida()-10);
				break;
			}
		return seMovio;
	}
	
}
