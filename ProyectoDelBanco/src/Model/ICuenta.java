package Model;

public interface ICuenta {

	/*
	 * Declaracion para acceder a la clase banco
	 */
	Banco banco = new Banco();
	//__________________________________________________________________
	
	/*
	 * Metodo que permite retirar dinero de una cuenta
	 */
	public static Cliente retirarDinero() {
		return banco.getCliente();
	}
	//__________________________________________________________________
	
	/*
	 * Metodo que permite hacer deposito de dinero
	 */
	static Cliente depositarDinero() {
		return banco.getCliente();
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite obtener un cliente
	 */
	static Cliente obtenerCliente() {
		return banco.getCliente();
	}
	//__________________________________________________________________
	
	/*
	 * Metodo que permite consultar el saldo de una cuenta
	 */
	public static Double consultarSaldo(String numeroCuenta, Cuenta saldo) {
		return banco.consultarSaldo(numeroCuenta, saldo);
	}
	//__________________________________________________________________
}
