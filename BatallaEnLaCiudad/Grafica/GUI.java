package Grafica;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Logica.*;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	 private Logica mapaLogica;
	 
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
	    	
	    	mapaLogica = new Logica(this);
	    	
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
	        crearJugador();
	        
	        setVisible(true);
	        
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
				
				public void keyReleased1(KeyEvent arg0) {
					
				}

				public void keyTyped1(KeyEvent arg0) {
					
				}

				public void keyPressed(KeyEvent e) {
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP : 
					 		mapaLogica.mover(3);		//Mover el Jugador hacia Arriba
					 		contentPane.repaint();	
					 		break;
						case KeyEvent.VK_DOWN :
							mapaLogica.mover(4);		//Mover el Jugador hacia Abajo
							contentPane.repaint();	
							break;
	        			case KeyEvent.VK_RIGHT :
	        				mapaLogica.mover(1);		//Mover el Jugador hacia la Derecha
	        				contentPane.repaint();		
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						mapaLogica.mover(2);		//Mover el Jugador hacia la Izquierda
	 						contentPane.repaint();	
	 						break;
	 					case KeyEvent.VK_Q :
	 						
	 						break;
	 					case KeyEvent.VK_W :
	 						crearEnemigo();
	 						break;
	 					case KeyEvent.VK_E :
	 						
	 						break;
	 					case KeyEvent.VK_SPACE:
	 						crearDisparo();
	 						break;
					 }
					 contentPane.repaint();
				}

				public void keyReleased(KeyEvent arg0){
					
				}

				public void keyTyped(KeyEvent arg0){
				}
	        });	       	        
	    }
	    
	    public void refrescarPanel(){
	    	this.repaint();
	    }
	    	
		public void generarPanel(){
			for(int i=0;i<20;i++)
			 	for(int j=0;j<20;j++)
			 		contentPane.add(mapaLogica.getComponente(i, j));
			this.repaint();
	    }
	    
<<<<<<< HEAD
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
=======
	    public void crearDisparo(){
	    	ComponenteGrafico bala=mapaLogica.crearDisparo();
	    	if(bala!=null){
				contentPane.add(bala);
				contentPane.setComponentZOrder(bala, 1);
				this.repaint();
	    	}
>>>>>>> origin/master
	    }
	    
	    private void crearEnemigo() {
			ComponenteGrafico enemigo=mapaLogica.crearEnemigo();
			contentPane.add(enemigo);
			contentPane.setComponentZOrder(enemigo, 1);
			this.repaint();
		}

	    public boolean finDelJuego(){
	    	return mapaLogica.finDelJuego();
	    }
	    
	    public void eliminarDisparo(ComponenteGrafico x){
	    	contentPane.remove(x);
	    	refrescarPanel();
	    }
	    
	    public void crearJugador(){
	    	mapaLogica.ingresarJugador();
	        contentPane.add(mapaLogica.getJugador());
	        contentPane.setComponentZOrder(mapaLogica.getJugador(), 1);
	        this.repaint();
	    }
	    
<<<<<<< HEAD
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
			contentPane.remove(x.element());

			try {

				listaDisparos.remove(x);
				System.out.println("elimino");
			} catch (InvalidPositionException | NullPointerException e) {e.printStackTrace();}

			
		}
=======
>>>>>>> origin/master
}