package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.MImplementacion;
import modelo.Modelo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VFichero extends JFrame implements Vista{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPass;
	private JTextField textFieldURL;
	private JButton btnGuardarDatos;
	private MImplementacion modelo;
	private CImplementacionControl controlador;
	private JButton btnComprobarConexin;
	private JLabel lblAviso;

	public String getTextFieldNombre() {
		String usuario=textFieldNombre.getText();
		System.out.println(usuario);
		return usuario;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public String getTextFieldPass() {
		String pass= textFieldPass.getText();
		return pass;
	}

	public void setTextFieldPass(JTextField textFieldPass) {
		this.textFieldPass = textFieldPass;
	}

	public String getTextFieldURL() {
		String bbdd= textFieldURL.getText();
		return bbdd;
	}

	public void setTextFieldURL(JTextField textFieldURL) {
		this.textFieldURL = textFieldURL;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = (MImplementacion) modelo;
	}

	public Controlador getControlador() {
		return controlador;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFichero frame = new VFichero();
					
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
	public VFichero() {
		setResizable(false);
		
		setBounds(100, 100, 380, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		
		JLabel lblURL = new JLabel("URL BBDD");
		
		textFieldURL = new JTextField();
		textFieldURL.setText("");
		textFieldURL.setColumns(10);
		
		btnGuardarDatos = new JButton("GUARDAR DATOS");
		btnGuardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cargarDatosBBDD();
			}
		});
		
		btnComprobarConexin = new JButton("COMPROBAR CONEXI\u00D3N");
		btnComprobarConexin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAviso.setText(modelo.ConexionBBDD());
			}
		});
		
		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnComprobarConexin, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAviso, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsuario)
										.addComponent(lblURL)
										.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldURL, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
										.addComponent(textFieldNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
										.addComponent(textFieldPass, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
								.addComponent(btnGuardarDatos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
							.addGap(20))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPass)
						.addComponent(textFieldPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblURL)
						.addComponent(textFieldURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGuardarDatos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnComprobarConexin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAviso, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void actualizarDatosBBDD() {
		textFieldNombre.setText(modelo.getUsuario());
		textFieldPass.setText(modelo.getPass());
		textFieldURL.setText(modelo.getBbdd());
		
	}

	@Override
	public void setControlador(CImplementacionControl controlador) {
		this.controlador=controlador;
		
	}
}
