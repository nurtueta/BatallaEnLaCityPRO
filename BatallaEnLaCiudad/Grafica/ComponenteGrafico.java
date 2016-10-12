package Grafica;

import javax.swing.JLabel;

public abstract class ComponenteGrafico extends JLabel {
	
	/*Variables*/
	
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int velocidad;
	protected int miX,miY;
	protected int direccion;
	
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
	
	public ComponenteGrafico(int vel, int x, int y)
	{	
		super();
		velocidad = vel;
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
	
	//seteo la posicion en X
	public void setX(int x)
	{
		miX=x*ancho;
	}
	
	//seteo la posicion en Y
	public void setY(int y)
	{
		miY=y*alto;
		
	}
	
	public void setPosicionX(int x){
		miX=x;
		
	}

	public void setPosicionY(int y){
		miY=y;
	}
	/*Consultas*/

	//pregunnto si es posible mover a esta posicion
	public abstract boolean movimientoPosible();
	
	//devuelvo alto de la imagen
	public int getAlto()
	{
		return alto;
	}
	
	//devuelvo ancho de la imagen
	public int getAncho(){
		return ancho;
	}
	
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
	/**
	 * Destruye al componente que recibe el mensaje.
	 */
	public	abstract void	eliminar();
	
	public abstract void posicionImagen(int i);

	public abstract boolean mover();

	
}