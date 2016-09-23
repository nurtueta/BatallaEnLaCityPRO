package Grafica;

import javax.swing.ImageIcon;

public class ArbolesGraficos extends CeldaGrafica{

	public ArbolesGraficos(int x, int y) {
		super(x, y);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/arboles.png")), 3);	}

}
