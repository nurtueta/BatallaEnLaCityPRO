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
	        
	        
	        
	        setBounds(50,50,700,700);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        contentPane.setVisible(true);
	        setContentPane(contentPane);
	        
	        
	        
	       	mapaLogica.generacionDeMapaLogico();
			M=mapaLogica.getMapaLogico();
	        
			generarPanel();
	        
	        setVisible(true);
	        
	        
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
				
				public void KeyPressed(KeyEvent e) {
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP : 
					 		
					 		mapaLogica.mover(3);
					 		generarPanel();
					 		break;
						case KeyEvent.VK_DOWN :
							mapaLogica.mover(4);
							generarPanel();
							break;
	        			case KeyEvent.VK_RIGHT :
	        				mapaLogica.mover(1);
	        				generarPanel();
	        				break;
    					case KeyEvent.VK_LEFT :
    						mapaLogica.mover(2);
    						generarPanel();
    						break;
    					case KeyEvent.VK_Q :
    						mapaLogica.crearEnemigo(1, 1);
    						generarPanel();
    						System.out.println("anda");
    						break;
    					case KeyEvent.VK_W :
    						mapaLogica.eliminar(mapaLogica.getEnemigo(1));
    						generarPanel();
    						break;
    					case KeyEvent.VK_E :
    						mapaLogica.eliminar(mapaLogica.getComponente(0, 0));
    						generarPanel();
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
	    	
	    
	    public void generarPanel(){
	    	
			for(int i=0;i<20;i++)
			 	for(int j=0;j<20;j++){
			 		//M[i][j].setVisible(true);
			 		
			 		this.add(M[i][j]);
			 		//setComponentZOrder(M[i][j], 0);
			 	}
			this.repaint();
	    }
	    
	    private void refrescarPanel(){
	    	this.repaint();
	    }
			
}