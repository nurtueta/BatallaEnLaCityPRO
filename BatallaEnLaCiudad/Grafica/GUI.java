package Grafica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Logica.*;

public class GUI extends JFrame {
	
	 private JLayeredPane contentPane;
	 private Logica mapaLogica;
	 private boolean disparo;
	 private boolean movio;
	 private JLabel panelPuntaje,btnRestart;
	 private JLabel panelRestantes;
	 private JLabel panelVidas;
	 private JLabel panelNivel;
	 private AudioClip musicaJuego;
	 private boolean teclado=true;
	 private JFrame yo=this;
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
	        
	        setBounds(100,100,900,630);
	        contentPane = new JLayeredPane();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setVisible(true);
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        getContentPane().setLayout(null);
	        contentPane.setLayout(null);
	        JLabel fondo = new JLabel();
	        ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
	        fondo.setVisible(true);
	        fondo.setIcon(icono);
	        fondo.setBounds(0,0,600,600);
	        contentPane.add(fondo);
	        contentPane.setLayer(fondo, 1);
	        
	        
	        btnRestart = new JLabel();
			btnRestart.setText("Restart");
			btnRestart.setBounds(0, 0, 179, 77);
			contentPane.add(btnRestart);
			btnRestart.setForeground(Color.RED);
			btnRestart.setFont(new Font("Times New Roman", Font.ITALIC, 26));
	        btnRestart.setVisible(false);
			btnRestart.disable();
	        btnRestart.addMouseListener(new MouseAdapter() {
	        				@Override
	        				public void mouseClicked(MouseEvent arg0) {
	        					contentPane.removeAll();
	        					Inicio juego = new Inicio();
	        					juego.setVisible();
	        					
	        					musicaJuego.stop();
	        					yo.dispose();
	        
	        					
	        					
	        					
	        				}
	        			});

	        			
	        
			
			JPanel panel = new JPanel();
			panel.setBounds(600, 0, 321, 600);
			contentPane.add(panel);
			panel.setLayout(null);
			
			//agrego panel para el puntaje
	
			JLabel panelPuntaje_1 = new JLabel();
			panelPuntaje_1.setVerticalAlignment(SwingConstants.TOP);
			panelPuntaje_1.setBounds(10, 0, 246, 114);
			panel.add(panelPuntaje_1);
			panelPuntaje_1.setFont(new Font("Harrington", Font.ITALIC, 25));
			panelPuntaje_1.setForeground(Color.RED);
			contentPane.setLayer(panelPuntaje_1, 5);
			panelPuntaje_1.setText("Puntos: \n");
			this.panelPuntaje=panelPuntaje_1;
			
			//agrego panel para enemigos restantes
			
			JLabel panelRestantes_2 = new JLabel();
			panelRestantes_2.setVerticalAlignment(SwingConstants.TOP);
			panelRestantes_2.setHorizontalAlignment(SwingConstants.LEFT);
			panelRestantes_2.setBounds(10, 177, 277, 188);
			panel.add(panelRestantes_2);
			panelRestantes_2.setFont(new Font("Harrington", Font.ITALIC, 25));
			panelRestantes_2.setForeground(Color.RED);
			contentPane.setLayer(panelRestantes_2, 5);
			panelRestantes_2.setText("16 naves:");
			this.panelRestantes=panelRestantes_2;
			
			JLabel panelRestantes_3 = new JLabel();
			panelRestantes_3.setVerticalAlignment(SwingConstants.TOP);
			panelRestantes_3.setHorizontalAlignment(SwingConstants.LEFT);
			panelRestantes_3.setBounds(10, 150, 277, 188);
			panel.add(panelRestantes_3);
			panelRestantes_3.setFont(new Font("Harrington", Font.ITALIC, 25));
			panelRestantes_3.setForeground(Color.RED);
			contentPane.setLayer(panelRestantes_3, 5);
			panelRestantes_3.setText("Restan :");
			
			//agrego panel de la vidas
			
			JLabel panelRestantes_4 = new JLabel();
			panelRestantes_4.setVerticalAlignment(SwingConstants.TOP);
			panelRestantes_4.setHorizontalAlignment(SwingConstants.LEFT);
			panelRestantes_4.setBounds(10, 50, 277, 188);
			panel.add(panelRestantes_4);
			panelRestantes_4.setFont(new Font("Harrington", Font.ITALIC, 25));
			panelRestantes_4.setForeground(Color.RED);
			contentPane.setLayer(panelRestantes_2, 5);
			panelRestantes_4.setText("Vidas : 0");
			this.panelVidas=panelRestantes_4;
			
			//agrego panel de nivel
			
