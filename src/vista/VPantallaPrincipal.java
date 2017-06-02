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
import javax.swing.table.TableRowSorter;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.MImplementacion;
import modelo.Modelo;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VPantallaPrincipal extends JFrame implements Vista{
	
	private CImplementacionControl micontrolador;
	private MImplementacion modelo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtfNombre;
	private JTextField txtfBuscaDni;
	private JTextField textFieldPersona;
	private JTextField textFieldRazonSocial;
	private JTextField textFieldDireccion;
	private JTextField textFieldMunicipio;
	private JTextField textFieldCif;
	private JTextField textFieldMovil;
	private JTextField textFieldCP;
	private JTextField textFieldEmail;
	private JTextField textFieldFijo;
	JTable table_persona;
	private JTextField txtfRegistro;
	private JTextField textCatastro;
	private JTable table_licencias;
	private JTextArea textDescripcion;
	private JTextField textActividad;
	private JTextField textInicioActividad;
	private JTextField textSolicitud;
	private JCheckBox checkBoxDNI;
	private JCheckBox checkBoxImpuesto;
	private JCheckBox checkBoxFotografia;
	private JCheckBox checkBoxLicenciaObra;
	private JCheckBox checkBoxEscrituras;
	private JCheckBox checkBoxMemoria;
	private JCheckBox checkBoxJustificantePago;
	private JCheckBox checkBoxOtras;
	private JCheckBox checkBoxCertificado1;
	private JCheckBox checkBoxCertificado2;
	private JCheckBox checkBoxPlanos;
	private JButton button_1;
	private JButton button_3;
	private TableRowSorter trsfiltro;
	private String dato;
	private String cadena;
	private TableRowSorter trsfiltro2;
	private JTextField textField;

	public VPantallaPrincipal(Modelo modelo, Controlador controlador){
		setResizable(false);
    	this.modelo=(MImplementacion) modelo;
    	micontrolador=(CImplementacionControl) controlador;
		
		setLocation(new Point(400, 50));
    	setState(Frame.ICONIFIED);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VPantallaPrincipal.class.getResource("/GestionLicencias/IMG/386px-Escudo-torrijos.svg.png")));
    	
 
        //Parametros asociados a la ventana
    	setSize(1058,876);
    	
        setTitle("A.G.L.A. (APLICATIVO GESTION DE LICENCIAS ADMINISTRATIVAS) Versi\u00F3n 1.0.0");
 
        //Creamos el conjunto de ppestanas
        JTabbedPane ppestanas=new JTabbedPane();
 
        JPanel panel2=new JPanel();
 
        ppestanas.addTab("POR REGISTRO DE PERSONAS", panel2);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        GroupLayout gl_panel2 = new GroupLayout(panel2);
        gl_panel2.setHorizontalGroup(
        	gl_panel2.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
        );
        gl_panel2.setVerticalGroup(
        	gl_panel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_3.setBackground(new Color(176, 196, 222));
        scrollPane_2.setViewportView(panel_3);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(248, 248, 255));
        panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BUSCADOR POR PERSONA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        JLabel label_3 = new JLabel("POR NOMBRE / APELLIDOS");
        label_3.setHorizontalAlignment(SwingConstants.LEFT);
        
