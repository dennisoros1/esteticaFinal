package kernel.datos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import kernel.factory.*;
import kernel.models.*;

public class CrudEmpleados {
	
	SessionFactory miSessionFactory;
	Session miSession;
	Factory miFactory;


	public void insertarEmpleados(
			String nombre, 
			String telefono, 
			String correo, 
			String puesto, 
			String pass, 
			String direccion, 
			String municipio, 
			String estado, 
			String codigoPostal) {
		
		inicializarSesiones();
		
		try {
			
			miSession.beginTransaction();
			Empleado miEmpleado = 
					miFactory.CreateEmpleado(
					nombre, 
					telefono, 
					correo, 
					puesto, 
					pass);
			
			if (miEmpleado == null) System.out.println("Error creando al empleado!!");
			else {
				
				miSession.save(miEmpleado);
				Direccion miDireccion = miFactory.CreateDireccion(
						miEmpleado, 
						direccion, 
						municipio, 
						estado, 
						codigoPostal);
				if (miDireccion == null) System.out.println("Error creando la direccion..."); 
				else{
					miEmpleado.agregarDireccion(miDireccion);
					miSession.save(miDireccion);
					miSession.getTransaction().commit();
					System.out.println("¡Empleado Creado! " + miEmpleado);
					System.out.println("Direccion relacionada: " + miDireccion);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			miSession.close();
			miSessionFactory.close();
		}
	}
	
	private void inicializarSesiones() {
		
		miSessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Cita.class)
				.addAnnotatedClass(Empleado.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
		
		miSession = miSessionFactory.openSession();
		miFactory = new Factory();
	}
	
	
	
	public Empleado GetEmpleado(int _IdEmpleado) {
		inicializarSesiones();
		return miSession.get(Empleado.class, _IdEmpleado);
	}


	public boolean Login(String _Nombre, String _Pass) {

		inicializarSesiones();
        
		List<Empleado> Empleados = miSession.createQuery("from Empleado").getResultList();
		
		if(Empleados != null) {	
			for(Empleado empleado:Empleados) {
				
				if(empleado.getPass() == null) {
					if(empleado.getNombre().equals(_Nombre)) {
						return true;
					}				
				}
				
				if(empleado.getNombre().equals(_Nombre) && empleado.getPass().equals(_Pass)) {
					return true;
				}
			}			
		}

		return false;
	}
}

	
	
	
	
	