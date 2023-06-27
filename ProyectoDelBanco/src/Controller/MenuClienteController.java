package Controller;

import java.io.IOException;

import Model.Cliente;
import Model.Cuenta;
import Model.IBanco;
import Model.ICuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuClienteController {
	
	/*
	 * Atributo que permite saber de que cliente se esta hablando
	 */
	private Cliente cliente = ICuenta.obtenerCliente();
	//__________________________________________________________________
	
	
	/*
	 * Atributos
	 */
    @FXML
    private Button btnConsultarDinero;

    @FXML
    private Button btnDepositarDinero;

    @FXML
    private Label labelCliente;
    
    @FXML
    private Button btnRetirarDinero;

    @FXML
    private Button btnVolver;
    //__________________________________________________________________

    
    /*
     * Metodo que permite saber el saldo actual del cliente
     */
    @FXML
    void btnConsultarDineroEvent(ActionEvent event) {

    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Notificacion");
		alert.setContentText("Su saldo actual es de: " + cliente.getDefCuenta().getSaldo() + "$");
		alert.showAndWait();
		
    }
  //__________________________________________________________________
    
    
    /*
     * Metodo que abre la interfaz para el deposito de dinero
     */
    @FXML
    void btnDepositarDineroEvent(ActionEvent event) {
    	
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DepositarDinero.fxml"));
			Parent root = loader.load();

			DepositarDineroController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			controlador.init();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Depositar Dinero");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnDepositarDinero.getScene().getWindow();
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
     * Metodo que permite abrir la interfaz para el retirno de dinero
     */
    @FXML
    void btnRetirarDineroEvent(ActionEvent event) {

    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RetirarDinero.fxml"));
			Parent root = loader.load();

			RetirarDineroController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			controlador.init();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Retirar Dinero");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnRetirarDinero.getScene().getWindow();
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
     * Metodo que permite vovler al menu principal
     */
    @FXML
    void volver(ActionEvent event) {

    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MenuPrincipal.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Menu Principal");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
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
     * Metodo que inicializa el cliente del que se esta haciendo referencia
     */
    public void init() {
    	labelCliente.setText(cliente.getNombre().toUpperCase());
	}
  //__________________________________________________________________

}