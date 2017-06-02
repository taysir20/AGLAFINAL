package modelo;

import controlador.Controlador;
import vista.VCambioDatosLicencia;
import vista.VCambioDeTitularidad;
import vista.VFichero;
import vista.VInicioSolicitud;
import vista.VInicioTitular;
import vista.VPantallaHistorico;
import vista.VPantallaPrincipal;
import vista.Vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

public class MImplementacion implements Modelo {

	private VPantallaPrincipal vista;
	private VFichero vista2;
	private VInicioSolicitud vista3;
	private VInicioTitular vista4;
	private VCambioDeTitularidad vista5;
	private VPantallaHistorico vista6;
	private VCambioDatosLicencia vista7;

	public VFichero getVista2() {
		return vista2;
	}

	private Connection conexion;
	private String Usuario;
	private String Pass;
	private String bbdd;

	// Datos
	private String descripcion;
	private String actividad;
	private String catastro;
	private String fechaInicio;
	private String solicitud;
	private String fotocopiaDNI;
	private String fotocopiaImpuestos;
	private String fotografia;
	private String fotocopiaObra;
	private String fotocopiaEscritura;
	private String fotocopiaMemoria;
	private String fotocopiaPago;
	private String fotocopiaOtras;
	private String certificado1;
	private String certificado2;
	private String planos;

	private String razonSocial;
	private String cif;
	private String fax;
	private String tipoPersona;
	private String tlfMovil;
	private String tlfFijo;
	private String direccion;
	private String municipio;
	private String cp;
	private String email;
	private String nombre;
	private String apellidos;
	private String antiguoTitular;
	private String fechaActividadAntiguoTitular;
	private String licenciaAnterior;
	private String escrituras;
	private String numeroExpediente;
	private String planosLocal;
	private String datoRegistro;
	private String registroCambioDatos;
	private String fechaSolicitudCambioDatos;
	private String tipoDeSueloCambioDatos;
	private String emplazamientoCambioDatos;
	private String referenciaCatastralCambioDatos;
	private String estadoSolicitudCambioDatos;
	private String tipoDeActividadCambioDatos;
	private String descripcionActividadCambioDatos;
	private String fotocopiaDNICambioDatos;
	private String fotocopiaImpuestosCambioDatos;
	private String fotografiasCambioDatos;
	private String fotocopiaEscriturasCambioDatos;
	private String justificantePagoCambioDatos;
	private String memoriaActividadCambioDatos;
	private String planosDeLocalCambioDatos;
	private String fotocopiaObraCambioDatos;
	private String certificadoModelo1CambioDatos;
	private String certificadoModelo2CambioDatos;
	private String otrasAutorizacionesCambioDatos;
	private String fechaInicioActividadCambioDatos;

