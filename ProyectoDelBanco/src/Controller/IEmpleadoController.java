package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;

import Model.Cliente;
import Model.Cuenta;
import Model.Empleado;
import Model.IBanco;
import Model.ICuenta;
import Model.IEmpleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IEmpleadoController implements Initializable{

	/*
	 * Metodo que permite saber de que empleado se esta hablando
	 */
	private Empleado empleado = IEmpleado.banco.getEmpleado();

	/*
	 * Listas donde se van a almacenar los clientes 
	 */
	private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

	//_________________________________________________________________________


	/*
	 * Metodo Initialize que permite inicializar los combobox y columnas de los 
	 * table view. Tambien recorre la lista de empleados y clientes para añadirlos
	 * al tableView.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {



		/*
		 * Se inicializan los combobox
		 */
		comboboxTipoCuenta.getItems().addAll("Ahorro", "Corriente");

		/*
		 * Se inicializan los table view
		 */
		this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
		this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
		this.colCedula.setCellValueFactory(new PropertyValueFactory("cedula"));
		this.colDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
		this.colCelular.setCellValueFactory(new PropertyValueFactory("telefono"));
		this.colCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
		this.colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
		this.colTipoCuenta.setCellValueFactory(new PropertyValueFactory("cuenta"));
		this.colNumCuenta1.setCellValueFactory(new PropertyValueFactory("defCuenta"));

		cargarClientes();

	}
	//__________________________________________________________________


	/*
	 * Metodo que permite cargar los clientes y agregarlos al table view
	 */
	private void cargarClientes() {

		/*
		 * En este punto se cargan los datos de los clientes al table view
		 */
		Iterator<Cliente> iterador = IBanco.banco.getListaClientes().iterator();
		while (iterador.hasNext()) {

			Cliente clienteLista = iterador.next();

			String nombre = clienteLista.getNombre();
			String apellidos = clienteLista.getApellido();
			String cedula = clienteLista.getCedula();
			String direccion = clienteLista.getDireccion();
			String correo =  clienteLista.getCorreo();
			String telefono = clienteLista.getTelefono();
			String fechaNacimiento = clienteLista.getFechaNacimiento();
			String tipoCuenta = clienteLista.getCuenta();
			String contrasenia = clienteLista.getContrasenia();
			Cuenta defCuenta = clienteLista.getDefCuenta();

			Cliente nuevoCliente = new Cliente(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
					tipoCuenta, contrasenia, defCuenta);

			if(!this.clientes.contains(nuevoCliente)) {
				this.clientes.add(nuevoCliente);
				this.tblDatos1.setItems(clientes);
			} 
		}
	}
	//_________________________________________________________________________


	/*
	 * Atributos del FXML.
	 */
	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnLimpiar;

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnEliminar2;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnVolver;

	@FXML
	private TableColumn<?, ?> colSaldo1;

	@FXML
	private TableColumn<?, ?> colApellidos;


	@FXML
	private TableColumn<?, ?> colCedula;

	@FXML
	private Button btnSelec;

	@FXML
	private Button btnHacerDeposito;

	@FXML
	private Button btnConsultarSaldo;

	@FXML
	private Button btnRetirarDinero;

	@FXML
	private TableColumn<?, ?> colCelular;

	@FXML
	private TableColumn<?, ?> colCorreo;

	@FXML
	private TableColumn<?, ?> colDireccion;

	@FXML
	private TableColumn<?, ?> colFechaNacimiento;

	@FXML
	private TableColumn<?, ?> colNombre;

	@FXML
	private TableColumn<?, ?> colNumCuenta1;

	@FXML
	private TableColumn<?, ?> colTipoCuenta;

	@FXML
	private ComboBox<String> comboboxTipoCuenta;

	@FXML
	private ComboBox<String> comboboxTipoEmpleado;

	@FXML
	private Label nombreEmpleado;

	@FXML
	private TableView<Cliente> tblDatos1;

	@FXML
	private TextField txtSaldo;

	@FXML
	private TextArea textArea;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtCedula;

	@FXML
	private TextField txtNumCuenta;

	@FXML
	private TextField txtSalario;

	@FXML
	private TextField txtCedulaCliente;

	@FXML
	private TextField txtCelular;

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
	private TextField txtNombre2;
	//__________________________________________________________________________


	//___________________________________Todo sobre los Clientes_______________________
	/*
	 * Metodo que permite agregar un cliente tanto a la lista ObservableList como al
	 * HashSet recorriendo primeramente las interface que pertenecen al banco. tener
	 * en cuenta que se verifican que ningun espacio esta en blanco y que no exista
	 * la misma cedula dos veces.
	 */
	@FXML
	void agregarEvent(ActionEvent event) {

		if(this.txtNombre.getText().equals("") || this.txtApellidos.getText().equals("") || this.txtCedulaCliente.getText().equals("") ||
				this.txtDireccion.getText().equals("") || this.txtCelular.getText().equals("") || this.txtCorreo.getText().equals("") ||
				this.txtFechaNacimiento.getText().equals("") || this.comboboxTipoCuenta.getValue().equals("") || this.txtContrasenia.getText().equals("")) {

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Asegurese de rellenar todos los espacios por favor. Dejando numero de cuenta y saldo en blanco.");
			alert.showAndWait();


		}else {
			String nombre = this.txtNombre.getText();
			String apellidos = this.txtApellidos.getText();
			String cedula = this.txtCedulaCliente.getText();
			String direccion = this.txtDireccion.getText();
			String telefono =  this.txtCelular.getText();
			String correo =  this.txtCorreo.getText();
			String fechaNacimiento = this.txtFechaNacimiento.getText();
			String tipoCuenta = this.comboboxTipoCuenta.getValue();
			String contrasenia = this.txtContrasenia.getText();

			Random random = new Random();

			// Generamos un número aleatorio entre 0 y 150
			String numeroCuenta = String.valueOf(random.nextInt(150));
			double saldo = 0.0;

			Cuenta defCuenta = new Cuenta(numeroCuenta, saldo);

			Cliente nuevoCliente = new Cliente(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
					tipoCuenta, contrasenia, defCuenta);

			if(IBanco.banco.verificarCedulaCliente(nuevoCliente)) {

				if(!this.clientes.contains(nuevoCliente)){
					this.clientes.add(nuevoCliente);
					this.tblDatos1.setItems(clientes);

					IBanco.crearCliente(nuevoCliente);

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Notificacion");
					alert.setContentText("Cliente registrado con exito.");
					alert.showAndWait();

				}else{
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("La persona existe");
					alert.showAndWait();
				}
			}
		}
	}

	/*
	 * Metodo que permite modificar y actualizar los datos de un cliente.
	 */
	@FXML
	void modificarEvent(ActionEvent event) {

		Cliente cliente = this.tblDatos1.getSelectionModel().getSelectedItem();

		if(cliente == null){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Seleccione primero un cliente.");
			alert.showAndWait();
		}else{

			try{

				String nombre = this.txtNombre.getText();
				String apellidos = this.txtApellidos.getText();
				String cedula = this.txtCedulaCliente.getText();
				String direccion = this.txtDireccion.getText();
				String telefono =  this.txtCelular.getText();
				String correo =  this.txtCorreo.getText();
				String fechaNacimiento = this.txtFechaNacimiento.getText();
				String tipoCuenta = this.comboboxTipoCuenta.getValue();
				String contrasenia = this.txtContrasenia.getText();

				String numCuenta = this.txtNumCuenta.getText();
				double saldo = Double.parseDouble(this.txtSaldo.getText());

				Cuenta defCuenta = new Cuenta(numCuenta, saldo);

				Cliente nuevoCliente = new Cliente(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
						tipoCuenta, contrasenia, defCuenta);

				if(verificacionCamposCliente(nuevoCliente)) {


					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Primero presione seleccione al cliente que desea modificar dando en ´Seleccionar Cliente´.");
					alert.showAndWait();

				}else {
					cliente.setNombre(nuevoCliente.getNombre());
					cliente.setApellido(nuevoCliente.getApellido());
					cliente.setCedula(nuevoCliente.getCedula());
					cliente.setDireccion(nuevoCliente.getDireccion());
					cliente.setTelefono(nuevoCliente.getTelefono());
					cliente.setCorreo(nuevoCliente.getCorreo());
					cliente.setFechaNacimiento(nuevoCliente.getFechaNacimiento());
					cliente.setCuenta(nuevoCliente.getCuenta());
					cliente.setContrasenia(contrasenia);
					cliente.getDefCuenta().setNumeroCuenta(nuevoCliente.getDefCuenta().getNumeroCuenta());
					cliente.getDefCuenta().setSaldo(nuevoCliente.getDefCuenta().getSaldo());

					IBanco.actualizarCliente(nuevoCliente);

					this.tblDatos1.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Info");
					alert.setContentText("Se ha modificado el cliente " + nuevoCliente.getNombre() + " correctamente.");
					alert.showAndWait();
				}


			}catch(NumberFormatException e){

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Primero presione en Seleccionar cliente.");
				alert.showAndWait();
			}
		}
	}
	private boolean verificacionCamposCliente(Cliente nuevoCliente) {

		if(nuevoCliente.getNombre().equals("") || nuevoCliente.getApellido().equals("") || nuevoCliente.getCedula().equals("") ||
				nuevoCliente.getCorreo().equals("") || nuevoCliente.getDireccion().equals("") || nuevoCliente.getTelefono().equals("")  
				|| nuevoCliente.getFechaNacimiento().equals("") || nuevoCliente.getCuenta().equals(null) || 
				nuevoCliente.getContrasenia().equals("")) {
			return true;
		}
		return false;
	}
	//________________________________________________________________________

	/*
	 * Metodo que permite obtener un cliente mediante su cedula e imprimir los datos
	 * de este en el textArea.
	 */
	@FXML
	void buscarEvent(ActionEvent event) {

		String cedula = this.txtCedula.getText();

		String busquedadCliente = IBanco.obtenerCliente(cedula);

		Cliente objeto = IBanco.obtenerObjetoCliente(cedula);

		if(busquedadCliente == null || objeto == null) {
			textArea.setText("El cliente no existe en la base de datos.");
		}else {
			textArea.setText(busquedadCliente.toString() + "\n" + "Numero de cuenta: " + objeto.getDefCuenta().getNumeroCuenta() + "\n"
					+ "Saldo Actual: " + objeto.getDefCuenta().getSaldo());
		}
	}
	//________________________________________________________________________


	/*
	 * Metodo que permite eliminar un cliente de la lista observableList y del HashSet
	 */
	@FXML
	void eliminarEvent(ActionEvent event) {

		Cliente clienteSeleccionado = this.tblDatos1.getSelectionModel().getSelectedItem();

		if(clienteSeleccionado == null){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Seleccione primero a un cliente.");
			alert.showAndWait();
		}else{

			this.clientes.remove(clienteSeleccionado);
			this.tblDatos1.refresh();

			boolean eliminacionCliente  = IBanco.eliminarCliente(clienteSeleccionado);

			if(eliminacionCliente) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Se ha eliminado correctamente");
				alert.showAndWait();
			}

		}
	}
	//________________________________________________________________________

	/*
	 * Metodo que permite seleccionar un cliente de la talba de datos y que estos datos
	 * aparezcan en los espacios de texto para su modificacion o eliminacion.
	 */
	@FXML
	void selecEvent(ActionEvent event) {

		Cliente cliente = this.tblDatos1.getSelectionModel().getSelectedItem();

		this.txtNombre.setText(cliente.getNombre());
		this.txtApellidos.setText(cliente.getApellido());
		this.txtCedulaCliente.setText(cliente.getCedula());
		this.txtDireccion.setText(cliente.getDireccion());
		this.txtCelular.setText(cliente.getTelefono());
		this.txtCorreo.setText(cliente.getCorreo());
		this.txtFechaNacimiento.setText(cliente.getFechaNacimiento());
		this.txtNumCuenta.setText(cliente.getDefCuenta().getNumeroCuenta());
		this.txtContrasenia.setText(cliente.getContrasenia());
		this.txtSaldo.setText(cliente.getDefCuenta().getSaldo().toString());
		this.comboboxTipoCuenta.setValue(cliente.getCuenta());

	}
	//________________________________________________________________________


	/*
	 * Metodo que permite abrir la interfaz de deposito de dinero.
	 */
	@FXML
	void hacerDepositoEvent(ActionEvent event) {

		Cliente clienteSeleccionado = this.tblDatos1.getSelectionModel().getSelectedItem();
		IBanco.banco.setCliente(clienteSeleccionado);

		if(clienteSeleccionado == null) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Para hacer deposito primero seleccione un cliente.");
			alert.showAndWait();
		}else {

			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DepositarDineroAdmin.fxml"));
				Parent root = loader.load();

				DepositarDineroAdminController controlador = loader.getController();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				controlador.init();
				stage.initModality(Modality.APPLICATION_MODAL); 
				stage.setTitle("Depositar Dinero");
				stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
				stage.setScene(scene);
				stage.show();
				Stage myStage = (Stage) this.btnHacerDeposito.getScene().getWindow();
				myStage.close();

			} catch (IOException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		}

	}
	//________________________________________________________________________


	/*
	 * Metodo que permite consultar el saldo de un cliente elegido de la tabla de
	 * datos.
	 */
	@FXML
	void consultarSaldoEvent(ActionEvent event) {

		this.tblDatos1.refresh();

		Cliente clienteSeleccionado = this.tblDatos1.getSelectionModel().getSelectedItem();


		if(clienteSeleccionado == null) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Para consultar dinero primero seleccione un cliente.");
			alert.showAndWait();
		}else {

			IBanco.consultarSaldo(clienteSeleccionado);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Consultar Saldo");
			alert.setContentText("Saldo actual: " + clienteSeleccionado.getDefCuenta().getSaldo() + "$");
			alert.showAndWait();

		}

	}
	//________________________________________________________________________


	/*
	 * Metodo que permite abrir la interfaz de retiro de dinero.
	 */
	@FXML
	void retirarDineroEvent(ActionEvent event) {

		Cliente clienteSeleccionado = this.tblDatos1.getSelectionModel().getSelectedItem();
		IBanco.banco.setCliente(clienteSeleccionado);

		if(clienteSeleccionado == null) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Para retirar dinero primero seleccione un cliente.");
			alert.showAndWait();
		}else {

			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RetirarDineroAdmin.fxml"));
				Parent root = loader.load();

				RetirarDineroAdminController controlador = loader.getController();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				controlador.init();
				stage.initModality(Modality.APPLICATION_MODAL); 
				stage.setTitle("Retirar Dinero");
				stage.getIcons().add(new Image(getClass().getResourceAsStream("/Resources/LogoBanco.png")));
				stage.setScene(scene);
				stage.show();
				Stage myStage = (Stage) this.btnHacerDeposito.getScene().getWindow();
				myStage.close();

			} catch (IOException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		}
	}
	//________________________________________________________________________


	/*
	 * Metodo que permite dejar vacios todos los espacios de texto.
	 */
	@FXML
	void limpiarEvent1(ActionEvent event) {
		txtNombre.clear();
		txtApellidos.clear();
		txtCedulaCliente.clear();
		txtDireccion.clear();
		txtCelular.clear();
		txtCorreo.clear();
		txtFechaNacimiento.clear();
		txtContrasenia.clear();

		txtNumCuenta.clear();
		txtSaldo.clear();
	}
	//________________________________________________________________________

	/*
	 * Metodo que permite volver al menu principal de la aplicacion
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
	//__________


	/*
	 * Metodo init que permite cargar el nombre del empleado
	 */
	public void init() {
		/*
		 * Se inicializa el nombre del empleado
		 */
		nombreEmpleado.setText(empleado.getNombre().toUpperCase());

	}
	//__________________________________________________________________
}
