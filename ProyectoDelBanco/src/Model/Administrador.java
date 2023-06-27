package Model;

import java.util.Objects;

public class Administrador {

	/*
	 * Atributos
	 */
	private String correo;
	private String contrasenia;
	//__________________________________________________________________
	
	/*
	 * Metodos constructor
	 */
	public Administrador() {}
	
	public Administrador(String correo, String contrasenia) {
		super();
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	//__________________________________________________________________
	
	/*
	 * Metodos Get and Set
	 */
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	//__________________________________________________________________

	
	/*
	 * Metodo hasCode and equals
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contrasenia, correo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(contrasenia, other.contrasenia) && Objects.equals(correo, other.correo);
	}
	//__________________________________________________________________

	/*
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Administrador [correo=" + correo + ", contrasenia=" + contrasenia + "]";
	}
	//__________________________________________________________________
	
}
