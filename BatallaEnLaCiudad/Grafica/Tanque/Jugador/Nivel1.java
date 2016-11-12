package Grafica.Tanque.Jugador;

public class Nivel1 extends Nivel{

	public Nivel1() {
		super(2, 1, 1, 1);
		
	}

	public Nivel mejorarNivel() {
		Nivel nuevo = new Nivel2();
		return nuevo;
		
	}

	public int getNivel(){
		return 1;
	}
	/*
	@Override
	public Nivel bajarNivel() {
		return null;
	}
	*/

}
