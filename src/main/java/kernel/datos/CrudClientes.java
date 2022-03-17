package kernel.datos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import kernel.factory.*;
import kernel.models.*;

public class CrudClientes {
	
	SessionFactory miSessionFactory;
	Session miSession;
	Factory miFactory;

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
	
	public void insertarClientes(String nombre, String telefono, String email) {
		inicializarSesiones();
		try {
			
			Cliente miCliente = miFactory.CreateCliente(nombre, telefono, email);
			
			miSession.beginTransaction();
			miSession.save(miCliente);
			System.out.println(miCliente);
			miSession.getTransaction().commit();
			System.out.println("¡Cliente insertado! Con id: " + miCliente.getId());
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			miSession.close();
			miSessionFactory.close();
		}
	}
	
	public Cliente GetCliente(int _IdCliente) {
		inicializarSesiones();
		return miSession.get(Cliente.class, _IdCliente);
	}
	
	
}