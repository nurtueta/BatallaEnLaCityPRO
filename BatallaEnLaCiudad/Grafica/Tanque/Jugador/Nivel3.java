package Grafica.Tanque.Jugador;

public class Nivel3 extends Nivel{

	public Nivel3() {
		super(2, 2, 2, 2);
	}

	@Override
	public Nivel mejorarNivel() {
		Nivel nuevo = new Nivel4();
		return nuevo;
	}

	/*
	public int getNivel(){
		return 3;
	}
	
	@Override
	public Nivel bajarNivel() {
		Nivel nuevo = new Nivel2();
		return nuevo;
	}
	*/

	@Override
	public boolean rompeAcero() {
		return false;
	}

}
