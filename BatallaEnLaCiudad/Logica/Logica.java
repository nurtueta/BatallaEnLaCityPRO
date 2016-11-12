package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.util.Random;

import Grafica.*;
import Grafica.Bloque.*;
import Grafica.PowerUp.*;
import Grafica.Tanque.*;
import Grafica.Tanque.Enemigo.*;
import Grafica.Tanque.Jugador.*;
import Logica.Hilo.*;
import Logica.Hilo.Movimiento.*;
import Logica.Hilo.PowerUp.*;

public class Logica {
	
	/*Variables*/
	
	protected ComponenteGrafico[][] mapa;
	protected ComponenteGrafico miJugador;
	protected	static java.net.URL url = Disparo.class.getResource("/archivo/StarWarsBlasterSoundEffect.wav");
	protected static AudioClip clip = Applet.newAudioClip(url);
	private Movimiento hiloEnemigos;
	private Movimiento hiloDisparoJugador;
	private Movimiento hiloDisparoEnemigo;
	private HiloTiempoEspera tiempoEsperaParaFinalizar;
	private HiloPowerUp hiloMantenerPowerUp;
	private HiloPowerUp powerUpPala;
	private HiloPowerUp powerUpCasco;
	private HiloPowerUp powerUpTimer;
	private HiloPowerUp powerUpGranada;
	
	private int puntaje=0;
	private int enemigosMatados=0;
	private int muertesAcumuladas;
	private int []respawn;
	private boolean termina;
	private boolean porQueTermina;
	private boolean detenerTanque;
	private boolean eliminarEnemigos;

	
	
	protected GUI grafica;
	
	/*--------------------------------Constructor---------------------------------*/
	