			JLabel panelRestantes_5 = new JLabel();
			panelRestantes_5.setVerticalAlignment(SwingConstants.TOP);
			panelRestantes_5.setHorizontalAlignment(SwingConstants.LEFT);
			panelRestantes_5.setBounds(10, 100, 277, 188);
			panel.add(panelRestantes_5);
			panelRestantes_5.setFont(new Font("Harrington", Font.ITALIC, 25));
			panelRestantes_5.setForeground(Color.RED);
			contentPane.setLayer(panelRestantes_2, 5);
			panelRestantes_5.setText("Vidas : 0");
			this.panelNivel=panelRestantes_5;
			
			
			JLabel panelDerecha = new JLabel("");
			panelDerecha.setBounds(0, 0, 300, 600);
			panel.add(panelDerecha);
			
			 fot = new ImageIcon(getClass().getResource("/Imagenes/panelDerecha.jpg"));
			 icono = new ImageIcon(fot.getImage().getScaledInstance(300, this.getHeight(), Image.SCALE_DEFAULT));
			panelDerecha.setIcon(icono);
			
			mapaLogica.generarPanel();
	        mapaLogica.crearJugador();
	        mapaLogica.crearEnemigoInicio();
	        mapaLogica.addPuntaje(0);
	        
	        mapaLogica.addPuntaje(0);
	        
	        setVisible(true);
	        
	        //agrego el oyente al teclado en el panel contenedor
	        this.addKeyListener( new KeyListener() {
	        	

				public void keyTyped1(KeyEvent arg0) {}

				public void keyPressed(KeyEvent e) {
					if (teclado){
						
					 switch(e.getKeyCode()){
					 	case KeyEvent.VK_UP :
					 			mapaLogica.mover(3);		//Mover el Jugador hacia Arriba
						 		movio=true;
						 		
					 		break;
						case KeyEvent.VK_DOWN :
								mapaLogica.mover(4);		//Mover el Jugador hacia Abajo
						 		movio=true;
							break;
	        			case KeyEvent.VK_RIGHT :
						 		mapaLogica.mover(1);		//Mover el Jugador hacia Derecha
						 		movio=true;
	        				break;
	 					case KeyEvent.VK_LEFT :
	 							mapaLogica.mover(2);		//Mover el Jugador hacia Izquierda
						 		movio=true;
	 						break;
	 					case KeyEvent.VK_SPACE:
	 							mapaLogica.crearDisparoJugador();	//Creo disparo del jugador
	 							disparo=true;
	 						break; 
					 }}
				}

				/*public void keyReleased(KeyEvent e){
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
				}*/

				public void keyTyped(KeyEvent arg0) {}

				@Override
				public void keyReleased(KeyEvent arg0) {
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
	 
	 public JLabel getPanelVidas(){
		 return panelVidas;
	 }
	 
	 public JLabel getPanelNivel(){
		 return panelNivel;
	 }
	 
	 public	JLabel getPanelPuntaje(){
	   	return panelPuntaje;
	 }
	    
	 public	JLabel getPanelRestantes(){
		 return panelRestantes;
	 }
	 public	JLayeredPane getContentPane(){
	  	return contentPane;
	 }
	    
	 public void terminarJuego(boolean Victoria){
		 mapaLogica.stopMusic();
		 contentPane.removeAll();
		 teclado= false;
		 contentPane.add(btnRestart);
		 btnRestart.enable();
		 btnRestart.setVisible(true);
		 yo=this;
		if(Victoria){
			ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Victory.png"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth()+200, this.getHeight(), Image.SCALE_DEFAULT));
			JLabel algo = new JLabel();
			
			java.net.URL url = GUI.class.getResource("/archivo/StarWarsVictory.wav");
		     musicaJuego = Applet.newAudioClip(url);
		    musicaJuego.play();
		    
			this.setBounds(100, 100, this.getWidth()+200, this.getHeight());
			algo.setBounds(0, 0, this.getWidth(), this.getHeight());
			algo.setPreferredSize(contentPane.getPreferredSize());
			algo.setIcon(icono);
			contentPane.add(algo);
			
		}else{
			
			ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/DarthVaderVictory.png"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.getWidth()+200, this.getHeight(), Image.SCALE_DEFAULT));
			JLabel algo = new JLabel();
			this.setBounds(100, 100, this.getWidth()+200, this.getHeight());
			algo.setBounds(0, 0, this.getWidth(), this.getHeight());
			algo.setPreferredSize(contentPane.getPreferredSize());
			algo.setIcon(icono);
			contentPane.add(algo);
			
			java.net.URL url = GUI.class.getResource("/archivo/StarWarsImperialMarch.wav");
		     musicaJuego = Applet.newAudioClip(url);
		    musicaJuego.play();
		}
		contentPane.repaint();
	 }
}