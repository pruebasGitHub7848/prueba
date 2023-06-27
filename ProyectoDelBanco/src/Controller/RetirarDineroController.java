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

public class RetirarDineroController {
	
	/*
	 * Metodo que permite saber de que cliente se esta hablando
	 */
	private Cliente cliente = ICuenta.banco.getCliente();
	//__________________________________________________________________
	
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
    //__________________________________________________________________
    
    
    /*
     * Metodoq que permite retirar dinero
     */
    @FXML
    void btnRetirarDineroEvent(ActionEvent event) {
    	
    	double dineroRetirar = Double.parseDouble(this.txtDineroDepositar.getText());

    	if(this.txtDineroDepositar.getText().equals("")) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setTitle("Notificacion");
        	alert.setContentText("Agregue el valor que desea retirar.");
        	alert.showAndWait();
    	}else {
    		if(verificarDinero(dineroRetirar)) {
    	    	
    	    	Double dineroDelCliente = ICuenta.banco.getCliente().getDefCuenta().getSaldo();

        		Double retirarDinero = ICuenta.banco.getCliente().getDefCuenta().setSaldo(dineroDelCliente - dineroRetirar);
            	
            	this.cliente.getDefCuenta().setSaldo(retirarDinero);
            	
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            	alert.setHeaderText(null);
            	alert.setTitle("Notificacion");
            	alert.setContentText("Transaccion realizada con exito.");
            	alert.showAndWait();
            	
            	crearTransaccion(dineroRetirar);
            	
            	try {

        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MenuCliente.fxml"));
        			Parent root = loader.load();

        			MenuClienteController controlador = loader.getController();
        			Scene scene = new Scene(root);
        			Stage stage = new Stage();
        			controlador.init();
        			stage.initModality(Modality.APPLICATION_MODAL); 
        			stage.setTitle("Menu del Cliente");
        			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
        			stage.setScene(scene);
        			stage.setResizable(false);
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
     * Metodo que permite crear la transaccion
     */
    private void crearTransaccion(double dineroRetirar) {
		
    	LocalDate fechaLocaldate = LocalDate.now();
    	
    	String fecha = fechaLocaldate.toString();
    	
    	LocalTime horaLocalDate = LocalTime.now();
    	
    	String hora = horaLocalDate.toString();
    	
    	double valor = dineroRetirar;
    	
    	Transaccion transaccionNueva = new Transaccion(fecha, hora, valor, this.cliente.getDefCuenta());
    	
    	ICuenta.banco.crearTransaccion(transaccionNueva);
    	
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
     * Metodo que permite verificar que el dinero ha retirar sea meno o igualq ue ele dinero actual
     */
	private boolean verificarDinero(double dineroRetirar) {
		
    	if(dineroRetirar <= ICuenta.banco.getCliente().getDefCuenta().getSaldo()) {
    		return true;
    	}
		return false;
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite vovler al menu del cliente
	 */
	@FXML
    void volver(ActionEvent event) {
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MenuCliente.fxml"));
			Parent root = loader.load();

			MenuClienteController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			controlador.init();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Menu del Cliente");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
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
	 * Metodo que permite inicializar el cliente del que se esta hablando
	 */
    public void init() {
    	labelNombre.setText(cliente.getNombre().toUpperCase());
	}
  //__________________________________________________________________

}