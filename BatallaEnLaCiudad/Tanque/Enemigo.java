package Tanque;

public abstract class Enemigo extends Tanque{
	
	
	/*Atributo de clase*/
	public static Enemigo []misEnemigos=new Enemigo[6];
	
	/*Constructor*/
	
	public	Enemigo(int x,int y){
		super(x,y);
	}
		
	/*Comandos*/
	/*
	//seteo la imagen en la posicion del tanque enemigo
	public abstract void posicionImagen(int i);
	
	//seteo la vida del tanque
	public abstract void setVida(int v);

	//seteo la posicion en Y
	public abstract void setFila(int f);

	//seteo la posicion en X
	public abstract void setColumna(int c);

	/*Consultas*/
	/*
	//devuelvo si puedo mover a la posicion del tanque
	abstract public boolean movimientoPosible();
	
	//devuelvo la posicion en X
	public abstract int getColumna();
	
	//devuelvo la posicion en Y
	public abstract int getFila();
	
	//devuelvo la vida del tanque
	public abstract int getVida();
	*/
}
