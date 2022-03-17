package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Label;
import javax.swing.JRadioButton;

public class menuCitas extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NombreCitas;
	private JTextField textField_FechaHora;
	
	int xx,xy;
	private JTextField textField_Monto;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCitas frame = new menuCitas();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public menuCitas() {
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
		
		JLabel lblNewLabel = new JLabel("CITAS");
		lblNewLabel.setBounds(231, 11, 208, 77);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(178, 34, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblUsername = new JLabel("Nombre de cliente");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setForeground(new Color(240, 255, 255));
		lblUsername.setBounds(59, 126, 154, 14);
		panel.add(lblUsername);
		
		textField_NombreCitas = new JTextField();
		textField_NombreCitas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_NombreCitas.setBounds(60, 151, 256, 27);
		panel.add(textField_NombreCitas);
		textField_NombreCitas.setColumns(10);
		
		JLabel lblEmail = new JLabel("Fecha (aa-mm-dd) y Horario (00:00:00)");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(59, 199, 245, 14);
		panel.add(lblEmail);
		
		textField_FechaHora = new JTextField();
		textField_FechaHora.setBounds(59, 228, 256, 27);
		panel.add(textField_FechaHora);
		textField_FechaHora.setColumns(10);
		
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
		lbl_close.setBounds(722, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JLabel ImagenSpa = new JLabel("");
		ImagenSpa.setBounds(124, 298, 110, 109);
		panel.add(ImagenSpa);
		ImagenSpa.setIcon(new ImageIcon(menuCitas.class.getResource("/Imagenes/Spas.png")));
		ImagenSpa.setVerticalAlignment(SwingConstants.TOP);
		
		Button button = new Button("Reservar");
		button.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(30, 144, 255));
		button.setBounds(487, 402, 131, 36);
		contentPane.add(button);
		
		JLabel lblWeGotYou = new JLabel("Monto");
		lblWeGotYou.setBounds(445, 322, 40, 27);
		contentPane.add(lblWeGotYou);
		lblWeGotYou.setBackground(new Color(0, 0, 0));
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(0, 0, 0));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAs = new JLabel("AS");
		lblAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAs.setForeground(new Color(30, 144, 255));
		lblAs.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblAs.setBackground(new Color(204, 51, 51));
		lblAs.setBounds(311, 11, 208, 77);
		contentPane.add(lblAs);
		
		Label EstilistaMenu = new Label("Estilista:");
		EstilistaMenu.setBounds(445, 120, 238, 22);
		contentPane.add(EstilistaMenu);
		EstilistaMenu.setForeground(Color.BLACK);
		EstilistaMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_Andrea = new JRadioButton("Andrea Tirado");
		rdbtnNewRadioButton_Andrea.setBounds(487, 148, 109, 23);
		contentPane.add(rdbtnNewRadioButton_Andrea);
		
		JRadioButton rdbtnNewRadioButton_Frida = new JRadioButton("Frida Martinez");
		rdbtnNewRadioButton_Frida.setBounds(487, 183, 109, 23);
		contentPane.add(rdbtnNewRadioButton_Frida);
		
		JRadioButton rdbtnNewRadioButton_Dennis = new JRadioButton("Dennis Oros");
		rdbtnNewRadioButton_Dennis.setBounds(487, 217, 109, 23);
		contentPane.add(rdbtnNewRadioButton_Dennis);
		
		JRadioButton rdbtnNewRadioButton_Nelson = new JRadioButton("Nelson Beas");
		rdbtnNewRadioButton_Nelson.setBounds(487, 249, 109, 23);
		contentPane.add(rdbtnNewRadioButton_Nelson);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(menuCitas.class.getResource("/Imagenes/icono.png")));
		label_2.setBounds(400, 110, 40, 48);
		contentPane.add(label_2);
		label_2.setVerticalAlignment(SwingConstants.TOP);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Ricardo Navarro");
		rdbtnNewRadioButton_4.setBounds(487, 281, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JLabel label_2_1 = new JLabel("");
		label_2_1.setIcon(new ImageIcon(menuCitas.class.getResource("/Imagenes/monto.png")));
		label_2_1.setVerticalAlignment(SwingConstants.TOP);
		label_2_1.setBounds(400, 312, 40, 48);
		contentPane.add(label_2_1);
		
		textField_Monto = new JTextField();
		textField_Monto.setBounds(495, 326, 86, 20);
		contentPane.add(textField_Monto);
		textField_Monto.setColumns(10);
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

