package plugins;

import gui.models.*;
import kernel.datos.*;


public class PlugInGui {
	
	public static boolean UserValidation(User _User) {		
		CrudEmpleados CrudEmpleados = new CrudEmpleados();
		return CrudEmpleados.Login(_User.Name, _User.Password);
	}
	
	public static boolean ALDate(CitaGui _Cita) {
		
		CrudCitas CrudCitas = new CrudCitas();

		try {
			CrudCitas.insertarCitas(_Cita.ClientName, _Cita.Estilista, _Cita.CitaDate, _Cita.Monto);		
		}catch(Exception e){
	        return false;
		}
		
		return true;
    }
	
	public static boolean RegistrarCliente(ClienteGui _ClienteGui) {
		
		CrudClientes CrudClientes = new CrudClientes();
		
		try {
			CrudClientes.insertarClientes(_ClienteGui.Nombre, _ClienteGui.Telefono, _ClienteGui.Correo);		
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
