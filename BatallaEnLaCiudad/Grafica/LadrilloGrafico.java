package Grafica;

import javax.swing.ImageIcon;

public class LadrilloGrafico extends CeldaGrafica{

	public LadrilloGrafico(int x, int y) {
		super(x,y);
		
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/fondo.png")), 0);
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/ladrillo.png")), 1);
	}
	
	//Cuando se destruye se transforma en piso
	/*public void destruir()
	{
		this.setImagenActual(0);
	}*/

	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
