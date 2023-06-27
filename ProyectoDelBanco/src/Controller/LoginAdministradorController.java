package Controller;

import java.io.IOException;

import Model.Administrador;
import Model.IBanco;
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

public class LoginAdministradorController {

	//Atributos
    @FXML
    private Button btnLogear;

    @FXML
    private Button btnVolver;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;
    //_______________________________________________________________________________________________

    /*
     * Boton que permite logearse como administrador verificando que ese administrador si existe segun
     * el correo y contrsaseña introducidos
     */
    @FXML
    void logearEvent(ActionEvent event) {
    	
    	String correo = txtCorreo.getText();
    	String contrasenia = txtContrasenia.getText();
    	
    	Administrador admin = new Administrador(correo, contrasenia);
    	
    	if(IBanco.banco.loginAdministrador(admin)){
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Bienvenido");
			alert.showAndWait();
    		
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
			alert.setContentText("Los datos son incorrectos");
			alert.showAndWait();
    	}
    
    }
  //_______________________________________________________________________________________________

    /*
     * Boton que permite volver al menu del principio
     */
    @FXML
    void volverEvent(ActionEvent event) {
  
    	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MenuPrincipal.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL); 
			stage.setTitle("Menu Principal");
			stage.setResizable(false);
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
  //_______________________________________________________________________________________________

}
