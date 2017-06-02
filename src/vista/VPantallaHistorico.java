package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CImplementacionControl;
import modelo.MImplementacion;
import modelo.Modelo;

import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VPantallaHistorico extends JFrame implements Vista {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private MImplementacion modelo;
	private CImplementacionControl controlador;
	private JCheckBox checkBoxPlanos;
	private JCheckBox checkBoxLicenciaAnterior;
	private JCheckBox checkBoxExp;
	private JCheckBox checkBoxEscrituras;
	private JTextField txtBuscadorRegistro;
	private TableRowSorter trsfiltro;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param modelo2 
	 * @param cImplementacionControl 
	 */
	public VPantallaHistorico(CImplementacionControl cImplementacionControl, MImplementacion modelo2) {
		this.controlador=cImplementacionControl;
		this.modelo=modelo2;
		
		setBounds(100, 100, 943, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "HIST\u00D3RICO CAMBIO TITULARIDAD", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Documentacion Necesaria para Cambio de Titularidad Actividad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 224)));
		panel_1.setBackground(new Color(0, 0, 128));
		
		checkBoxPlanos = new JCheckBox("Planos distribuici\u00F3n / planta actividad anterior");
		checkBoxPlanos.setForeground(new Color(0, 0, 0));
		checkBoxPlanos.setEnabled(false);
		checkBoxPlanos.setBackground(new Color(0, 0, 128));
		
		checkBoxEscrituras = new JCheckBox("Escrituras, contrato arrendamiento/documentos justificativos");
		checkBoxEscrituras.setForeground(new Color(0, 0, 0));
		checkBoxEscrituras.setEnabled(false);
		checkBoxEscrituras.setBackground(new Color(0, 0, 128));
		
		checkBoxLicenciaAnterior = new JCheckBox("Licencia anterior / documento que lo acredite");
		checkBoxLicenciaAnterior.setForeground(new Color(0, 0, 0));
		checkBoxLicenciaAnterior.setEnabled(false);
		checkBoxLicenciaAnterior.setBackground(new Color(0, 0, 128));
		
		checkBoxExp = new JCheckBox("Numero expediente Anterior Titular");
		checkBoxExp.setForeground(new Color(0, 0, 0));
		checkBoxExp.setEnabled(false);
		checkBoxExp.setBackground(new Color(0, 0, 128));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 892, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxPlanos)
						.addComponent(checkBoxEscrituras))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxLicenciaAnterior, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxExp))
					.addGap(54))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 109, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(checkBoxLicenciaAnterior)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxExp))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxEscrituras)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxPlanos)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblBuscarHistoricoPor = new JLabel("Buscar historico por Registro");
		
		txtBuscadorRegistro = new JTextField();
		txtBuscadorRegistro.addKeyListener(new KeyAdapter() {//////////////////////////////filtros por registro////////////////////////////////
	        	

				@Override
	        	public void keyTyped(KeyEvent e) {
					txtBuscadorRegistro.addKeyListener(new KeyAdapter() {
	        			public void keyReleased(final KeyEvent e) {
	        			
	    
	        			
	        			filtro();
	        			}
	        			});
	        			trsfiltro = new TableRowSorter(table.getModel());
	        			table.setRowSorter(trsfiltro);
	        		
	        	}
	        });
		txtBuscadorRegistro.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 892, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBuscarHistoricoPor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBuscadorRegistro, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscarHistoricoPor)
						.addComponent(txtBuscadorRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.recogerRegistroNuevoTitular();
			}
		});
		 Object[][] documentacionAportada = (Object[][]) ((MImplementacion) modelo).recogerDatosCambioTitularidad();
		table.setModel(new DefaultTableModel(
				documentacionAportada,
			new String[] {
				"REGISTRO", "DNI NUEVO TITULAR", "FECHA NUEVO TITULAR", "DNI ANTIGUO TITULAR", "FECHA ANTIGUO TITULAR"
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
		
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}

	@Override
	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControlador(CImplementacionControl controlador) {
		// TODO Auto-generated method stub
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void devolverDocumentacionNuevoTitular() {
		if(modelo.getNumeroExpediente().equalsIgnoreCase("SI")){
			checkBoxExp.setSelected(true);
		}else if(modelo.getNumeroExpediente().equalsIgnoreCase("NO")){
			checkBoxExp.setSelected(false);
		}
		if(modelo.getLicenciaAnterior().equalsIgnoreCase("SI")){
			checkBoxLicenciaAnterior.setSelected(true);
		}else if(modelo.getLicenciaAnterior().equalsIgnoreCase("NO")){
			checkBoxLicenciaAnterior.setSelected(false);
		}
		if(modelo.getPlanosLocal().equalsIgnoreCase("SI")){
			checkBoxPlanos.setSelected(true);
		}else if(modelo.getPlanosLocal().equalsIgnoreCase("NO")){
			checkBoxPlanos.setSelected(false);
		}
		if(modelo.getEscrituras().equalsIgnoreCase("SI")){
			checkBoxEscrituras.setSelected(true);
		}else if(modelo.getEscrituras().equalsIgnoreCase("NO")){
			checkBoxEscrituras.setSelected(false);
		}
		
	}
	
	public void filtro(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBuscadorRegistro.getText(), 0)); //////metodo de filtro de datos
	}
}
