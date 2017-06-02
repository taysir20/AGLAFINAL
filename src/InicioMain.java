import javax.swing.UIManager;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.MImplementacion;
import modelo.Modelo;
import vista.VCambioDeTitularidad;
import vista.VInicioSolicitud;
import vista.VInicioTitular;
import vista.VPantallaPrincipal;

public class InicioMain {
	
	public static void main(String[] args) {
		
		//Instanciación 
		Modelo modelo= new MImplementacion();
		Controlador controlador= new CImplementacionControl();
        //Conexión a BBDD
        ((MImplementacion) modelo).ConexionBBDD();
        ((MImplementacion) modelo).recogerDatosBBDDLicencias();
        ((MImplementacion) modelo).recogerDatosBBDDPersonas();
        VPantallaPrincipal ventanaPrincipal=new VPantallaPrincipal(modelo, controlador);
        //    ventanaPrincipal.setControlador(controlador);
//    ventanaPrincipal.setModelo(modelo);
        controlador.setVista(ventanaPrincipal);
        controlador.setModelo(modelo);
        modelo.setVista(ventanaPrincipal);
        ventanaPrincipal.setVisible(true);   
        

       
        
	}

}