	public Logica(GUI laGUI){
		termina=false;
		
		hiloDisparoJugador=new MovimientoBalas(this); //maneja los disparos del jugador
		hiloDisparoJugador.start();
		
		hiloDisparoEnemigo=new MovimientoBalas(this); //maneja los disparos de todos los enemigos
		hiloDisparoEnemigo.start();
		
		hiloEnemigos = new MovimientoEnemigos(this); //maneja a los enemigos
		hiloEnemigos.start();
		
		puntaje=0;			 //cuando llega a 20000, sumar una vida
		enemigosMatados=0;   //cuando llega a 4 creo un powerUp y lo reseteo
		muertesAcumuladas=0; //al llegar a 16, fin del juego con victoria
		
		grafica=laGUI;
		
		//creo los respawn
		respawn=new int[8];
		respawn[0]=1;respawn[1]=1;respawn[2]=19;respawn[3]=16;respawn[4]=1;
		respawn[5]=6;respawn[6]=1;respawn[7]=16;
		
		detenerTanque=false;
		eliminarEnemigos=false;
		
		mapa=new ComponenteGrafico[20][20];
		//creo el mapa
		generacionDeMapaLogico();
	}
	
	
	/* ---------------------------------Mapa----------------------------------*/
	
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
	public void generacionDeMapaLogico(){
	  	FileReader fi;
		try {
			fi = new FileReader("archivo/Mapa.txt");
	        BufferedReader b = new BufferedReader(fi);
	        String cadena;
	        int j=0;
	        while((cadena = b.readLine())!=null) {
	        	for(int i=0;i<cadena.length();i++){
	        		char s = cadena.charAt(i);
	        		switch(s){
	        		case 'A':
	        			mapa[j][i]= new Agua(i,j,this);
	        			break;
	        		case 'L':
	        			mapa[j][i]= new Ladrillo(i,j,this);
	        			break;
	        		case 'I':
	        			mapa[j][i]= new Acero(i,j,this);
	        			break;
	        		case 'B':
		      			mapa[j][i]= new Arbol(i,j,this);
		      			break;
	        		case 'E':
		      			mapa[j][i]= new Aguila(i,j,this);
		      			break;
		      		default:
		      			mapa[j][i]= new Piso(i,j,this);
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
	
	/**
	 * Obtengo el componente en las coordenadas (x,y)
	 * @param x coordenada en el eje x
	 * @param y coordenada en el eje y
	 * @return Componente en la posicion indicada
	 */
	public ComponenteGrafico getComponente(int x,int y){
		ComponenteGrafico aux;
		if (x<0 || x>19 || y<0 || y>19)
			aux=null;
		else
			aux=mapa[y][x];
		return aux;
	}
			
	/**
	 * Ingresa un componente en las coordeandas (x,y)
	 * @param x coordenada en el eje x
	 * @param y coordenada en el eje y
	 * @param p componente a ingresar
	 */
	public void setComponente(ComponenteGrafico c){
		int x=c.getPosicionX();
		int y=c.getPosicionY();
		mapa[y][x]=c;
	}
	
	/**
	 * Actualiza el panel del puntaje
	 */
	public void actualizarPanel(){
		grafica.getPanelPuntaje().setText("Puntaje: "+puntaje);
		grafica.getPanelPuntaje().updateUI();
		repintarPanel();
	}
	
	/**
	 * Actualizo el panel
	 */
	private void repintarPanel(){
		grafica.repaint();
	}
	
	/**
	 * Elimina el componente de la grafica
	 * @param x Componente a eliminar
	 */
	public void eliminarGrafico(ComponenteGrafico x){
		grafica.eliminarGrafico(x);
	}
	
	/**
	 * Agrega el componente a la grafica
	 * @param x Componente a agregar
	 */
	public void agregarGrafico(ComponenteGrafico x){
		grafica.agregarGrafico(x);
	}

	/**
	 * Indica si termino el juego para frenar los hilos
	 * @return True si termino el juego, False en caso contrario
	 */
	public boolean finDelJuego()
	{
		return termina;
	}
	
	/**
	 * Indica que termino el juego y espera medio segundo para que se eliminen 
	 * todos los disparos y enemigos para finalizar todo.
	 * @param x indica si se gano (true) o perdio (false)
	 */
	public void finalizarJuego(boolean x){
		termina=true;
		porQueTermina=x;
		tiempoEsperaParaFinalizar=new HiloTiempoEspera(this);
		tiempoEsperaParaFinalizar.start();
	}
	
	/**
	 * Con todos los enemigos y disparos eliminados, muestro la pantalla de 
	 * fin de juego
	 */
	public void finalizar(){
		grafica.terminarJuego(porQueTermina);
	}
	
	/**
	 * Elimino el componente en las coordenadas (x,y) que fue colicionado, si es el
	 * jugador o el aguila, el eliminado, finalizo el juego.
	 * @param x coordenada x
	 * @param y coordenada y
	 * @param deQuienEs indica si disparo enemigo (0) o jugador (1)
	 */
	public void eliminarColicion(int x,int y,int deQuienEs){
		getComponente(x, y).colicion(deQuienEs);
		if(getComponente(x, y).getVida()==0){
			addPuntaje(getComponente(x, y).getPuntos());
			eliminarGrafico(getComponente(x, y));
			mapa[y][x]=new Piso(x,y,this);
			agregarGrafico(getComponente(x, y));
		}
	}
	
	/**
	 * Indica el puntaje total en el juego
	 * @return Puntaje total
	 */
	public	int obtenerPuntaje(){
		return puntaje;
	}
	
	/**
	 * Ingresa los componentes del mapa en la parte grafica
	 */
	public void generarPanel(){
		for(int i=0;i<20;i++)
		 	for(int j=0;j<20;j++)
		 		agregarGrafico(getComponente(i,j));		 	
	}	
	
	/**
	 * Aumenta el puntaje del jugador
	 * @param puntos puntos a aumentar
	 */
	public void addPuntaje(int puntos){
		puntaje+=puntos;
		grafica.getPanelPuntaje().setText("Puntaje: /n"+puntaje);
		grafica.getPanelRestantes().setText("Restan "+ (16-muertesAcumuladas)+" naves");
		repintarPanel();
	}
	
	/*--------------------------------Jugador---------------------------------- */
	
	/**
	 * @return Jugador
	 */
	public ComponenteGrafico getJugador(){
		return miJugador;
	}
	
	/**
	 * Mueve al jugador en la direccion inducada
	 * @param direccion a la que se desea mover
	 */
	public void mover(int direccion){
		miJugador.mover(direccion);
	}
	
	/**
	 * Creo al jugador y lo ingreso al mapa logico
	 */
	private void ingresarJugador(){
		miJugador = new Jugador(5,17,this);
		mapa[miJugador.getPosicionY()][miJugador.getPosicionX()]=miJugador;
	}
	
	/**
	 * Creo al jugador al iniciar el juego
	 */
	public void crearJugador(){
    	ingresarJugador();
        agregarGrafico(getJugador());
    }
	
	/**
	 * Creo el disparo del jugador
	 */
	public void crearDisparoJugador(){
		if(hiloDisparoJugador.getBalas().size()<miJugador.getDisparosSimultaneos()){
			//if(miJugador.getPuedeMover()){
				ComponenteGrafico bala=miJugador.crearDisparo();
				clip.play();
				if(bala!=null){
		    		agregarGrafico(bala);
		    		repintarPanel();
		    		hiloDisparoJugador.addBala(bala);
				}
			//}
		}
	}
	
	public void setCasco(boolean x){
		miJugador.usaCasco(x);
	}
	
	/* ---------------------------------Enemigo----------------------------------*/
	
	/**
	 * @return Hilo que contiene a los enemigos
	 */
	public Movimiento getHilosEnemigos(){
		return hiloEnemigos;
	}
	
	/**
	 * Creo el disparo a partir del enemigo que disparo
	 * @param x enemigo que disparo
	 */
	public void crearDisparoEnemigo(ComponenteGrafico x){
    	ComponenteGrafico bala=x.crearDisparo();
    	if(bala!=null){
    		agregarGrafico(bala);
    		repintarPanel();
    		hiloDisparoEnemigo.addBala(bala);
    	}
    }
	
	/**
	 * Creo un enemigo random en las coordenadas (x,y)
	 * @param x coordenada x
	 * @param y coordenada y
	 * @return enemigo creado
	 */
	private ComponenteGrafico crearEnemigoRandom(int x,int y){
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
			setComponente(enemigo);
			enemigo.setVisible(true);
			hiloEnemigos.addEnemigo(enemigo);
		}else
			enemigo=null;
		return enemigo;
	}

	/**
	 * Crea un enemigo random y lo ingresa en alguno de los respawn
	 */
	public void crearEnemigo(){
		int tipoACrear;
		boolean pudoCrear=false;
		while(!pudoCrear){
			tipoACrear = (int) new Random().nextInt(4);
			ComponenteGrafico enemigo=crearEnemigoRandom(respawn[tipoACrear],respawn[tipoACrear+4]);
			if(enemigo!=null){
				agregarGrafico(enemigo);
				pudoCrear=true;
			}
		}
	}

	/**
	 * Creo 4 enemigos random apenas inicia el juego, 
	 * cada uno en su respectivo respawn
	 */
	public void crearEnemigoInicio(){
		ComponenteGrafico enemigo=crearEnemigoRandom(respawn[0],respawn[4]);
		if(enemigo!=null){
			agregarGrafico(enemigo);
		}
		enemigo=crearEnemigoRandom(respawn[1],respawn[1+4]);
		if(enemigo!=null){
			agregarGrafico(enemigo);
		}
		enemigo=crearEnemigoRandom(respawn[2],respawn[2+4]);
		if(enemigo!=null){
			agregarGrafico(enemigo);
		}
		enemigo=crearEnemigoRandom(respawn[3],respawn[3+4]);
		if(enemigo!=null){
			agregarGrafico(enemigo);
		}
	}
	
	/**
	 * Si se murio un jugador y es el 4 seguido, entonces creo un PowerUp; 
	 * si es el numero 16 eliminado, entonces gane el juego.
	 * Si no termino el juego entonces creo un enemigo para mantener 4 enemigos 
	 * siempre
	 */
	public void enemigoMurio(){
		enemigosMatados++;
		muertesAcumuladas++;
		if(muertesAcumuladas == 16)
			finalizarJuego(true);
		else{
			if(enemigosMatados == 4){
				crearPowerUp();
				enemigosMatados = 0;
			}
			crearEnemigo();
		}
	}

	/* ---------------------------------PowerUp----------------------------------*/
	
	/**
	 * Creo un PowerUp random y lo agrego al mapa
	 * @return PowerUp creado
	 */
	private ComponenteGrafico obtenerPowerUp(){
		int tipo = 3;//(int) new Random().nextInt(6)+1;
		boolean espacioVacio=false;
		int localizarX=0;
		int localizarY=0;
		while(!espacioVacio){
			localizarX = (int) new Random().nextInt(20);
			localizarY = (int) new Random().nextInt(20);
			if(getComponente(localizarX, localizarY).puedoIngresarPowerUp())
				espacioVacio=true;
		}
		
		PowerUp miPowerUp=null;;
		switch (tipo){
		case 1: 
			miPowerUp = new Casco(localizarX,localizarY,this);
			break;
		case 2: 
			miPowerUp = new Estrella(localizarX,localizarY,this);
			break;
		case 3: 
			miPowerUp = new Granada(localizarX,localizarY,this);
			break;
		case 4: 
			miPowerUp = new Pala(localizarX,localizarY,this);
			break;
		case 5: 
			miPowerUp = new Timer(localizarX,localizarY,this);
			break;
		case 6: 
			miPowerUp = new VidaTanque(localizarX,localizarY,this);
			break;
		}
		
		setComponente(miPowerUp);
		miPowerUp.setVisible(true);
		agregarGrafico(miPowerUp);
		return miPowerUp;
	}
	
	/**
	 * Creo un PowerUp, si no se agarra por 5 segundos desaparece;
	 * si se agarra entonces se ejecuta
	 */
	public void crearPowerUp(){
		ComponenteGrafico p=obtenerPowerUp();
		hiloMantenerPowerUp=new HiloMantenerPowerUp(this,p);
		hiloMantenerPowerUp.start();
	}
	
	/**
	 * Elimina el PowerUp en caso de no haberse agarrado.
	 */
	public void eliminarPowerUp(ComponenteGrafico p){
		int x=p.getPosicionX();
		int y=p.getPosicionY();
		eliminarGrafico(getComponente(x, y));
		mapa[y][x]=new Piso(x, y,this);
		agregarGrafico(getComponente(x, y));
	}
	
	/**
	 * Elimina a todos los enemigos
	 */
	public void powerUpGranada(){
		eliminarEnemigos=true;
		powerUpGranada=new HiloPowerUpGranada(this);
		powerUpGranada.start();
	}
	
	public boolean eliminarTodosLosEnemigos(){
		return eliminarEnemigos;
	}
	
	public void terminarPowerUpGranada(){
		eliminarEnemigos=false;
		hiloEnemigos = new MovimientoEnemigos(this);
		hiloEnemigos.start();
		muertesAcumuladas+=4;
		crearEnemigoInicio();
		
	}
	
	/**
	 * El jugador se hace invulnerable por 5 segundos
	 */
	public void powerUpCasco(){
		setCasco(true);
		powerUpCasco=new HiloPowerUpCasco(this);
		powerUpCasco.start();
	}
	
	/**
	 * Cambian las paredes de la base por acero por 20 segundos,
	 * pasados los 20 segundos se vuelven a poner paredes comunes al 100%.
	 */
	public void powerUpPala(){
		ComponenteGrafico [] base = getBase();
		for(ComponenteGrafico c : base){
			if(c.mejorar()){
				eliminarGrafico(c);
				setComponente(new Acero(c.getPosicionX(), c.getPosicionY(),this));
				agregarGrafico(getComponente(c.getPosicionX(), c.getPosicionY()));
			}
		}
		powerUpPala=new HiloPala(this);
		powerUpPala.start();
	}
	
	/**
	 * Obtengo y devuelvo en un arreglo las 5 componentes que rodean al aguila para reparaciones o mejoras.
	 * @return ComponenteGrafico []
	 */
	public ComponenteGrafico [] getBase(){
		ComponenteGrafico [] base = new ComponenteGrafico [5];
		base[0] = getComponente(8,19);
		base[1] = getComponente(8,18);
		base[2] = getComponente(9,18);
		base[3] = getComponente(10,18);
		base[4] = getComponente(10,19);
		
		return base;
	}
	
	/**
	 * Aumenta el nivel del Jugador
	 */
	public void powerUpEstrella(){
		miJugador.subirNivel();
	}
	
	/**
	 * Aumenta una vida al Jugador
	 */
	public void powerUpTanque(){
		miJugador.aumentarVida();
	}
	
	/**
	 * Detiene a todos los enemigos por 5 segundos
	 */
	public void powerUpTimer(){
		setDetenerTanque(true);
		powerUpTimer=new HiloDetenerEnemigos(this);
		powerUpTimer.start();
	}
	
	public void setDetenerTanque(boolean x){
		detenerTanque=x;
	}
	
	public boolean getDetenerTanque(){
		return detenerTanque;
	}
	
	
}
