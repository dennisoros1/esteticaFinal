package kernel.factory;

import java.sql.Date;

import kernel.datos.*;
import kernel.models.Cita;
import kernel.models.Cliente;
import kernel.models.Direccion;
import kernel.models.Empleado;

public class Factory{
		
	Cliente miCliente;
	Empleado miEmpleado;
	Direccion miDireccion;
	Cita miCita;
	
	public Empleado ExisteElEmpleado(int _IdEmpleado) {
		
		CrudEmpleados CrudEmpleados = new CrudEmpleados();
		miEmpleado =  CrudEmpleados.GetEmpleado(_IdEmpleado); 
		//miSesion.get(Empleado.class, _IdEmpleado);
		
		if(miEmpleado==null) {
			System.out.println("El empleado proporcionado no existe!!!"); 
		}
		
		return miEmpleado;
	}
	
	public Cliente ExisteElCliente(int _IdCliente) { 
		
		CrudClientes CrudClientes = new CrudClientes();
		miCliente = CrudClientes.GetCliente(_IdCliente);

		if(miCliente==null) {
			System.out.println("El cliente proporcionado no existe!!!"); 
		}

		return miCliente;
	}

	public Cita CreateCita(int _IdCliente, int _IdEmpleado, Date _Fecha, float _Monto) {

		if(_Monto < 0) { return null; }
		
		CrudCitas CrudCitas = new CrudCitas();
		
		boolean tmp = CrudCitas.ExisteLaCita(_IdCliente, _IdEmpleado, _Fecha);
		if(tmp==true) { return null; }
		else {		
			miEmpleado = ExisteElEmpleado(_IdEmpleado);
			miCliente = ExisteElCliente(_IdCliente);
			
			if(miEmpleado!=null && miCliente!=null) {
				establecerFecha();
				miCita = new Cita(miCliente, miEmpleado,_Fecha, _Monto, establecerFecha());
					
			}
			else { return null; }
		}

		return miCita;
	}
	
	
	public Empleado CreateEmpleado(String Nombre, String Telefono, String Correo, 
			String puesto, String pass) {
		
		if(Nombre == "" || Nombre == null) { return null; }
		if(Telefono == "" || Telefono == null) { return null; }
		if(Correo == "" || Correo == null) { return null; }
		if(puesto == "" || puesto == null) { return null; }
		if(pass == "" || pass == null || pass.length() != 8) { return null; }
		//if(Dirección == null) { return null; }
		//if(LastUpdate == null) { return null; }
		
		establecerFecha();
		miEmpleado = new Empleado(Nombre,Telefono,Correo,puesto,true,establecerFecha(), pass);
		
		/*miEmpleado.Nombre = Nombre;
		miEmpleado.Telefono = Telefono;
		miEmpleado.Correo = Correo;
		miEmpleado.puesto = puesto;
		miEmpleado.Direccion = Direccion;
		miEmpleado.Activo = Activo;
		miEmpleado.LastUpdate = LastUpdate;*/
		return miEmpleado;
	}
	
	public Cliente CreateCliente(String Nombre, String Telefono, String Correo) {
		
		if(Nombre == "" || Nombre == null) { return null; }
		if(Telefono == "" || Telefono == null) { return null; }
		if(Correo == "" || Correo == null) { return null; }
		//if(LastUpdate == null) { return null; }
		
		establecerFecha();
		miCliente = new Cliente(Nombre, Telefono, Correo, establecerFecha());
		
		/*cliente.Nombre = Nombre;
		cliente.Telefono = Telefono;
		cliente.Correo = Correo;
		cliente.LastUpdate = LastUpdate;*/
		
		return miCliente;
	}	
	
	public Direccion CreateDireccion(
			Empleado empleado,
			String Direccion, 
			String Municipio, 
			String Estado, 
			String CodigoPostal) 
	{
		//if(empleado == null) { return null; }
		int idEmpleado = empleado.getId();
		if(ExisteElEmpleado(idEmpleado) == null) return null;
		if(Direccion == "" || Direccion == null) { return null; }
		if(Municipio == null) { return null; }
		if(Estado == null) { return null; }
		if(CodigoPostal == null) { return null; }
		
		establecerFecha();
		miDireccion = new Direccion(empleado, Direccion, Municipio, Estado, CodigoPostal, establecerFecha());
		
		/*direccion.Direccion = Direccion;
		direccion.Municipio = Municipio;
		direccion.Estado = Estado;
		direccion.CodigoPostal = CodigoPostal;*/
		
		return miDireccion;
	}
	

	
	private Date establecerFecha() {
		return new Date(System.currentTimeMillis());
	}
	
}