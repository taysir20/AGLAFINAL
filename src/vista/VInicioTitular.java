package vista;

import javax.swing.*;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.MImplementacion;
import modelo.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Toolkit;

public class VInicioTitular extends JFrame implements Vista {

	private CImplementacionControl controlador;
	private MImplementacion modelo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldFax;
	private JTextField textFieldEmail;
	private JTextField textFieldFijo;
	private JTextField textFieldMovil;
	private JTextField textFieldMunicipio;
	private JTextField textFieldNombre;
	private JTextField textRSocial;
	private JTextField textFieldDireccion;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textFieldCP;
	private JComboBox comboBoxPersona;
	private JLabel lblCamposObligatorios;
	private JLabel labelCp;
	private JLabel labelFijo;
	private JLabel labelMovil;
	private JLabel labelFax;


	public VInicioTitular() {
		setTitle("REGISTRO DE PERSONAS FISICA / JURIDICA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VInicioTitular.class.getResource("/GestionLicencias/IMG/386px-Escudo-torrijos.svg.png")));
		setBounds(100,100,950,592);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
		);
		
		JButton button = new JButton("SIGUIENTE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textApellidos.getText());
				if (!textFieldNombre.getText().isEmpty() && !textApellidos.getText().isEmpty()
						&& !textFieldDireccion.getText().isEmpty() && !textFieldMunicipio.getText().isEmpty()
						&& !textRSocial.getText().isEmpty() && !textDNI.getText().isEmpty()) {
					if(!textFieldCP.getText().isEmpty() ){
						try {
							int number=Integer.parseInt(textFieldCP.getText());
							
						    
						}
						catch (NumberFormatException e1) {
							
							lblCamposObligatorios.setText("Revisa los campos numericos( Tel�fono Fijo, M�vil, Fax y CP) ");
							lblCamposObligatorios.setForeground(Color.RED);
							labelCp.setForeground(Color.RED);
							
							
						}
						
					}
					System.out.println("Esto se deber�a imprimir");
					if(!textFieldFijo.getText().isEmpty()){
						try {
							int number=Integer.parseInt(textFieldFijo.getText());
							
						    
						}
						catch (NumberFormatException e1) {
							
							lblCamposObligatorios.setText("Revisa los campos numericos( Tel�fono Fijo, M�vil, Fax y CP) ");
							lblCamposObligatorios.setForeground(Color.RED);
							labelFijo.setForeground(Color.RED);
							
							
						}
						
						
					} if(!textFieldMovil.getText().isEmpty()){
						try {
							int number=Integer.parseInt(textFieldMovil.getText());
							
						    
						}
						catch (NumberFormatException e1) {
							
							lblCamposObligatorios.setText("Revisa los campos numericos( Tel�fono Fijo, M�vil, Fax y CP) ");
							lblCamposObligatorios.setForeground(Color.RED);
							labelMovil.setForeground(Color.RED);
							
							
						}
						
						
					}
					
					if(!textFieldFax.getText().isEmpty()){
						try {
							int number=Integer.parseInt(textFieldFax.getText());
							
						    
						}
						catch (NumberFormatException e1) {
							
							lblCamposObligatorios.setText("Revisa los campos numericos( Tel�fono Fijo, M�vil, Fax y CP) ");
							lblCamposObligatorios.setForeground(Color.RED);
							labelFax.setForeground(Color.RED);
							
							
						}
					}
					
					controlador.recogerDatosRegistroTitular();
					JOptionPane.showMessageDialog(null, "Petici�n procesada");
					dispose();

				}else{
					lblCamposObligatorios.setText("Rellena los campos con asterisco");
					lblCamposObligatorios.setForeground(Color.RED);
				}
				
			}

			
		});
		button.setIcon(new ImageIcon(VInicioTitular.class.getResource("/GestionLicencias/IMG/next.png")));
		
		JButton button_1 = new JButton("CANCELAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(VInicioTitular.class.getResource("/GestionLicencias/IMG/cancel.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "INTRODUCE LOS DATOS DEL SOLICITANTE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		
		comboBoxPersona = new JComboBox();
		comboBoxPersona.setModel(new DefaultComboBoxModel(new String[] {"FISICA", "JURIDICA"}));
		
		JLabel label = new JLabel("JURIDICA / FISICA");
		
		textFieldFax = new JTextField();
		textFieldFax.setColumns(10);
		
		labelFax = new JLabel("FAX");
		
		JLabel label_2 = new JLabel("CORREO ELECTR\u00D3NICO");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		textFieldFijo = new JTextField();
		textFieldFijo.setColumns(10);
		
		labelFijo = new JLabel("TELF FIJO");
		
		labelMovil = new JLabel("TELF M\u00D3VIL");
		
		textFieldMovil = new JTextField();
		textFieldMovil.setColumns(10);
		
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setColumns(10);
		
		JLabel label_5 = new JLabel("MUNICIPIO*");
		
		JLabel label_6 = new JLabel("NOMBRE*");
		
		JLabel label_7 = new JLabel("RAZ\u00D3N SOCIAL*");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textRSocial = new JTextField();
		textRSocial.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		JLabel label_8 = new JLabel("DIRECCI\u00D3N*");
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		
		JLabel label_9 = new JLabel("APELLIDOS*");
		
		JLabel label_10 = new JLabel("DNI/NIE/CIF*");
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		
		labelCp = new JLabel("C\u00D3DIGO POSTAL");
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDireccion, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textRSocial, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
										.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(20)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(textFieldMunicipio)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldFax, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
														.addComponent(labelFax, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
													.addGap(29)
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(labelFijo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
							.addGap(12)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldCP)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(labelCp, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBoxPersona, Alignment.LEADING, 0, 121, Short.MAX_VALUE)
									.addComponent(labelMovil, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPersona, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCp, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelFijo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelMovil, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRSocial, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelFax, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(139))
		);
		panel_1.setLayout(gl_panel_1);
		
		lblCamposObligatorios = new JLabel("*Campos Obligatorios");
		lblCamposObligatorios.setForeground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCamposObligatorios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 912, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(82)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCamposObligatorios)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		VInicioTitular ventana = new VInicioTitular();

	}





	@Override
	public void setControlador(CImplementacionControl controlador) {
		this.controlador= controlador;
		
	}

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo= (MImplementacion) modelo;
		
	}

	public String getTextFieldFax() {
		return textFieldFax.getText();
	}


	public String getTextFieldEmail() {
		return textFieldEmail.getText();
	}


	public String getTextFieldFijo() {
		return textFieldFijo.getText();
	}


	public String getTextFieldMovil() {
		return textFieldMovil.getText();
	}


	public String getTextFieldMunicipio() {
		return textFieldMunicipio.getText();
	}

	public String getTextFieldNombre() {
		return textFieldNombre.getText();
	}

	public String getTextRSocial() {
		return textRSocial.getText();
	}
	
	public String getTextFieldDireccion() {
		return textFieldDireccion.getText();
	}

	public 	String getTextApellidos() {
		return textApellidos.getText();
	}

	public String  getTextDNI() {
		return textDNI.getText();
	}

	public String  getTextFieldCP() {
		return textFieldCP.getText();
	}

	public String getComboBoxPersona() {
		return (String) comboBoxPersona.getSelectedItem();
	}
	
}