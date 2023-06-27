package Model;

import java.util.Objects;
import java.util.TreeSet;

public class Empleado extends Persona {

	//Atributos
	private String codigo;
	private double salario;
	private String contrasenia;
	private String tipoCuenta;
	//__________________________________________________________________
	
	
	//Metodos Constructor
	
	public Empleado() {}
	
	
	public Empleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo,
			String fechaNacimiento, String codigo, double salario, String contrasenia, String tipoCuenta) {
		super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
		this.codigo = codigo;
		this.salario = salario;
		this.contrasenia = contrasenia;
		this.tipoCuenta = tipoCuenta;
	}


	//__________________________________________________________________
	
	
	//Metodos Get and Set
	
	//__________________________________________________________________
	
	
	//Metodo hasCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(codigo, salario);
	}
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Double getSalario() {
		return salario;
	}


	public Double setSalario(double salario) {
		return this.salario = salario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(codigo, other.codigo)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	//__________________________________________________________________
	
	//Metodo toString

	@Override
	public String toString() {
		return "Codigo: " + codigo + "\n"
				+ "Salario: " + salario + "\n"
				+ "Tipo de Cuenta: " + tipoCuenta;
	}

//	@Override
//	public int compareTo(Empleado o) {
//		// TODO Auto-generated method stub
//		return this.getCodigo().compareTo(codigo);
//	}
	//__________________________________________________________________


	
	
	

}
