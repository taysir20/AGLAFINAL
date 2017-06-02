package controlador;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.toedter.calendar.JTextFieldDateEditor;

import modelo.MImplementacion;
import modelo.Modelo;
import vista.VCambioDatosLicencia;
import vista.VCambioDeTitularidad;
import vista.VFichero;
import vista.VInicioSolicitud;
import vista.VInicioTitular;
import vista.VPantallaHistorico;
import vista.VPantallaPrincipal;
import vista.Vista;

public class CImplementacionControl implements Controlador {
	private MImplementacion modelo;
	private VPantallaPrincipal vista;
	private VFichero vista2;
	private VInicioTitular vistaRegistroPersona;
	private VInicioSolicitud inicioSolicitud;
	private VCambioDeTitularidad cambioTitularidad;
	private VPantallaHistorico historicoTitular;
	private VCambioDatosLicencia cambioDatosLicencia;

	// Variables que recogen los campos que se van a insertar:

	private String registro;
	private String fechaInicioSolicitud;
	private String fechaSolicitud;
	private String tipoSuelo;
	private String emplazamiento;
	private String refCatastral;
	private String estadoSolicitud;
	private String tipoActividad;
	private String descripcionActividad;
	private String fotocopiaDni;
	private String fotocopiaImpuestos;
	private String fotografia;
	private String fotocopiaEscrituras;
	private String justificantePago;
	private String memoriaActividad;
	private String planosLocal;
	private String fotocopiaLicenciaObra;
	private String certificado1;
	private String certificado2;
	private String otrasAutorizaciones;
	private String nombre;
	private String apellidos;
	private String tipoPersona;
	private String direccion;
	private String municipio;
	private String CP;
	private String razonSocial;
	private String dni;
	private String tlfFijo;
	private String tlfMovil;
	private String email;
	private String fax;
	private String dato; // Registro de la licencia/titular seleccionado;
	private String planos;
	private String licenciaAnt;
	private String escrituras;
	private String numExpediente;
	private String dniNuevoTitular;
	private String estadoLicenciaCambioDatos;
	private String descripcionCambioDatos;
	private String fotocopiaDNICambioDatos;
	private String fotocopiaImpuestoCambioDatos;
	private String fotografiasCambioDatos;
	private String fotocopiaEscriturasCambioDatos;
	private String justificantePagoCambioDatos;
	private String memoriaActividadCambioDatos;
	private String planosLocalCambioDatos;
	private String fotocopiaLicenciaCambioDatos;
	private String certificadoModelo1CambioDatos;
	private String certificadoModelo2CambioDatos;
	private String otrasAutorizacionesCambioDatos;
	private String fechaInicioActividad;

	public CImplementacionControl() {
		super();

	}

	public void InicioSolicitud() {
		VInicioSolicitud ven = new VInicioSolicitud();
		ven.setControlador(this);
		ven.setModelo(modelo);
		this.setInicioSolicitud(ven);
		modelo.setVetanaInicio(ven);
		ven.setVisible(true);

	}

	private void setInicioSolicitud(Vista ven) {
		// TODO Auto-generated method stub
		this.inicioSolicitud = (VInicioSolicitud) ven;
	}

	public void cambiarPantallaCambioTitularidad() {
		VCambioDeTitularidad ven = new VCambioDeTitularidad();
		ven.setControlador(this);
		ven.setModelo(modelo);
		this.setVistaCambioTitularidad(ven);
		modelo.setVistaCambioTitularidad(ven);
		ven.setVisible(true);

	}

	private void setVistaCambioTitularidad(VCambioDeTitularidad ven) {
		this.cambioTitularidad = ven;

	}

	public void cambiarPantallaRegistroPersona() {
		VInicioTitular ven = new VInicioTitular();
		ven.setControlador(this);
		ven.setModelo(modelo);
		this.setVistaRegistroPersona(ven);
		modelo.setVistaRegistroPersona(ven);
		ven.setVisible(true);

	}

	private void setVistaRegistroPersona(VInicioTitular ven) {
		this.vistaRegistroPersona = ven;

	}

	public void cambioPantallaFichero() {
		VFichero ven = new VFichero();
		ven.setControlador(this);
		ven.setModelo(modelo);
		this.setVista2(ven);
		modelo.setVista2(ven);
		ven.setVisible(true);

	}

	private void setVista2(VFichero ven) {
		this.vista2 = ven;
	}

	public void cargarDatosBBDD() {
		String usuario = vista2.getTextFieldNombre();
		String pass = vista2.getTextFieldPass();
		String bbdd = vista2.getTextFieldURL();
		System.out.println(bbdd);
		modelo.setBBDD(usuario, pass, bbdd);

	}

	public void setModelo(Modelo modelo) {
		this.modelo = (MImplementacion) modelo;

	}

	public void setVista(Vista vista) {
		this.vista = (VPantallaPrincipal) vista;

	}

	public void obtenerDatosBBDD() {
		modelo.getBBDD();

	}

	public void enviarRegistro(String dato) {
		this.dato = dato;
		((MImplementacion) modelo).recogerDatosExtra(dato);

	}

