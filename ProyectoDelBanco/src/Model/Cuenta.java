package Model;

public class Cuenta implements ICuenta{

	//Atributos
	private String numeroCuenta;
	private double saldo;
	
	//_________________________________________________________
	
	//Metodo Constructor
	public Cuenta(String numeroCuenta, Double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	
	public Cuenta(String numeroCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
	}
	
	public Cuenta() {}
	//_________________________________________________________
	
	//Metodo Get and Set
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double setSaldo(Double saldo) {
		return this.saldo = saldo;
		
	}
	//__________________________________________________________________

	//Metodo toString
	@Override
	public String toString() {
		return numeroCuenta;
	}
	//__________________________________________________________________
	
	
	
}
