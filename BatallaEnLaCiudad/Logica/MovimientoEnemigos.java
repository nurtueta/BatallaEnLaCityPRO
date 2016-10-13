package Logica;

import javax.swing.JFrame;

import Grafica.ComponenteGrafico;
import Grafica.GUI;
import TDALista.PositionList;

public class MovimientoEnemigos extends Movimiento{

	
	/*
	 * MEGA ALGORITMO MOVIMIENTO GUILLE
	 * do{
	direccion = rnd.nextInt(3)+1;
	}while(enemigo.movimientoPosible(direccion))
	cantidadAvance = rnd.nextInt(6)+1;
	
	//ENVIAR LO PROXIMO A LA COLA
	
	MOVER(DIRECCION,ENEMIGO);
	
	//FIN ENVIO A COLA
	
	
	wait(250*enemigo.factorVelocidad());
		
	 * 
	 * 
	 */
	public MovimientoEnemigos(GUI miGUI)
	{
		super(miGUI);
	}
	
	public void run()
	{
		PositionList<ComponenteGrafico> enemigos = grafica.getEnemigos();
		
		//Agregar un booleano que le pida a la logica un 'sigo en el juego' como corte del while
		
			boolean movio;
			try
			{
				while(!grafica.finDelJuego())
				{
							
							this.sleep(300);
							
							for(ComponenteGrafico enemigo: enemigos)
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
								movio=enemigo.mover();
								
								grafica.repaint();
								//System.out.println("<"+enemigo.getPosicionX()+" , "+enemigo.getPosicionY()+">");
								
							}
							
							//grafica.eliminarBalas();
							//grafica.eliminarEnemigos();
						
				}
						
			}catch(InterruptedException e){ e.printStackTrace();}
	}
	
	@Override
	public void posicionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inicio() {
		// TODO Auto-generated method stub
		this.start();
	}

}