	public void enviarRegistro2(String dato) {
		this.dato = dato;
		((MImplementacion) modelo).recogerDatosExtra2(dato);
	}

	public void recogerDatosInicioSolicitud() {
		registro = inicioSolicitud.getRegistro();
		fechaInicioSolicitud = inicioSolicitud.getFechaInicioSolicitud();
		fechaSolicitud = inicioSolicitud.getFechaSolicitud();
		tipoSuelo = inicioSolicitud.getTipoSuelo();
		emplazamiento = inicioSolicitud.getEmplazamiento();
		refCatastral = inicioSolicitud.getReferenciaCatastral();
		estadoSolicitud = inicioSolicitud.getEstadoSolicitud();
		tipoActividad = inicioSolicitud.getTipoActividad();
		descripcionActividad = inicioSolicitud.getDescripcionActividad();
		fotocopiaDni = inicioSolicitud.getCheckBoxDNI();
		fotocopiaImpuestos = inicioSolicitud.getCheckImpuestosActividad();
		fotografia = inicioSolicitud.getCheckFotografias();
		fotocopiaEscrituras = inicioSolicitud.getCheckEscrituras();
		justificantePago = inicioSolicitud.getCheckJustificantePago();
		memoriaActividad = inicioSolicitud.getCheckMemoriaActividad();
		planosLocal = inicioSolicitud.getCheckPlanosLocal();
		fotocopiaLicenciaObra = inicioSolicitud.getCheckFotocopiaObra();
		certificado1 = inicioSolicitud.getCheckModeloTecnico();
		certificado2 = inicioSolicitud.getCheckColegio();
		otrasAutorizaciones = inicioSolicitud.getCheckOtrasAutorizaciones();
		System.out.println(tipoActividad);
		System.out.println(tipoSuelo);
		System.out.println(fechaInicioSolicitud);
		System.out.println(fechaSolicitud);

	}

	public void recogerDatosRegistroTitular() {
		nombre = vistaRegistroPersona.getTextFieldNombre();
		apellidos = vistaRegistroPersona.getTextApellidos();
		tipoPersona = vistaRegistroPersona.getComboBoxPersona();
		direccion = vistaRegistroPersona.getTextFieldDireccion();
		municipio = vistaRegistroPersona.getTextFieldMunicipio();

		if (vistaRegistroPersona.getTextFieldCP().isEmpty()) {
			CP = "00000";
		} else {
			CP = vistaRegistroPersona.getTextFieldCP();
		}
		if (vistaRegistroPersona.getTextFieldFijo().isEmpty()) {
			tlfFijo = "000000000";
		} else {
			tlfFijo = vistaRegistroPersona.getTextFieldFijo();
		}
		if (vistaRegistroPersona.getTextFieldMovil().isEmpty()) {
			tlfMovil = "000000000";
		} else {
			tlfMovil = vistaRegistroPersona.getTextFieldMovil();
		}
		if (vistaRegistroPersona.getTextFieldFax().isEmpty()) {
			fax = "000000000";
		} else {
			fax = vistaRegistroPersona.getTextFieldFax();
		}

		razonSocial = vistaRegistroPersona.getTextRSocial();
		dni = vistaRegistroPersona.getTextDNI();

		email = vistaRegistroPersona.getTextFieldEmail();

		System.out.println(tipoPersona);
		this.enviarCampos();

	}

	private void enviarCampos() {
		modelo.insertarDatos(registro, fechaInicioSolicitud, fechaSolicitud, tipoSuelo, emplazamiento, refCatastral,
				estadoSolicitud, tipoActividad, descripcionActividad, fotocopiaDni, fotocopiaImpuestos, fotografia,
				fotocopiaEscrituras, justificantePago, memoriaActividad, planosLocal, fotocopiaLicenciaObra,
				certificado1, certificado2, otrasAutorizaciones, nombre, apellidos, tipoPersona, direccion, municipio,
				CP, razonSocial, dni, tlfFijo, tlfMovil, email, fax);

	}

	public void cargarDatosTitularActual(String dato) {

		modelo.recogerDatosParaCambioTitularidad(dato);

	}

	public void recogerDatosNuevoTitular() {
		nombre = cambioTitularidad.getTextFieldNombre();
		apellidos = cambioTitularidad.getTextApellidos();
		tipoPersona = cambioTitularidad.getComboBoxPersona();
		direccion = cambioTitularidad.getTextFieldDireccion();
		municipio = cambioTitularidad.getTextFieldMunicipio();
		CP = cambioTitularidad.getTextFieldCP();
		razonSocial = cambioTitularidad.getTextRSocial();
		dni = cambioTitularidad.getTextDNI();
		tlfFijo = cambioTitularidad.getTextFieldFijo();
		tlfMovil = cambioTitularidad.getTextFieldMovil();
		email = cambioTitularidad.getTextFieldEmail();
		fax = cambioTitularidad.getTextFieldFax();
		planos = cambioTitularidad.getCheckBoxPlanos();
		licenciaAnt = cambioTitularidad.getCheckBoxLicenciaAnt();
		escrituras = cambioTitularidad.getCheckboxEscrituras();
		numExpediente = cambioTitularidad.getCheckBoxNumExpediente();
		modelo.actualizarTitular(nombre, apellidos, tipoPersona, direccion, municipio, CP, razonSocial, dni, tlfFijo,
				tlfMovil, email, fax, dato, planos, licenciaAnt, escrituras, numExpediente);

	}

