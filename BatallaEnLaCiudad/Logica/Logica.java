package Logica;

import java.io.*;
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
	
	private int puntaje;
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
	
	/*Comandos*/
	
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
				      			//grafica.agregarGrafico(mapa[j][i]);
				      		//	grafica.setComponentZOrder(mapa[j][i], 1);
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

	/*Consultas*/
	
	//devuelvo el componente grafico en la posicion (x,y)
	public ComponenteGrafico getComponente(int x,int y){
		if (x<0)
			x=0;
		if(y<0)
			y=0;
		return mapa[y][x];
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
		
		grafica.repaint();
	}
	
	public void eliminarGrafico(ComponenteGrafico x){
		grafica.eliminarGrafico(x);
	}
	
	private ComponenteGrafico crearEnemigo(int x,int y){
		Enemigo enemigo = new Basico(x, y,1,this);
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
						miPowerUp = new Casco(localizarX,localizarY);
						break;
					}
			case 2: {
						miPowerUp = new Estrella(localizarX,localizarY);
						break;
					}
			case 3: {
						miPowerUp = new Granada(localizarX,localizarY);
						break;
					}
			case 4: {
						miPowerUp = new Pala(localizarX,localizarY);
						break;
					}
			case 5: {
						miPowerUp = new Timer(localizarX,localizarY);
						break;
					}
			case 6: {
						miPowerUp = new VidaTanque(localizarX,localizarY);
						break;
					}
			default:  { 
						miPowerUp = new Casco(localizarX,localizarY);
						break;
					  }
			}
		return miPowerUp;
	}
	
	public Movimiento getHilosEnemigos(){
		return hiloEnemigos;
	}
	
	private void finalizarJuego(){
		terminar();
		hiloEnemigos.stop();
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
    	}
    }
	
	//ingreso jugador
	private void ingresarJugador()
	{
		miJugador = new JugadorNivel4(1,1,this);
		miJugador.setDireccion(1);
		miJugador.setPosicionY(1);
		miJugador.setPosicionX(1);
		mapa[1][1]=miJugador;
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
				enemigosMatados = 0;
			}
			else
				if(muertesAcumuladas == 16)
					finalizarJuego();
	}
	
}
