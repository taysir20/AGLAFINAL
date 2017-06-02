package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Point;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import controlador.CImplementacionControl;
import modelo.MImplementacion;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class VCambioDatosLicencia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRefCatastral;
	private JTextField textFieldEmplazamiento;
	private JTextField textFieldRegistro;
	private JTextField textFieldFechaSolicitud;
	private CImplementacionControl controlador;
	private MImplementacion modelo;
	private JDateChooser dateChooserInicioActividad;
	private JComboBox comboBoxTipoSuelo;
	private JCheckBox checkBoxFotocopiaDni;
	private JCheckBox checkBoxFotocopiaImpuestos;
	private JCheckBox checkBoxFotografias;
	private JCheckBox checkBoxFotocopiaEscrituras;
	private JCheckBox checkBoxJustificantePago;
	private JCheckBox checkBoxOtrasAutorizaciones;
	private JCheckBox checkBoxCertificadoModelo2;
	private JCheckBox checkBoxCertificadoModelo1;
	private JCheckBox checkBoxFotocopiaLicencia;
	private JCheckBox checkBoxPlanosLocal;
	private JCheckBox checkBoxMemoria;
	private JTextPane textPaneDescripcion;
	private JComboBox comboBoxTipoDeActividad;
	private JComboBox comboBoxEstadoLicencia;
	private Date fecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCambioDatosLicencia frame = new VCambioDatosLicencia();
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
	public VCambioDatosLicencia() {
		setTitle("MODIFICAR DATOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VCambioDatosLicencia.class.getResource("/GestionLicencias/IMG/386px-Escudo-torrijos.svg.png")));
		setBounds(100, 100, 837, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(176, 196, 222));
		contentPane.add(panel, BorderLayout.CENTER);

		JButton button = new JButton("CANCELAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(VCambioDatosLicencia.class.getResource("/GestionLicencias/IMG/cancel.png")));
		button.setHorizontalAlignment(SwingConstants.RIGHT);

		textFieldRefCatastral = new JTextField();
		textFieldRefCatastral.setBackground(Color.LIGHT_GRAY);
		textFieldRefCatastral.setEditable(false);

		textFieldRefCatastral.setColumns(10);

		JLabel lblReferenciaCatastral = new JLabel("REFERENCIA CATASTRAL");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "SELECCIONE LA DOCUMENTACI\u00D3N NECESARIA APORTADA",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(248, 248, 255));

		checkBoxFotocopiaDni = new JCheckBox("FOTOCOPIA DNI/NIF/CIF");
		checkBoxFotocopiaDni.setForeground(Color.BLACK);
		checkBoxFotocopiaDni.setBackground(new Color(248, 248, 255));

		checkBoxFotografias = new JCheckBox("FOTOGRAF\u00CDAS (EXTERIORES E INTERIORES)");
		checkBoxFotografias.setBackground(new Color(248, 248, 255));

		checkBoxJustificantePago = new JCheckBox("JUSTIFICANTE DE PAGO");
		checkBoxJustificantePago.setBackground(new Color(248, 248, 255));

		checkBoxFotocopiaImpuestos = new JCheckBox("FOTOCOPIA IMPUESTOS DE ACTIVIDAD");
		checkBoxFotocopiaImpuestos.setBackground(new Color(248, 248, 255));

		checkBoxFotocopiaEscrituras = new JCheckBox("FOTOCOPIA ESCRITURAS");
		checkBoxFotocopiaEscrituras.setBackground(new Color(248, 248, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 417, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBoxFotocopiaDni, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 377,
										Short.MAX_VALUE)
								.addComponent(checkBoxFotografias, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(checkBoxJustificantePago, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(checkBoxFotocopiaImpuestos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										377, Short.MAX_VALUE)
								.addComponent(checkBoxFotocopiaEscrituras, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										377, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 175, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE)
						.addComponent(checkBoxFotocopiaDni).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBoxFotocopiaImpuestos).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBoxFotografias).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBoxFotocopiaEscrituras).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBoxJustificantePago).addGap(14)));
		panel_1.setLayout(gl_panel_1);

		JButton button_1 = new JButton("SIGUIENTE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.actualizarDatosLicencia();
				JOptionPane.showMessageDialog(null, "Petición procesada");
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(VCambioDatosLicencia.class.getResource("/GestionLicencias/IMG/next.png")));
		button_1.setLocation(new Point(20, 400));
		button_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_1 = new JLabel("*Campos Obligatorios");
		label_1.setForeground(Color.BLACK);

		JLabel label_2 = new JLabel("N\u00BA REGISTRO");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);

		textFieldEmplazamiento = new JTextField();
		textFieldEmplazamiento.setBackground(Color.LIGHT_GRAY);
		textFieldEmplazamiento.setEditable(false);
		textFieldEmplazamiento.setColumns(10);

		JLabel lblTipoDeSuelo = new JLabel("TIPO DE SUELO");

		comboBoxTipoSuelo = new JComboBox();
		comboBoxTipoSuelo.setForeground(Color.BLACK);
		comboBoxTipoSuelo.setBackground(Color.LIGHT_GRAY);
		comboBoxTipoSuelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipoSuelo.setEnabled(false);
		comboBoxTipoSuelo.setModel(new DefaultComboBoxModel(new String[] { "", "RURAL", "URBANO" }));

		JLabel lblEmplazamientolugar = new JLabel("EMPLAZAMIENTO/LUGAR");

		JLabel label_5 = new JLabel("FECHA INICIO ACTIVIDAD");

		dateChooserInicioActividad = new JDateChooser();
		dateChooserInicioActividad.setDateFormatString("dd/MM/yyyy");
		dateChooserInicioActividad.setBackground(Color.LIGHT_GRAY);

		textFieldRegistro = new JTextField();
		textFieldRegistro.setBackground(Color.LIGHT_GRAY);
		textFieldRegistro.setForeground(Color.BLACK);
		textFieldRegistro.setEditable(false);
		textFieldRegistro.setColumns(10);

		JLabel lblFechaSolicitud = new JLabel("FECHA SOLICITUD");

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"SELECCIONE LA DOCUMENTACI\u00D3N T\u00C9CNICA APORTADA", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBackground(new Color(248, 248, 255));

		checkBoxMemoria = new JCheckBox("MEMORIA DE LA ACTIVIDAD");
		checkBoxMemoria.setBackground(new Color(248, 248, 255));

		checkBoxPlanosLocal = new JCheckBox("PLANOS DEL LOCAL");
		checkBoxPlanosLocal.setBackground(new Color(248, 248, 255));

		checkBoxFotocopiaLicencia = new JCheckBox("FOTOCOPIA LICENCIA OBRA DE ADAPTACI\u00D3N ");
		checkBoxFotocopiaLicencia.setBackground(new Color(248, 248, 255));

		checkBoxCertificadoModelo1 = new JCheckBox("CERTIFICADO MODELO T\u00C9CNICO ");
		checkBoxCertificadoModelo1.setBackground(new Color(248, 248, 255));

		checkBoxOtrasAutorizaciones = new JCheckBox("OTRAS AUTORIZACIONES ");
		checkBoxOtrasAutorizaciones.setBackground(new Color(248, 248, 255));

		checkBoxCertificadoModelo2 = new JCheckBox("CERTIFICADO DEL COLEGIO ORIGINAL MODELO 2 ");
		checkBoxCertificadoModelo2.setBackground(new Color(248, 248, 255));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGap(0, 424, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBoxMemoria, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(checkBoxPlanosLocal, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(checkBoxFotocopiaLicencia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										384, Short.MAX_VALUE)
								.addComponent(checkBoxCertificadoModelo1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										384, Short.MAX_VALUE)
								.addComponent(checkBoxOtrasAutorizaciones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										384, Short.MAX_VALUE)
								.addComponent(checkBoxCertificadoModelo2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										384, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGap(0, 175, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(checkBoxMemoria)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkBoxPlanosLocal)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkBoxFotocopiaLicencia)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkBoxCertificadoModelo1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkBoxCertificadoModelo2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkBoxOtrasAutorizaciones)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JLabel lblTipoDeActividad = new JLabel("TIPO DE ACTIVIDAD");

		JLabel label_8 = new JLabel("DESCRIPCI\u00D3N ACTIVIDAD");

		textPaneDescripcion = new JTextPane();

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ESTADO SOLICITUD",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(240, 248, 255));

		comboBoxEstadoLicencia = new JComboBox();
		comboBoxEstadoLicencia
				.setModel(new DefaultComboBoxModel(new String[] { "", "EN TRAMITE", "ACEPTADA", "DENEGADA" }));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(comboBoxEstadoLicencia, 0, 384, Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING).addGap(0, 69, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(comboBoxEstadoLicencia,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_3.setLayout(gl_panel_3);

		comboBoxTipoDeActividad = new JComboBox();
		comboBoxTipoDeActividad.setBackground(Color.LIGHT_GRAY);
		comboBoxTipoDeActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipoDeActividad.setEnabled(false);
		comboBoxTipoDeActividad.setForeground(Color.BLACK);
		comboBoxTipoDeActividad.setModel(new DefaultComboBoxModel(new String[] { "", "SUELO CALIFICADO COMO INDUSTRIAL",
				"SUELO URBANO NO CALIFICADO COMO INDUSTRIAL", "CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS",
				"SEGUROS, CAJA DE PENSIONES", "BARES, CAFETERIAS, RESTAURANTES", "SALONES RECREATIVOS Y DE JUEGO",
				"ESTABLECIMIENTOS, SECTOR ALIMENTICIO", "HOTELES,HOSTALES Y PENSIONES", "TERRAZAS DE VERANO",
				"GASOLINERAS" }));

		textFieldFechaSolicitud = new JTextField();
		textFieldFechaSolicitud.setBackground(Color.LIGHT_GRAY);
		textFieldFechaSolicitud.setEditable(false);
		textFieldFechaSolicitud.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING).addComponent(button, Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel
										.createSequentialGroup().addGroup(gl_panel
												.createParallelGroup(
														Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addGap(15).addGroup(gl_panel
														.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lblReferenciaCatastral)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(button_1)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(label_1, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addComponent(textFieldRefCatastral).addComponent(panel_1,
																GroupLayout.PREFERRED_SIZE, 358,
																GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 58,
																Short.MAX_VALUE))
												.addGroup(gl_panel.createSequentialGroup().addGap(13).addGroup(gl_panel
														.createParallelGroup(Alignment.LEADING).addComponent(label_2)
														.addComponent(textFieldEmplazamiento, 345, 362, Short.MAX_VALUE)
														.addComponent(lblTipoDeSuelo)
														.addComponent(comboBoxTipoSuelo, 0, 362, Short.MAX_VALUE)
														.addComponent(lblEmplazamientolugar)
														.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(label_5)
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(dateChooserInicioActividad,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(textFieldRegistro,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 165,
																				Short.MAX_VALUE)))
																.addGap(46).addGroup(
																		gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(textFieldFechaSolicitud,
																						GroupLayout.DEFAULT_SIZE, 151,
																						Short.MAX_VALUE)
																				.addComponent(lblFechaSolicitud,
																						GroupLayout.DEFAULT_SIZE, 103,
																						Short.MAX_VALUE))))
														.addGap(56)))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
												.addComponent(lblTipoDeActividad).addComponent(label_8)
												.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(
														textPaneDescripcion, GroupLayout.DEFAULT_SIZE, 355,
														Short.MAX_VALUE))
												.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
												.addComponent(comboBoxTipoDeActividad, 0, 357, Short.MAX_VALUE))))
						.addGap(21)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(14)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_5).addComponent(
								lblFechaSolicitud, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldFechaSolicitud, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooserInicioActividad, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblTipoDeSuelo)
						.addComponent(lblTipoDeActividad))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxTipoSuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTipoDeActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblEmplazamientolugar)
						.addComponent(label_8))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(textFieldEmplazamiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblReferenciaCatastral).addGap(10)
						.addComponent(textFieldRefCatastral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addComponent(textPaneDescripcion, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
				.addContainerGap()));
		panel.setLayout(gl_panel);
	}

	public void setControlador(CImplementacionControl cImplementacionControl) {
		this.controlador = cImplementacionControl;

	}

	public void setModelo(MImplementacion modelo) {
		this.modelo = modelo;

	}

	public void devolverDatosDeLicencia() {
		
		if(!modelo.getFechaInicioActividadCambioDatos().equals("") || modelo.getFechaInicioActividadCambioDatos()!=null){
			SimpleDateFormat formato= new java.text.SimpleDateFormat("dd/MM/yyyy");
			fecha = new Date();
			try {
				
				fecha=formato.parse(modelo.getFechaInicioActividadCambioDatos());
				dateChooserInicioActividad.setDate(fecha);
				dateChooserInicioActividad.setEnabled(false);
			} catch (ParseException e) {
				fecha=null;
				dateChooserInicioActividad.setEnabled(true);
				dateChooserInicioActividad.setDate(fecha);
				
				
			}
			
		}else if(modelo.getFechaInicioActividadCambioDatos().equals("") || modelo.getFechaInicioActividadCambioDatos()==null){
			System.out.println("hola jorge");
			
			
		}
		
		
		
		textFieldRegistro.setText(modelo.getRegistroCambioDatos());
		textFieldFechaSolicitud.setText(modelo.getFechaSolicitudCambioDatos());
		comboBoxTipoSuelo.setSelectedItem(modelo.getTipoDeSueloCambioDatos());
		textFieldEmplazamiento.setText(modelo.getEmplazamientoCambioDatos());
		textFieldRefCatastral.setText(modelo.getReferenciaCatastralCambioDatos());
		comboBoxEstadoLicencia.setSelectedItem(modelo.getEstadoSolicitudCambioDatos());
		comboBoxTipoDeActividad.setSelectedItem(modelo.getTipoDeActividadCambioDatos());
		textPaneDescripcion.setText(modelo.getDescripcionActividadCambioDatos());
		
		
		if (modelo.getFotocopiaDNICambioDatos().equalsIgnoreCase("SI")) {
			checkBoxFotocopiaDni.setSelected(true);
		} else if (modelo.getFotocopiaDNICambioDatos().equalsIgnoreCase("NO")) {
			checkBoxFotocopiaDni.setSelected(false);
		}
		if (modelo.getFotocopiaImpuestosCambioDatos().equalsIgnoreCase("SI")) {
			checkBoxFotocopiaImpuestos.setSelected(true);
		} else if (modelo.getFotocopiaImpuestosCambioDatos().equalsIgnoreCase("NO")) {
			checkBoxFotocopiaImpuestos.setSelected(false);
		}
		if (modelo.getFotografiasCambioDatos().equalsIgnoreCase("SI")) {
			checkBoxFotografias.setSelected(true);
		} else if (modelo.getFotografiasCambioDatos().equalsIgnoreCase("NO")) {
			checkBoxFotografias.setSelected(false);
		}
		if(modelo.getFotocopiaEscriturasCambioDatos().equalsIgnoreCase("SI")){
			checkBoxFotocopiaEscrituras.setSelected(true);
		}else if(modelo.getFotocopiaEscriturasCambioDatos().equalsIgnoreCase("NO")){
			checkBoxFotocopiaEscrituras.setSelected(false);
		}
		if(modelo.getJustificantePagoCambioDatos().equalsIgnoreCase("SI")){
			checkBoxJustificantePago.setSelected(true);
		}else if(modelo.getJustificantePagoCambioDatos().equalsIgnoreCase("NO")){
			checkBoxJustificantePago.setSelected(false);
		}
		if(modelo.getMemoriaActividadCambioDatos().equalsIgnoreCase("SI")){
			checkBoxMemoria.setSelected(true);
		}else if(modelo.getMemoriaActividadCambioDatos().equalsIgnoreCase("NO")){
			checkBoxMemoria.setSelected(false);
		}
		if(modelo.getPlanosDeLocalCambioDatos().equalsIgnoreCase("SI")){
			checkBoxPlanosLocal.setSelected(true);
		}else if(modelo.getPlanosDeLocalCambioDatos().equalsIgnoreCase("NO")){
			checkBoxPlanosLocal.setSelected(false);
		}
		if(modelo.getFotocopiaObraCambioDatos().equalsIgnoreCase("SI")){
			checkBoxFotocopiaLicencia.setSelected(true);
		}else if(modelo.getFotocopiaObraCambioDatos().equalsIgnoreCase("NO")){
			checkBoxFotocopiaLicencia.setSelected(false);
		}
		if(modelo.getCertificadoModelo1CambioDatos().equalsIgnoreCase("SI")){
			checkBoxCertificadoModelo1.setSelected(true);
		}else if(modelo.getCertificadoModelo1CambioDatos().equalsIgnoreCase("NO")){
			checkBoxCertificadoModelo1.setSelected(false);
		}
		if(modelo.getCertificadoModelo2CambioDatos().equalsIgnoreCase("SI")){
			checkBoxCertificadoModelo2.setSelected(true);
		}else if(modelo.getCertificadoModelo2CambioDatos().equalsIgnoreCase("NO")){
			checkBoxCertificadoModelo2.setSelected(false);
		}
		if(modelo.getOtrasAutorizacionesCambioDatos().equalsIgnoreCase("SI")){
			checkBoxOtrasAutorizaciones.setSelected(true);
		}else if(modelo.getOtrasAutorizacionesCambioDatos().equalsIgnoreCase("NO")){
			checkBoxOtrasAutorizaciones.setSelected(false);
		}
		
	}

	public String getCheckBoxFotocopiaDni() {
		if(checkBoxFotocopiaDni.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}


	public String getCheckBoxFotocopiaImpuestos() {
		if(checkBoxFotocopiaImpuestos.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		 
	}

	
	public String getCheckBoxFotografias() {
		if(checkBoxFotografias.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	
	public String getCheckBoxFotocopiaEscrituras() {
		if(checkBoxFotocopiaEscrituras.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	public String getCheckBoxJustificantePago() {
		if(checkBoxJustificantePago.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	public String getCheckBoxOtrasAutorizaciones() {
		if(checkBoxOtrasAutorizaciones.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}


	public String getCheckBoxCertificadoModelo2() {
		if(checkBoxCertificadoModelo2.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	
	public String getCheckBoxCertificadoModelo1() {
		if(checkBoxCertificadoModelo1.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	public String getCheckBoxFotocopiaLicencia() {
		if(checkBoxFotocopiaLicencia.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}

	public String getCheckBoxPlanosLocal() {
		if(checkBoxPlanosLocal.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}


	public String getCheckBoxMemoria() {
		if(checkBoxMemoria.isSelected()){
			return "SI";
		}else{
			return "NO";
		}
		
	}


	public String getTextPaneDescripcion() {
		
		return textPaneDescripcion.getText();
	}


	public String getComboBoxEstadoLicencia() {
		return comboBoxEstadoLicencia.getSelectedItem().toString();
	}

	

	public String getDateChooserInicioActividad() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String date = formato.format(dateChooserInicioActividad.getDate());
		return date;
	}
	

	




	
	
}
