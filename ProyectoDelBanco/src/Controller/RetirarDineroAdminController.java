package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import Model.Cliente;
import Model.IBanco;
import Model.ICuenta;
import Model.Transaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RetirarDineroAdminController {
	
	/*
	 * Atributoque permitira saber de que cliente se esta haciendo el retiro de 
	 * dinero
	 */
	private Cliente cliente = IBanco.retirarDinero();

	/*
	 * Atributos
	 */
    @FXML
    private Button btnRetirarDinero;

    @FXML
    private Button btnVolver;

    @FXML
    private Label labelNombre;

    @FXML
    private TextField txtDineroDepositar;

    
    /*
     * Metodo que permite retirar dinero haciendo las verificaciones necesarias
     */
    @FXML
    void btnRetirarDineroEvent(ActionEvent event) {

    	double dineroRetirar = Double.parseDouble(this.txtDineroDepositar.getText());
    	
    	Double dineroDelCliente = IBanco.banco.getCliente().getDefCuenta().getSaldo();
    	
    	if(this.txtDineroDepositar.getText().equals("")) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setTitle("Notificacion");
        	alert.setContentText("Agregue el valor que desea retirar.");
        	alert.showAndWait();
    	}else {
    		if(verificarDinero(dineroRetirar)) {

        		Double retirarDinero = IBanco.banco.getCliente().getDefCuenta().setSaldo(dineroDelCliente - dineroRetirar);
            	
            	this.cliente.getDefCuenta().setSaldo(retirarDinero);
            	
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            	alert.setHeaderText(null);
            	alert.setTitle("Notificacion");
            	alert.setContentText("Transaccion realizada con exito.");
            	alert.showAndWait();
            	
            	crearTransaccion(dineroRetirar);
            	
            	try {

        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/IBancoAdministrador.fxml"));
        			Parent root = loader.load();

        			Scene scene = new Scene(root);
        			Stage stage = new Stage();
        			stage.initModality(Modality.APPLICATION_MODAL); 
        			stage.setTitle("Menu del Administrador");
        			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
        			stage.setScene(scene);
        			stage.show();
        			Stage myStage = (Stage) this.btnRetirarDinero.getScene().getWindow();
        			myStage.close();

        		} catch (IOException ex) {

        			alert = new Alert(Alert.AlertType.ERROR);
        			alert.setHeaderText(null);
        			alert.setTitle("Error");
        			alert.setContentText(ex.getMessage());
        			alert.showAndWait();
        		}
        	}else {
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            	alert.setHeaderText(null);
            	alert.setTitle("Notificacion");
            	alert.setContentText("Dinero insuficiente");
            	alert.showAndWait();
        	}
    	}
    }
  //__________________________________________________________________
    
   
    /*
     * Metodo que permite generar la transaccion una vez hecho el retiro
     */
    private void crearTransaccion(double dineroRetirar) {
		
    	LocalDate fechaLocaldate = LocalDate.now();
    	
    	String fecha = fechaLocaldate.toString();
    	
    	LocalTime horaLocalDate = LocalTime.now();
    	
    	String hora = horaLocalDate.toString();

    	double valor = dineroRetirar;

    	Transaccion transaccionNueva = new Transaccion(fecha, hora, valor, this.cliente.getDefCuenta());

    	IBanco.realizarTransaccion(transaccionNueva);

    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("Notificacion");
    	alert.setContentText("Datos de la transaccion hecha:" + "\n" +
    			"Fecha: " + fecha + "\n" +
    			"Hora: " + hora + "\n"	+
    			"Valor: " + valor + "$" + "\n" +
    			"Numero de cuenta: " + this.cliente.getDefCuenta().getNumeroCuenta());
    	alert.showAndWait();
		
	}
  //__________________________________________________________________

    
    /*
     * Metodo que verifica que el dinero ha retirar sea menor o igual que el dinero
     * actual.
     */
	private boolean verificarDinero(double dineroRetirar) {
		
    	if(dineroRetirar <= IBanco.banco.getCliente().getDefCuenta().getSaldo()) {
    		return true;
    	}
		return false;
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permita volver al menu principal
	 */
	@FXML
    void volver(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/IBancoAdministrador.fxml"));
			Parent root = loader.load();

//			MenuClienteController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
//			controlador.init();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Menu del Administrador");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.show();
			Stage myStage = (Stage) this.btnVolver.getScene().getWindow();
			myStage.close();

		} catch (IOException ex) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
		}
    }
	//__________________________________________________________________
    
	
	/*
	 * Metodo que inicializa el cliente
	 */
    public void init() {
    	labelNombre.setText(cliente.getNombre().toUpperCase());
	}
  //__________________________________________________________________

}
