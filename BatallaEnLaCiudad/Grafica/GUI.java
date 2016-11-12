package Grafica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Logica.*;

public class GUI extends JFrame {
	
	 private JLayeredPane contentPane;
	 private Logica mapaLogica;
	 private boolean disparo;
	 private boolean movio;
	 private JLabel panelPuntaje;
	 private boolean teclado=true;
	   
	 
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
	        
	        setBounds(100,100,800,630);
	        contentPane = new JLayeredPane();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setVisible(true);
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        getContentPane().setLayout(null);
	        contentPane.setLayout(null);
	        
	        
	        
	        JLabel panelPuntaje = new JLabel();
	        panelPuntaje.setFont(new Font("Harrington", Font.ITALIC, 36));
	        panelPuntaje.setBounds(352, 11, 282, 45);
	        panelPuntaje.setForeground(Color.RED);
	        contentPane.setLayer(panelPuntaje, 5);
	        panelPuntaje.setText("puntaje: ");
	        this.panelPuntaje=panelPuntaje;
	        
	        contentPane.add(panelPuntaje);
	        ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
			JLabel fondo = new JLabel();
			fondo.setVisible(true);
			fondo.setIcon(icono);
			fondo.setBounds(0,0,600,600);
			contentPane.add(fondo);
			contentPane.setLayer(fondo, 1);
	        mapaLogica.generarPanel();
	        mapaLogica.crearJugador();
	        mapaLogica.crearEnemigoInicio();
	        
	        setVisible(true);
	        
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
				
				public void keyReleased1(KeyEvent arg0) {
					
				}

				public void keyTyped1(KeyEvent arg0) {
					
				}

				public void keyPressed(KeyEvent e) {
					if (teclado){
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP :
					 		if(!movio){
					 			mapaLogica.mover(3);		//Mover el Jugador hacia Arriba
						 		movio=true;
						 	}
					 		break;
						case KeyEvent.VK_DOWN :
							if(!movio){
								mapaLogica.mover(4);		//Mover el Jugador hacia Arriba
						 		movio=true;
						 	}
							break;
	        			case KeyEvent.VK_RIGHT :
	        				if(!movio){
						 		mapaLogica.mover(1);
						 		movio=true;
						 	}
	        				break;
	 					case KeyEvent.VK_LEFT :
	 						if(!movio){
	 							mapaLogica.mover(2);		//Mover el Jugador hacia Arriba
						 		movio=true;
						 	}	
	 						break;
	 					case KeyEvent.VK_SPACE:
	 						if(!disparo){
	 							mapaLogica.crearDisparoJugador();
	 							disparo=true;
	 						}
	 						break; 
					 }}
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

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
	        }
				);	       	        
	    	}
 
	 public void eliminarGrafico(ComponenteGrafico x){
	  	contentPane.remove(x);
	 }
	   
	 public void agregarGrafico(ComponenteGrafico x){
	  	contentPane.add(x,new Integer(x.getDepth()));
	 }
	 
	 public	JLabel getPanelPuntaje(){
	   	return panelPuntaje;
	 }
	    
	 public	JLayeredPane getContentPane(){
	  	return contentPane;
	 }
	    
	 public void terminarJuego(boolean Victoria){
		 
		 contentPane.removeAll();
		 teclado= false;
		mapaLogica=null;
		
		if(Victoria){
			ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Victory.png"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth()+200, this.getHeight(), Image.SCALE_DEFAULT));
			JLabel algo = new JLabel();
			this.setBounds(100, 100, this.getWidth()+200, this.getHeight());
			algo.setBounds(0, 0, this.getWidth(), this.getHeight());
			algo.setPreferredSize(contentPane.getPreferredSize());
			algo.setIcon(icono);
			contentPane.add(algo);
		}
		else{
			
			ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/DarthVaderVictory2.jpg"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth()+200, this.getHeight(), Image.SCALE_DEFAULT));
			JLabel algo = new JLabel();
			this.setBounds(100, 100, this.getWidth()+200, this.getHeight());
			algo.setBounds(0, 0, this.getWidth(), this.getHeight());
			algo.setPreferredSize(contentPane.getPreferredSize());
			algo.setIcon(icono);
			contentPane.add(algo);
			
			java.net.URL url = GUI.class.getResource("/archivo/StarWarsImperialMarch.wav");
		    AudioClip clip = Applet.newAudioClip(url);
		    clip.play();
		}
		contentPane.repaint();

	 }
}