package Grafica.Tanque.Jugador;

public class Nivel1 extends Nivel{

	public Nivel1() {
		super(2, 1, -1, 1);
	}

	public Nivel mejorarNivel() {
		Nivel nuevo = new Nivel2();
		return nuevo;
	}

	@Override
	public Nivel bajarNivel() {
		return null;
	}

}
