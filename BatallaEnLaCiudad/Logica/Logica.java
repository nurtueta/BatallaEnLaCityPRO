package Logica;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import Tanque.Jugador;



public class Logica {
	//
	//variables
	protected int[][] mapa;
	
	//constructor
	public Logica(){
		mapa=new int[20][20];
		generacionDeMapaLogico();	
	}
	//Commands
	public	int[][] getMapaLogico(){
		return mapa;
	}
	public void generacionDeMapaLogico(){

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
	      			mapa[i][j]= 5;
	      		}else
	      		if(s=='L'){
	      			mapa[i][j]= 2;
	      		}else
	      		if(s=='I'){
	      			mapa[i][j]= 3;
	      		}else
	      		if(s=='B'){
	      			mapa[i][j]= 4;
	      		}else
	      		if(s=='E'){
	      			mapa[i][j]= 26;
	      		}else
	      		if(s=='P'){
	      			mapa[i][j]= 28;
	      		}else
	      		if(s=='R'){
	      			mapa[i][j]= 27;
	      		}
	      		else{
	      			mapa[i][j]= 1;
	      		}
	      		}
	      	i++;
	      	}  
	    
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
			
	public void mover(Jugador j,int direccion){
		
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
	}
	
	public void disparar(Jugador j){
		
	}
	
	public void mostrarMapa(){
		for(int i=0; i<mapa.length;i++){
			for(int j=0;j<mapa[0].length;j++)
				System.out.print(mapa[i][j]+" ");
			System.out.println();
		}
	}

	public void ingresarJugador(Jugador j){
		mapa[j.getPosFila()][j.getPosColumna()]=22;
	}
	
	
}
