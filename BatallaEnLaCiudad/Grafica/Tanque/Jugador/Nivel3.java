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

}
