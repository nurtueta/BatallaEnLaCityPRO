package Logica;

import java.io.*;

import javax.swing.ImageIcon;

import Grafica.*;
import Logica.Bloque.*;
import Tanque.Enemigo;
import Tanque.Jugador;



public class Logica {
	
	//variables
	protected ComponenteGrafico[][] mapa;
	protected Jugador miJugador;
	private Enemigo [] misEnemigos;
	
	//constructor
	public Logica(){
		mapa=new ComponenteGrafico[20][20];
		generacionDeMapaLogico();	
		
		//Creaci�n del jugador
		miJugador = new Jugador();
		
		//Creaci�n de los enemigos
		misEnemigos = new Enemigo [4];
		
	}
	
	//Commands
	public	ComponenteGrafico[][] getMapaLogico(){
		return mapa;
	}
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
	      			mapa[i][j]= new Agua(j,i);
	      		}else
	      		if(s=='L'){
	      			mapa[i][j]= new Ladrillo(i,j);
	      		}else
	      		if(s=='I'){
	      			mapa[i][j]= new Acero(i,j);
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
	      			mapa[i][j]= new Piso(i,j);
	      		}
	      		}
	      	i++;
	      	}  
	    
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public	void	mover(int direccion){
		mover(miJugador,direccion);
	}
	private void mover(Jugador j,int direccion)
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
	
	public void disparar(Jugador j)
	{
		
	}
	
	public void mostrarMapa()
	{
		for(int i=0; i<mapa.length;i++){
			for(int j=0;j<mapa[0].length;j++)
				System.out.print(mapa[i][j]+"  \n ");
			System.out.println();
		}
	}

	public void ingresarJugador(int x, int y)
	{
		mapa[x][y]=miJugador;
		miJugador.setFila(x);
		miJugador.setColumna(y);
	}
	
	public Jugador getJugador()
	{
		return miJugador;
	}
	
}
