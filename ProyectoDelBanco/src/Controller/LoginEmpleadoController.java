package Controller;

import java.io.IOException;

import Model.Cliente;
import Model.Empleado;
import Model.IBanco;
import Model.ICuenta;
import Model.IEmpleado;
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

public class LoginEmpleadoController {

	@FXML
	private Button btnLogear;

	@FXML
	private Button btnVolver;

	@FXML
	private PasswordField txtContrasenia;

	@FXML
	private TextField txtCorreo;

	@FXML
	void logearEvent(ActionEvent event) {

		String correo = this.txtCorreo.getText();
		String contrasenia = this.txtContrasenia.getText();

		Empleado empleado = IEmpleado.loginEmpleado(correo, contrasenia);
		
		System.out.println(empleado);
		
		if(empleado != null) {
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Bienvenido");
			alert.showAndWait();

			IEmpleado.banco.setEmpleado(empleado);

			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/IEmpleado.fxml"));
				Parent root = loader.load();

				IEmpleadoController controlador = loader.getController();
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
			alert.setContentText("Los datos ingresados son incorrectos.");
			alert.showAndWait();
		}
	}

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
