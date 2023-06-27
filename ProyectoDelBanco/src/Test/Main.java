package Test;

import java.util.Iterator;
import java.util.Map;

import Model.Banco;
import Model.Cuenta;

public class Main {

	public static void main(String[] args) {
	
		Banco b = new Banco();
		
		b.init();
		
		Iterator<Map.Entry<String, Cuenta>> iterator = b.getLsitaCuentas().entrySet().iterator();
				
		while(iterator.hasNext()) {
			Map.Entry<String, Cuenta> entry = iterator.next();
			System.out.println("Clave " + entry.getKey() + ", Numero de cuenta: " + entry.getValue().getNumeroCuenta() +
					", Saldo: " + entry.getValue().getSaldo());
		}
	}

}
