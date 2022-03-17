package Interfaz;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_RegistroCliente;
	private JTextField textField_RegistroTelefono;
	private JTextField textField_RegistroTelefono_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public Registro() {
			setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 755, 502);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setBounds(0, 0, 366, 468);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblUsername = new JLabel("Nombre del cliente");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUsername.setForeground(new Color(240, 255, 255));
			lblUsername.setBounds(56, 128, 154, 14);
			panel.add(lblUsername);
			
			JLabel lblEmail = new JLabel("Telefono");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmail.setForeground(new Color(255, 255, 255));
			lblEmail.setBounds(56, 211, 245, 14);
			panel.add(lblEmail);
			
			Button button_IniciarSesion = new Button("Iniciar Sesion");
			button_IniciarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home inicio = new Home();
					inicio.setVisible(true);
					
				}
			});
			button_IniciarSesion.setBounds(214, 387, 115, 22);
			panel.add(button_IniciarSesion);
			button_IniciarSesion.setFont(new Font("Dialog", Font.PLAIN, 15));
			
			button_IniciarSesion.setForeground(Color.WHITE);
			button_IniciarSesion.setBackground(new Color(30, 144, 255));
			
			JLabel lblNewLabel = new JLabel("REGISTRO");
			lblNewLabel.setBounds(27, 11, 302, 77);
			panel.add(lblNewLabel);
			lblNewLabel.setBackground(new Color(178, 34, 34));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
			lblNewLabel.setForeground(Color.WHITE);
			
			Label label_1_1 = new Label("Correo");
			label_1_1.setBounds(56, 292, 238, 22);
			panel.add(label_1_1);
			label_1_1.setForeground(Color.WHITE);
			label_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			textField_RegistroCliente = new JTextField();
			textField_RegistroCliente.setBounds(56, 152, 248, 27);
			panel.add(textField_RegistroCliente);
			textField_RegistroCliente.setColumns(10);
			
			textField_RegistroTelefono = new JTextField();
			textField_RegistroTelefono.setColumns(10);
			textField_RegistroTelefono.setBounds(56, 232, 248, 27);
			panel.add(textField_RegistroTelefono);
			
			textField_RegistroTelefono_1 = new JTextField();
			textField_RegistroTelefono_1.setColumns(10);
			textField_RegistroTelefono_1.setBounds(56, 320, 248, 27);
			panel.add(textField_RegistroTelefono_1);
			
			Button button_Registro = new Button("Registrar");
			button_Registro.setForeground(Color.WHITE);
			button_Registro.setFont(new Font("Dialog", Font.PLAIN, 15));
			button_Registro.setBackground(new Color(30, 144, 255));
			button_Registro.setBounds(61, 387, 115, 22);
			panel.add(button_Registro);
			
			JLabel label_2_2 = new JLabel("");
			label_2_2.setBounds(360, 0, 379, 479);
			contentPane.add(label_2_2);
			label_2_2.setIcon(new ImageIcon(Registro.class.getResource("/Imagenes/fondo.jpg")));
			label_2_2.setVerticalAlignment(SwingConstants.TOP);
			
		}
		
		private static void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}
	}
