package Model;

public interface IEmpleado {

	/*
	 * Declaracion para acceder a la clase banco
	 */
	Banco banco = new Banco();
	//__________________________________________________________________

	
	/*
	 * Metodo que permite hacer la verificación del empleado
	 */
	static Empleado loginEmpleado(String correo, String contrasenia) {
		return banco.loginEmpleados(correo, contrasenia);
	}
	//__________________________________________________________________
	
	/*
	 * Metodo que nos permite inicializar datos para los empleados
	 */
	static void init() {
		banco.init();
	}
	//__________________________________________________________________
}
