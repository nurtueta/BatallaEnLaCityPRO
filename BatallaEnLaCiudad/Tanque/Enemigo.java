package Tanque;

public class Enemigo extends Tanque{
	
	public	Enemigo(){
		super();
	}

	@Override
	int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void setVida(int v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int getFila() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void setFila(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int getColumna() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void setColumna(int c) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean movimientoPosible() {
		return false;
	}

}
