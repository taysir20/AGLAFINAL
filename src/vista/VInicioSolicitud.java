package vista;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.MImplementacion;
import modelo.Modelo;

import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class VInicioSolicitud extends JFrame implements Vista {

	private CImplementacionControl controlador;
	private MImplementacion modelo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRegistro;
	private JTextField refCatastral;
	private JTextField emplazamiento;
	private JDateChooser fechaInicioSolicitud;
	private JDateChooser fechaSolicitud;
	private JComboBox estadoSolicitud;
	private JComboBox tipoActividad;
	private JTextPane descripcionActividad;
	private JComboBox tipoSuelo;
	private JCheckBox checkDNI;
	private JCheckBox checkImpuestos;
	private JCheckBox checkColegio;
	private JCheckBox checkModeloTecnico;
	private JCheckBox checkFotocopiaObra;
	private JCheckBox checkPlanosLocal;
	private JCheckBox checkMemoriaActividad;
	private JCheckBox checkJustificantePago;
	private JCheckBox checkEscrituras;
	private JCheckBox checkFotografias;
	private JCheckBox checkOtrasAutorizaciones;
	private JButton btnSiguiente;
	private JLabel lblcamposObligatorios;
	private JLabel lblRefCatastral;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicioSolicitud frame = new VInicioSolicitud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * Create the frame.
	 */
	public VInicioSolicitud() {
		setLocation(new Point(100, 200));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VInicioSolicitud.class.getResource("/GestionLicencias/IMG/386px-Escudo-torrijos.svg.png")));
		setTitle("INICIO SOLICITUD DE LICENCIA/ ACTIVIDAD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);

		JLabel lblNRegistro = new JLabel("N\u00BA REGISTRO");
		lblNRegistro.setHorizontalAlignment(SwingConstants.LEFT);

		textRegistro = new JTextField();
		textRegistro.setEditable(false);
		textRegistro.setForeground(Color.LIGHT_GRAY);
		textRegistro.setColumns(10);

		JLabel lblNewLabel = new JLabel("FECHA SOLICITUD*");

		JLabel lblFecha = new JLabel("FECHA INICIO ACTIVIDAD");

		fechaSolicitud = new JDateChooser();
		fechaSolicitud.setDateFormatString("dd/MM/yyyy");

		JLabel lblTipoSolicitud = new JLabel("TIPO DE ACTIVIDAD*");

		tipoActividad = new JComboBox();
		tipoActividad.setModel(new DefaultComboBoxModel(new String[] {"", "SUELO CALIFICADO COMO INDUSTRIAL", "SUELO URBANO NO CALIFICADO COMO INDUSTRIAL", "CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS", "SEGUROS, CAJA DE PENSIONES", "BARES, CAFETERIAS, RESTAURANTES", "SALONES RECREATIVOS Y DE JUEGO", "ESTABLECIMIENTOS, SECTOR ALIMENTICIO", "HOTELES,HOSTALES Y PENSIONES", "TERRAZAS DE VERANO", "GASOLINERAS"}));

		JLabel lblDescripcinActividad = new JLabel("DESCRIPCI\u00D3N ACTIVIDAD");

		JLabel lblEmplazamientolugar = new JLabel("EMPLAZAMIENTO/LUGAR*");

		refCatastral = new JTextField();
		refCatastral.setColumns(10);

		emplazamiento = new JTextField();
		emplazamiento.setColumns(10);

		lblRefCatastral = new JLabel("REFERENCIA CATASTRAL*");

		fechaInicioSolicitud = new JDateChooser();
		fechaInicioSolicitud.setEnabled(false);
		fechaInicioSolicitud.setBackground(Color.LIGHT_GRAY);
		fechaInicioSolicitud.getCalendarButton().setEnabled(false);
		fechaInicioSolicitud.setDateFormatString("yyyy-MM-dd");

		JLabel lblNewLabel_3 = new JLabel("TIPO DE SUELO*");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ESTADO INICIAL SOLICITUD",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBorder(new TitledBorder(null, "SELECCIONE LA DOCUMENTACI\u00D3N NECESARIA APORTADA",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"SELECCIONE LA DOCUMENTACI\u00D3N T\u00C9CNICA APORTADA", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setLocation(new Point(20, 400));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fechaSolicitud.getDate() != null && (String) tipoSuelo.getSelectedItem() != ""
						&& (String) tipoActividad.getSelectedItem() != "" && !emplazamiento.getText().isEmpty()
						&& !refCatastral.getText().isEmpty()) {
					try {
						int number=Integer.parseInt(refCatastral.getText());
						controlador.recogerDatosInicioSolicitud();
						controlador.cambiarPantallaRegistroPersona();
						dispose();
					    
					}
					catch (NumberFormatException e1) {
						
						lblcamposObligatorios.setText("El campo Referencia Catastral ha de ser un número");
						lblcamposObligatorios.setForeground(Color.RED);
						lblRefCatastral.setForeground(Color.RED);
						
						
					}
					

				} else {
					lblcamposObligatorios.setText("Rellena los campos con asterisco");
					lblcamposObligatorios.setForeground(Color.RED);
				}

			}
		});
		btnSiguiente.setIcon(new ImageIcon(VInicioSolicitud.class.getResource("/GestionLicencias/IMG/next.png")));
		btnSiguiente.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnCancelar, "¿Desea cancelar Solicitud?",
						"CANCELAR SOLICITUD TRAMITE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					dispose();
				// System.exit(0); cierra totalmente la aplicación
				// dispose cierra la ventana en la que nos encontramos y no
				// funciona cuando se llama desde otra método en otra clase

			}
		});
		btnCancelar.setIcon(new ImageIcon(VInicioSolicitud.class.getResource("/GestionLicencias/IMG/cancel.png")));
		btnCancelar.setHorizontalAlignment(SwingConstants.RIGHT);

		descripcionActividad = new JTextPane();

		tipoSuelo = new JComboBox();
		tipoSuelo.setModel(new DefaultComboBoxModel(new String[] { "", "RURAL", "URBANO" }));

		lblcamposObligatorios = new JLabel("*Campos Obligatorios");
		lblcamposObligatorios.setForeground(Color.BLACK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 134,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane
								.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane
												.createSequentialGroup().addGap(15).addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING, false)
														.addComponent(refCatastral).addComponent(lblRefCatastral)
														.addComponent(panel_1, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(gl_contentPane
																.createSequentialGroup().addComponent(btnSiguiente)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(
																		lblcamposObligatorios, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(13)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNRegistro)
														.addComponent(emplazamiento, 345, 428, Short.MAX_VALUE)
														.addComponent(lblNewLabel_3)
														.addComponent(tipoSuelo, 0, 428, Short.MAX_VALUE)
														.addComponent(lblEmplazamientolugar)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblFecha)
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.TRAILING,
																						false)
																				.addComponent(fechaInicioSolicitud,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(textRegistro,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 165,
																						Short.MAX_VALUE)))
																.addGap(94)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel,
																				GroupLayout.DEFAULT_SIZE, 169,
																				Short.MAX_VALUE)
																		.addComponent(fechaSolicitud,
																				GroupLayout.DEFAULT_SIZE, 169,
																				Short.MAX_VALUE))))
												.addGap(56)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
										.addComponent(lblTipoSolicitud).addComponent(lblDescripcinActividad)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(
												descripcionActividad, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
										.addComponent(tipoActividad, 0, 424, Short.MAX_VALUE))))
				.addGap(21)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(14).addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNRegistro, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFecha))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(fechaInicioSolicitud, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(fechaSolicitud, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(lblTipoSolicitud))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tipoSuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tipoActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(12)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmplazamientolugar).addComponent(lblDescripcinActividad))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(emplazamiento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblRefCatastral)
										.addGap(10).addComponent(refCatastral, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(descripcionActividad, GroupLayout.PREFERRED_SIZE, 94,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSiguiente, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblcamposObligatorios))
						.addContainerGap()));

		checkMemoriaActividad = new JCheckBox("MEMORIA DE LA ACTIVIDAD");
		checkMemoriaActividad.setBackground(new Color(248, 248, 255));

		checkPlanosLocal = new JCheckBox("PLANOS DEL LOCAL");
		checkPlanosLocal.setBackground(new Color(248, 248, 255));

		checkFotocopiaObra = new JCheckBox("FOTOCOPIA LICENCIA OBRA DE ADAPTACI\u00D3N ");
		checkFotocopiaObra.setBackground(new Color(248, 248, 255));

		checkModeloTecnico = new JCheckBox("CERTIFICADO MODELO T\u00C9CNICO ");
		checkModeloTecnico.setBackground(new Color(248, 248, 255));

		checkColegio = new JCheckBox("CERTIFICADO DEL COLEGIO ORIGINAL MODELO 2 ");
		checkColegio.setBackground(new Color(248, 248, 255));

		checkOtrasAutorizaciones = new JCheckBox("OTRAS AUTORIZACIONES ");
		checkOtrasAutorizaciones.setBackground(new Color(248, 248, 255));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(checkMemoriaActividad, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
								.addComponent(checkPlanosLocal, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
								.addComponent(checkFotocopiaObra, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 381,
										Short.MAX_VALUE)
								.addComponent(checkModeloTecnico, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 381,
										Short.MAX_VALUE)
								.addComponent(checkOtrasAutorizaciones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										381, Short.MAX_VALUE)
								.addComponent(checkColegio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 381,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(checkMemoriaActividad)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkPlanosLocal)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkFotocopiaObra)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkModeloTecnico)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkColegio)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkOtrasAutorizaciones)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		checkDNI = new JCheckBox("FOTOCOPIA DNI/NIF/CIF");
		checkDNI.setBackground(new Color(248, 248, 255));
		checkDNI.setForeground(new Color(0, 0, 0));

		checkImpuestos = new JCheckBox("FOTOCOPIA IMPUESTOS DE ACTIVIDAD");
		checkImpuestos.setBackground(new Color(248, 248, 255));

		checkFotografias = new JCheckBox("FOTOGRAF\u00CDAS (EXTERIORES E INTERIORES)");
		checkFotografias.setBackground(new Color(248, 248, 255));

		checkEscrituras = new JCheckBox("FOTOCOPIA ESCRITURAS");
		checkEscrituras.setBackground(new Color(248, 248, 255));

		checkJustificantePago = new JCheckBox("JUSTIFICANTE DE PAGO");
		checkJustificantePago.setBackground(new Color(248, 248, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(checkDNI, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(checkFotografias, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(checkJustificantePago, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(checkImpuestos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 377,
								Short.MAX_VALUE)
						.addComponent(checkEscrituras, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 377,
								Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE).addComponent(checkDNI)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkImpuestos)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkFotografias)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkEscrituras)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(checkJustificantePago).addGap(14)));
		panel_1.setLayout(gl_panel_1);

		estadoSolicitud = new JComboBox();
		estadoSolicitud.setModel(new DefaultComboBoxModel(new String[] {"", "EN TRAMITE", "ACEPTADA", "DENEGADA"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(estadoSolicitud, 0, 379, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(estadoSolicitud,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = (CImplementacionControl) controlador;

	}

	public void setModelo(Modelo modelo) {
		this.modelo = (MImplementacion) modelo;

	}

	// Métodos para capturar los datos

	public String getRegistro() {
		return textRegistro.getText();
	}

	public String getFechaSolicitud() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String date = formato.format(fechaSolicitud.getDate());
		return date;

	}

	public String getEstadoSolicitud() {
		return (String) estadoSolicitud.getSelectedItem();

	}

	public String getTipoActividad() {
		return (String) tipoActividad.getSelectedItem();

	}

	public String getDescripcionActividad() {

		return descripcionActividad.getText();
	}

	public String getTipoSuelo() {
		return (String) tipoSuelo.getSelectedItem();
	}

	public String getEmplazamiento() {
		return emplazamiento.getText();

	}

	public String getReferenciaCatastral() {
		return refCatastral.getText();

	}

	public String getFechaInicioSolicitud() {
		if (fechaInicioSolicitud.getDate() == null) {
			String sinFecha = "";
			return sinFecha;
		}
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String date = formato.format(fechaInicioSolicitud.getDate());
		return date;

	}

	public String getCheckBoxDNI() {
		String seleccionado = "";
		if (checkDNI.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckImpuestosActividad() {
		String seleccionado = "";
		if (checkImpuestos.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckFotografias() {
		String seleccionado = "";
		if (checkFotografias.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckEscrituras() {
		String seleccionado = "";
		if (checkEscrituras.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckJustificantePago() {
		String seleccionado = "";
		if (checkJustificantePago.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckMemoriaActividad() {
		String seleccionado = "";
		if (checkMemoriaActividad.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckPlanosLocal() {
		String seleccionado = "";
		if (checkPlanosLocal.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckFotocopiaObra() {
		String seleccionado = "";
		if (checkFotocopiaObra.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckModeloTecnico() {
		String seleccionado = "";
		if (checkModeloTecnico.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckColegio() {
		String seleccionado = "";
		if (checkColegio.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	public String getCheckOtrasAutorizaciones() {
		String seleccionado = "";
		if (checkOtrasAutorizaciones.isSelected()) {
			seleccionado = "SI";
		} else {
			seleccionado = "NO";
		}
		return seleccionado;
	}

	// TODO
	@Override
	public void setControlador(CImplementacionControl controlador) {
		this.controlador = controlador;

	}

	public MImplementacion getModelo() {
		return modelo;
	}

	public void setModelo(MImplementacion modelo) {
		this.modelo = modelo;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}
}
