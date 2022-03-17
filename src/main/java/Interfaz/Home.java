package Interfaz;

import java.awt.Color;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	public int xx,xy;
	private JPanel contentPane;
	private JTextField textField_LoginContraseña;
	private JTextField textField_LoginCorreo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public Home() {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTETICA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(87, 273, 175, 43);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
		
		label.setBounds(64, 40, 228, 210);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/icono1.png")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("Halcones");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(Color.WHITE);
		lblWeGotYou.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeGotYou.setBounds(108, 327, 141, 27);
		panel.add(lblWeGotYou);
		
		Button button_LogInicioSesion = new Button("Iniciar Sesion");
		button_LogInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//?
							
			}
		});
		
		button_LogInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_LogInicioSesion.setForeground(Color.WHITE);
		button_LogInicioSesion.setBackground(new Color(30, 144, 255));
		button_LogInicioSesion.setBounds(450, 305, 186, 36);
		contentPane.add(button_LogInicioSesion);
		
		JLabel LblNombre = new JLabel("Nombre");
		LblNombre.setBounds(395, 132, 54, 14);
		contentPane.add(LblNombre);
		
		textField_LoginContraseña = new JTextField();
		textField_LoginContraseña.setColumns(10);
		textField_LoginContraseña.setBounds(395, 234, 283, 36);
		contentPane.add(textField_LoginContraseña);
		
		JLabel lblPassword = new JLabel("Contrasena");
		lblPassword.setBounds(395, 204, 96, 14);
		contentPane.add(lblPassword);
				
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(30, 144, 255));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(698, 0, 37, 27);
		contentPane.add(lbl_close);
		
		textField_LoginCorreo = new JTextField();
		textField_LoginCorreo.setColumns(10);
		textField_LoginCorreo.setBounds(395, 157, 283, 36);
		contentPane.add(textField_LoginCorreo);
		
		Button button_LoginRegistro = new Button("Registro de Clientes");
		button_LoginRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro nuevo = new Registro();
				nuevo.setVisible(true);
			}

		});
		
		button_LoginRegistro.setForeground(Color.WHITE);
		button_LoginRegistro.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_LoginRegistro.setBackground(new Color(30, 144, 255));
		button_LoginRegistro.setBounds(450, 361, 186, 36);
		contentPane.add(button_LoginRegistro);
	}
}