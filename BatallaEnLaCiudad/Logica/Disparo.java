package Logica;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Bloque.Celda;
import Logica.Bloque.Piso;
import TDALista.Position;

public class Disparo extends Celda{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int direccion;
	protected Position<Disparo> posEnLista;
	
	public Disparo(int d, int x, int y)
	{	
		super(x,y);
		direccion = d;
		ImageIcon fot = new ImageIcon();
		switch (d){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaDerecha.png"));
				this.setX(x+ancho);
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaIzquierda.png"));
				this.setX(x-ancho);
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaArriba.png"));
				this.setY(y-alto);
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaAbajo.png"));
				this.setY(y+alto);
				break;
		}
		
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png")));
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	public void setPosEnLista(Position<Disparo> p)
	{
		posEnLista = p;
	}
	
	public Position<Disparo> getPosEnLista ()
	{
		return posEnLista;
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
	
	public void mover()
	{
		switch (direccion) {
			case 1: /*
					if(x<(mapa[0].length-1)){
						if(mapa[Y][X+1].movimientoPosible()){
							mapa[Y][X+1]=j;
							mapa[Y][X]= new Piso(X,Y);
							X++;
						}	
					*/
						this.setX(getX()+ancho);
					
						break;
			case 2: /*
					if(X>0){
						if(mapa[Y][X-1].movimientoPosible()){
							mapa[Y][X-1]=j;
							mapa[Y][X]= new Piso(X,Y);
							X--;
						}
					}
					*/
					this.setX(getX()-ancho);
					break;
			case 3: /*
					if(Y>0){
						if(mapa[Y-1][X].movimientoPosible()){
							mapa[Y-1][X]=j;
							mapa[Y][X]= new Piso(X,Y);
							Y--;
						}
					}
					*/
					this.setY(getY()-alto);
					break;
			case 4: 
					/*
					if(Y<(mapa.length-1)){
					
						if(mapa[Y+1][X].movimientoPosible()){
							mapa[Y+1][X]=j;
							mapa[Y][X]= new Piso(X,Y);
							Y++;
						}
					}
					 */
					this.setY(getY()+alto);
					break;
			}

		//j.setPosicionX(x);
		//j.setPosicionY(y);

	}
	
	
}
