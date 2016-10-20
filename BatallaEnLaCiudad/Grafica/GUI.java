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
	 private boolean disparo;
	 private boolean movio;
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
	    	disparo=false;
	    	movio=false;
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
	        
	        mapaLogica.generarPanel();
	        mapaLogica.crearJugador();
	        
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
					 		if(!movio){
						 		mapaLogica.mover(3);		//Mover el Jugador hacia Arriba
						 		refrescarPanel();
						 		movio=true;
						 	}
					 		break;
						case KeyEvent.VK_DOWN :
							if(!movio){
						 		mapaLogica.mover(4);		//Mover el Jugador hacia Arriba
						 		refrescarPanel();
						 		movio=true;
						 	}
							break;
	        			case KeyEvent.VK_RIGHT :
	        				if(!movio){
						 		mapaLogica.mover(1);		//Mover el Jugador hacia Arriba
						 		refrescarPanel();
						 		movio=true;
						 	}
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						if(!movio){
						 		mapaLogica.mover(2);		//Mover el Jugador hacia Arriba
						 		refrescarPanel();
						 		movio=true;
						 	}	
	 						break;
	 					case KeyEvent.VK_W :
	 						mapaLogica.crearEnemigo();
	 						break;
	 					case KeyEvent.VK_SPACE:
	 						if(!disparo){
	 							mapaLogica.crearDisparo();
	 							disparo=true;
	 						}
	 						break;
					 }
				   //     contentPane.setComponentZOrder(panelPuntaje, 0);

					 contentPane.repaint();
				}

				public void keyReleased(KeyEvent e){
					switch(e.getKeyCode()){	
						case KeyEvent.VK_SPACE:
							disparo=false;
							break;
						case KeyEvent.VK_UP : 
					 		movio=false;
							break;
						case KeyEvent.VK_DOWN :
							movio=false;
							break;
	        			case KeyEvent.VK_RIGHT :
	        				movio=false;
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						movio=false;
	 						break;
					}
				}

				public void keyTyped(KeyEvent arg0){
				}
	        });	       	        
	    }
	    
	    public void refrescarPanel(){
	    	this.repaint();
	    }

	    public boolean finDelJuego(){
	    	return mapaLogica.finDelJuego();
	    }
	    
	    public void eliminarGrafico(ComponenteGrafico x){
	    	contentPane.remove(x);
	    	refrescarPanel();
	    }
	    
	    public void agregarGrafico(ComponenteGrafico x){
	    	contentPane.add(x);
	    	refrescarPanel();
		}	
	    
	    public void agregarZOrder(ComponenteGrafico x,int a){
	    	contentPane.setComponentZOrder(x, a);
	    	refrescarPanel();
	    }
	    
}