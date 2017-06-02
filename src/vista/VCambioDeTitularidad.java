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

public class VCambioDeTitularidad extends JFrame implements Vista {

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
	
	private String nombre;
	private String apellidos;
	private String tipoPersona;
	private String direccion;
	private String municipio;
	private String CP;
	private String razonSocial;
	private String cif;
	private String tlfFijo;
	private String tlfMovil;
	private String email;
	private String fax;
	private JCheckBox checkboxEscrituras;
	private JCheckBox checkBoxPlanos;
	private JCheckBox checkBoxLicenciaAnt;
	private JCheckBox checkBoxNumExpediente;

	public VCambioDeTitularidad() {
		setResizable(false);
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
				controlador.recogerDatosNuevoTitular();
				JOptionPane.showMessageDialog(null, "Petición procesada");
				dispose();
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
		panel_1.setBorder(new TitledBorder(null, "INTRODUCE LOS DATOS DEL NUEVO TITULAR", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		
		comboBoxPersona = new JComboBox();
		comboBoxPersona.setModel(new DefaultComboBoxModel(new String[] {"FISICA", "JURIDICA"}));
		
		JLabel label = new JLabel("JURIDICA / FISICA");
		
		textFieldFax = new JTextField();
		textFieldFax.setColumns(10);
		
		JLabel label_1 = new JLabel("FAX");
		
		JLabel label_2 = new JLabel("CORREO ELECTR\u00D3NICO");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		textFieldFijo = new JTextField();
		textFieldFijo.setColumns(10);
		
		JLabel label_3 = new JLabel("TELF FIJO");
		
		JLabel label_4 = new JLabel("TELF M\u00D3VIL");
		
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
		
		JLabel label_11 = new JLabel("C\u00D3DIGO POSTAL");
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Documentacion Necesaria para Cambio de Titularidad Actividad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2.setBackground(new Color(248, 248, 255));
		
		checkBoxNumExpediente = new JCheckBox("Numero expediente Anterior Titular");
		checkBoxNumExpediente.setBackground(new Color(248, 248, 255));
		
		checkBoxLicenciaAnt = new JCheckBox("Licencia anterior / documento que lo acredite");
		checkBoxLicenciaAnt.setBackground(new Color(248, 248, 255));
		
		checkboxEscrituras = new JCheckBox("Escrituras, contrato arrendamiento/documentos justificativos");
		checkboxEscrituras.setBackground(new Color(248, 248, 255));
		
		checkBoxPlanos = new JCheckBox("Planos distribuici\u00F3n / planta actividad anterior");
		checkBoxPlanos.setBackground(new Color(248, 248, 255));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxPlanos)
						.addComponent(checkboxEscrituras))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxLicenciaAnt, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxNumExpediente))
					.addGap(54))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 155, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(checkBoxLicenciaAnt)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxNumExpediente))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkboxEscrituras)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxPlanos)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
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
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
														.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldFax, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
														.addComponent(textDNI))
													.addGap(32)
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
									.addGap(73)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(61)))
							.addGap(12)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldCP)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBoxPersona, Alignment.LEADING, 0, 121, Short.MAX_VALUE)
									.addComponent(label_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)))
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
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRSocial, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
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

	

	public void setModelo(Modelo modelo) {
		this.modelo = (MImplementacion) modelo;

	}

	
	
	@Override
	public void setControlador(CImplementacionControl controlador) {
		this.controlador= (CImplementacionControl) controlador;
		
	}

	public void devolverDatosTitular() {
		textFieldNombre.setText(modelo.getNombre());
		textApellidos.setText(modelo.getApellidos());
		comboBoxPersona.setSelectedItem(modelo.getTipoPersona());
		textFieldDireccion.setText(modelo.getDireccion());
		textFieldMunicipio.setText(modelo.getMunicipio());
		textFieldCP.setText(modelo.getCp());
		textRSocial.setText(modelo.getRazonSocial());
		textDNI.setText(modelo.getCif());
		textFieldFijo.setText(modelo.getTlfFijo());
		textFieldMovil.setText(modelo.getTlfMovil());
		textFieldEmail.setText(modelo.getEmail());
		textFieldFax.setText(modelo.getFax());
		
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

	public String getTextApellidos() {
		return textApellidos.getText();
	}

	public String getTextDNI() {
		return textDNI.getText();
	}

	public String getTextFieldCP() {
		return textFieldCP.getText();
	}

	public String getComboBoxPersona() {
		return (String) comboBoxPersona.getSelectedItem();
	}

	public String getCheckboxEscrituras() {
		if(checkboxEscrituras.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setCheckboxEscrituras(JCheckBox checkboxEscrituras) {
		this.checkboxEscrituras = checkboxEscrituras;
	}

	public String getCheckBoxPlanos() {
		if(checkBoxPlanos.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setCheckBoxPlanos(JCheckBox checkBoxPlanos) {
		this.checkBoxPlanos = checkBoxPlanos;
	}

	public String getCheckBoxLicenciaAnt() {
		if(checkBoxLicenciaAnt.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setCheckBoxLicenciaAnt(JCheckBox checkBoxLicenciaAnt) {
		this.checkBoxLicenciaAnt = checkBoxLicenciaAnt;
	}

	public String getCheckBoxNumExpediente() {
		if(checkBoxNumExpediente.isSelected()){
			return "SI";
		}
		return "NO";
	}

	public void setCheckBoxNumExpediente(JCheckBox checkBoxNumExpediente) {
		this.checkBoxNumExpediente = checkBoxNumExpediente;
	}

	

	



}