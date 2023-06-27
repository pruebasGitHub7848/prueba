package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.IBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuPrincipalController{

	/*
	 * Atributos 
	 */
	@FXML
	private Button btnHacerRegistro;

	@FXML
	private Button btnLogearAdmin;

	@FXML
	private Button btnLoginCliente;

	@FXML
	private Button btnLoginEmpleado;
	//__________________________________________________________________


	/*
	 * Metodo que permite hacer el registro de un cliente
	 */
	@FXML
	void btnHacerRegistroEvent(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RegistrarCliente.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Registro Cliente");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnLoginCliente.getScene().getWindow();
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
	 * Metodo que permite hacer el login como administrador
	 */
	@FXML
	void btnLogearAdminEvent(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginAdministrador.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Login Como Administrador");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnLogearAdmin.getScene().getWindow();
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
	 * Metodo que permite logearse como cliente.
	 */
	@FXML
	void btnLoginClienteEvent(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginCliente.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Logear Como Cliente");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnLoginCliente.getScene().getWindow();
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
	 * Metodo que permite hacer el login como empleado
	 */
	@FXML
	void btnLoginEmpleadoEvent(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginEmpleado.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Logear Como Empleado");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			Stage myStage = (Stage) this.btnLoginEmpleado.getScene().getWindow();
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
}
