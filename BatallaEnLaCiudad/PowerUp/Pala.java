package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Logica;

public class Pala extends PowerUp{

	public Pala(int x, int y,Logica l){
		super(x,y,3);
		logica=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpPala.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public void colicion(int deQuienEs) {
		// TODO Auto-generated method stub
		//Hace todas las paredes de la base(aguila) irrompibles
		//Repara todo el daño a las paredes de la base
	}
	
}
