package Grafica;

import javax.swing.JLabel;

public abstract class ComponenteGrafico extends JLabel {
	
	/*Variables*/
	
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int miX,miY;

	protected int pixelX;
	protected int pixelY;
	protected int profundidad;
	protected int direccion;
	protected int puntaje;
	protected int vida;
	
	protected boolean movimientoPosible;
	protected boolean movimientoPosibleDisparo;
	
	
	/*Constructores*/
	
	public	ComponenteGrafico(){}
	
	public ComponenteGrafico(int x, int y)
	{	
		super();
		miX = x;
		miY = y;
		movimientoPosible=true;
		movimientoPosibleDisparo=true;
		
		//seteo el componente grafico en el lugar correspondiente
		pixelX=miX*ancho;
		pixelY=miY*alto;
		setBounds(pixelX ,pixelY , ancho, alto);
		setVisible(true);
	}
	
	/*Comandos*/
	
	public void setPosicionX(int x){
		miX=x;	
		pixelX=miX*ancho;
	}

	public void setPosicionY(int y){
		miY=y;
		pixelY=miY*alto;
	}
	
	public void setX(int x){
		pixelX=x;
	}
	
	public void setY(int y){
		pixelY=y;
	}
	
	/*Consultas*/
	
	public int getDireccion(){
		return direccion;
	}
	
	//devuelvo la posicion en X
	public int getX()
	{
		return pixelX;
	}
	
	public int getPosicionX(){
		return miX;
	}
	
	public int getPosicionY(){
		return miY;
	}
	
	public int getY()
	{
		return pixelY;
	}
	
	public void posicionImagen(int i){
		
	}

	public boolean mover(int direccion){
		return false;
	}
	
	public int getPuntos(){
		return puntaje;
	}
	
	public final int getVida(){
		return vida;
	}
	
	public final void aumentarVida(){
		vida++;
	}
	
	public abstract void colicion(int deQuienEs);
	
	//pregunnto si es posible mover a esta posicion
	public abstract boolean movimientoPosible();
	
	public abstract boolean movimientoPosibleDisparo();
	
	public void setPowerUpDeTanque(int pu){
		
	}
	
	public int getDeQuienEs(){
		return -1;		
	}
	
	public void setDireccion(int d){
		
	}
	public	int getDepth(){
		return profundidad;
	}
	public int getVelMovimiento(){
		return 0;
	}
	
	public ComponenteGrafico crearDisparo(){
		return null;
	}
	
	public int getDisparosSimultaneos(){
		return 0;
	}
	
	public void setPuedeMover(){
		movimientoPosible=true;
		movimientoPosibleDisparo=true;
	}
	
	public void setMovimientoPosible(){
		movimientoPosible=false;
		movimientoPosibleDisparo=false;
	}
	
	public void subirNivel(){}
	
	public void bajarNivel(){}
	
	public int getState(){
		return 0;
	}
	public void setState(int i){}
	
	public abstract ComponenteGrafico mejorar();
	
	public void usaCasco(boolean x){}
}