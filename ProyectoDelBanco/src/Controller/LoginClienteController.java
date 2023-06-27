package Controller;

import java.io.IOException;

import Model.Cliente;
import Model.IBanco;
import Model.ICuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginClienteController {

	/*
	 * Atributos
	 */
	@FXML
	private Button btnLogear;

	@FXML
	private Button btnVolver;

	@FXML
	private PasswordField txtContrasenia;

	@FXML
	private TextField txtCorreo;
	//__________________________________________________________________

	/*
	 * Metodo que permite logear un cliente verificando el correo y su contraseña
	 */
	@FXML
	void logearEvent(ActionEvent event) {

		String correo = txtCorreo.getText();
		String contrasenia = txtContrasenia.getText();
	
		if(IBanco.banco.loginClientes(correo, contrasenia)) {

			Cliente obtenerCliente = IBanco.banco.obtenerObjetoClienteContrasenia(contrasenia);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Bienvenido");
			alert.showAndWait();

			ICuenta.banco.setCliente(obtenerCliente);

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
				Stage myStage = (Stage) this.btnLogear.getScene().getWindow();
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
			alert.setContentText("Datos incorrectos, vuelva a intentarlo");
			alert.showAndWait();
			
		}
	}
	//__________________________________________________________________

	
	/*
	 * Metodo que permite volver al menu principal
	 */
	@FXML
	void volverEvent(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MenuPrincipal.fxml"));
			Parent root = loader.load();

			//			RegistroController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Menu Principal");
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
}