package PowerUp;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VidaTanque extends PowerUp{

	public VidaTanque(int x, int y){
		super(x,y,5);
//		this.deQuienEs=9; //9 indica que es un powerup
		//manejo=l;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/PowerUpTanque.png"));

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	@Override
	public void colicion(int deQuienEs) {
		// TODO Auto-generated method stub
		//Agrega una vida al tanque del jugador (+50 de vida)
	}
	
}
