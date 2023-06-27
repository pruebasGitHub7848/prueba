package Aplicacion;

import java.io.IOException;

import Model.IBanco;
import Model.IEmpleado;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{

	/*
	 * Metodo que permite cargar la interfaz que da inicio a la aplicacion
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		 try {
	            //Cargo la vista
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(App.class.getResource("/View/MenuPrincipal.fxml"));

	            // Cargo la ventana
	            Pane ventana = (Pane) loader.load();

	            // Cargo el scene
	            Scene scene = new Scene(ventana);

	            // Seteo la scene y la muestro
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            primaryStage.setResizable(false);
	            primaryStage.setTitle("Menu Principal");
	            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}
	//__________________________________________________________________________________________________
	
	/*
	 * Metodo Main
	 */
	public static void main(String[] args) {
		IBanco.banco.init();
		IEmpleado.banco.init();
		launch(args);

	}
	//__________________________________________________________________________________________________
}
