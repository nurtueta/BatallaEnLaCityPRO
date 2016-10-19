package Grafica;

import javax.swing.JLabel;

public abstract class ComponenteGrafico extends JLabel {
	
	/*Variables*/
	
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int velocidad;
	protected int miX,miY;
	protected int direccion;
	
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
		direccion = -1;
		
		//seteo el componente grafico en el lugar correspondiente
		setBounds(miX*ancho , miY*alto, ancho, alto);
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
	}

	public void setPosicionY(int y){
		miY=y;
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
		return miX*ancho;
	}
	
	public int getPosicionX(){
		return miX;
	}
	
	public int getPosicionY(){
		return miY;
	}
	
	public int getY()
	{
		return miY*alto;
	}
	
	public	int obtenerDireccion(){
		return direccion;
	}
	public	void	setDireccion(int direccion){
		this.direccion=direccion;
	}
	
	//pregunnto si es posible mover a esta posicion
	public abstract boolean movimientoPosible();
	
	public abstract boolean movimientoPosibleDisparo();
	
	public abstract void recibirDisparo();
	
	public abstract void posicionImagen(int i);

	public abstract boolean mover();
	
	public abstract void colicion();

	
}