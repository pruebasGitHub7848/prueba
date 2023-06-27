package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import Model.Cliente;
import Model.Cuenta;
import Model.IBanco;
import Model.ICuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegistrarClienteController implements Initializable{
	
	/*
	 * Atributos
	 */
    @FXML
    private Button btnHacerRegistro;
    
    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<String> comboBoxTipo;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;
  //__________________________________________________________________
    
    
    /*
     * Metodo que permite hacer el registro de un cliente. Todo mediante la interface
     * de la cuenta
     */
    @FXML
    void btnHacerRegistroEvent(ActionEvent event) {

    	/*
    	 * Verificacion que no existan espacios en blanco
    	 */
    	if(this.txtNombre.getText().equals("") || this.txtApellido.getText().equals("") || this.txtCedula.getText().equals("") ||
    			this.txtDireccion.getText().equals("") || this.txtTelefono.getText().equals("") || this.txtCorreo.getText().equals("") ||
    			this.txtFechaNacimiento.getText().equals("") || this.comboBoxTipo.getValue().equals("") || this.txtContrasenia.getText().equals("")) {
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Asegurese de rellenar todos los espacios por favor.");
			alert.showAndWait();
			
    		
    	}else {
    		String nombre = this.txtNombre.getText();
    		String apellidos = this.txtApellido.getText();
    		String cedula = this.txtCedula.getText();
    		String direccion = this.txtDireccion.getText();
    		String telefono =  this.txtTelefono.getText();
    		String correo = this.txtCorreo.getText();
    		String fechaNacimiento = this.txtFechaNacimiento.getText();
    		String tipoCuenta = this.comboBoxTipo.getValue();
    		String contrasenia = this.txtContrasenia.getText();
        	
    		Random random = new Random();

    		// Generamos un número aleatorio entre 0 y 150
    		/*
    		 * La generacion del numero de cuenta es aleatoria y el saldo por defecto
    		 * es 0.
    		 */
    		String numeroCuenta = String.valueOf(random.nextInt(150));
    		double saldo = 0.0;

    		Cuenta defCuenta = new Cuenta(numeroCuenta, saldo);
    		
    		Cliente nuevoCliente = new Cliente(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
    				tipoCuenta, contrasenia, defCuenta);
    		
    		if(IBanco.banco.verificarCedulaCliente(nuevoCliente)) {
    			
    			IBanco.crearCliente(nuevoCliente);
    			ICuenta.banco.setCliente(nuevoCliente);
    			
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setTitle("Notificacion");
    			alert.setContentText("Bienvenido a nuestro banco. Su numero de cuenta es: " + defCuenta.getNumeroCuenta() + "\n");
    			alert.showAndWait();
    			
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
    				Stage myStage = (Stage) this.btnHacerRegistro.getScene().getWindow();
    				myStage.close();

    			} catch (IOException ex) {

    				alert = new Alert(Alert.AlertType.ERROR);
    				alert.setHeaderText(null);
    				alert.setTitle("Error");
    				alert.setContentText(ex.getMessage());
    				alert.showAndWait();
    			}
    		}
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
     * Metodo que inicializa los combobox
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBoxTipo.getItems().addAll("Ahorros", "Corriente");
	}
	//__________________________________________________________________

}