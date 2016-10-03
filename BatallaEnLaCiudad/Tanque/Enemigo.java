package Tanque;

public abstract class Enemigo extends Tanque{
	
	
	/*Atributo de clase*/
	public static Enemigo []misEnemigos=new Enemigo[6];
	/*Constructor*/
	
	public	Enemigo(int x,int y){
		super(x,y);
	}
	public	boolean	crearEnemigo(){
		boolean hayEspacio=false;
		int i=0;
		while(!hayEspacio &&i<=5){
			if(misEnemigos[i]==null){
				misEnemigos[i]=this;
				hayEspacio=true;
				System.out.println(this);
			}
			System.out.println(i);
			i++;
		}
		return hayEspacio;
	}
	
	public	void	eliminar(){
		for(int i=0;i<6;i++)
			if(misEnemigos[i]==this)
				misEnemigos[i]=null;
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
