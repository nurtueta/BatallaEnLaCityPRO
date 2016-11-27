package Grafica;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class Inicio {

	private JFrame frame;
	private	AudioClip musicaFondo;
	private JLabel labelCreditos,labelAyuda;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Inicio() {
		java.net.URL url = main.class.getResource("/archivo/StarWarsCreditsMusic.wav");
	    musicaFondo = Applet.newAudioClip(url);
	    musicaFondo.loop();
		
		
		initialize();
	}
	public	void setVisible(){
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Battle Star"); 
		frame.setBounds(100, 100, 900, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/creditos.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
		 
		 JLabel btnStart = new JLabel("Start!");
		 btnStart.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		
		 		musicaFondo.stop();
		 	    frame.disable();
		 	    frame.setVisible(false);
		 		GUI juego = new GUI();
		 		juego.setVisible(true);
		 	}
		 });
		
		 labelCreditos = new JLabel("");
		 labelCreditos.setVisible(false);
		 labelCreditos.setEnabled(false);
		 
		 labelCreditos.setBounds(0, 0, frame.getWidth(), 590);
		 labelCreditos.setIcon(icono);
		 frame.getContentPane().add(labelCreditos);
		 labelCreditos.disable();
		 labelCreditos.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		labelCreditos.disable();
		 		labelCreditos.setVisible(false);
		 	}
		 });
		
		
		labelAyuda = new JLabel("");
		labelAyuda.setVisible(false);
		labelAyuda.setEnabled(false);
		 fot = new ImageIcon(getClass().getResource("/Imagenes/Ayuda.png"));
 		 icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
 		labelAyuda.setIcon(icono);
		labelAyuda.setBounds(0, 0, frame.getWidth(), 590);
		labelAyuda.setIcon(icono);
		frame.getContentPane().add(labelAyuda);
		labelAyuda.disable();
		labelAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				
				labelAyuda.disable();
				labelAyuda.setVisible(false);
			}
		});
		 
		btnStart.setForeground(Color.RED);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		btnStart.setBounds(196, 44, 121, 64);
		frame.getContentPane().add(btnStart);
		 
		 JLabel btnHelp = new JLabel("Ayuda");
		 btnHelp.setForeground(Color.RED);
		 btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		 
		 btnHelp.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		
		 		
		 		
		 		labelAyuda.setEnabled(true);
		 		labelAyuda.setVisible(true);
		 		
		 		
		 	}
		 });
		 btnHelp.setBounds(196, 119, 121, 63);
		 
		 btnHelp.setBounds(196, 118, 121, 64);
		 frame.getContentPane().add(btnHelp);
		 
		  
		 
		 
		 JLabel btnAbout = new JLabel("About");
		 btnAbout.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e)  {
		 		
		 		labelCreditos.setVisible(true);
		 		labelCreditos.enable();
		 		    
		 		
		 		
		 		
		 		
		 		//JOptionPane.showMessageDialog(frame, "De los creadores de: vamo que zafamo. \n viene... ZAFAMOS2 !");

		 	}
		 });
		 btnAbout.setForeground(Color.RED);
		 btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 40));
		 btnAbout.setBounds(196, 187, 121, 63);
		 frame.getContentPane().add(btnAbout);
		 
		 
		frame.getContentPane().setBounds(0, 0, frame.getWidth(), frame.getHeight());
		 fot = new ImageIcon(getClass().getResource("/Imagenes/Main.jpg"));
		 icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
		
		
		JLabel fotito = new JLabel();
		fotito.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(fotito);
		fotito.setIcon(icono);
		
		
		
		
	}
}


