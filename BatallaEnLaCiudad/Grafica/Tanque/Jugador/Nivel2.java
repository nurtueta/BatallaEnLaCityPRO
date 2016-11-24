package Grafica.Tanque.Jugador;

public class Nivel2 extends Nivel{

	public Nivel2() {
		super(3, 2, 1, 1);
	}

	@Override
	public Nivel mejorarNivel() {
		Nivel nuevo = new Nivel3();
		return nuevo;
	}

	/*
	public int getNivel(){
		return 2;
	}
	
	@Override
	public Nivel bajarNivel() {
		Nivel nuevo = new Nivel1();
		return nuevo;
	}
	*/

	@Override
	public boolean rompeAcero() {
		return false;
	}

}
