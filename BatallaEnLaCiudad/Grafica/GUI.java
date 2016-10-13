package Grafica;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Logica.*;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Lista;
import TDALista.Position;
import TDALista.PositionList;
import Tanque.Basico;
import Tanque.Enemigo;

public class GUI extends JFrame {
	
     private JPanel contentPane;
	 private Logica mapaLogica;
	 private ComponenteGrafico[][] M;
	 private Movimiento hiloBalas;
	 private Movimiento hiloEnemigos;
	 protected PositionList<ComponenteGrafico> listaDisparos;
	 protected PositionList<Position<ComponenteGrafico>> disparosEliminables;
	 protected PositionList<ComponenteGrafico> listaEnemigos;
	 
	    /**
	     * Launch the application.
	     */
	   
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    GUI frame = new GUI();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	 
	    /**
	     * Create the frame.
	     */
	    public GUI() {
	    	
	    	mapaLogica = new Logica();
	    	
	    	
	    	M=mapaLogica.getMapaLogico();
			
	    	
	        //seteo inicial
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setTitle("Battle City 2016");
	        this.setResizable(false);
	        
	        //setteo del panel contenedor
	        
	        setBounds(0,0,650,650);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        contentPane.setVisible(true);
	        setContentPane(contentPane);
	        this.setLayout(null);
	       
	        
	        generarPanel();
	        
	        
			
			
	        

			listaDisparos = new Lista<ComponenteGrafico>();
			disparosEliminables = new Lista<Position<ComponenteGrafico>>();
			listaEnemigos = new Lista<ComponenteGrafico> ();
			
			hiloBalas = new MovimientoBalas(this);
			hiloEnemigos = new MovimientoEnemigos(this);
			hiloBalas.start();
			hiloEnemigos.start();
	        setVisible(true);
	        
	        
	        
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
				

				public void keyReleased1(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyTyped1(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP : 
					 		mapaLogica.mover(3);
					 		contentPane.repaint();
					 		//generarPanel();			//Mover el Jugador hacia Arriba
					 		break;
						case KeyEvent.VK_DOWN :
							mapaLogica.mover(4);
							contentPane.repaint();
							//generarPanel();			//Mover el Jugador hacia Abajo
							break;
	        			case KeyEvent.VK_RIGHT :
	        				mapaLogica.mover(1);
	        				contentPane.repaint();
	        				//generarPanel();			//Mover el Jugador hacia la Derecha
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						mapaLogica.mover(2);
	 						contentPane.repaint();
	 						//generarPanel();			//Mover el Jugador hacia la Izquierda
	 						break;
	 					case KeyEvent.VK_Q :
	 						contentPane.remove(mapaLogica.getComponente(5,1));
	 						mapaLogica.eliminar(mapaLogica.getComponente(5, 1));
	 						contentPane.add(M[1][5]);	//Eliminar bloque en posicion
	 					
	 						break;
	 					case KeyEvent.VK_W :
	 						crearEnemigo();
	 						break;
	 					case KeyEvent.VK_E :
	 						
	 						contentPane.remove(mapaLogica.getComponente(0,0));
	 						mapaLogica.eliminar(mapaLogica.getComponente(0, 0));
	 						contentPane.add(M[0][0]);
	 						break;
	 					case KeyEvent.VK_SPACE:
	 						crearDisparo();
	 						break;
					 }
					 
					 // M=mapaLogica.getMapaLogico();
					 contentPane.repaint();
					 
				}

				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub	
				}
	        });	       	        
	    }
	    	
	    
	
		public void generarPanel(){
	    	//M=mapaLogica.getMapaLogico();
	    	//contentPane.removeAll();
			for(int i=0;i<20;i++)
			 	for(int j=0;j<20;j++){
			 		contentPane.add(mapaLogica.getComponente(i, j));
			 		//contentPane.setComponentZOrder(mapaLogica.getComponente(i, j), 0);
			 	}
			this.repaint();
	    }
	    
	    public void crearDisparo()
	    {
	    	ComponenteGrafico bala = new Disparo(mapaLogica.getJugador().getPosicionX(),mapaLogica.getJugador().getPosicionY(),listaDisparos,mapaLogica);
			bala.setVisible(true);
			listaDisparos.addLast(bala);
			try {
				disparosEliminables.addLast(listaDisparos.last());
			
			contentPane.add(bala);
			contentPane.setComponentZOrder(bala, 1);
			ComponenteGrafico ObjetoEnPosicionBala = M[bala.getPosicionY()][bala.getPosicionX()];
			if (!ObjetoEnPosicionBala.movimientoPosible())
				this.eliminarBala(listaDisparos.last());
			} catch (EmptyListException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    private void crearEnemigo() {
	    	ComponenteGrafico enemigo = new Basico(5,5,listaEnemigos,mapaLogica);
			enemigo.setVisible(true);
			
			contentPane.add(enemigo);
			contentPane.setComponentZOrder(enemigo, 1);
				
		}

	    
	    public PositionList<ComponenteGrafico> getBalas()
	    {
	    	return listaDisparos;
	    }
	    
	    public PositionList<ComponenteGrafico> getEnemigos()
	    {
	    	return listaEnemigos;
	    }
	    
	    public PositionList<Position<ComponenteGrafico>> getBalasEliminables()
	    {
	    	return disparosEliminables;
	    }
	    
	    public boolean finDelJuego()
	    {
	    	return mapaLogica.finDelJuego();
	    }
	    
	    public ComponenteGrafico buscarColision(Rectangle p){	
			
			Iterator<ComponenteGrafico> it = listaDisparos.iterator();
			ComponenteGrafico d=null;
			boolean seguir = true;
			
				while(it.hasNext() && seguir)
				{
					d=it.next();			
					if(p.intersects(d.getBounds())){
						seguir=false;
					}
				}
				
				if (!seguir){
					return d;
				}
				
				
			return null;
		}
	    
		public void eliminarBalas()
		{
			Iterator<Position<ComponenteGrafico>> it = disparosEliminables.iterator();
			try 
			{
				while( it.hasNext() ) 
				{
					Position<ComponenteGrafico> bala = it.next();
					listaDisparos.remove(bala);
				
				}
				
			}catch (InvalidPositionException e) {e.printStackTrace();}

			disparosEliminables = new Lista<Position<ComponenteGrafico>>();
			
		}
		
		public void eliminarBala(Position<ComponenteGrafico> x){
			Position<ComponenteGrafico> aux;
			contentPane.remove(x.element());

			try {

				listaDisparos.remove(x);
				System.out.println("elimino");
			} catch (InvalidPositionException | NullPointerException e) {e.printStackTrace();}

			
		}
}