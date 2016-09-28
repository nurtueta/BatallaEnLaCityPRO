package Grafica;

import javax.swing.ImageIcon;

public class PisoGrafico extends CeldaGrafica{

	public PisoGrafico(int x, int y) {
		super(x, y);
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/fondo.png")), 0);	}

	}
	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}

}
