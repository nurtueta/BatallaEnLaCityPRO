package Grafica;

import javax.swing.JLabel;

public abstract class ComponenteGrafico extends JLabel {
	
	/*Variables*/
	
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int velocidad;
	protected int miX,miY;
	
	/*Constructores*/
	
	public	ComponenteGrafico(){}
	
	public ComponenteGrafico(int x, int y)
	{	
		super();
		velocidad = 0;
		miX = x;
		miY = y;
		
		//seteo el componente grafico en el lugar correspondiente
		setBounds(miX*alto , miY*ancho, ancho, alto);
		setVisible(true);
		
	}
	
	public ComponenteGrafico(int vel, int x, int y)
	{	
		super();
		velocidad = vel;
		miX = x;
		miY = y;
		
		//seteo el componente grafico en el lugar correspondiente
		setBounds(miX*alto , miY*ancho, ancho, alto);
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
		miX=x;
		this.setBounds(miX*alto , miY*ancho, ancho, alto);
	}
	
	//seteo la posicion en Y
	public void setY(int y)
	{
		miY=y;
		this.setBounds(miX*alto , miY*ancho, ancho, alto);
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
	
	//devuelvo la velocidad del objeto
	public int getVelocidad()
	{
		return velocidad;
	}
	
	//devuelvo la posicion en X
	public int getX()
	{
		return miX;
	}
	
	//devuelvo la posicion en Y
	public int getY()
	{
		return miY;
	}
	
	
		
	
}