//////////////////////////////filtros de busqueda////////////////////////////////
        txtfNombre = new JTextField();
        txtfNombre.addKeyListener(new KeyAdapter() {//////////////////////////////filtros por nombre////////////////////////////////
        	@Override
        	public void keyTyped(KeyEvent e) {
        		txtfNombre.addKeyListener(new KeyAdapter() {
        			public void keyReleased(final KeyEvent e) {
        			//String cadena = (txtfNombre.getText());
        			//txtfNombre.setText(cadena);
        			//repaint();
        			filtro2();
        			}
        			});
        			trsfiltro = new TableRowSorter(table_persona.getModel());
        			table_persona.setRowSorter(trsfiltro);
        		
        	}
        });
        txtfNombre.setColumns(10);
        
        txtfBuscaDni = new JTextField();
        txtfBuscaDni.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent arg0) {//////////////////////////////filtros por dni////////////////////////////////
        		
        		txtfBuscaDni.addKeyListener(new KeyAdapter() {
        			public void keyReleased(final KeyEvent e) {
        			String cadena = (txtfBuscaDni.getText());
        			txtfBuscaDni.setText(cadena);
        			repaint();
        			filtro();
        			}
        			});
        			trsfiltro = new TableRowSorter(table_persona.getModel());
        			table_persona.setRowSorter(trsfiltro);
        	}
        });
        txtfBuscaDni.setColumns(10);
        
        txtfRegistro = new JTextField();
        txtfRegistro.addKeyListener(new KeyAdapter() {//////////////////////////////filtros por registro////////////////////////////////
        	@Override
        	public void keyTyped(KeyEvent e) {
        		txtfRegistro.addKeyListener(new KeyAdapter() {
        			public void keyReleased(final KeyEvent e) {
        			
        			filtro3();
        			}
        			});
        
        			trsfiltro = new TableRowSorter(table_licencias.getModel());
        			table_licencias.setRowSorter(trsfiltro);
        		
        	}
        });
        txtfRegistro.setColumns(10);
        
        
        JLabel label_10 = new JLabel("POR D.N.I.");
        label_10.setHorizontalAlignment(SwingConstants.LEFT);
        label_10.setAlignmentX(0.5f);
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
        	gl_panel_4.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
        			.addGap(54)
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtfBuscaDni, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
        			.addGap(121))
        );
        gl_panel_4.setVerticalGroup(
        	gl_panel_4.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
        				.addComponent(label_3)
        				.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtfBuscaDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        panel_4.setLayout(gl_panel_4);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_5.setBackground(SystemColor.controlHighlight);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        
        JLabel label_11 = new JLabel("MUNICIPIO");
        
        textFieldPersona = new JTextField();
        textFieldPersona.setBackground(Color.LIGHT_GRAY);
        textFieldPersona.setEditable(false);
        textFieldPersona.setColumns(10);
        
        textFieldRazonSocial = new JTextField();
        textFieldRazonSocial.setBackground(Color.LIGHT_GRAY);
        textFieldRazonSocial.setEditable(false);
        textFieldRazonSocial.setColumns(10);
        
        JLabel label_12 = new JLabel("DIRECCI\u00D3N");
        
        textFieldDireccion = new JTextField();
        textFieldDireccion.setBackground(Color.LIGHT_GRAY);
        textFieldDireccion.setEditable(false);
        textFieldDireccion.setColumns(10);
        
        textFieldMunicipio = new JTextField();
        textFieldMunicipio.setBackground(Color.LIGHT_GRAY);
        textFieldMunicipio.setEditable(false);
        textFieldMunicipio.setColumns(10);
        
        JLabel label_13 = new JLabel("RAZ\u00D3N SOCIAL");
        
        JLabel lblTipoPersona = new JLabel("TIPO PERSONA");
        
        textFieldCif = new JTextField();
        textFieldCif.setBackground(Color.LIGHT_GRAY);
        textFieldCif.setEditable(false);
        textFieldCif.setColumns(10);
        
        textFieldMovil = new JTextField();
        textFieldMovil.setBackground(Color.LIGHT_GRAY);
        textFieldMovil.setEditable(false);
        textFieldMovil.setColumns(10);
        
        JLabel label_15 = new JLabel("TELF M\u00D3VIL");
        
        JLabel label_16 = new JLabel("CIF");
        
        textFieldCP = new JTextField();
        textFieldCP.setBackground(Color.LIGHT_GRAY);
        textFieldCP.setEditable(false);
        textFieldCP.setColumns(10);
        
        JLabel label_17 = new JLabel("C\u00D3DIGO POSTAL");
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBackground(Color.LIGHT_GRAY);
        textFieldEmail.setEditable(false);
        textFieldEmail.setColumns(10);
        
        textFieldFijo = new JTextField();
        textFieldFijo.setBackground(Color.LIGHT_GRAY);
        textFieldFijo.setEditable(false);
        textFieldFijo.setColumns(10);
        
        JLabel label_19 = new JLabel("TELF FIJO");
        
        JLabel label_20 = new JLabel("CORREO ELECTRONICO");
        
        JLabel label_21 = new JLabel("");
        
        JLabel label_22 = new JLabel("");
        
        JLabel label_23 = new JLabel("Aplicativo Gesti\u00F3n de Licencias y Actividades");
        label_23.setHorizontalAlignment(SwingConstants.LEFT);
        label_23.setForeground(Color.BLACK);
        label_23.setFont(new Font("Arial Black", Font.PLAIN, 16));
        
        JLabel label_24 = new JLabel("A.G.L.A.");
        label_24.setHorizontalAlignment(SwingConstants.LEFT);
        label_24.setForeground(Color.BLACK);
        label_24.setFont(new Font("Arial Black", Font.PLAIN, 24));
        
        JPanel panel_8 = new JPanel();
        panel_8.setForeground(Color.BLACK);
        panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MEN\u00DA TR\u00C1MITES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_8.setBackground(new Color(248, 248, 255));
        
        JButton button_5 = new JButton("INICIAR SOLICITUD");
        button_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		micontrolador.InicioSolicitud();
        	}
        });
        
        button_3 = new JButton("CAMBIO TITULARIDAD");
        button_3.setEnabled(false);
        button_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		micontrolador.cambiarPantallaCambioTitularidad();
        		
        		micontrolador.recogerRegistroCambio();
        		
        		
        	}
        });
        
        JButton button_7 = new JButton("MODELO CERTIFICADO PDF");
        button_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("src/GestionLicencias/IMG/declaracion_responsable.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException ex) {
                        // no application registered for PDFs
                    }
                }
        	}
        });
        
        JButton btnHistoricoCambioTitularidad = new JButton("HISTORICO CAMBIO TITULARIDAD");
        btnHistoricoCambioTitularidad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		micontrolador.cambioPantallaHistorico();
        	}
        });
        GroupLayout gl_panel_8 = new GroupLayout(panel_8);
        gl_panel_8.setHorizontalGroup(
        	gl_panel_8.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_8.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
        				.addComponent(button_5, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        				.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        				.addComponent(button_7, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        				.addComponent(btnHistoricoCambioTitularidad, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_panel_8.setVerticalGroup(
        	gl_panel_8.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_8.createSequentialGroup()
        			.addGap(6)
        			.addComponent(button_5)
        			.addGap(4)
        			.addComponent(button_3)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(button_7)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnHistoricoCambioTitularidad)
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        panel_8.setLayout(gl_panel_8);
        
        JLabel label_27 = new JLabel("");
        label_27.setIcon(new ImageIcon(VPantallaPrincipal.class.getResource("/GestionLicencias/IMG/Ayto.png")));
        GroupLayout gl_panel_5 = new GroupLayout(panel_5);
        gl_panel_5.setHorizontalGroup(
        	gl_panel_5.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_5.createSequentialGroup()
        			.addGap(10)
        			.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_5.createSequentialGroup()
        					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_5.createSequentialGroup()
        							.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_5.createSequentialGroup()
        							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_panel_5.createSequentialGroup()
        									.addGap(2)
        									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
        								.addComponent(label_12)
        								.addComponent(textFieldRazonSocial, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        								.addComponent(label_11)
        								.addComponent(lblTipoPersona, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textFieldPersona, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
        							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        								.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textFieldCif, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        								.addComponent(label_17))))
        					.addGap(18)
        					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        						.addComponent(label_20)
        						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(textFieldEmail)
        							.addComponent(label_15)
        							.addGroup(gl_panel_5.createSequentialGroup()
        								.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
        									.addComponent(label_19)
        									.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
        					.addGap(87))
        				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
        					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        gl_panel_5.setVerticalGroup(
        	gl_panel_5.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_5.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
        			.addGap(31)
        			.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
        				.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTipoPersona, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_15)
        				.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_19))
        			.addGap(7)
        			.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textFieldRazonSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldPersona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldCif, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldFijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
        				.addComponent(label_12)
        				.addComponent(label_11)
        				.addComponent(label_17)
        				.addComponent(label_20))
        			.addGap(6)
        			.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(76, Short.MAX_VALUE))
        );
        
        table_persona = new JTable();
       
       
        table_persona.addMouseListener(new MouseAdapter() {
        	 
     			

           
              	
        	@Override
        	public void mousePressed(MouseEvent me) {
        		 
        		 JTable table =(JTable) me.getSource();
                 Point p = me.getPoint();
                 int row = table.rowAtPoint(p);
                 if (me.getClickCount() == 2) {
                   micontrolador.cambioDatosLicencia();
                   micontrolador.recogerRegistro3Cambios();
                 }
        	}
        	
			
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		button_3.setEnabled(true);
        		micontrolador.recogerRegistro();
          		
        	}
        });
        
     
      datosTabla2();
        
        
        scrollPane_3.setViewportView(table_persona);
        panel_5.setLayout(gl_panel_5);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_panel_3.createSequentialGroup()
        							.addGap(6)
        							.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        							.addGap(6)
        							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        								.addComponent(label_23)
        								.addComponent(label_24))))
        					.addGap(122)
        					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        						.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_panel_3.createSequentialGroup()
        							.addGap(6)
        							.addComponent(label_23)
        							.addGap(6)
        							.addComponent(label_24)))
        					.addGap(6)
        					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGap(22)
        					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
        );
        panel_3.setLayout(gl_panel_3);
        panel2.setLayout(gl_panel2);
 
        getContentPane().add(ppestanas);
        
               //Creamos el panel y lo a�adimos a las ppestanas
               JPanel panel1=new JPanel();
               
                      //A�adimos un nombre de la pesta�a y el panel
                      ppestanas.addTab("POR REGISTRO DE LICENCIAS", panel1);
                      
                      JScrollPane scrollPane = new JScrollPane();
                      GroupLayout gl_panel1 = new GroupLayout(panel1);
                      gl_panel1.setHorizontalGroup(
                      	gl_panel1.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel1.createSequentialGroup()
                      			.addContainerGap()
                      			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                      			.addContainerGap())
                      );
                      gl_panel1.setVerticalGroup(
                      	gl_panel1.createParallelGroup(Alignment.TRAILING)
                      		.addGroup(Alignment.LEADING, gl_panel1.createSequentialGroup()
                      			.addContainerGap()
                      			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                      			.addContainerGap())
                      );
                      
                      JPanel panel = new JPanel();
                      panel.setBackground(new Color(176, 196, 222));
                      scrollPane.setViewportView(panel);
                      
                      JLabel label = new JLabel("");
                      
                      JScrollPane scrollPane_1 = new JScrollPane();
                      
                      JLabel label_1 = new JLabel("");
                      label_1.setIcon(new ImageIcon(VPantallaPrincipal.class.getResource("/GestionLicencias/IMG/Ayto.png")));
                      
                      JLabel label_2 = new JLabel("Aplicativo Gesti\u00F3n de Licencias y Actividades");
                      label_2.setHorizontalAlignment(SwingConstants.LEFT);
                      label_2.setForeground(Color.BLACK);
                      label_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
                      
                      JLabel label_4 = new JLabel("A.G.L.A.");
                      label_4.setHorizontalAlignment(SwingConstants.LEFT);
                      label_4.setForeground(Color.BLACK);
                      label_4.setFont(new Font("Arial Black", Font.PLAIN, 24));
                      
                      JPanel panel_1 = new JPanel();
                      panel_1.setForeground(Color.BLACK);
                      panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MEN\u00DA TR\u00C1MITES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
                      panel_1.setBackground(SystemColor.menu);
                      
                      JButton button = new JButton("INICIAR SOLICITUD");
                      button.addActionListener(new ActionListener() {
                      	public void actionPerformed(ActionEvent arg0) {
                      		micontrolador.InicioSolicitud();
                      	}
                      });
                      
                      button_1 = new JButton("CAMBIO TITULARIDAD");
                      button_1.setEnabled(false);
                      button_1.addActionListener(new ActionListener() {
                      	public void actionPerformed(ActionEvent e) {
                      		
                      		
                      		micontrolador.cambiarPantallaCambioTitularidad();
                      		micontrolador.recogerRegistroCambio2();
                      	}
                      });
                      
                      JButton button_2 = new JButton("MODELO CERTIFICADO PDF");
                      button_2.addActionListener(new ActionListener() {
                      	public void actionPerformed(ActionEvent e) {
                      		if (Desktop.isDesktopSupported()) {
                                try {
                                    File myFile = new File("src/GestionLicencias/IMG/declaracion_responsable.pdf");
                                    Desktop.getDesktop().open(myFile);
                                } catch (IOException ex) {
                                    // no application registered for PDFs
                                }
                            }
                    	
                      	}
                      });
                      
                      JButton btnHistoricoCambioTitularidad_1 = new JButton("HISTORICO CAMBIO TITULARIDAD");
                      btnHistoricoCambioTitularidad_1.addActionListener(new ActionListener() {
                      	public void actionPerformed(ActionEvent e) {
                      		
                      		micontrolador.cambioPantallaHistorico();
                      	}
                      });
                      GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                      gl_panel_1.setHorizontalGroup(
                      	gl_panel_1.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel_1.createSequentialGroup()
                      			.addContainerGap()
                      			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                      				.addComponent(button, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                      				.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                      				.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                      				.addComponent(btnHistoricoCambioTitularidad_1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                      			.addContainerGap())
                      );
                      gl_panel_1.setVerticalGroup(
                      	gl_panel_1.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel_1.createSequentialGroup()
                      			.addGap(6)
                      			.addComponent(button)
                      			.addGap(4)
                      			.addComponent(button_1)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addComponent(button_2)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addComponent(btnHistoricoCambioTitularidad_1)
                      			.addContainerGap(13, Short.MAX_VALUE))
                      );
                      panel_1.setLayout(gl_panel_1);
                      
                      JPanel panel_2 = new JPanel();
                      panel_2.setBorder(new TitledBorder(null, "BUSCADOR POR REGISTRO / LICENCIA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                      
                      
                      
                      JLabel label_5 = new JLabel("POR N\u00BA DE REGISTRO");
                      label_5.setHorizontalAlignment(SwingConstants.LEFT);
                      
                      JLabel label_6 = new JLabel("CLASIFICAR POR TIPO DE LICENCIA");
                      label_6.setHorizontalAlignment(SwingConstants.LEFT);
                      label_6.setAlignmentX(0.5f);
                      
                      textField = new JTextField();
                      textField.addKeyListener(new KeyAdapter() {
                      	@Override
                      	public void keyTyped(KeyEvent e) {
                      		trsfiltro2 = new TableRowSorter(table_licencias.getModel());
                  			table_licencias.setRowSorter(trsfiltro2);
                      		filtro4();
                      		
                      	}
                      });
                      
                     
                      textField.setColumns(10);
                      GroupLayout gl_panel_2 = new GroupLayout(panel_2);
                      gl_panel_2.setHorizontalGroup(
                      	gl_panel_2.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel_2.createSequentialGroup()
                      			.addContainerGap()
                      			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
                      				.addComponent(txtfRegistro)
                      				.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                      			.addGap(36)
                      			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
                      				.addGroup(gl_panel_2.createSequentialGroup()
                      					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                      					.addGap(75))
                      				.addGroup(gl_panel_2.createSequentialGroup()
                      					.addComponent(textField)
                      					.addContainerGap())))
                      );
                      gl_panel_2.setVerticalGroup(
                      	gl_panel_2.createParallelGroup(Alignment.TRAILING)
                      		.addGap(0, 64, Short.MAX_VALUE)
                      		.addGroup(gl_panel_2.createSequentialGroup()
                      			.addContainerGap(9, Short.MAX_VALUE)
                      			.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                      				.addComponent(label_5))
                      			.addGap(3)
                      			.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(txtfRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                      			.addContainerGap())
                      );
                      panel_2.setLayout(gl_panel_2);
                      
                      JPanel panel_6 = new JPanel();
                      panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                      panel_6.setBackground(new Color(211, 211, 211));
                      
                      JScrollPane scrollPane_4 = new JScrollPane();
                      scrollPane_4.addMouseListener(new MouseAdapter() {
                      	
                      	
                      });
                      
                      JLabel label_7 = new JLabel("Descripci\u00F3n de la Actividad");
                      
                      JLabel label_8 = new JLabel("Tipo de Actividad");
                      
                      JLabel label_9 = new JLabel("Referencia Catastral");
                      
                      textCatastro = new JTextField();
                      textCatastro.setEditable(false);
                      textCatastro.setBackground(Color.LIGHT_GRAY);
                      textCatastro.setColumns(10);
                      
                      JLabel label_25 = new JLabel("FECHA INICIO ACTIVIDAD");
                      
                      JLabel label_26 = new JLabel("FECHA SOLICITUD");
                      
                      JScrollPane scrollPane_5 = new JScrollPane();
                      
                      JPanel panel_7 = new JPanel();
                      panel_7.setBorder(new TitledBorder(null, "Documentaci\u00F3n Aportada por: TITULAR", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                      panel_7.setBackground(new Color(0, 51, 102));
                      
                      checkBoxDNI = new JCheckBox("Fotocopia DNI/NIE/CIF");
                      checkBoxDNI.setForeground(new Color(255, 255, 255));
                      checkBoxDNI.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxDNI.setEnabled(false);
                      checkBoxDNI.setBackground(new Color(0, 51, 102));
                      
                      checkBoxImpuesto = new JCheckBox("Fotocopia Impuesto Actividades");
                      checkBoxImpuesto.setForeground(new Color(255, 255, 255));
                      checkBoxImpuesto.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxImpuesto.setEnabled(false);
                      checkBoxImpuesto.setBackground(new Color(0, 51, 102));
                      
                      checkBoxFotografia = new JCheckBox("Fotografia (interiores/exteriores)");
                      checkBoxFotografia.setForeground(new Color(255, 255, 255));
                      checkBoxFotografia.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxFotografia.setEnabled(false);
                      checkBoxFotografia.setBackground(new Color(0, 51, 102));
                      
                      checkBoxLicenciaObra = new JCheckBox("Fotocopia licencia Obra Adaptaci\u00F3n");
                      checkBoxLicenciaObra.setForeground(new Color(255, 255, 255));
                      checkBoxLicenciaObra.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxLicenciaObra.setEnabled(false);
                      checkBoxLicenciaObra.setBackground(new Color(0, 51, 102));
                      
                      checkBoxOtras = new JCheckBox("Otras Autorizaciones");
                      checkBoxOtras.setForeground(new Color(255, 255, 255));
                      checkBoxOtras.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxOtras.setEnabled(false);
                      checkBoxOtras.setBackground(new Color(0, 51, 102));
                      
                      checkBoxJustificantePago = new JCheckBox("Justificante de Pago");
                      checkBoxJustificantePago.setForeground(new Color(255, 255, 255));
                      checkBoxJustificantePago.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxJustificantePago.setEnabled(false);
                      checkBoxJustificantePago.setBackground(new Color(0, 51, 102));
                      
                      checkBoxEscrituras = new JCheckBox("Fotocopia Escrituras");
                      checkBoxEscrituras.setForeground(new Color(255, 255, 255));
                      checkBoxEscrituras.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxEscrituras.setEnabled(false);
                      checkBoxEscrituras.setBackground(new Color(0, 51, 102));
                      
                      checkBoxMemoria = new JCheckBox("Memoria de Actividad");
                      checkBoxMemoria.setForeground(new Color(255, 255, 255));
                      checkBoxMemoria.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxMemoria.setEnabled(false);
                      checkBoxMemoria.setBackground(new Color(0, 51, 102));
                      
                      checkBoxCertificado2 = new JCheckBox("Certificado Mod 2");
                      checkBoxCertificado2.setForeground(new Color(255, 255, 255));
                      checkBoxCertificado2.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxCertificado2.setEnabled(false);
                      checkBoxCertificado2.setBackground(new Color(0, 51, 102));
                      
                      checkBoxPlanos = new JCheckBox("Planos del Local");
                      checkBoxPlanos.setForeground(new Color(255, 255, 255));
                      checkBoxPlanos.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxPlanos.setEnabled(false);
                      checkBoxPlanos.setBackground(new Color(0, 51, 102));
                      
                      checkBoxCertificado1 = new JCheckBox("Certificado Mod 1");
                      checkBoxCertificado1.setForeground(new Color(255, 255, 255));
                      checkBoxCertificado1.setFont(new Font("SansSerif", Font.BOLD, 12));
                      checkBoxCertificado1.setEnabled(false);
                      checkBoxCertificado1.setBackground(new Color(0, 51, 102));
                      GroupLayout gl_panel_7 = new GroupLayout(panel_7);
                      gl_panel_7.setHorizontalGroup(
                      	gl_panel_7.createParallelGroup(Alignment.LEADING)
                      		.addGap(0, 666, Short.MAX_VALUE)
                      		.addGap(0, 666, Short.MAX_VALUE)
                      		.addGroup(gl_panel_7.createSequentialGroup()
                      			.addContainerGap()
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING, false)
                      				.addComponent(checkBoxDNI, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                      				.addComponent(checkBoxImpuesto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      				.addComponent(checkBoxFotografia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      				.addComponent(checkBoxLicenciaObra))
                      			.addGap(18)
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
                      				.addGroup(gl_panel_7.createSequentialGroup()
                      					.addComponent(checkBoxOtras, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                      					.addGap(156))
                      				.addGroup(gl_panel_7.createSequentialGroup()
                      					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
                      						.addGroup(gl_panel_7.createSequentialGroup()
                      							.addComponent(checkBoxJustificantePago)
                      							.addPreferredGap(ComponentPlacement.RELATED))
                      						.addGroup(gl_panel_7.createSequentialGroup()
                      							.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
                      								.addComponent(checkBoxEscrituras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                      								.addComponent(checkBoxMemoria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                      							.addGap(15)))
                      					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
                      						.addComponent(checkBoxCertificado2)
                      						.addComponent(checkBoxPlanos)
                      						.addComponent(checkBoxCertificado1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                      					.addGap(28)))
                      			.addGap(30))
                      );
                      gl_panel_7.setVerticalGroup(
                      	gl_panel_7.createParallelGroup(Alignment.LEADING)
                      		.addGap(0, 248, Short.MAX_VALUE)
                      		.addGap(0, 216, Short.MAX_VALUE)
                      		.addGroup(gl_panel_7.createSequentialGroup()
                      			.addContainerGap()
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(checkBoxDNI)
                      				.addComponent(checkBoxCertificado1)
                      				.addComponent(checkBoxEscrituras))
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(checkBoxImpuesto)
                      				.addComponent(checkBoxMemoria)
                      				.addComponent(checkBoxCertificado2))
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(checkBoxFotografia)
                      				.addComponent(checkBoxPlanos)
                      				.addComponent(checkBoxJustificantePago))
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(checkBoxLicenciaObra)
                      				.addComponent(checkBoxOtras))
                      			.addContainerGap(88, Short.MAX_VALUE))
                      );
                      panel_7.setLayout(gl_panel_7);
                      
                      textActividad = new JTextField();
                      textActividad.setBackground(Color.LIGHT_GRAY);
                      textActividad.setEditable(false);
                      textActividad.setColumns(10);
                      
                      textInicioActividad = new JTextField();
                      textInicioActividad.setBackground(Color.LIGHT_GRAY);
                      textInicioActividad.setEditable(false);
                      textInicioActividad.setColumns(10);
                      
                      textSolicitud = new JTextField();
                      textSolicitud.setEditable(false);
                      textSolicitud.setBackground(Color.LIGHT_GRAY);
                      textSolicitud.setColumns(10);
                      GroupLayout gl_panel_6 = new GroupLayout(panel_6);
                      gl_panel_6.setHorizontalGroup(
                      	gl_panel_6.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel_6.createSequentialGroup()
                      			.addGap(6)
                      			.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
                      				.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 1004, GroupLayout.PREFERRED_SIZE)
                      				.addGroup(gl_panel_6.createSequentialGroup()
                      					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
                      						.addComponent(label_7)
                      						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                      						.addGroup(gl_panel_6.createSequentialGroup()
                      							.addPreferredGap(ComponentPlacement.RELATED)
                      							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
                      						.addGroup(gl_panel_6.createSequentialGroup()
                      							.addPreferredGap(ComponentPlacement.RELATED)
                      							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                      						.addGroup(gl_panel_6.createSequentialGroup()
                      							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
                      								.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                      								.addComponent(textInicioActividad, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                      							.addPreferredGap(ComponentPlacement.RELATED)
                      							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
                      								.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                      								.addComponent(textSolicitud, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
                      						.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING, false)
                      							.addComponent(textCatastro, Alignment.LEADING)
                      							.addComponent(textActividad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                      					.addGap(43)
                      					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)))
                      			.addGap(16))
                      );
                      gl_panel_6.setVerticalGroup(
                      	gl_panel_6.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel_6.createSequentialGroup()
                      			.addGap(6)
                      			.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                      			.addGap(12)
                      			.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
                      				.addGroup(gl_panel_6.createSequentialGroup()
                      					.addComponent(label_7)
                      					.addPreferredGap(ComponentPlacement.RELATED)
                      					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                      					.addGap(18)
                      					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                      				.addComponent(panel_7, 0, 0, Short.MAX_VALUE))
                      			.addGap(4)
                      			.addComponent(textActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addComponent(label_9)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addComponent(textCatastro, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(label_25)
                      				.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                      			.addGap(6)
                      			.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
                      				.addComponent(textInicioActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      				.addComponent(textSolicitud, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                      );
                      
                      textDescripcion = new JTextArea();
                      textDescripcion.setBackground(Color.LIGHT_GRAY);
                      textDescripcion.setEditable(false);
                      scrollPane_5.setViewportView(textDescripcion);
                      
                      table_licencias = new JTable();
                      scrollPane_4.setViewportView(table_licencias);
                      panel_6.setLayout(gl_panel_6);
                      GroupLayout gl_panel = new GroupLayout(panel);
                      gl_panel.setHorizontalGroup(
                      	gl_panel.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel.createSequentialGroup()
                      			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                      				.addComponent(label)
                      				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      				.addGroup(gl_panel.createSequentialGroup()
                      					.addGap(12)
                      					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                      					.addGap(12)
                      					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                      						.addComponent(label_2)
                      						.addGroup(gl_panel.createSequentialGroup()
                      							.addComponent(label_4)
                      							.addGap(431)
                      							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))))
                      				.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE))
                      			.addGap(56))
                      		.addGroup(gl_panel.createSequentialGroup()
                      			.addGap(6)
                      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
                      			.addContainerGap(472, Short.MAX_VALUE))
                      );
                      gl_panel.setVerticalGroup(
                      	gl_panel.createParallelGroup(Alignment.LEADING)
                      		.addGroup(gl_panel.createSequentialGroup()
                      			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                      				.addComponent(label)
                      				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                      			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                      				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                      				.addGroup(gl_panel.createSequentialGroup()
                      					.addComponent(label_2)
                      					.addGap(6)
                      					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                      						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                      						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
                      			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                      			.addPreferredGap(ComponentPlacement.RELATED)
                      			.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
                      			.addGap(21))
                      );
                      panel.setLayout(gl_panel);
                      
                      	
                      
                      JLabel label_28 = new JLabel("");
                      panel1.setLayout(gl_panel1);
                      datosTabla();
	}
                      public void datosTabla(){
                    	  Object[][] resultadosPersonas = (Object[][]) ((MImplementacion)modelo).recogerDatosBBDDLicencias();
                          table_licencias.setModel(new DefaultTableModel(
                          	resultadosPersonas,
                          	new String[] {
                          		"REGISTRO", "LICENCIA", "EMPLAZAMIENTO", "SUELO", "ESTADO LICENCIA"
                          	}
                          )
                           {
                          	/**
    						 * 
    						 */
    						private static final long serialVersionUID = 1L;
    						boolean[] columnEditables = new boolean[] {
                          		false, false, false, false, false
                          	};
                          	public boolean isCellEditable(int row, int column) {
                          		return columnEditables[column];
                          	}
                          });
                          table_licencias.getColumnModel().getColumn(1).setPreferredWidth(97);
                          table_licencias.getColumnModel().getColumn(2).setPreferredWidth(103);
                          table_licencias.getColumnModel().getColumn(3).setPreferredWidth(242);
                          table_licencias.addMouseListener(new MouseAdapter() 
                      
                      {
                      	@Override
                      	public void mousePressed(MouseEvent me) {
                      		JTable table =(JTable) me.getSource();
                            Point p = me.getPoint();
                            int row = table.rowAtPoint(p);
                            if (me.getClickCount() == 2) {
                              micontrolador.cambioDatosLicencia();
                              micontrolador.recogerRegistro4Cambios();
                            }
                      	}
                     
                      
                      @Override
                  	public void mouseClicked(MouseEvent e) {
                  		button_1.setEnabled(true);
                  		micontrolador.recogerRegistro2();
                  	}
                    
                      });
                     
                      
                      JToolBar toolBar = new JToolBar();
                      getContentPane().add(toolBar, BorderLayout.NORTH);
                      
                      JButton btnConexinBbdd = new JButton("Conexi\u00F3n BBDD");
                      btnConexinBbdd.addActionListener(new ActionListener() {
                      	public void actionPerformed(ActionEvent e) {
                      	
                      		micontrolador.cambioPantallaFichero();
                      		micontrolador.obtenerDatosBBDD();
                      	}
                      });
                      btnConexinBbdd.setBackground(Color.WHITE);
                      toolBar.add(btnConexinBbdd);
        setVisible(true); 
    }
   
    public void datosTabla2(){
    	  Object[][] resultados = (Object[][]) ((MImplementacion) modelo).recogerDatosBBDDPersonas();
         
          table_persona.setModel(new DefaultTableModel(resultados,
          
          	new String[] {
          		"DNI", "NOMBRE", "APELLIDOS", "LICENCIA", "REGISTRO"
          	}
          ) {
          	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
          		false, false, false, false, false
          	};
          	public boolean isCellEditable(int row, int column) {
          		return columnEditables[column];
          	}
          });  	   
          
    }
    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
 
       
 
    }



	@Override
	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		
	}


	public void devolverDatosExtra() {
		textDescripcion.setText(modelo.getDescripcion());
		textActividad.setText(modelo.getActividad());
		textCatastro.setText(modelo.getCatastro());
		textInicioActividad.setText(modelo.getFechaInicio());
		textSolicitud.setText(modelo.getSolicitud());
		
		
		if(modelo.getFotocopiaDNI().equalsIgnoreCase("SI")){
			checkBoxDNI.setSelected(true);
		}else if(modelo.getFotocopiaDNI().equalsIgnoreCase("NO")){
			checkBoxDNI.setSelected(false);
		}
		if(modelo.getFotocopiaImpuestos().equalsIgnoreCase("SI")){
			checkBoxImpuesto.setSelected(true);
		}else if(modelo.getFotocopiaImpuestos().equalsIgnoreCase("NO")){
			checkBoxImpuesto.setSelected(false);
		}
		if(modelo.getFotografia().equalsIgnoreCase("SI")){
			checkBoxFotografia.setSelected(true);
		}else if(modelo.getFotografia().equalsIgnoreCase("NO")){
			checkBoxFotografia.setSelected(false);
		}
		if(modelo.getFotocopiaObra().equalsIgnoreCase("SI")){
			checkBoxLicenciaObra.setSelected(true);
		}else if(modelo.getFotocopiaObra().equalsIgnoreCase("NO")){
			checkBoxLicenciaObra.setSelected(false);
		}
		if(modelo.getFotocopiaEscritura().equalsIgnoreCase("SI")){
			checkBoxEscrituras.setSelected(true);
		}else if(modelo.getFotocopiaEscritura().equalsIgnoreCase("NO")){
			checkBoxEscrituras.setSelected(false);
		}
		if(modelo.getFotocopiaMemoria().equalsIgnoreCase("SI")){
			checkBoxMemoria.setSelected(true);
		}else if(modelo.getFotocopiaMemoria().equalsIgnoreCase("NO")){
			checkBoxMemoria.setSelected(false);
		}
		if(modelo.getFotocopiaPago().equalsIgnoreCase("SI")){
			checkBoxJustificantePago.setSelected(true);
		}else if(modelo.getFotocopiaPago().equalsIgnoreCase("NO")){
			checkBoxJustificantePago.setSelected(false);
		}
		if(modelo.getFotocopiaOtras().equalsIgnoreCase("SI")){
			checkBoxOtras.setSelected(true);
		}else if(modelo.getFotocopiaOtras().equalsIgnoreCase("NO")){
			checkBoxOtras.setSelected(false);
		}
		if(modelo.getCertificado1().equalsIgnoreCase("SI")){
			checkBoxCertificado1.setSelected(true);
		}else if(modelo.getCertificado1().equalsIgnoreCase("NO")){
			checkBoxCertificado1.setSelected(false);
		}
		if(modelo.getCertificado2().equalsIgnoreCase("SI")){
			checkBoxCertificado2.setSelected(true);
		}else if(modelo.getCertificado2().equalsIgnoreCase("NO")){
			checkBoxCertificado2.setSelected(false);
		}
		if(modelo.getPlanos().equalsIgnoreCase("SI")){
			checkBoxPlanos.setSelected(true);
		}else if(modelo.getPlanos().equalsIgnoreCase("NO")){
			checkBoxPlanos.setSelected(false);
		}
		
	}
	public void filtro() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtfBuscaDni.getText(), 0)); //////metodo de filtro de datos
		}
	public void filtro2() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtfNombre.getText().toUpperCase(), 1)); //////metodo de filtro de datos
		}
	public void filtro3() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtfRegistro.getText(), 0)); //////metodo de filtro de datos
		}
	public void filtro4() {
		System.out.println("uuuoooolaaaaaa");
		trsfiltro2.setRowFilter(RowFilter.regexFilter(textField.getText().toUpperCase(), 1));
		System.out.println("yeahh");//////metodo de filtro de datos
		}
	public void devolverDatosExtra2(){
		textFieldRazonSocial.setText(modelo.getRazonSocial());
		textFieldCif.setText(modelo.getCif());
		textFieldFijo.setText(modelo.getTlfFijo());
		textFieldMovil.setText(modelo.getTlfMovil());
		textFieldPersona.setText(modelo.getTipoPersona());
		textFieldDireccion.setText(modelo.getDireccion());
		textFieldMunicipio.setText(modelo.getMunicipio());
		textFieldCP.setText(modelo.getCp());
		textFieldEmail.setText(modelo.getEmail());
	}
	

	@Override
	public void setControlador(CImplementacionControl controlador) {
		// TODO Auto-generated method stub
		
	}


	public void actualizarTablas() {
		datosTabla();
		datosTabla2();
		
	}
	public JTable getTable_persona() {
		return table_persona;
	}
	public void setTable_persona(JTable table_persona) {
		this.table_persona = table_persona;
	}
	public JTable getTable_licencias() {
		return table_licencias;
	}
	public void setTable_licencias(JTable table_licencias) {
		this.table_licencias = table_licencias;
	}
}