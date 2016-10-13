package Logica;

import java.io.*;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.*;
import Logica.Bloque.*;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Lista;
import TDALista.Position;
import TDALista.PositionList;
import Tanque.Basico;
import Tanque.Blindado;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Rapido;
import Tanque.Tanque;


public class Logica {
	
	/*Variables*/
	
	protected ComponenteGrafico[][] mapa;
	protected ComponenteGrafico miJugador;
	
	private Movimiento hiloBalas;
	private Movimiento hiloEnemigos;
	
	protected int direccion;
	
	protected GUI grafica;
	
	/*Constructor*/
	
	public Logica(GUI laGUI){
		
		hiloBalas = new MovimientoBalas(this);
		hiloEnemigos = new MovimientoEnemigos(this);
		hiloBalas.start();
		hiloEnemigos.start();
		
		grafica=laGUI;
		
		mapa=new ComponenteGrafico[20][20];
		
		generacionDeMapaLogico();
		
		miJugador = new Jugador(1,1);
		direccion=1;
		ingresarJugador(1,1);
	}
	
	/*
	 * Comandos
	 * */
	
	/**
	 * Permite ver el mapa logico
	 * @return Una matriz que represanta al mapa logico
	 */
	public	ComponenteGrafico[][] getMapaLogico(){
		return mapa;
	}
	
	/**
	 * Genera una matriz interna en Logica producto
	 *  de la traduccion de un archivo .txt
	 */
	public void generacionDeMapaLogico()
	{
	  	FileReader fi;
		try {
			fi = new FileReader("archivo/Hello1.txt");
	        BufferedReader b = new BufferedReader(fi);
	        String cadena;
		int j=0;
		
	      while((cadena = b.readLine())!=null) {
	    	  
	      	 for(int i=0;i<cadena.length();i++){
	      		char s = cadena.charAt(i);
	      		if(s=='A'){
	      			mapa[j][i]= new Agua(i,j);
	      		}else
		      		if(s=='L'){
		      			mapa[j][i]= new Ladrillo(i,j);
		      		}else
			      		if(s=='I'){
			      			mapa[j][i]= new Acero(i,j);
			      		}else
				      		if(s=='B'){
				      			mapa[j][i]= new Arbol(i,j);
				      		}/*else
					      		if(s=='E'){
					      			mapa[i][j]= 26; Aguila == Eagle
					      		}else
						      		if(s=='P'){
						      			mapa[i][j]= 28; Portal enemigo
						      		}else
							      		if(s=='R'){
							      			mapa[i][j]= 27; Respown
							      		}*/
							      		else{
							      			mapa[j][i]= new Piso(i,j);
							      		}
	      		}
	      	j++;
	      	}  
	    
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// al jugador
	public void mover(int direccion){
		mover(miJugador,direccion);
	}

	/**
	 * Mueve al Jugador o Enemigo pasado por parametro en la direccion indicada
	 * @param j Jugador o Enemigo
	 * @param direccion Direccion de movimiento
	 */
	private void mover(ComponenteGrafico j,int direccion)
	{
		this.direccion=direccion;
		int Y= j.getPosicionY();
		int X = j.getPosicionX();
		switch (direccion) {
			case 1: if(X<(mapa[0].length-1)){
						if(mapa[Y][X+1].movimientoPosible()){
							mapa[Y][X+1]=j;
							mapa[Y][X]= new Piso(X,Y);
							X++;
						}	
					}
					break;
			case 2: if(X>0){
						if(mapa[Y][X-1].movimientoPosible()){
							mapa[Y][X-1]=j;
							mapa[Y][X]= new Piso(X,Y);
							X--;
						}
					}
					break;
			case 3: if(Y>0){
						if(mapa[Y-1][X].movimientoPosible()){
							mapa[Y-1][X]=j;
							mapa[Y][X]= new Piso(X,Y);
							Y--;
						}
					}	
					break;
			case 4: if(Y<(mapa.length-1)){
						if(mapa[Y+1][X].movimientoPosible()){
							mapa[Y+1][X]=j;
							mapa[Y][X]= new Piso(X,Y);
							Y++;
						}
					}
					break;
			}

		j.setPosicionX(X);
		j.setPosicionY(Y);
		j.posicionImagen(direccion);
	}
	
	
	/**
	 * Elimina un ComponenteGrafico del mapa y deja solo el suelo.
	 * @param c ComponenteGrafico a eliminar.
	 */
	
	//ingreso jugador
	public void ingresarJugador(int x, int y)
	{
		miJugador.setPosicionY(y);
		miJugador.setPosicionX(x);
		mapa[y][x]=miJugador;
	}

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		return mapa[y][x];
	}

	//devuelvo jugador
	public ComponenteGrafico getJugador(){
		return miJugador;
	}
	
	public boolean finDelJuego()
	{
		boolean fin = false;
		
		return fin;
	}
	
	public void actualizarPanel(){
		grafica.repaint();
	}
	
	public void eliminarBala(ComponenteGrafico x){
			hiloBalas.getBalas().remove(x);
			grafica.eliminarDisparo(x);
	}
    
	public ComponenteGrafico crearDisparo(){
		Disparo bala = new Disparo(miJugador.getPosicionX(),miJugador.getPosicionY(),direccion,this);
		bala.setVisible(true);
		hiloBalas.addBala(bala);
		return bala;
	}
	
	public ComponenteGrafico crearEnemigo(){
		Enemigo enemigo = new Basico(4, 4,this);
		enemigo.setVisible(true);
		hiloEnemigos.addEnemigo(enemigo);
		return enemigo;
	
	}
	
	public Movimiento getHilosBalas(){
		return hiloBalas;
	}
	
	public Movimiento getHilosEnemigos(){
		return hiloEnemigos;
	}
	
}
