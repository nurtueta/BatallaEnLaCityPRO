package Grafica;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class Inicio {

	private JFrame frame;
	private	AudioClip musicaFondo;
	
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
		frame = new JFrame("Battle Wars!"); 
		frame.setBounds(100, 100, 900, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Main.jpg"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
		
		
		JLabel btnStart = new JLabel("Start!");
		btnStart.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
					
				musicaFondo.stop();
			    frame.disable();
			    frame.setVisible(false);
				GUI juego = new GUI();
				juego.setVisible(true);
			}
		});
		
		btnStart.setForeground(Color.RED);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		btnStart.setBounds(196, 44, 121, 64);
		frame.getContentPane().add(btnStart);
		frame.getContentPane().setBounds(0, 0, frame.getWidth(), frame.getHeight());
		
		JLabel btnHelp = new JLabel("Ayuda");
		btnHelp.setForeground(Color.RED);
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		btnHelp.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				JFrame ayuda = new JFrame("Help!");
				JLabel help = new JLabel();
				ayuda.getContentPane().add(help);
				ayuda.setBounds(100, 100, frame.getWidth(), frame.getHeight());
				ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Ayuda.png"));
				Icon icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
				ayuda.setVisible(true);
				help.setBounds(ayuda.getBounds());
				help.setIcon(icono);
				
				//JOptionPane.showMessageDialog(frame, "Ayuda!");
				
			}
		});
		btnHelp.setBounds(196, 119, 121, 63);
		
		btnHelp.setBounds(196, 118, 121, 64);
		frame.getContentPane().add(btnHelp);
		
		JLabel btnAbout = new JLabel("About");
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				musicaFondo.stop();

					main creditos;
					try {
						String[] s = {"archivo/IntroStory.txt"};
						main.main(s);
						//creditos = new main("archivo/IntroStory.txt");
						/*creditos.setBounds(100,100,800,600);
						creditos.show();

						creditos.setVisible(true);
						creditos.movePic ();
						creditos.disable();
					    creditos.setVisible(false);*/
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				    musicaFondo.play();
			
				JOptionPane.showMessageDialog(frame, "De los creadores de: vamo que zafamo. \n viene... ZAFAMOS2 !");
			}
		});
		
		btnAbout.setForeground(Color.RED);
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAbout.setBounds(196, 187, 121, 63);
		frame.getContentPane().add(btnAbout);
		JLabel fotito = new JLabel();
		fotito.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(fotito);
		fotito.setIcon(icono);
	}
}


