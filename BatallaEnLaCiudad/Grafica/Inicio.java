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
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;




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
		frame = new JFrame("Battle Wars!"); 
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/Main.jpg"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
		
		
		
		JLabel btnStart = new JLabel("Start!");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
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
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(frame, "Ayuda!");
				
			}
		});
		btnHelp.setBounds(196, 119, 121, 63);
		
		btnHelp.setBounds(196, 118, 121, 64);
		frame.getContentPane().add(btnHelp);
		
		JLabel btnAbout = new JLabel("About");
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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


