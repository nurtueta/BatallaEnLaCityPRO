package Grafica;

import javax.swing.ImageIcon;

public class AceroGrafico extends CeldaGrafica{

	public AceroGrafico(int x, int y) {
		super(x, y);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/acero.png")), 4);	}

}
