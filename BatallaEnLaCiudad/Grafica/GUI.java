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
	        
	       // JTextField panelPuntaje = new JTextField("Puntaje: "+mapaLogica.obtenerPuntaje());
	        JLabel panelPuntaje = new JLabel("Puntaje:"+mapaLogica.obtenerPuntaje());

	        panelPuntaje.setFont(new Font("Verdana",1,500));
	        panelPuntaje.setForeground(Color.RED);
	        contentPane.add(panelPuntaje);
	        
	        //contentPane.add(panelPuntaje);
	        // contentPane.setComponentZOrder(panelPuntaje, 0);
	        //panelPuntaje.setBounds(contentPane.getWidth()-100, 50, 100, 50);
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
	 					case KeyEvent.VK_W :
	 						crearEnemigo();
	 						break;
	 					case KeyEvent.VK_SPACE:
	 						crearDisparo();
	 						break;
					 }
				   //     contentPane.setComponentZOrder(panelPuntaje, 0);

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
	    

	    public void crearDisparo(){
	    	ComponenteGrafico bala=mapaLogica.crearDisparo();
	    	if(bala!=null){
				contentPane.add(bala);
				contentPane.setComponentZOrder(bala, 1);
				this.repaint();
	    	}
	    }
	    
	    private void crearEnemigo() {
			ComponenteGrafico enemigo=mapaLogica.crearEnemigo();
			if(enemigo!=null){
				contentPane.add(enemigo);
				contentPane.setComponentZOrder(enemigo, 1);
				this.repaint();
			}
		}

	    public boolean finDelJuego(){
	    	return mapaLogica.finDelJuego();
	    }
	    
	    public void eliminarGrafico(ComponenteGrafico x){
	    	contentPane.remove(x);
	    	refrescarPanel();
	    }
	    
	    public void crearJugador(){
	    	mapaLogica.ingresarJugador();
	        contentPane.add(mapaLogica.getJugador());
	        contentPane.setComponentZOrder(mapaLogica.getJugador(), 1);
	        this.repaint();
	    }
	    
	    public void agregarGrafico(ComponenteGrafico x){
	    	contentPane.add(x);
	    	refrescarPanel();
		}	
	    
}