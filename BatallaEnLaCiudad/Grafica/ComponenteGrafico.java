package Grafica;

import javax.swing.JLabel;

public abstract class ComponenteGrafico extends JLabel {
	
	/*Variables*/
	
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int velocidad;
	protected int miX,miY;
	protected int direccion;
	protected int pixelX;
	protected int pixelY;

	protected int deQuienEs;
	
	protected int vida;
	protected int powerUpDeTanque;
	
	/*Constructores*/
	
	public	ComponenteGrafico(){}
	
	public ComponenteGrafico(int x, int y)
	{	
		super();
		velocidad = 0;
		miX = x;
		miY = y;
		//direccion = -1;
		
		//seteo el componente grafico en el lugar correspondiente
		pixelX=miX*ancho;
		pixelY=miY*alto;
		setBounds(pixelX ,pixelY , ancho, alto);
		setVisible(true);
		
	}
	
	/*Comandos*/
	
	//seteo la velocidad del componente grafico
	public void setVelocidad(int v)
	{
		velocidad = v;
	}
	
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
	
	//devuelvo la direccion para la que apunta el componente grafico
	public int getDireccion()
	{
		return direccion;
	}
	
	//devuelvo la velocidad del objeto
	public int getVelocidad()
	{
		return velocidad;
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
	public void setDireccion(int d){
		direccion=d;
	}
	
	//pregunnto si es posible mover a esta posicion
	public abstract boolean movimientoPosible();
	
	public abstract boolean movimientoPosibleDisparo();
	
	public abstract void recibirDisparo();
	
	public abstract void posicionImagen(int i);

	public abstract boolean mover();
	
	public abstract void colicion(int deQuienEs);
	
	
	public final int getVida(){
		return vida;
	}
	
	public final int deQuienEs(){
		return deQuienEs;
	}
	
	public boolean esArbol(){
		return false;
	}
}