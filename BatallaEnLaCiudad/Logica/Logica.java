package Logica;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import Tanque.Enemigo;
import Tanque.Jugador;



public class Logica {
	
	//variables
	protected GameObject[][] mapa;
	protected Jugador miJugador;
	private Enemigo [] misEnemigos;
	
	//constructor
	public Logica(){
		mapa=new Celda[20][20];
		generacionDeMapaLogico();	
		
		//Creación del jugador
		miJugador = new Jugador();
		
		//Creación de los enemigos
		misEnemigos = new Enemigo [4];
		
	}
	
	//Commands
	public	GameObject[][] getMapaLogico(){
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
	      			mapa[i][j]= new Agua();
	      		}else
	      		if(s=='L'){
	      			mapa[i][j]= new Ladrillo();
	      		}else
	      		if(s=='I'){
	      			mapa[i][j]= new Acero();
	      		}else
	      		if(s=='B'){
	      			mapa[i][j]= new Arbol();
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
	      			mapa[i][j]= new Piso();
	      		}
	      		}
	      	i++;
	      	}  
	    
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	public void mover(Jugador j,int direccion)
	{
		/*
		int pF = j.getPosFila();
		int pC = j.getPosColumna();
		boolean movio=false;
		
		switch (direccion) {
			case 1: if(pC<(mapa[0].length-1)){
						if(mapa[pF][pC+1]==1){
							mapa[pF][pC+1]=22;
							movio=true;
						}						
						else 
							if(mapa[pF][pC+1]==4){
								mapa[pF][pC+1]=10;
								movio=true;
							}
						if(movio){
							if((mapa[pF][pC]<14) && (mapa[pF][pC]>9))
								mapa[pF][pC]=4;
							else
								mapa[pF][pC]=1;
							j.setPosColumna(pC+1);
						}else
							mapa[pF][pC]=22;
					}
					break;
			case 2: if(pC>0){
						if(mapa[pF][pC-1]==1){
							mapa[pF][pC-1]=23;
							movio=true;
						}
						else
							if(mapa[pF][pC-1]==4){
								mapa[pF][pC-1]=11;
								movio=true;
							}
						if(movio){
							if((mapa[pF][pC]<14) && (mapa[pF][pC]>9))
								mapa[pF][pC]=4;
							else
								mapa[pF][pC]=1;
							j.setPosColumna(pC-1);
						}else
							mapa[pF][pC]=23;
					}
					break;
			case 3: if(pF>0){
						if(mapa[pF-1][pC]==1){
							mapa[pF-1][pC]=24;
							movio=true;
						}
						else
							if(mapa[pF-1][pC]==4){
								mapa[pF-1][pC]=12;
								movio=true;
							}
						if(movio){
							if((mapa[pF][pC]<14) && (mapa[pF][pC]>9))
								mapa[pF][pC]=4;
							else
								mapa[pF][pC]=1;
							j.setPosFila(pF-1);
						}else
							mapa[pF][pC]=24;
					}
					break;
			case 4: if(pC<(mapa.length-1)){
						if(mapa[pF+1][pC]==1){
							mapa[pF+1][pC]=25;
							movio=true;
						}
						else
							if(mapa[pF+1][pC]==4){
								mapa[pF+1][pC]=13;
								movio=true;
							}
						if(movio){
							if((mapa[pF][pC]<14) && (mapa[pF][pC]>9))
								mapa[pF][pC]=4;
							else
								mapa[pF][pC]=1;
							j.setPosFila(pF+1);
						}else
							mapa[pF][pC]=25;
					}
					break;
		}
		*/
	}
	
	public void disparar(Jugador j)
	{
		
	}
	
	public void mostrarMapa()
	{
		for(int i=0; i<mapa.length;i++){
			for(int j=0;j<mapa[0].length;j++)
				System.out.print(mapa[i][j]+" ");
			System.out.println();
		}
	}

	public void ingresarJugador(int x, int y)
	{
		mapa[x][y]=miJugador;
		miJugador.setPos(x, y);
	}
	
	public Jugador getJugador()
	{
		return miJugador;
	}
	
}
