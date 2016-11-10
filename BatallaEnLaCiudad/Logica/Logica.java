package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import Grafica.*;
import Logica.Bloque.*;
import PowerUp.*;
import Tanque.*;

public class Logica {
	
	/*Variables*/
	
	protected ComponenteGrafico[][] mapa;
	protected ComponenteGrafico miJugador;
	protected	static java.net.URL url = Disparo.class.getResource("/archivo/StarWarsBlasterSoundEffect.wav");
	protected static AudioClip clip = Applet.newAudioClip(url);
	private Movimiento hiloEnemigos;
	private Movimiento hiloDisparoJugador;
	private Movimiento hiloDisparoEnemigo;
	private Movimiento tiempoEsperaParaFinalizar;
	private HiloPowerUps hiloPowerup;
	
	private int puntaje=0;
	private int enemigosMatados;
	private int muertesAcumuladas;
	private int enemigosEnTablero;
	private int []respawn;
	private boolean termina;

	
	
	protected GUI grafica;
	
	/*Constructor*/
	
	public Logica(GUI laGUI){
		termina=false;
		
		hiloDisparoJugador=new MovimientoBalas(this);
		hiloDisparoJugador.start();
		hiloDisparoEnemigo=new MovimientoBalas(this);
		hiloDisparoEnemigo.start();
		hiloEnemigos = new MovimientoEnemigos(this);
		hiloEnemigos.start();
		
		
		puntaje=0;			 //cuando llega a 20000, sumar una vida
		enemigosMatados=0;   //cuando llega a 4 creo un powerUp y lo reseteo
		enemigosEnTablero=0; //deberia iniciar en 4 y no bajar de 2
		muertesAcumuladas=0; //al llegar a 16, fin del juego con victoria
		grafica=laGUI;
		
		//creo los respawn
		respawn=new int[8];
		respawn[0]=0;respawn[1]=0;respawn[2]=19;respawn[3]=16;respawn[4]=0;
		respawn[5]=6;respawn[6]=0;respawn[7]=16;
		
		puntaje=0;			 //cuando llega a 20000, sumar una vida
		enemigosMatados=0;   //cuando llega a 4 creo un powerUp y lo reseteo
		enemigosEnTablero=0; //deberia iniciar en 4 y no bajar de 2
		muertesAcumuladas=0; //al llegar a 16, fin del juego con victoria

				
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
			fi = new FileReader("archivo/Hello2.txt");
	        BufferedReader b = new BufferedReader(fi);
	        String cadena;
	        int j=0;
	        while((cadena = b.readLine())!=null) {
	        	for(int i=0;i<cadena.length();i++){
	        		char s = cadena.charAt(i);
	        		switch(s){
	        		case 'A':
	        			mapa[j][i]= new Agua(i,j);
	        			break;
	        		case 'L':
	        			mapa[j][i]= new Ladrillo(i,j);
	        			break;
	        		case 'I':
	        			mapa[j][i]= new Acero(i,j);
	        			break;
	        		case 'B':
		      			mapa[j][i]= new Arbol(i,j);
		      			break;
	        		case 'E':
		      			mapa[j][i]= new Aguila(i,j);
		      			break;
		      		default:
		      			mapa[j][i]= new Piso(i,j);
			      		break;
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
		miJugador.mover(direccion);
	}
	
	//ingreso jugador
	private void ingresarJugador()
	{
		miJugador = new Jugador(5,17,this);
		mapa[miJugador.getPosicionY()][miJugador.getPosicionX()]=miJugador;

	}

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		ComponenteGrafico aux;
		if (x<0 || x>19 || y<0 || y>19)
			aux=null;
		else
			aux=mapa[y][x];
		return aux;
	}
	
	public void setComponente(int x,int y,ComponenteGrafico p){
		mapa[y][x]=p;
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
		grafica.getPanelPuntaje().setText("Puntaje: "+puntaje);
		grafica.getPanelPuntaje().updateUI();
		grafica.repaint();
	}
	
	public void eliminarGrafico(ComponenteGrafico x){
		grafica.eliminarGrafico(x);
	}
	
	
	private PowerUp crearPowerUp(){
		//Busco entre 1 y 6 un tipo de powerup aleatorio siendo: 1)Casco; 2) Estrella; 3)Granada
		//4) Pala; 5) Timer; 6) VidaTanque.
		int tipo = (int) new Random().nextInt(6)+1;
		
		//Elijo variables de posicion en el mapa al azar.
		int localizarX = (int) new Random().nextInt(20);
		int localizarY = (int) new Random().nextInt(20);
		
		PowerUp miPowerUp;
		
			switch (tipo){
			case 1: {
						miPowerUp = new Casco(localizarX,localizarY,this);
						break;
					}
			case 2: {
						miPowerUp = new Estrella(localizarX,localizarY,this);
						break;
					}
			case 3: {
						miPowerUp = new Granada(localizarX,localizarY,this);
						break;
					}
			case 4: {
						miPowerUp = new Pala(localizarX,localizarY,this);
						break;
					}
			case 5: {
						miPowerUp = new Timer(localizarX,localizarY,this);
						break;
					}
			case 6: {
						miPowerUp = new VidaTanque(localizarX,localizarY,this);
						break;
					}
			default:  { 
						miPowerUp = new Casco(localizarX,localizarY,this);
						break;
					  }
			}
		return miPowerUp;
	}
	
	public Movimiento getHilosEnemigos(){
		return hiloEnemigos;
	}
	
	private void finalizarJuego(){
		System.out.println("termino");
		terminar();
		tiempoEsperaParaFinalizar=new HiloTiempoEspera(this);
		tiempoEsperaParaFinalizar.start();
		
	}

	public void finalizar(){
		grafica.eliminarGrafico(miJugador);
		grafica.terminarJuego();
	}

	
	private void terminar(){
		termina=true;
	}
	public void eliminarColicion(int x,int y,int deQuienEs){
		getComponente(x, y).colicion(deQuienEs);
		if(getComponente(x, y).getVida()==0){
			if(getComponente(x, y)==miJugador || ((x==9)&&(y==19))){
						if(getComponente(x, y)==miJugador)
							System.out.println("termino eliminarColicion miJugador");
						else
							System.out.println("termino eliminarColicion "+x+" "+y);
						finalizarJuego();
			}else{
				addPuntaje(getComponente(x, y).getPuntos());
				grafica.eliminarGrafico(getComponente(x, y));
				mapa[y][x]=new Piso(x,y);
				grafica.agregarGrafico(getComponente(x, y));
			}
		}
	}

	
	public	int obtenerPuntaje(){
		return puntaje;
	}
	
	public void crearDisparoJugador(){
		if(hiloDisparoJugador.getBalas().size()<miJugador.getDisparosSimultaneos()){
			ComponenteGrafico bala=miJugador.crearDisparo();
			clip.play();

			if(bala!=null){
	    		grafica.agregarGrafico(bala);
	    		grafica.repaint();
	    		hiloDisparoJugador.addBala(bala);
	    	}
		}
	}
	
	public void crearDisparo(ComponenteGrafico x){
    	ComponenteGrafico bala=x.crearDisparo();
    	if(bala!=null){
    		grafica.agregarGrafico(bala);
    		grafica.repaint();
    		hiloDisparoEnemigo.addBala(bala);
    	}
    }
	
	public void crearJugador(){
    	ingresarJugador();
        grafica.agregarGrafico(getJugador());
    }
	
	private ComponenteGrafico crearEnemigo(int x,int y){
		int tipoACrear = (int) new Random().nextInt(4)+1;
		Enemigo enemigo=null;
		switch(tipoACrear){
			case 1: 
				enemigo = new Basico(x,y,1,this);
			 	break;
			case 2: 
				enemigo = new Blindado(x,y,1,this);
				break;
			case 3: 
				enemigo = new Poder(x,y,1,this);
				break;
			case 4: 
				enemigo = new Rapido(x,y,1,this);
				break;
		}
		if(getComponente(x, y).movimientoPosible()){
			setComponente(x, y, enemigo);
			enemigo.setVisible(true);
			hiloEnemigos.addEnemigo(enemigo);
		}else
			enemigo=null;
		return enemigo;
	}

	public void crearEnenmigo(){
		int tipoACrear;
		boolean pudoCrear=true;
		while(pudoCrear){
			tipoACrear = (int) new Random().nextInt(3);
			ComponenteGrafico enemigo=crearEnemigo(respawn[tipoACrear],respawn[tipoACrear+4]);
			if(enemigo!=null){
				grafica.agregarGrafico(enemigo);
				pudoCrear=false;
			}
		}
	}

	public void crearEnemigoInicio(){
		ComponenteGrafico enemigo=crearEnemigo(respawn[0],respawn[4]);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(respawn[1],respawn[1+4]);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(respawn[2],respawn[2+4]);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(respawn[3],respawn[3+4]);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
	}

	
	public void generarPanel(){
		for(int i=0;i<20;i++)
		 	for(int j=0;j<20;j++){
		 		ComponenteGrafico comp = getComponente(i,j);
		 		grafica.agregarGrafico(comp);		 	
		 	}
	}	
	
	
	public void addPuntaje(int puntos){
		puntaje+=puntos;
		grafica.getPanelPuntaje().setText("Puntaje: "+puntaje);
		System.out.println(puntaje);
		grafica.repaint();
	}
	
	public void enemigoMurio(){
		enemigosMatados++;
		muertesAcumuladas++;
		if(muertesAcumuladas == 16){
			System.out.println("termino enemigoMurio");
			finalizarJuego();
		}else{
			if(enemigosMatados == 4){
				PowerUp p = crearPowerUp();
				grafica.agregarGrafico(p);
				enemigosMatados = 0;
				subirNivel();
			}
			crearEnenmigo();
		}
	}

	
	//POWERUPS
	
			public void ponerCasco(){
				miJugador.usaCasco(true);
			}
			
			//EfectoPowerUpEstrella
			public void subirNivel(){
				miJugador.subirNivel();
			}
			
			public void bajarNivel(){
				miJugador.bajarNivel();
			}
			
			public void subirVida(){
				miJugador.aumentarVida();
			}
			
			public void destruirTodosLosEnemigos(){
			}
			
			public void powerUpPala(){
				//Controlar Bloques alrededor del 'Aguila'
			}
			
			public void detenerEnemigos(){
				// Movimiento posible de todos = false
				//HiloTimer h = new HiloTimer();
				//h.start();
				// Movimiento posible de todos = true;
			}
			
			public void eliminarPowerUps(){
				hiloPowerup.stop();
			}
			
		

	
}
