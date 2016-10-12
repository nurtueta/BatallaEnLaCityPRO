package Logica;

import javax.swing.JFrame;

import Grafica.ComponenteGrafico;
import Grafica.GUI;
import TDALista.*;
import Tanque.*;

public class MovimientoBalas extends Movimiento{
		
	public MovimientoBalas(GUI miGUI)
	{
		super(miGUI);
	}
	
	public void run()
	{
		PositionList<ComponenteGrafico> balas = grafica.getBalas();
		
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		
			int posY;
			try
			{
				while(!grafica.finDelJuego())
				{
							
							this.sleep(500);
							
							for(ComponenteGrafico bala: balas)
							{
								/*
								ComponenteGrafico c = grafica.buscarColision(bala.getBounds());
									if (c!=null) 
										{ //colision con escenario + enemigo (ahora implemento solo escenario)
											//boolean murio=c.damage(bala);
											bala.setVisible(false);
											grafica.getBalasEliminables().addLast(bala.getPosEnLista());
										}
										
									else
									{
										posY = bala.getY()-8;
										bala.setLocation(bala.getX(), posY);
									}
									*/
								bala.mover();
								grafica.repaint();
								System.out.println("<"+bala.getPosicionX()+" , "+bala.getPosicionY()+">");
								
							}
							
							grafica.eliminarBalas();
							//grafica.eliminarEnemigos();
						
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}
	
	
	public void posicionar() 
	{
			
	}

	
	public void inicio() 
	{
		this.start();
	}

}
