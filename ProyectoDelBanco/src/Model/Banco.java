package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Banco implements IBanco{

	/*
	 * Atributos
	 */
	private HashSet<Cliente> listaClientes = new HashSet<Cliente>();
	private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
	private HashMap<String, Cuenta> listaCuentas = new HashMap<String, Cuenta>();
	private HashMap<String, Transaccion> listaTransacciones = new HashMap<String, Transaccion>();
	private ArrayList<Administrador> listaAdministradores = new ArrayList<Administrador>();

	Cliente cliente;
	Empleado empleado;
	//__________________________________________________________________
	
	
	/*
	 * Metodos Get and Set
	 */
	public HashSet<Cliente> getListaClientes() {
		return listaClientes;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public HashMap<String, Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setListaCuentas(HashMap<String, Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public HashMap<String, Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}

	public void setListaTransacciones(HashMap<String, Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	public ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public HashMap<String, Cuenta> getLsitaCuentas() {
		return listaCuentas;
	}

	public void setLsitaCuentas(HashMap<String, Cuenta> lsitaCuentas) {
		this.listaCuentas = lsitaCuentas;
	}

	public HashMap<String, Transaccion> getLsitaTransacciones() {
		return listaTransacciones;
	}

	public void setLsitaTransacciones(HashMap<String, Transaccion> lsitaTransacciones) {
		this.listaTransacciones = lsitaTransacciones;
	}

	public void setListaClientes(HashSet<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	//__________________________________________________________________
	
	
	/*
	 * Metodos Constructor
	 */
	public Banco(HashSet<Cliente> listaClientes, ArrayList<Empleado> listaEmpleados, HashMap<String, Cuenta> listaCuentas,
			HashMap<String, Transaccion> listaTransacciones) {
		super();
		this.listaClientes = listaClientes;
		this.listaEmpleados = listaEmpleados;
		this.listaCuentas = listaCuentas;
		this.listaTransacciones = listaTransacciones;
	}
	
	public Banco() {}
	//__________________________________________________________________

	/*
	 * Metodo que inicializa algunos datos
	 */
	public void init() {
		
		Administrador admin = new Administrador();
		admin.setCorreo("q");
		admin.setContrasenia("w");
		listaAdministradores.add(admin);
				
		Cliente c = new Cliente();
		c.setNombre("Lilith");
		c.setApellido("Campos");
		c.setCedula("333");
		c.setDireccion("Calle 13 #23-67");
		c.setTelefono("323577343");
		c.setCorreo("lilithCampos@gmail.com");
		c.setFechaNacimiento("24/06/2034");
		c.setCuenta("Ahorro");
		c.setContrasenia("lilith2442");
		Cuenta cuenta=new Cuenta();
		cuenta.setNumeroCuenta("123132");
		cuenta.setSaldo(0.0);
		c.setDefCuenta(cuenta);
		listaClientes.add(c);
		
		c = new Cliente();
		c.setNombre("Poly");
		c.setApellido("Arboleda");
		c.setCedula("2468");
		c.setDireccion("Calle 21 #06-04");
		c.setTelefono("3016025619");
		c.setCorreo("polyArboleda@gmail.com");
		c.setFechaNacimiento("28/06/2036");
		c.setCuenta("Corriente");
		c.setContrasenia("poly0129");
		cuenta=new Cuenta();
		cuenta.setNumeroCuenta("CA-012");
		cuenta.setSaldo(5.5);
		c.setDefCuenta(cuenta);
		listaClientes.add(c);		
		
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNombre("Woods");
		empleadoNuevo.setApellido("Luna");
		empleadoNuevo.setCedula("1357");
		empleadoNuevo.setDireccion("Calle 25 #256-23");
		empleadoNuevo.setTelefono("7654");
		empleadoNuevo.setCorreo("WoodsBueno@gmail.com");
		empleadoNuevo.setFechaNacimiento("13/06/2000");
		empleadoNuevo.setTipoCuenta("Gerente");
		empleadoNuevo.setCodigo("0129344");
		empleadoNuevo.setSalario(344.21);
		empleadoNuevo.setContrasenia("Parcero");
		listaEmpleados.add(empleadoNuevo);
		
		empleadoNuevo = new Empleado();
		empleadoNuevo.setNombre("Cilian");
		empleadoNuevo.setApellido("Murphy");
		empleadoNuevo.setCedula("13467");
		empleadoNuevo.setDireccion("Cra 15 #54-40");
		empleadoNuevo.setTelefono("3214000");
		empleadoNuevo.setCorreo("w");
		empleadoNuevo.setFechaNacimiento("31/01/1996");
		empleadoNuevo.setTipoCuenta("Asesor de Cuentas");
		empleadoNuevo.setCodigo("012933");
		empleadoNuevo.setSalario(344.21);
		empleadoNuevo.setContrasenia("q");
		listaEmpleados.add(empleadoNuevo);
		
		Cuenta nuevaCuenta = new Cuenta();
		nuevaCuenta.setNumeroCuenta("65667587");
		nuevaCuenta.setSaldo(34523.23);
		listaCuentas.put("12A-34", nuevaCuenta);	
		
		nuevaCuenta = new Cuenta();
		nuevaCuenta.setNumeroCuenta("23424");
		nuevaCuenta.setSaldo(2222.23);
		listaCuentas.put("12A-35", nuevaCuenta);	
		
		Transaccion nuevaTransaccion = new Transaccion();
		nuevaTransaccion.setFecha("23/06/2022");
		nuevaTransaccion.setHora("16:23 PM");
		nuevaTransaccion.setValor(32156.12);
		listaTransacciones.put("12B-11", nuevaTransaccion);
		
		nuevaTransaccion = new Transaccion();
		nuevaTransaccion.setFecha("13/09/2021");
		nuevaTransaccion.setHora("10:13 PM");
		nuevaTransaccion.setValor(43323.12);
		listaTransacciones.put("12B-12", nuevaTransaccion);

		
		System.out.println("Datos inicializados");
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite logearse como administrador
	 */
	public boolean loginAdministrador(Administrador admin) {

		int flag = 0;
		
		for (Administrador administrador : listaAdministradores) {
			if(administrador.getCorreo().equals(admin.getCorreo()) &&
					administrador.getContrasenia().equals(admin.getContrasenia())){
				flag = 1;
			}
		}
		if(flag == 1) {
			System.out.println("tr");
			return true;
		}
		
		return false;
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite verificar la cedula de un cliente
	 */
	public boolean verificarCedulaCliente(Cliente nuevoCliente) {
		
		int flag = 1;
		
		Iterator<Cliente> iterador = listaClientes.iterator();
	    while (iterador.hasNext()) {
	    	
	      Cliente clienteLista = iterador.next();
	      if(clienteLista.getCedula().equals(nuevoCliente.getCedula())) {
	    	  flag = 0;
	      }
	    }
	    
	    if(flag == 1) {
	    	System.out.println("true");
	    	return true;
	    }
		
		return false;
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite crear un cliente
	 */
	public void crearCliente(Cliente nuevoCliente) {
		
		System.out.println(nuevoCliente.getDefCuenta().getNumeroCuenta());
		listaClientes.add(nuevoCliente);
		
		listaCuentas.put("CN01", nuevoCliente.getDefCuenta());
	
		System.out.println("Cliente agregado con exito");
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite consultar el saldo de un cliente
	 */
	public Double consultarSaldo(String numeroCuenta, Cuenta saldo) {

		int flag = 0;
		
		double saldoC = 0;

		for (Map.Entry<String, Cuenta> entry : listaCuentas.entrySet()) {

			if(numeroCuenta.equals(entry.getValue().getNumeroCuenta())) {
				flag = 1;
				
				saldoC = entry.getValue().getSaldo();
			}
		}
		
		if(flag == 1) {
			return saldoC;
		}
		
		
		return 0.0;
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite hacer el deposito de una cuenta
	 */
	public boolean depositarDinero(double dineroDepositar, String clienteAux) {
		
		int flag = 0;
		
		for (Map.Entry<String, Cuenta> entry : listaCuentas.entrySet()) {

			if(entry.getValue().getNumeroCuenta().equals(clienteAux)) {
				flag = 1;
			}
		}
		
		if(flag == 1) {
			System.out.println("dwasda");
			return true;
		}
		
		return false;
	}
	//__________________________________________________________________

	/*
	 * Metodo que permite crear transacciones y agregarlas a la lista de transacciones
	 */
	public void crearTransaccion(Transaccion transaccionNueva) {
		
		listaTransacciones.put("TR01", transaccionNueva);
		System.out.println("Transa añadida");
		
	}
	//__________________________________________________________________

	
	/*
	 * Metodoq ue permite obtener un cliente
	 */
	public String obtenerCliente(String cedula) {
		
		int flag = 0;
		
		String cliente = "";
		
		Iterator<Cliente> iterador = listaClientes.iterator();
		while(iterador.hasNext()) {
			Cliente clienteLista = iterador.next();
			if(clienteLista.getCedula().equals(cedula)) {
				flag = 1;
			}
			
			if(flag == 1) {
				cliente = clienteLista.toString();
				break;
			}
		}

		return cliente;
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite obtener un cliente como objeto
	 */
	public Cliente obtenerObjetoCliente(String cedula) {

		int flag = 0;

		Cliente cliente = null;

		Iterator<Cliente> iterador = listaClientes.iterator();
		while(iterador.hasNext()) {
			Cliente clienteLista = iterador.next();
			if(clienteLista.getCedula().equals(cedula)) {
				flag = 1;
			}

			if(flag == 1) {
				cliente = clienteLista;
				break;
			}
		}

		return cliente;
	}
	//__________________________________________________________________
	
	
	/*
	 * Metodo que permite obtener un cliente mediante su contraseña
	 */
	public Cliente obtenerObjetoClienteContrasenia(String contrasenia) {

		int flag = 0;

		Cliente cliente = null;

		Iterator<Cliente> iterador = listaClientes.iterator();
		while(iterador.hasNext()) {
			Cliente clienteLista = iterador.next();
			if(clienteLista.getContrasenia().equals(contrasenia)) {
				flag = 1;
			}

			if(flag == 1) {
				cliente = clienteLista;
				break;
			}
		}

		return cliente;
	}
	//__________________________________________________________________

	/*
	 * Metodo que permite modificar un cliente
	 */
	public void modificarCliente(Cliente nuevoCliente) {
		
		Iterator<Cliente> iterador = listaClientes.iterator();
		
		while(iterador.hasNext()) {
			Cliente cambiarCliente = iterador.next();
			
			if(cambiarCliente.getCedula().equals(nuevoCliente.getCedula())) {
				
	
				cambiarCliente.setNombre(nuevoCliente.getNombre());
				cambiarCliente.setApellido(nuevoCliente.getApellido());
				cambiarCliente.setCedula(nuevoCliente.getCedula());
				cambiarCliente.setDireccion(nuevoCliente.getDireccion());
				cambiarCliente.setTelefono(nuevoCliente.getTelefono());
				cambiarCliente.setCorreo(nuevoCliente.getCorreo());
				cambiarCliente.setFechaNacimiento(nuevoCliente.getFechaNacimiento());
				cambiarCliente.setCuenta(nuevoCliente.getCuenta());
				cambiarCliente.setContrasenia(nuevoCliente.getContrasenia());
				cambiarCliente.getDefCuenta().setNumeroCuenta(nuevoCliente.getDefCuenta().getNumeroCuenta());
				cambiarCliente.getDefCuenta().setSaldo(nuevoCliente.getDefCuenta().getSaldo());
				
				System.out.println("Ca");
				
				
				
			}
			System.out.println(cambiarCliente.getNombre());
		}
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite eliminar un cliente
	 */
	public boolean eliminarCliente(Cliente clienteSeleccionado) {
		
		listaClientes.remove(clienteSeleccionado);
		System.out.println("Cliente eliminado pa");
		
		return true;
		
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite verificar un empleado
	 */
	public boolean verificarCedulaEmpleado(Empleado nuevoEmpleado) {
		
		int flag = 1;
		
		Iterator<Empleado> iterador = listaEmpleados.iterator();
		while(iterador.hasNext()) {
			Empleado consultaEmpleado = iterador.next();
			
			if(consultaEmpleado.getCedula().equals(nuevoEmpleado.getCedula())) {
				flag = 0;
			}
		}
		
		if(flag == 1) {
			return true;
		}
		return false;
	}
	//__________________________________________________________________

	/*
	 * Metodo que permite crear un empleado y agregarlo a la lista
	 */
	public void crearEmpleado(Empleado nuevoEmpleado) {
		
		listaEmpleados.add(nuevoEmpleado);
		System.out.println("Empleado creado con exito pa.");
	}
	//__________________________________________________________________

	/*
	 * Metodo que permite obtener el toString de un empleado
	 */
	public String obtenerEmpleado(String cedula) {
		
		int flag = 0;
		
		String empleado = "";
		
		Iterator<Empleado> iterador = listaEmpleados.iterator();
		while(iterador.hasNext()) {
			Empleado empleadoEnLista = iterador.next();
			if(empleadoEnLista.getCedula().equals(cedula)) {
				flag = 1;
			}
			
			if(flag == 1) {
				empleado = empleadoEnLista.toString();
				break;
			}
		}

		return empleado;
	}
	//__________________________________________________________________

	/*
	 * Metodo que permite obtneer el objeto empleado
	 */
	public Empleado obtenerObjetoEmpleado(String cedula) {
		
		int flag = 0;

		Empleado empleado = null;

		Iterator<Empleado> iterador = listaEmpleados.iterator();
		while(iterador.hasNext()) {
			Empleado empleadoEnLista = iterador.next();
			if(empleadoEnLista.getCedula().equals(cedula)) {
				flag = 1;
			}

			if(flag == 1) {
				empleado = empleadoEnLista;
				break;
			}
		}

		return empleado;
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite eliminar un empleado
	 */
	public boolean eliminarEmpleado(Empleado empleadoSeleccionado) {
		
		listaEmpleados.remove(empleadoSeleccionado);
		System.out.println("Empleado eliminado pa");
		
		return true;
		
	}
	//__________________________________________________________________
	
	/*
	 * Metodo que permite obtener el saldo
	 */
	public Cliente obtenerSaldo(Cliente cliente) {
		
		Cliente clienteBuscar = null;
		
		Iterator<Cliente> iterador = listaClientes.iterator();
		while(iterador.hasNext()) {
			Cliente empleadoEnLista = iterador.next();
			if(empleadoEnLista.getCedula().equals(cliente.getCedula())) {
				
				clienteBuscar = empleadoEnLista;
				return clienteBuscar;
			}
		}
		return clienteBuscar;
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite hacer la modificacion de un empleado
	 */
	public void modificarEmpleado(Empleado nuevoEmpleado) {
	
		Iterator<Empleado> iterador = listaEmpleados.iterator();
		
		int flag = 0;
		
		while(iterador.hasNext()) {
			Empleado cambiarEmpleado = iterador.next();
			
			if(cambiarEmpleado.getCedula().equals(nuevoEmpleado.getCedula())) {
				
				cambiarEmpleado.setNombre(nuevoEmpleado.getNombre());
				cambiarEmpleado.setApellido(nuevoEmpleado.getApellido());
				cambiarEmpleado.setCedula(nuevoEmpleado.getCedula());
				cambiarEmpleado.setDireccion(nuevoEmpleado.getDireccion());
				cambiarEmpleado.setTelefono(nuevoEmpleado.getTelefono());
				cambiarEmpleado.setCorreo(nuevoEmpleado.getCorreo());
				cambiarEmpleado.setFechaNacimiento(nuevoEmpleado.getFechaNacimiento());
				cambiarEmpleado.setCodigo(nuevoEmpleado.getCodigo());
				cambiarEmpleado.setSalario(nuevoEmpleado.getSalario());
				cambiarEmpleado.setContrasenia(nuevoEmpleado.getContrasenia());
				cambiarEmpleado.setTipoCuenta(nuevoEmpleado.getTipoCuenta());
				
			}
		}
		
		if(flag == 1) {
			listaEmpleados.add(nuevoEmpleado);
			System.out.println("Empleado añadido pa");
		}
	}
	//__________________________________________________________________
	

	/*
	 * Metodo que permite hacer el login de los clientes
	 */
	public boolean loginClientes(String correo, String contrasenia) {
		Iterator<Cliente> iterador = listaClientes.iterator();
		
		while(iterador.hasNext()) {
			Cliente clienteEnLista = iterador.next();
			
			if(clienteEnLista.getCorreo().equals(correo) &&
					clienteEnLista.getContrasenia().equals(contrasenia)) {
				return true;
			}
		}
		return false;
	}
	//__________________________________________________________________

	public Empleado loginEmpleados(String correo, String contrasenia) {
		
//		for (Empleado empleado : listaEmpleados) {
//			if(empleado.getCorreo().equals(correo) && empleado.getContrasenia().equals(contrasenia)) {
//				return empleado;
//			}
//		}
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).getCorreo().equals(correo) && listaEmpleados.get(i).getContrasenia().equals(contrasenia)) {
				return listaEmpleados.get(i);
			}
		}
		return null;
	}


}
