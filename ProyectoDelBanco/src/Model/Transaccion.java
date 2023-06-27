package Model;

import java.util.Objects;

public class Transaccion {

	//Atributos
	private String fecha;
	private String hora;
	private Double valor;
	private Cuenta cuenta;
	//________________________________________________________________
	
	//Metodos Constructor

	public Transaccion() {}
	public Transaccion(String fecha, String hora, Double valor, Cuenta cuenta) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.valor = valor;
		this.cuenta = cuenta;
	}
	//________________________________________________________________
	

	//Metodos Get and Set
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	//________________________________________________________________
	
	
	//Metodo hasCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora)
				&& Objects.equals(valor, other.valor);
	}
	//________________________________________________________________
	
	
	//Metodo toString
	@Override
	public String toString() {
		return "Transaccion [fecha=" + fecha + ", hora=" + hora + ", valor=" + valor + "]";
	}
	//________________________________________________________________
	
}
