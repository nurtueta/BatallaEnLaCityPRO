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
	//private Enemigo [] misEnemigos;
	
	/*Constructor*/
	
	public Logica(){
		mapa=new ComponenteGrafico[20][20];
		
		generacionDeMapaLogico();
		//Creacion del jugador 
		miJugador = new Jugador(1,1);
		ingresarJugador(1,1);
		
		
		
		//Creacion de los enemigos
	//	misEnemigos = new Enemigo [4];
	//misEnemigos[0]= new Basico(5,0);
		//crearEnemigo(1,1);//(x,y): x=posicion en arreglo, y=tipo de enemigo
		
	}
	
	/*Commandos*/

	//Devuelvo el mapa creado
	public	ComponenteGrafico[][] getMapaLogico(){
		return mapa;
	}
	
	//Genero mapa a partir de un archivo
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
	      			mapa[i][j]= new Agua(j,i);
	      		}else
	      		if(s=='L'){
	      			mapa[i][j]= new Ladrillo(j,i);
	      		}else
	      		if(s=='I'){
	      			mapa[i][j]= new Acero(j,i);
	      		}else
	      		if(s=='B'){
	      			mapa[i][j]= new Arbol(j,i);
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
	      			mapa[i][j]= new Piso(j,i);
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

	//Mover para el jugador y los enemigos
	private void mover(ComponenteGrafico j,int direccion)
	{
		
		int f= j.getPosicionY();
		int c = j.getPosicionX();
		boolean movio=false;
		switch (direccion) {
			case 1: if(c<(mapa[0].length-1)){
						if(mapa[f][c+1].movimientoPosible()){
							ComponenteGrafico aux = mapa[f][c+1];
							mapa[f][c+1]=mapa[f][c];
							mapa[f][c]= aux;
							movio=true;
							c++;
						}	
					}
						break;
			case 2: if(c>0){
						if(mapa[f][c-1].movimientoPosible()){
							ComponenteGrafico aux = mapa[f][c-1];

							mapa[f][c-1]=mapa[f][c];
							mapa[f][c]=aux;
							movio=true;
							c--;
						}
					}
					break;
			case 3: if(f>0){
						if(mapa[f-1][c].movimientoPosible()){
							ComponenteGrafico aux = mapa[f-1][c];

							mapa[f-1][c]=mapa[f][c];
							
							mapa[f][c]=aux;
							movio=true;
							f--;
						}
					}	
					break;
			case 4: if(f<(mapa.length-1)){
						if(mapa[f+1][c].movimientoPosible()){
							ComponenteGrafico aux = mapa[f+1][c];

							mapa[f+1][c]=mapa[f][c];
							mapa[f][c]=aux;
							movio=true;
							f++;
						}
					}
					break;
			}
	/*	if(movio){
			mapa[f][c].setPosicionX(c);
			mapa[f][c].setPosicionY(f);
		}*/
		j.setPosicionX(c);
		j.setPosicionY(f);
		
	}
	
	//disparo del jugador
	public void disparar(Jugador j)
	{
		
	}
	
	//elimino la celda del mapa y le asigno el piso vacio.
	public void eliminar(ComponenteGrafico c){
		
		//mapa[c.getPosicionX()][c.getPosicionY()]=null;
		mapa[c.getPosicionX()][c.getPosicionY()]= new Piso(c.getPosicionX(),c.getPosicionY());
		c.eliminar();
		//c.setVisible(false);
	}
	
	//ingreso jugador
	public void ingresarJugador(int x, int y)
	{
		miJugador.setPosicionY(y);
		miJugador.setPosicionX(x);
		mapa[x][y]=miJugador;
		System.out.println(miJugador);
	}
	
	//creo enemigo indicando la posicion en el arreglo y el tipo de enemigo
	public void crearEnemigo(){
		//mapa[c.getPosicionX()][c.getPosicionY()]= new Basico(c.getPosicionX(),c.getPosicionY());
		Enemigo nuevoEnemigo = new Basico(5,0);
		if( nuevoEnemigo.crearEnemigo()){
			mapa[5][0]= nuevoEnemigo;
			System.out.println(mapa[5][0]+"hola");
		}
		else
			System.out.println("esto no entra en el if");
	}
	
	//agrego el enemigo creado al mapa
	private void agregarEnemigo(ComponenteGrafico e,int x,int y){
		//genero x,y en los respawn
		
		e.setPosicionY(y);
		e.setPosicionX(x);
		mapa[x][y]=e;
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
		return mapa[x][y];
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
}
