package Grafica;

import javax.swing.Icon;
import javax.swing.JLabel;


public abstract class ComponenteGrafico extends JLabel {

	
	protected JLabel imagenActual;
	protected Icon misImagenes[];
	protected final int alto  = 30;
	protected final int ancho = 30;
	protected int velocidad;
	protected int miX,miY;
	
	//CONSTRUCTORES
	public	ComponenteGrafico(){}
	public ComponenteGrafico(int x, int y)
	{	
		imagenActual = null;
		velocidad = 0;
		miX = x;
		miY = y;
		this.setBounds(miX*alto , miY*ancho, ancho, alto);
	}
	
	public ComponenteGrafico(int vel, int x, int y)
	{	
		
		//Asignacion de imagen actual por defecto a la imagen del piso
		//this.setImagenActual(0);
		
		velocidad = vel;
		miX = x;
		miY = y;
		this.setBounds(miX*alto , miY*ancho, ancho, alto);
	}
	
	//METODOS
	
		//COMANDOS
		public void setImagenActual(int i)
		{
			imagenActual.setIcon(misImagenes[i]);
		}
		
		public void setImagenEnPos(Icon img, int i)
		{
			misImagenes[i] = img;
		}
	
		public void setVelocidad(int v)
		{
			velocidad = v;
		}
		
		public void setMiX(int x)
		{
			miX=x;
			this.setBounds(miX*alto , miY*ancho, ancho, alto);
		}
		
		public void setMiY(int y)
		{
			miY=y;
			this.setBounds(miX*alto , miY*ancho, ancho, alto);
		}
	
		//CONSULTAS
		

		public abstract boolean movimientoPosible();
		
		public JLabel getImagenActual()
		{
			return imagenActual;
		}
		
		public Icon getImagenPos(int i)
		{
			return misImagenes[i];
		}
		
		public int getAlto()
		{
			return alto;
		}
		
		public int getAncho(){
			return ancho;
		}
		
		public int getVelocidad()
		{
			return velocidad;
		}
		
		public int getMiX()
		{
			return miX;
		}
		
		public int getMiY()
		{
			return miY;
		}
		
	
}
