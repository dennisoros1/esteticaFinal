package kernel.datos;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import kernel.factory.*;
import kernel.models.*;

public class CrudCitas {
	SessionFactory miSessionFactory;
	Session miSession;
	Factory miFactory;
	long now;
	Date sqlDate;

	public void insertarCitas(
			
			String nombreCliente, 
			String nombreEmpleado, 
			Date fechaCita, 
			float montoTotal){
		
		inicializarSesiones();
		
		try {
		
			miSession.beginTransaction();
			List<Cliente> misClientes = miSession.createQuery(
					"from Cliente cl where cl.nombre='"+ nombreCliente + "'").getResultList();
			List<Empleado> misEmpleados = miSession.createQuery(
					"from Empleado em where em.nombre='" + nombreEmpleado + "'").getResultList();

			if (misClientes.size()>0 && misEmpleados.size()>0) {
				Cliente miCliente = misClientes.get(0);
				Empleado miEmpleado = misEmpleados.get(0);	

				Cita miCita = miFactory.CreateCita(miCliente.getId(), miEmpleado.getId(), fechaCita, montoTotal);
				
				if (miCita == null) System.out.println("ha habido un error creando la cita...");
				else {
					miCliente.agregarCitas(miCita);
					miEmpleado.agregarCitas(miCita);
					miSession.save(miCita);
					miSession.getTransaction().commit();
					System.out.println("¡Cita Creada!" + miCita);
				}
				
			} else System.out.println("el cliente o el empleado introducido no existe en los registros!!" + misClientes.get(0) + misEmpleados.get(0));		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			cerrarSesiones();
		}
	}
	
	public void insertarCitas(int idCliente, int idEmpleado, Date fechaCita, float montoTotal) {
		inicializarSesiones();
		try {
			miSession.beginTransaction();
			Cliente miCliente = miSession.get(Cliente.class, idCliente);
			Empleado miEmpleado = miSession.get(Empleado.class, idEmpleado);
			
			Cita miCita = miFactory.CreateCita(idCliente, idEmpleado, fechaCita, montoTotal);
			if(miCita == null) {
				System.out.println("Ha habido un error creando la cita... ");
			} else {
				miCliente.agregarCitas(miCita);
				miEmpleado.agregarCitas(miCita);
				
				miSession.save(miCita);
				System.out.println(miCita);
				
				miSession.getTransaction().commit();
				System.out.println("¡Cita Creada!" + miCita);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			cerrarSesiones();
		}
	}	
	
	
	public boolean ExisteLaCita(int _IdCliente, int _IdEmpleado, Date Fecha) { 
		boolean existeCita; 
			
		inicializarSesiones();
		
		List<Cita> misCitas = miSession.createQuery("from Cita ci where cliente.id=" + _IdCliente + " and empleado.id=" + _IdEmpleado + " and ci.fecha='" + Fecha + "'").getResultList();
		System.out.println(misCitas);
			
		if(misCitas.isEmpty()) {
			existeCita = false;
		}else {
			existeCita = true;
			System.out.println("La cita ya existe!!!");
		}
		cerrarSesiones();
		return existeCita;
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
	
	private void cerrarSesiones() {
		miSessionFactory.close();
		miSession.close();
	}
	
	//private Date getDateNow() {		
		//now = System.currentTimeMillis();
		//return (sqlDate = new Date(now));
	//}
}