package Tanque;

import javax.swing.JLabel;

public abstract class Tanque extends JLabel {

	abstract int getVida();
	
	abstract void setVida(int v);
	
	abstract int getPosFila();
	
	abstract void setPosFila(int f);
	
	abstract int getPosColumna();
	
	abstract void setPosColumna(int c);
	
	abstract int getTipo();
}
