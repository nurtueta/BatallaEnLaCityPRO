package Tanque;

public abstract class Enemigo extends Tanque{
	
	/*Constructor*/
	public	Enemigo(int x,int y){
		super(x,y);
		disparosSimultaneos=1;
	}
	
	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
}
