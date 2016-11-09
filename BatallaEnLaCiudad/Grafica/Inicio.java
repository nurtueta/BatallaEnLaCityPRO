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

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 * Insercion de la imagen de FONDO. 
		 * 
		 */
		JLayeredPane fondo= new JLayeredPane();
		JLabel fotito = new JLabel();
		fondo.setBounds(frame.getBounds());
		fotito.setBounds(fondo.getBounds());
		fondo.add(fotito, new Integer(0));
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Main.jpg"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
		fotito.setIcon(icono);
		frame.setIconImage(fot.getImage());
		
		JButton btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GUI juego = new GUI();
				juego.setVisible(true);
			}
		});
		btnStart.setBounds(196, 44, 121, 64);
		frame.getContentPane().add(btnStart);
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"Ayuda");
			}
		});
		btnHelp.setBounds(196, 118, 121, 64);
		frame.getContentPane().add(btnHelp);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"Acerca De BatallaEnLaCiudad");

			}
		});
		btnAbout.setBounds(196, 193, 121, 57);
		frame.getContentPane().add(btnAbout);
	}
}


