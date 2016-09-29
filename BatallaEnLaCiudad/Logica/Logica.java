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
	protected Tanque miJugador;
	private Tanque [] misEnemigos;
	
	/*Constructor*/
	
	public Logica(){
		mapa=new ComponenteGrafico[20][20];
		generacionDeMapaLogico();
		
		//Creacion del jugador 
		miJugador = new Jugador();
		ingresarJugador(1,1);
		
		
		//Creacin de los enemigos
		misEnemigos = new Enemigo [4];
		crearEnemigo(1,1);//(x,y): x=posicion en arreglo, y=tipo de enemigo
		
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
		int i=0;
		
	      while((cadena = b.readLine())!=null) {
	    	  
	      	 for(int j=0;j<cadena.length();j++){
	      		 
	      		char s = cadena.charAt(j);
	      		
	      		if(s=='A'){
	      			mapa[i][j]= new Agua(i,j);
	      		}else
	      		if(s=='L'){
	      			mapa[i][j]= new Ladrillo(j,i);
	      		}else
	      		if(s=='I'){
	      			mapa[i][j]= new Acero(j,i);
	      		}else
	      		if(s=='B'){
	      			mapa[i][j]= new Arbol(i,j);
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
	      	i++;
	      	}  
	    
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Mover al jugador
	public	void mover(int direccion){
		mover(miJugador,direccion);
	}

	//Mover para el jugador y los enemigos
	private void mover(Tanque j,int direccion)
	{
		
		int f= j.getY();
		int c = j.getX();
		
		switch (direccion) {
			case 1: if(c<(mapa[0].length-1)){
						if(mapa[f][c+1].movimientoPosible()){
							mapa[f][c+1]=mapa[f][c];
							mapa[f][c]= new PisoGrafico(f,c);
						}	
					}
						break;
			case 2: if(c>0){
						if(mapa[f][c-1].movimientoPosible()){
							mapa[f][c-1]=mapa[f][c];
							mapa[f][c]=new PisoGrafico(f,c);
						}
					}
					break;
			case 3: if(f>0){
						if(mapa[f-1][c].movimientoPosible()){
							mapa[f-1][c]=mapa[f][c];
							mapa[f][c]=new PisoGrafico(f,c);
						}
					}	
					break;
			case 4: if(f<(mapa.length-1)){
						if(mapa[f+1][c].movimientoPosible()){
							mapa[f+1][c]=mapa[f][c];
							mapa[f][c]=new PisoGrafico(f,c);
						}
					}
					break;
		}
		j.setX(c);
		j.setY(f);
		
	}
	
	//disparo del jugador
	public void disparar(Jugador j)
	{
		
	}
	
	//elimino la celda del mapa y le asigno el piso vacio.
	public void eliminar(ComponenteGrafico c){
		mapa[c.getX()][c.getY()]= new Piso(c.getX(),c.getY());
	}
	
	//ingreso jugador
	public void ingresarJugador(int x, int y)
	{
		mapa[x][y]=miJugador;
		miJugador.setFila(y);
		miJugador.setColumna(x);
	}
	
	//creo enemigo indicando la posicion en el arreglo y el tipo de enemigo
	public void crearEnemigo(int p,int t){
		switch (t){
			case 1: 
				misEnemigos[p]=new Basico();
				agregarEnemigo(misEnemigos[p]);
				break;
			case 2: 
				misEnemigos[p]=new Blindado();
				agregarEnemigo(misEnemigos[p]);
				break;
			case 3:
				misEnemigos[p]=new Rapido();
				agregarEnemigo(misEnemigos[p]);
				break;
		}
	}
	
	//agrego el enemigo creado al mapa
	private void agregarEnemigo(Tanque e){
		//genero x,y en los respawn
		int x=5,y=5;
		mapa[x][y]=e;
		e.setFila(y);
		e.setColumna(x);
	}
	
	//cambio de nivel al jugador
	public void nivel(int i){
		switch (i){
			case 1:
				eliminar(miJugador);
				ingresarJugador(miJugador.getX(), miJugador.getY());
				break;
		}
	}

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		return mapa[x][y];
	}
	
	//devuelvo tanque en la posicion p
	public Tanque getEnemigo(int p){
		return misEnemigos[p];
	}
	
	//devuelvo jugador
	public Tanque getJugador(){
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
