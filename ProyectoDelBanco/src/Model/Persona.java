package Model;

import java.util.Objects;

public class Persona extends Cuenta{

	//Atributos
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private String correo;
	private String fechaNacimiento;
	//________________________________________________________________
	
	//Metodos Constructor
	public Persona(String nombre, String apellido, String cedula, String direccion, String telefono, String correo,
			String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Persona() {}
	
	
	//________________________________________________________________
	
	
	//Metodos Get and Set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//________________________________________________________________
	
	//Metodos hasCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(apellido, cedula, correo, direccion, fechaNacimiento, nombre, telefono);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(cedula, other.cedula)
				&& Objects.equals(correo, other.correo) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}
	//_______________________________________________________________
	
	
	//Metodo toString
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n"
				+ "Apellido: " + apellido + "\n"
						+ "Cedula: " + cedula + "\n"
								+ "Direccion: " + direccion + "\n"
										+ "Telefono: " + telefono + "\n"
												+ "Correo: " + correo + "\n"
														+ "FechaNacimiento: " + fechaNacimiento;
								
	}

	//________________________________________________________________
	
	
}
