package Logica;

import java.io.*;
import java.util.ArrayList;
import Grafica.*;
import Logica.Bloque.*;
import Tanque.*;

public class Logica {
	
	/*Variables*/
	
	protected ComponenteGrafico[][] mapa;
	protected ComponenteGrafico miJugador;
	
	private Movimiento hiloBalas;
	private Movimiento hiloEnemigos;
	private MovimientoFluido [] hilosFluidos;
	private int puntaje;
	
	private boolean termina;
	
	
	protected GUI grafica;
	
	/*Constructor*/
	
	public Logica(GUI laGUI){
		
		hiloBalas = new MovimientoBalas(this);
		hiloEnemigos = new MovimientoEnemigos(this);
		hilosFluidos=new MovimientoFluido[5];
		hiloBalas.start();
		hiloEnemigos.start();
		puntaje=0;
		grafica=laGUI;
		
		termina=false;
		
		mapa=new ComponenteGrafico[20][20];
		
		generacionDeMapaLogico();
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
	public void mover(ComponenteGrafico j,int direccion)
	{
		j.setDireccion(direccion);
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
	public void ingresarJugador()
	{
		miJugador = new Jugador(1,1);
		miJugador.setDireccion(1);
		miJugador.setPosicionY(1);
		miJugador.setPosicionX(1);
		mapa[1][1]=miJugador;
	}

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		if (x<0)
			x=0;
		if(y<0)
			y=0;
		return mapa[y][x];
	}

	//devuelvo jugador
	public ComponenteGrafico getJugador(){
		return miJugador;
	}
	
	public boolean finDelJuego()
	{
		return termina;
	}
	
	public void actualizarPanel(){
		grafica.repaint();
	}
	
	public void eliminarBala(ComponenteGrafico x){
			grafica.eliminarGrafico(x);
	}
	
	public void eliminarEnemigo(ComponenteGrafico x){
		grafica.eliminarGrafico(x);
	}
    
	private ComponenteGrafico crearDisparo(ComponenteGrafico componente,int x){
		ComponenteGrafico bala = new Disparo(0,0,componente.getDireccion(),this,x);
		boolean puedeCrear=true;
		switch(componente.getDireccion()){
			case 1:
				bala.setPosicionX(componente.getPosicionX()+1);
				bala.setPosicionY(componente.getPosicionY());
				if(!mapa[componente.getPosicionY()][componente.getPosicionX()+1].movimientoPosibleDisparo())
					puedeCrear=false;
				break;
			case 2:
				bala.setPosicionX(componente.getPosicionX()-1);
				bala.setPosicionY(componente.getPosicionY());
				if(!mapa[componente.getPosicionY()][componente.getPosicionX()-1].movimientoPosibleDisparo())
					puedeCrear=false;
				break;
			case 3:
				bala.setPosicionX(componente.getPosicionX());
				bala.setPosicionY(componente.getPosicionY()-1);
				if(!mapa[componente.getPosicionY()-1][componente.getPosicionX()].movimientoPosibleDisparo())
					puedeCrear=false;
				break;
			case 4:
				bala.setPosicionX(componente.getPosicionX());
				bala.setPosicionY(componente.getPosicionY()+1);
				if(!mapa[componente.getPosicionY()+1][componente.getPosicionX()].movimientoPosibleDisparo())
					puedeCrear=false;
				break;
		}
		if(!puedeCrear){
			eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),x);
			bala=null;
		}else{
			hiloBalas.addBala(bala);
		}
		return bala;
	}
	
	private ComponenteGrafico crearEnemigo(int x,int y){
		Enemigo enemigo = new Basico(x, y,this,1);
		if(mapa[y][x].movimientoPosible()){
			mapa[y][x]=enemigo;
			enemigo.setVisible(true);
			hiloEnemigos.addEnemigo(enemigo);
		}else
			enemigo=null;
		return enemigo;
	
	}
	
	public Movimiento getHilosBalas(){
		return hiloBalas;
	}
	
	public Movimiento getHilosEnemigos(){
		return hiloEnemigos;
	}
	
	private void finalizarJuego(){
		terminar();
		grafica.eliminarGrafico(miJugador);
		grafica.terminarJuego();
	}
	
	private void terminar(){
		termina=true;
	}
	
	public void eliminarColicion(int x,int y,int deQuienEs){
		int sigX=x;
		int sigY=y;
		getComponente(sigX, sigY).colicion(deQuienEs);
		if(getComponente(sigX, sigY).getVida()==0){
			if(getComponente(sigX, sigY)==miJugador){
				finalizarJuego();
			}else{
				grafica.eliminarGrafico(getComponente(sigX, sigY));
				mapa[sigY][sigX]=new Piso(sigX,sigY);
				grafica.agregarGrafico(getComponente(sigX, sigY));
			}
		}
		actualizarPanel();
	}
	
	public	int obtenerPuntaje(){
		return puntaje;
	}
	
	public void crearDisparo(){
    	ComponenteGrafico bala=crearDisparo(getJugador(),1);
    	if(bala!=null){
    		grafica.agregarGrafico(bala);
    		grafica.agregarZOrder(bala,1);
    	}
    }
	
	public void crearDisparoEnemigo(ComponenteGrafico enemigo){
		ComponenteGrafico bala=crearDisparo(enemigo,0);
    	if(bala!=null){
    		grafica.agregarGrafico(bala);
    		grafica.agregarZOrder(bala,1);
    	}
		
	}
	
	public void crearJugador(){
    	ingresarJugador();
        grafica.agregarGrafico(getJugador());
        grafica.agregarZOrder(getJugador(), 1);
    }
	
	public void crearEnemigo() {
		ComponenteGrafico enemigo=crearEnemigo(4,4);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
			grafica.agregarZOrder(enemigo, 1);
		}
	}
	
	public void generarPanel(){
		for(int i=0;i<20;i++)
		 	for(int j=0;j<20;j++){
		 		ComponenteGrafico comp = getComponente(i,j);
		 		grafica.agregarGrafico(comp);
		 	}
    }
	
	public void iniciarMovimientoJugador(int d){
		hilosFluidos[0]=new MovimientoFluido(this, miJugador.getPosicionX(), miJugador.getPosicionY(), d);
		hilosFluidos[0].start();
	}
	
	public void iniciarMovimientoEnemigo(int enemigo,ComponenteGrafico e,int d){
		hilosFluidos[enemigo]=new MovimientoFluido(this, e.getPosicionX(), e.getPosicionY(), d);
		hilosFluidos[enemigo].start();
	}
	
}
