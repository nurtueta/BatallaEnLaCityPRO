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
	        
	        //setteo del panel contenedor
	        
	        
	        
	        setBounds(0,0,650,650);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        contentPane.setVisible(true);
	        setContentPane(contentPane);
	       
	        
			M=mapaLogica.getMapaLogico();
	        
			generarPanel();
	        
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
					 		generarPanel();			//Mover el Jugador hacia Arriba
					 		break;
						case KeyEvent.VK_DOWN :
							mapaLogica.mover(4);
							generarPanel();			//Mover el Jugador hacia Abajo
							break;
	        			case KeyEvent.VK_RIGHT :
	        				mapaLogica.mover(1);
	        				generarPanel();			//Mover el Jugador hacia la Derecha
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						mapaLogica.mover(2);
	 						generarPanel();			//Mover el Jugador hacia la Izquierda
	 						break;
	 					case KeyEvent.VK_Q :
	 						contentPane.remove(mapaLogica.getComponente(5,1));
	 						mapaLogica.eliminar(mapaLogica.getComponente(5, 1));
	 						contentPane.add(M[1][5]);	//Eliminar bloque en posicion
	 					
	 						break;
	 					case KeyEvent.VK_W :
	 						contentPane.remove(mapaLogica.getComponente(5,1));
	 						//mapaLogica.eliminar(mapaLogica.getComponente(5, 1));
	 						mapaLogica.crearEnemigo(1);	//Crear enemigo en posicion
	 						contentPane.add(M[1][5]);
	 					
	 						break;
	 					case KeyEvent.VK_E :
	 						
	 						contentPane.remove(mapaLogica.getComponente(0,0));
	 						mapaLogica.eliminar(mapaLogica.getComponente(0, 0));
	 						contentPane.add(M[0][0]);
	 				
	 						
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
	    	contentPane.removeAll();
			for(int i=0;i<20;i++)
			 	for(int j=0;j<20;j++){
			 		this.add(M[i][j]);
			 	}
			this.repaint();
	    }
	    
	    private void refrescarPanel(){
	    	this.repaint();
	    }
			
}