	public void recogerRegistro() {
		dato = String.valueOf(vista.getTable_persona().getValueAt(vista.getTable_persona().getSelectedRow(), 4));
		System.out.println(dato);
		this.enviarRegistro2(dato);

	}

	public void recogerRegistro2() {
		// TODO Auto-generated method stub
		dato = String.valueOf(vista.getTable_licencias().getValueAt(vista.getTable_licencias().getSelectedRow(), 0));
		System.out.println(dato);
		this.enviarRegistro(dato);
	}

	public void recogerRegistroCambio() {
		dato = String.valueOf(vista.getTable_persona().getValueAt(vista.getTable_persona().getSelectedRow(), 4));
		this.cargarDatosTitularActual(dato);

	}

	public void recogerRegistroCambio2() {
		dato = String.valueOf(vista.getTable_licencias().getValueAt(vista.getTable_licencias().getSelectedRow(), 0));
		this.cargarDatosTitularActual(dato);

	}

	public void cambioPantallaHistorico() {
		System.out.println("444444444444444");
		System.out.println("HOLA, ENTRO AL MODELO");
		System.out.println("444444444444444");
		VPantallaHistorico ven = new VPantallaHistorico(this, modelo);
		this.setPantallaHistorico(ven);
		modelo.setVistaPantallaHistorio(ven);
		ven.setVisible(true);
	}

	private void setPantallaHistorico(VPantallaHistorico ven) {
		this.historicoTitular = ven;

	}

	public void recogerRegistroNuevoTitular() {
		registro = String
				.valueOf(historicoTitular.getTable().getValueAt(historicoTitular.getTable().getSelectedRow(), 0));
		modelo.recogerDocumentacionCambioTitularidad(registro);

	}

	public void recogerRegistro3Cambios() {
		registro = String.valueOf(vista.getTable_persona().getValueAt(vista.getTable_persona().getSelectedRow(), 4));
		modelo.cargarCambiosLiencia(registro);
	}

	public void cambioDatosLicencia() {
		VCambioDatosLicencia ven = new VCambioDatosLicencia();
		ven.setControlador(this);
		ven.setModelo(modelo);
		this.setPantallaCambiosLicencias(ven);
		modelo.setPantallaCambiosLicencias(ven);
		ven.setVisible(true);

	}

	private void setPantallaCambiosLicencias(VCambioDatosLicencia ven) {
		this.cambioDatosLicencia = ven;

	}

	public void recogerRegistro4Cambios() {
		registro = String
				.valueOf(vista.getTable_licencias().getValueAt(vista.getTable_licencias().getSelectedRow(), 0));
		modelo.cargarCambiosLiencia(registro);

	}

	public void actualizarDatosLicencia() {
		estadoLicenciaCambioDatos = cambioDatosLicencia.getComboBoxEstadoLicencia();
		descripcionCambioDatos = cambioDatosLicencia.getTextPaneDescripcion();
		fotocopiaDNICambioDatos = cambioDatosLicencia.getCheckBoxFotocopiaDni();
		fotocopiaImpuestoCambioDatos = cambioDatosLicencia.getCheckBoxFotocopiaImpuestos();
		fotografiasCambioDatos = cambioDatosLicencia.getCheckBoxFotografias();
		fotocopiaEscriturasCambioDatos = cambioDatosLicencia.getCheckBoxFotocopiaEscrituras();
		justificantePagoCambioDatos = cambioDatosLicencia.getCheckBoxJustificantePago();
		memoriaActividadCambioDatos = cambioDatosLicencia.getCheckBoxMemoria();
		planosLocalCambioDatos = cambioDatosLicencia.getCheckBoxPlanosLocal();
		fotocopiaLicenciaCambioDatos = cambioDatosLicencia.getCheckBoxFotocopiaLicencia();
		certificadoModelo1CambioDatos = cambioDatosLicencia.getCheckBoxCertificadoModelo1();
		certificadoModelo2CambioDatos = cambioDatosLicencia.getCheckBoxCertificadoModelo2();
		otrasAutorizacionesCambioDatos = cambioDatosLicencia.getCheckBoxOtrasAutorizaciones();
		fechaInicioActividad = cambioDatosLicencia.getDateChooserInicioActividad();
		
		modelo.actualizarLicencia(estadoLicenciaCambioDatos, descripcionCambioDatos, fotocopiaDNICambioDatos,
				fotocopiaImpuestoCambioDatos, fotografiasCambioDatos, fotocopiaEscriturasCambioDatos,
				justificantePagoCambioDatos, memoriaActividadCambioDatos, planosLocalCambioDatos,
				fotocopiaLicenciaCambioDatos, certificadoModelo1CambioDatos, certificadoModelo2CambioDatos,
				otrasAutorizacionesCambioDatos,fechaInicioActividad);
	}

}

