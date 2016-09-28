package Grafica;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.*;
import Logica.Bloque.*;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Tanque;

public class GUI extends JFrame {
	
     private JPanel contentPane;
	 private Logica mapaLogica;
	 private ComponenteGrafico[][] M;
	 
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
	    	
	        //seteo inicial
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setTitle("Battle City 2016");
	        this.setResizable(false);
	        //this.setIconImage(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/tanqueArriba.png")));
	       
	        //setteo del panel contenedor
	        setBounds(400, 55, 600, 600);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);
	        
	        generarPanel();
	       // setVisible(true);
	       /* 
	        //Agrego al panel el label del jugador
	        Jugador miJugador = mapaLogica.getJugador();
	       // miJugador.getGrafico().setVisible(true);
	        miJugador.setVisible(true);
	        miJugador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueArriba.png")));
	        miJugador.setBounds(miJugador.getColumna()*30, miJugador.getFila()*30, 30, 30);
			 contentPane.add(miJugador);
			 */
			//Genero el mapa en base al archivo seteado.
			
						
	       
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
				
				public void keyPressed1(KeyEvent e) {
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP : 
					 		
					 		mapaLogica.mover(3);
					 		//miJugador.setBounds(miJugador.getX(), miJugador.getY()-5, miJugador.getWidth(), miJugador.getHeight());
					 		//miJugador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueArriba.png")));
					 		//System.out.println(miJugador.getX()+","+miJugador.getY());
					 		generarPanel();
					 		break;
						case KeyEvent.VK_DOWN :
							//miJugador.setBounds(miJugador.getX(), miJugador.getY()+5, miJugador.getWidth(), miJugador.getHeight());
							//miJugador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueAbajo.png")));
							mapaLogica.mover(4);
							generarPanel();
							//System.out.println(miJugador.getX()+","+miJugador.getY());
							break;
	        			case KeyEvent.VK_RIGHT :
	        				//j.setBounds(miJugador.getX()+5, miJugador.getY(), miJugador.getWidth(), miJugador.getHeight());
	        				//miJugador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueDer.png")));
	        				mapaLogica.mover(1);
	        				generarPanel();
	        				//System.out.println(miJugador.getX()+","+miJugador.getY());
	        				break;
    					case KeyEvent.VK_LEFT :
    						//j.setBounds(miJugador.getX()-5, miJugador.getY(), miJugador.getWidth(), miJugador.getHeight());
    						//miJugador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tanqueIzq.png")));
    						mapaLogica.mover(2);
    						generarPanel();
    						//System.out.println(miJugador.getX()+","+miJugador.getY());
    						break;
					 }
					 
	        	}

				public void keyReleased1(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyTyped1(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

	        });
	        
	        
	    }
	    	
	    
	    private void generarPanel(){
	    	
	    	mapaLogica.generacionDeMapaLogico();
			M=mapaLogica.getMapaLogico();
			
			for(int i=0;i<20;i++)
			 	for(int j=0;j<20;j++){
			 		contentPane.add(M[i][j]);
			 					 		
			 		M[i][j].setVisible(true);
			 	}
	    }
			
}