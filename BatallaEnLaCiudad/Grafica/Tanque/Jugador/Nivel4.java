package Grafica.Tanque.Jugador;

public class Nivel4 extends Nivel{

	public Nivel4() {
		super(2, 3, 3, 4);
	}

	@Override
	public Nivel mejorarNivel() {
		Nivel nuevo = new Nivel4();
		return nuevo;
	}

	/*
	@Override
	public Nivel bajarNivel() {
		Nivel nuevo = new Nivel3();
		return nuevo;
	}
	*/
	
}
