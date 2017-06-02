package vista;

import controlador.CImplementacionControl;
import controlador.Controlador;
import modelo.Modelo;

public interface Vista {
	
	public void setModelo(Modelo modelo);
	public void setControlador(CImplementacionControl controlador);
	
	
}