	public void setBBDD(String Usuario, String Pass, String bbdd) {
		this.Usuario = Usuario;
		this.Pass = Pass;
		this.bbdd = bbdd;

		Properties propiedades = new Properties();
		OutputStream salida = null;
		try {
			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				salida = new FileOutputStream(miFichero);

				propiedades.setProperty("Usuario", this.Usuario);
				propiedades.setProperty("Pass", this.Pass);
				propiedades.setProperty("Url", this.bbdd);

				propiedades.store(salida, "Comentario para el fichero");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (salida != null) {
				try {
					salida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getBBDD() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);
				// obtenemos las propiedades y las imprimimos
				this.Usuario = propiedades.getProperty("Usuario");
				this.Pass = propiedades.getProperty("Pass");
				this.bbdd = propiedades.getProperty("Url");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (vista2 != null) {
			vista2.actualizarDatosBBDD();
		}

	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getBbdd() {
		return bbdd;
	}

	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}

	public String ConexionBBDD() {
		String aviso;
		try {
			getBBDD();
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(this.bbdd, this.Usuario, this.Pass);
			System.out.println(" - Conexión con MySQL establecida -");
			aviso = "¡Conexión satisfactoria!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" – Error de Conexión con MySQL -");
			aviso = "¡Conexión Fallida!";
			e.printStackTrace();
		}
		return aviso;

	}

	public String[][] recogerDatosBBDDPersonas() {
		String resultados[][] = null;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			ResultSet rset = pstmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {

				System.out.println(rset.getString("CIF_NIF_NIE") + " " + rset.getString("nombre") + " "
						+ rset.getString("apellidos") + " " + rset.getString("actividad") + " "
						+ rset.getString("registro"));
				z += 1;
			}

			rset.first();
			rset = pstmt.executeQuery();
			int i = 0;
			resultados = new String[z][rsmd.getColumnCount()];
			while (rset.next()) {
				String fila[] = new String[rsmd.getColumnCount()];
				fila[0] = rset.getString("CIF_NIF_NIE");
				fila[1] = rset.getString("nombre");
				fila[2] = rset.getString("apellidos");
				fila[3] = rset.getString("actividad");
				fila[4] = rset.getString("registro");

				resultados[i] = fila;
				System.out.println(rset.getString("CIF_NIF_NIE") + " " + rset.getString("nombre") + " "
						+ rset.getString("apellidos") + " " + rset.getString("actividad") + " "
						+ rset.getString("registro"));
				i++;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return resultados;
	}

	public String[][] recogerDatosBBDDLicencias() {
		String resultados[][] = null;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.registro, licencia.actividad, licencia.emplazamiento,licencia.tipo_suelo, licencia.EstadoLicencia FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			ResultSet rset = pstmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {

				z += 1;
			}

			rset.first();
			rset = pstmt.executeQuery();
			int i = 0;
			resultados = new String[z][rsmd.getColumnCount()];
			while (rset.next()) {
				String fila[] = new String[rsmd.getColumnCount()];
				fila[0] = rset.getString("registro");
				fila[1] = rset.getString("actividad");
				fila[2] = rset.getString("emplazamiento");
				fila[3] = rset.getString("tipo_suelo");
				fila[4] = rset.getString("EstadoLicencia");
				resultados[i] = fila;

				i++;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return resultados;
	}

	public String[][] recogerDatosCambioTitularidad() {
		String resultados[][] = null;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM modificaciones");
			ResultSet rset = pstmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {
				z += 1;
			}
			rset.first();
			rset = pstmt.executeQuery();
			int i = 0;
			resultados = new String[z][rsmd.getColumnCount()];
			while (rset.next()) {
				String fila[] = new String[rsmd.getColumnCount()];

				System.out.println("33333333333333333333333333333333333333333");
				fila[0] = rset.getString("REGISTRO");
				System.out.println("rset.getString('REGISTRO')");
				fila[1] = rset.getString("NuevoTitular");
				System.out.println("rset.getString('NuevoTitular')");
				fila[2] = rset.getString("FechaNuevoTitular");
				System.out.println("rset.getString('FechaNuevoTitular')");
				fila[3] = rset.getString("AntiguoTitular");
				System.out.println("rset.getString('AntiguoTitular')");
				fila[4] = rset.getString("FechaAntiguoTitular");
				System.out.println("rset.getString('FechaAntiguoTitular')");
				System.out.println("33333333333333333333333333333333333333333");
				resultados[i] = fila;
				i++;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return resultados;
	}

	public void setVista(Vista vista) {
		this.vista = (VPantallaPrincipal) vista;

	}

	public void setVista2(Vista ven) {
		this.vista2 = (VFichero) ven;

	}

	public Vista getVista() {
		return vista;
	}

	public void recogerDatosExtra(String dato) {

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ dato);
			ResultSet rset = pstmt.executeQuery();

			// ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {
				descripcion = rset.getString("DescripcionActividad");
				actividad = rset.getString("ACTIVIDAD");
				catastro = rset.getString("REF_CATASTRAL");
				fechaInicio = rset.getString("FechaInicioActividad");
				solicitud = rset.getString("FechaSolicitud");
				fotocopiaDNI = rset.getString("Fotocopia_DNI_CIF_NIE");
				fotocopiaImpuestos = rset.getString("FOTOCOPIA_ACTIVIDAD");
				fotografia = rset.getString("FOTOGRAFIAS");
				fotocopiaObra = rset.getString("FOTOCOPIA_OBRA");
				fotocopiaEscritura = rset.getString("FOTOCOPIA_ESCRITURAS");
				fotocopiaMemoria = rset.getString("MEMORIA_ACTIVIDAD");
				fotocopiaPago = rset.getString("JUSTIFICANTE_PAGO");
				fotocopiaOtras = rset.getString("FOTOCOPIA_OTROS");
				certificado1 = rset.getString("CERTIFICADO_TECNICO1");
				certificado2 = rset.getString("CERTIFICADO_COLEGIO_OFICIAL2");
				planos = rset.getString("PLANOS_LOCAL");
				z += 1;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		vista.devolverDatosExtra();
	}

	public void recogerDatosExtra2(String dato) {

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ dato);
			ResultSet rset = pstmt.executeQuery();

			// ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {
				razonSocial = rset.getString("RAZON_SOCIAL");
				cif = rset.getString("CIF_NIF_NIE");
				tipoPersona = rset.getString("TIPO_SOLICITANTE");
				tlfMovil = rset.getString("TELEFONO_MOVIL");
				tlfFijo = rset.getString("TELEFONO_FIJO");
				direccion = rset.getString("DIRECCION");
				municipio = rset.getString("MUNICIPIO");
				cp = rset.getString("COD_POSTAL");
				email = rset.getString("EMAIL");
				z += 1;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		vista.devolverDatosExtra2();
	}

	public void recogerDatosParaCambioTitularidad(String dato) {
		this.datoRegistro = dato;

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ dato);
			ResultSet rset = pstmt.executeQuery();

			// ResultSetMetaData rsmd = rset.getMetaData();
			System.out.println("avanzo");
			int z = 0;
			while (rset.next()) {
				nombre = rset.getString("NOMBRE");
				apellidos = rset.getString("APELLIDOS");
				tipoPersona = rset.getString("TIPO_SOLICITANTE");
				direccion = rset.getString("DIRECCION");
				municipio = rset.getString("MUNICIPIO");
				cp = rset.getString("COD_POSTAL");
				razonSocial = rset.getString("RAZON_SOCIAL");
				cif = rset.getString("CIF_NIF_NIE");
				antiguoTitular = rset.getString("CIF_NIF_NIE");
				tlfFijo = rset.getString("TELEFONO_FIJO");
				tlfMovil = rset.getString("TELEFONO_MOVIL");
				email = rset.getString("EMAIL");
				fax = rset.getString("FAX");
				fechaActividadAntiguoTitular = rset.getString("FechaInicioActividad");
				z += 1;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}

		vista5.devolverDatosTitular();
	}

	public String getDatoRegistro() {
		return datoRegistro;
	}

	public void recogerDocumentacionCambioTitularidad(String registro) {

		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion
					.prepareStatement("SELECT * FROM modificaciones WHERE modificaciones.REGISTRO='" + registro + "'");
			ResultSet rset = pstmt.executeQuery();

			int z = 0;
			while (rset.next()) {
				licenciaAnterior = rset.getString("LICENCIAANT");
				escrituras = rset.getString("ESCRITURAS");
				numeroExpediente = rset.getString("NUMEXPEDIENTE");
				planosLocal = rset.getString("PLANOS");
				z += 1;
			}

			System.out.println("hhhhhhhhhhhhhhhhh");
			System.out.println(licenciaAnterior);
			System.out.println("hhhhhhhhhhhhhhhhh");

		} catch (SQLException s) {
			s.printStackTrace();
		}

		vista6.devolverDocumentacionNuevoTitular();

	}

	public String getLicenciaAnterior() {
		return licenciaAnterior;
	}

	public void setLicenciaAnterior(String licenciaAnterior) {
		this.licenciaAnterior = licenciaAnterior;
	}

	public String getEscrituras() {
		return escrituras;
	}

	public void setEscrituras(String escrituras) {
		this.escrituras = escrituras;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public String getPlanosLocal() {
		return planosLocal;
	}

	public void setPlanosLocal(String planosLocal) {
		this.planosLocal = planosLocal;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCatastro() {
		return catastro;
	}

	public void setCatastro(String catastro) {
		this.catastro = catastro;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFotocopiaDNI() {
		return fotocopiaDNI;
	}

	public void setFotocopiaDNI(String fotocopia) {
		this.fotocopiaDNI = fotocopia;
	}

	public String getFotocopiaImpuestos() {
		return fotocopiaImpuestos;
	}

	public void setFotocopiaImpuestos(String fotocopiaImpuestos) {
		this.fotocopiaImpuestos = fotocopiaImpuestos;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getFotocopiaObra() {
		return fotocopiaObra;
	}

	public void setFotocopiaObra(String fotocopiaObra) {
		this.fotocopiaObra = fotocopiaObra;
	}

	public String getFotocopiaEscritura() {
		return fotocopiaEscritura;
	}

	public void setFotocopiaEscritura(String fotocopiaEscritura) {
		this.fotocopiaEscritura = fotocopiaEscritura;
	}

	public String getFotocopiaMemoria() {
		return fotocopiaMemoria;
	}

	public void setFotocopiaMemoria(String fotocopiaMemoria) {
		this.fotocopiaMemoria = fotocopiaMemoria;
	}

	public String getFotocopiaPago() {
		return fotocopiaPago;
	}

	public void setFotocopiaPago(String fotocopiaPago) {
		this.fotocopiaPago = fotocopiaPago;
	}

	public String getFotocopiaOtras() {
		return fotocopiaOtras;
	}

	public void setFotocopiaOtras(String fotocopiaOtras) {
		this.fotocopiaOtras = fotocopiaOtras;
	}

	public String getCertificado1() {
		return certificado1;
	}

	public void setCertificado1(String certificado1) {
		this.certificado1 = certificado1;
	}

	public String getCertificado2() {
		return certificado2;
	}

	public void setCertificado2(String certificado2) {
		this.certificado2 = certificado2;
	}

	public String getPlanos() {
		return planos;
	}

	public void setPlanos(String planos) {
		this.planos = planos;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTlfMovil() {
		return tlfMovil;
	}

	public void setTlfMovil(String tlfMovil) {
		this.tlfMovil = tlfMovil;
	}

	public String getTlfFijo() {
		return tlfFijo;
	}

	public void setTlfFijo(String tlfFijo) {
		this.tlfFijo = tlfFijo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVetanaInicio(Vista vista) {
		this.vista3 = (VInicioSolicitud) vista;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void insertarDatos(String registro, String fechaInicioSolicitud, String fechaSolicitud, String tipoSuelo,
			String emplazamiento, String refCatastral, String estadoSolicitud, String tipoActividad,
			String descripcionActividad, String fotocopiaDni2, String fotocopiaImpuestos2, String fotografia2,
			String fotocopiaEscrituras, String justificantePago, String memoriaActividad, String planosLocal,
			String fotocopiaLicenciaObra, String certificado12, String certificado22, String otrasAutorizaciones,
			String nombre, String apellidos, String tipoPersona2, String direccion2, String municipio2, String cP2,
			String razonSocial2, String dni, String tlfFijo2, String tlfMovil2, String email2, String fax2) {

		System.out.println(tipoPersona2);
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			pstmt.executeUpdate(
					"INSERT INTO `titular` (`CIF_NIF_NIE`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELEFONO_MOVIL`, `TELEFONO_FIJO`, `EMAIL`, `TIPO_SOLICITANTE`, `FOTOCOPIA_DNI_CIF_NIE`, `FOTOGRAFIAS`, `FOTOCOPIA_ACTIVIDAD`, `FOTOCOPIA_ESCRITURAS`, `JUSTIFICANTE_PAGO`, `FOTOCOPIA_OTROS`, `RAZON_SOCIAL`, `FAX`) VALUES ('"
							+ dni.toUpperCase() + "', '" + nombre.toUpperCase() + "', '" + apellidos.toUpperCase()
							+ "', '" + municipio2.toUpperCase() + "', '" + Integer.parseInt(cP2) + "', '"
							+ direccion2.toUpperCase() + "', '" + Integer.parseInt(tlfMovil2) + "', '"
							+ Integer.parseInt(tlfFijo2) + "', '" + email2.toUpperCase() + "', '"
							+ tipoPersona2.toUpperCase() + "', '" + fotocopiaDni2.toUpperCase() + "', '"
							+ fotografia2.toUpperCase() + "', '" + fotocopiaImpuestos2.toUpperCase() + "', '"
							+ fotocopiaEscrituras.toUpperCase() + "', '" + justificantePago.toUpperCase() + "', '"
							+ otrasAutorizaciones.toUpperCase() + "', '" + razonSocial2.toUpperCase() + "', '"
							+ Integer.parseInt(fax2) + "')");
			pstmt.executeUpdate(
					"INSERT INTO `licencia` (`REF_CATASTRAL`, `TIPO_SUELO`, `EMPLAZAMIENTO`, `ACTIVIDAD`, `MEMORIA_ACTIVIDAD`, `PLANOS_LOCAL`, `FOTOCOPIA_OBRA`, `CERTIFICADO_TECNICO1`, `CERTIFICADO_COLEGIO_OFICIAL2`, `DNI_titular`, `FechaSolicitud`, `FechaInicioActividad`, `EstadoLicencia`, `DescripcionActividad`) VALUES ('"
							+ refCatastral + "', '" + tipoSuelo.toUpperCase() + "', '" + emplazamiento.toUpperCase()
							+ "', '" + tipoActividad.toUpperCase() + "', '" + memoriaActividad.toUpperCase() + "', '"
							+ planosLocal.toUpperCase() + "', '" + fotocopiaLicenciaObra.toUpperCase() + "', '"
							+ certificado12.toUpperCase() + "', '" + certificado22.toUpperCase() + "', '"
							+ dni.toUpperCase() + "', '" + fechaSolicitud.toUpperCase() + "', '"
							+ fechaInicioSolicitud.toUpperCase() + "', '" + estadoSolicitud.toUpperCase() + "', '"
							+ descripcionActividad.toUpperCase() + "')");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		vista.actualizarTablas();

	}

	public void setVistaRegistroPersona(VInicioTitular ven) {
		this.vista4 = ven;

	}

	public void setVistaCambioTitularidad(VCambioDeTitularidad ven) {
		this.vista5 = ven;

	}

	public void actualizarTitular(String nombre2, String apellidos2, String tipoPersona2, String direccion2,
			String municipio2, String cP2, String razonSocial2, String dni, String tlfFijo2, String tlfMovil2,
			String email2, String fax2, String dato, String planos2, String licenciaAnt, String escrituras,
			String numExpediente) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");
			System.out.println("UPDATE `titular` SET `CIF_NIF_NIE` = '" + dni.toUpperCase() + "', `NOMBRE` = '"
					+ nombre2.toUpperCase() + "', `APELLIDOS` = '" + apellidos2.toUpperCase() + "', `MUNICIPIO` = '"
					+ municipio2 + "', `COD_POSTAL` = '" + Integer.parseInt(cP2) + "', `DIRECCION` = '" + direccion2
					+ "', `TELEFONO_MOVIL` = '" + Integer.parseInt(tlfMovil2) + "', `TELEFONO_FIJO` = '"
					+ Integer.parseInt(tlfFijo2) + "', `EMAIL` = '" + email2 + "', `TIPO_SOLICITANTE` = '"
					+ tipoPersona2 + "', `RAZON_SOCIAL` = '" + razonSocial2 + "', `FAX` = '" + Integer.parseInt(fax2)
					+ "' WHERE `titular`.`REGISTRO` = '" + dato + "'");
			pstmt.executeUpdate("UPDATE `titular` SET `CIF_NIF_NIE` = '" + dni.toUpperCase() + "', `NOMBRE` = '"
					+ nombre2.toUpperCase() + "', `APELLIDOS` = '" + apellidos2.toUpperCase() + "', `MUNICIPIO` = '"
					+ municipio2.toUpperCase() + "', `COD_POSTAL` = '" + Integer.parseInt(cP2) + "', `DIRECCION` = '"
					+ direccion2.toUpperCase() + "', `TELEFONO_MOVIL` = '" + Integer.parseInt(tlfMovil2)
					+ "', `TELEFONO_FIJO` = '" + Integer.parseInt(tlfFijo2) + "', `EMAIL` = '" + email2.toUpperCase()
					+ "', `TIPO_SOLICITANTE` = '" + tipoPersona2.toUpperCase() + "', `RAZON_SOCIAL` = '"
					+ razonSocial2.toUpperCase() + "', `FAX` = '" + Integer.parseInt(fax2)
					+ "' WHERE `titular`.`REGISTRO` = '" + dato + "'");
			Calendar c = Calendar.getInstance();

			pstmt.executeUpdate(
					"INSERT INTO `modificaciones` (`AntiguoTitular`, `FechaAntiguoTitular`, `NuevoTitular`, `FechaNuevoTitular`, `LICENCIAANT`, `ESCRITURAS`, `NUMEXPEDIENTE`, `PLANOS`, `REGISTRO`) VALUES ('"
							+ antiguoTitular.toUpperCase() + "', '" + fechaActividadAntiguoTitular + "', '"
							+ dni.toUpperCase() + "', '" + c.getTime().toString() + "','" + licenciaAnt.toUpperCase()
							+ "', '" + escrituras + "', '" + numExpediente + "', '" + planos2 + "', '" + datoRegistro
							+ "')");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		vista.actualizarTablas();

	}

	public void setVistaPantallaHistorio(VPantallaHistorico ven) {
		this.vista6 = ven;

	}

	public void setPantallaCambiosLicencias(VCambioDatosLicencia ven) {
		this.vista7 = ven;

	}

	public void cargarCambiosLiencia(String registro) {
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT * FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE WHERE titular.REGISTRO= "
							+ registro);
			ResultSet rset = pstmt.executeQuery();

			int z = 0;
			while (rset.next()) {
				registroCambioDatos = rset.getString("REGISTRO");
				fechaSolicitudCambioDatos = rset.getString("FechaSolicitud");
				tipoDeSueloCambioDatos = rset.getString("TIPO_SUELO");
				emplazamientoCambioDatos = rset.getString("EMPLAZAMIENTO");
				referenciaCatastralCambioDatos = rset.getString("REF_CATASTRAL");
				estadoSolicitudCambioDatos = rset.getString("EstadoLicencia");
				tipoDeActividadCambioDatos = rset.getString("ACTIVIDAD");
				descripcionActividadCambioDatos = rset.getString("DescripcionActividad");

				fotocopiaDNICambioDatos = rset.getString("FOTOCOPIA_DNI_CIF_NIE");

				fotocopiaImpuestosCambioDatos = rset.getString("FOTOCOPIA_ACTIVIDAD");
				System.out.println(fotocopiaImpuestosCambioDatos);
				fotografiasCambioDatos = rset.getString("FOTOGRAFIAS");
				fotocopiaEscriturasCambioDatos = rset.getString("FOTOCOPIA_ESCRITURAS");
				justificantePagoCambioDatos = rset.getString("JUSTIFICANTE_PAGO");
				memoriaActividadCambioDatos = rset.getString("MEMORIA_ACTIVIDAD");
				planosDeLocalCambioDatos = rset.getString("PLANOS_LOCAL");
				fotocopiaObraCambioDatos = rset.getString("FOTOCOPIA_OBRA");
				certificadoModelo1CambioDatos = rset.getString("CERTIFICADO_TECNICO1");
				certificadoModelo2CambioDatos = rset.getString("CERTIFICADO_COLEGIO_OFICIAL2");
				otrasAutorizacionesCambioDatos = rset.getString("FOTOCOPIA_OTROS");
				fechaInicioActividadCambioDatos = rset.getString("FechaInicioActividad");
				z += 1;
			}
			

		} catch (SQLException s) {
			s.printStackTrace();
		}

		vista7.devolverDatosDeLicencia();
	}

	public String getFechaActividadAntiguoTitular() {
		return fechaActividadAntiguoTitular;
	}

	public String getRegistroCambioDatos() {
		return registroCambioDatos;
	}

	public String getFechaSolicitudCambioDatos() {
		return fechaSolicitudCambioDatos;
	}

	public String getTipoDeSueloCambioDatos() {
		return tipoDeSueloCambioDatos;
	}

	public VInicioSolicitud getVista3() {
		return vista3;
	}

	public VInicioTitular getVista4() {
		return vista4;
	}

	public VCambioDeTitularidad getVista5() {
		return vista5;
	}

	public VPantallaHistorico getVista6() {
		return vista6;
	}

	public VCambioDatosLicencia getVista7() {
		return vista7;
	}

	public String getAntiguoTitular() {
		return antiguoTitular;
	}

	public void setFotocopiaImpuestosCambioDatos(String fotocopiaImpuestosCambioDatos) {
		this.fotocopiaImpuestosCambioDatos = fotocopiaImpuestosCambioDatos;
	}

	public String getEmplazamientoCambioDatos() {
		return emplazamientoCambioDatos;
	}

	public String getReferenciaCatastralCambioDatos() {
		return referenciaCatastralCambioDatos;
	}

	public String getEstadoSolicitudCambioDatos() {
		return estadoSolicitudCambioDatos;
	}

	public String getTipoDeActividadCambioDatos() {
		return tipoDeActividadCambioDatos;
	}

	public String getDescripcionActividadCambioDatos() {
		return descripcionActividadCambioDatos;
	}

	public String getFotocopiaDNICambioDatos() {
		return fotocopiaDNICambioDatos;
	}

	public String getFotocopiaImpuestosCambioDatos() {
		return fotocopiaImpuestosCambioDatos;
	}

	public String getFotografiasCambioDatos() {
		return fotografiasCambioDatos;
	}

	public String getFotocopiaEscriturasCambioDatos() {
		return fotocopiaEscriturasCambioDatos;
	}

	public String getJustificantePagoCambioDatos() {
		return justificantePagoCambioDatos;
	}

	public String getMemoriaActividadCambioDatos() {
		return memoriaActividadCambioDatos;
	}

	public String getPlanosDeLocalCambioDatos() {
		return planosDeLocalCambioDatos;
	}

	public String getFotocopiaObraCambioDatos() {
		return fotocopiaObraCambioDatos;
	}

	public String getCertificadoModelo1CambioDatos() {
		return certificadoModelo1CambioDatos;
	}

	public String getCertificadoModelo2CambioDatos() {
		return certificadoModelo2CambioDatos;
	}

	public String getOtrasAutorizacionesCambioDatos() {
		return otrasAutorizacionesCambioDatos;
	}
	
	
	public String getFechaInicioActividadCambioDatos() {
		return fechaInicioActividadCambioDatos;
	}

	public void actualizarLicencia(String estadoLicenciaCambioDatos, String descripcionCambioDatos,
			String fotocopiaDNICambioDatos2, String fotocopiaImpuestoCambioDatos, String fotografiasCambioDatos2,
			String fotocopiaEscriturasCambioDatos2, String justificantePagoCambioDatos2,
			String memoriaActividadCambioDatos2, String planosLocalCambioDatos, String fotocopiaLicenciaCambioDatos,
			String certificadoModelo1CambioDatos2, String certificadoModelo2CambioDatos2,
			String otrasAutorizacionesCambioDatos2, String fechaInicioActividad2) {
		
		
		try {
			PreparedStatement pstmt = conexion.prepareStatement(
					"SELECT titular.CIF_NIF_NIE, titular.registro, titular.nombre, titular.apellidos, licencia.actividad FROM titular JOIN licencia ON licencia.DNI_titular=titular.CIF_NIF_NIE");

			pstmt.executeUpdate("UPDATE `licencia` SET `MEMORIA_ACTIVIDAD` = '" + memoriaActividadCambioDatos2 + "', `PLANOS_LOCAL` = '"  + planosLocalCambioDatos + "', `FOTOCOPIA_OBRA` = '"+fotocopiaLicenciaCambioDatos+"', `CERTIFICADO_TECNICO1` = '"+certificadoModelo1CambioDatos2+"', `CERTIFICADO_COLEGIO_OFICIAL2` = '"+certificadoModelo2CambioDatos2+"', `EstadoLicencia` = '"+estadoLicenciaCambioDatos+"', `DescripcionActividad` = '"+descripcionCambioDatos+"', `FechaInicioActividad` = '"+fechaInicioActividad2+"' WHERE `licencia`.`REF_CATASTRAL` = '" + referenciaCatastralCambioDatos + "'");        
		

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		vista.actualizarTablas();
		
		
	}

}
