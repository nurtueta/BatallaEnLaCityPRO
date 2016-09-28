package Grafica;

import javax.swing.ImageIcon;

public class AguaGrafica extends CeldaGrafica{

	public AguaGrafica(int x, int y) {
		super(x, y);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/agua.png")), 2);	}

	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
