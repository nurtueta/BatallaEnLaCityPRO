package Grafica.Tanque.Jugador;

public abstract class Nivel {
	protected int velMovimiento;
	protected int velDisparo;
	protected int disparosSimultaneos;
	protected int vida;
	
	//Constructor
	public Nivel(int vMov,int vDisparo,int dSimultaneos, int v){
		velMovimiento = vMov;
		velDisparo = vDisparo;
		disparosSimultaneos = dSimultaneos;
		vida = v;
	}
	
	//public abstract int getNivel();
	
	//Metodos representativos del handle del State
	
	public void bajarVida(){
		vida--;
	}
	
	public void aumentarVida(){
		vida++;
	}
	
	public int getVelocidadMov(){
		return velMovimiento;
	}
	
	public int getVelocidadDisparo(){
		return velDisparo;
	}
	
	public int getDisparosSimultaneos(){
		return disparosSimultaneos;
	}
	
	public int getVida(){
		return vida;
	}
	
	public abstract boolean rompeAcero();
	
	public abstract Nivel mejorarNivel();
	
}
