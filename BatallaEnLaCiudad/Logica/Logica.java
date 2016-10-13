package Logica;

import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.*;
import Logica.Bloque.*;
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
	protected ComponenteGrafico [] misEnemigos;
	
	/*Constructor*/
	
	public Logica(){
		mapa=new ComponenteGrafico[20][20];
		
		generacionDeMapaLogico();
		//Creacion del jugador 
		miJugador = new Jugador(1,1);
		ingresarJugador(1,1);
		
		
		misEnemigos=new Enemigo[5];
	}
	
	 
	/*
	 * 
	 * 
	 * Comandos
	 * 
	 * 
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
	
	//disparo del jugador
	public void disparar(Jugador j)
	{
		
	}
	
	/**
	 * Elimina un ComponenteGrafico del mapa y deja solo el suelo.
	 * @param c ComponenteGrafico a eliminar.
	 */
	public void eliminar(ComponenteGrafico c){
		boolean esEnemigo=false;
		for(int i=0;i<5;i++)
			if(misEnemigos[i]==c){
				misEnemigos[i]=null;
				mapa[c.getPosicionY()][c.getPosicionX()]=new Piso(c.getPosicionX(),c.getPosicionY());
				esEnemigo=true;
			}
		if(!esEnemigo){
			mapa[c.getPosicionY()][c.getPosicionX()]= new Piso(c.getPosicionX(),c.getPosicionY());
		}
	}
	
	
	//ingreso jugador
	public void ingresarJugador(int x, int y)
	{
		miJugador.setPosicionY(y);
		miJugador.setPosicionX(x);
		mapa[y][x]=miJugador;
	}
	
	//creo enemigo indicando la posicion en el arreglo y el tipo de enemigo
	public	boolean	crearEnemigo(int e){
		boolean hayEspacio=false;
		int i=0;
		while(!hayEspacio &&i<=5){
			if(misEnemigos[i]==null){
				switch(e){
					case 1:misEnemigos[i]=new Basico(5,1,null,null);
						mapa[1][5]=misEnemigos[i];
							break;
				}
				hayEspacio=true;
				System.out.println(this);
			}
			System.out.println(i);
			i++;
		}
		return hayEspacio;
	}
	
	//cambio de nivel al jugador
	public void nivel(int i){
		switch (i){
			case 1:
				eliminar(miJugador);
				ingresarJugador(miJugador.getPosicionX(), miJugador.getPosicionY());
				break;
		}
	}

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		if(y<0 )
			y=0;
		if(x<0)
			x=0;
		return mapa[y][x];
	}
	
	//devuelvo tanque en la posicion p
	/*public ComponenteGrafico getEnemigo(int p){
		return misEnemigos[p];
	}*/
	
	//devuelvo jugador
	public ComponenteGrafico getJugador(){
		return miJugador;
	}
	
	//mostrar mapa para Tester
	public void mostrarMapa(){
		for(int i=0; i<mapa.length;i++){
			for(int j=0;j<mapa[0].length;j++)
				System.out.print(mapa[i][j]+"  \n ");
			System.out.println();
		}
	}
	
	public boolean finDelJuego()
	{
		boolean fin = false;
		
		return fin;
	}
	
	
}
