package Logica;

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
	
	private Movimiento hiloEnemigos;
	private Movimiento hiloDisparoJugador;
	private Movimiento hiloDisparoEnemigo;
	private HiloPowerUps hiloPowerup;
	
	private int puntaje=0;
	private int enemigosMatados;
	private int muertesAcumuladas;
	private int enemigosEnTablero;
	
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
				      		}else
					      		if(s=='E'){
					      			mapa[j][i]= new Aguila(i,j);
					      		}/*else
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
		miJugador.mover(direccion);
	}
	
	//ingreso jugador
	private void ingresarJugador()
	{
		miJugador = new JugadorNivel4(5,17,this);
		miJugador.setDireccion(1);
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
	
	private ComponenteGrafico crearEnemigo(int x,int y){
		//Creo un valor aleatorio representativo del enemigo que deseo eliminar
				int tipoACrear = (int) new Random().nextInt(4)+1;
				
				Enemigo enemigo = new Basico(x,y,1,this);
				
					switch(tipoACrear){
					
						case 1: {
									enemigo = new Basico(x,y,1,this);
								 	break;
								}	
						case 2: {
									enemigo = new Blindado(x,y,1,this);
									break;
								}
						case 3: {
									enemigo = new Poder(x,y,1,this);
									break;
								}
						case 4: {
									enemigo = new Rapido(x,y,1,this);
									break;
								}
					
					}
				
				//Enemigo enemigo = new Basico(x, y,1,this);
		
		if(getComponente(x, y).movimientoPosible()){
			setComponente(x, y, enemigo);
			enemigo.setVisible(true);
			hiloEnemigos.addEnemigo(enemigo);
		}else
			enemigo=null;
		return enemigo;
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

		hiloEnemigos.stop();
		hiloDisparoEnemigo.stop();
		hiloDisparoJugador.stop();
		

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
						if(getComponente(x, y)==miJugador){
							System.out.println("termino eliminarColicion miJugador");
							this.finalizarJuego();
							}
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
	
	public void crearEnemigo() {
		ComponenteGrafico enemigo=crearEnemigo(3,3);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(17,3);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(8,7);
		if(enemigo!=null){
			grafica.agregarGrafico(enemigo);
		}
		enemigo=crearEnemigo(15,10);
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
			if(enemigosMatados == 4){
				PowerUp p = crearPowerUp();
				grafica.agregarGrafico(p);
				hiloPowerup = new HiloPowerUps(this,p);
				hiloPowerup.run();
				enemigosMatados = 0;
			}
			else
				if(muertesAcumuladas == 16){
					System.out.println("termino enemigoMurio");
					finalizarJuego();
				}
		
	}
	
	//POWERUPS
	
		public void ponerCasco(){
			/*Jugador j = (Jugador)this.getJugador();
			j.conCasco(true);
			HiloTimer h = new HiloTimer();
			h.start();
			j.conCasco(false);*/
		}
		
		//EfectoPowerUpEstrella
		public void subirNivel(){
			int nivelJugador = miJugador.getDeQuienEs();
			
			//Siempre que se pueda subir de nivel
			if(nivelJugador < 4){
				switch (nivelJugador){
					case 1: {
								grafica.eliminarGrafico(miJugador);
								miJugador = new JugadorNivel2(miJugador.getPosicionX(),miJugador.getPosicionY(),this);
								grafica.agregarGrafico(miJugador);
							}
					case 2: {
								grafica.eliminarGrafico(miJugador);
								miJugador = new JugadorNivel3(miJugador.getPosicionX(),miJugador.getPosicionY(),this);
								grafica.agregarGrafico(miJugador);
							}
					case 3: {
								grafica.eliminarGrafico(miJugador);
								miJugador = new JugadorNivel4(miJugador.getPosicionX(),miJugador.getPosicionY(),this);
								grafica.agregarGrafico(miJugador);
							}
				}
				nivelJugador++;
			}
		}
		
		public void bajarNivel(){
			grafica.eliminarGrafico(miJugador);
			miJugador = new JugadorNivel1(miJugador.getPosicionX(),miJugador.getPosicionY(),this);
			grafica.agregarGrafico(miJugador);
		}
		
		public void subirVida(){
			Jugador j = (Jugador)this.getJugador();
			j.aumentarVida();
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
