package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;

import Model.Cliente;
import Model.Cuenta;
import Model.Empleado;
import Model.IBanco;
import Model.ICuenta;
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


public class IBancoAdministradorController implements Initializable{
	
	/*
	 * Listas donde se van a almacenar los clientes y empleados
	 */
	private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
	private ObservableList<Empleado> empleados = FXCollections.observableArrayList();
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
		comboboxTipoEmpleado.getItems().addAll("Gerente", "Cajero", "Asesor de cuentas");
		
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
		
		this.colCodigo2.setCellValueFactory(new PropertyValueFactory("codigo"));
		this.colNombre2.setCellValueFactory(new PropertyValueFactory("nombre"));
		this.colApellidos2.setCellValueFactory(new PropertyValueFactory("apellido"));
		this.colCedula2.setCellValueFactory(new PropertyValueFactory("cedula"));
		this.colDireccion2.setCellValueFactory(new PropertyValueFactory("direccion"));
		this.colCelular2.setCellValueFactory(new PropertyValueFactory("telefono"));
		this.colCorreo2.setCellValueFactory(new PropertyValueFactory("correo"));
		this.colTipo2.setCellValueFactory(new PropertyValueFactory("tipoCuenta"));
		this.colSalario2.setCellValueFactory(new PropertyValueFactory("salario"));
		
		cargarClientes();
	    
	    /*
		 * En este punto se cargan los datos de los empleados al table view
		 */
	    Iterator<Empleado> it = IBanco.banco.getListaEmpleados().iterator();
	    while (it.hasNext()) {
	    	
	    	Empleado empleadoEnLista = it.next();

	    	String nombre = empleadoEnLista.getNombre();
	    	String apellidos = empleadoEnLista.getApellido();
	    	String cedula = empleadoEnLista.getCedula();
	    	String direccion = empleadoEnLista.getDireccion();
	    	String codigo = empleadoEnLista.getCodigo();
	    	String correo =  empleadoEnLista.getCorreo();
	    	String telefono = empleadoEnLista.getTelefono();
			String fechaNacimiento = empleadoEnLista.getFechaNacimiento();
			String tipoCuenta = empleadoEnLista.getTipoCuenta();
			String contrasenia = empleadoEnLista.getContrasenia();
			double salario = empleadoEnLista.getSalario();
			
			
			Empleado nuevoEmpleado = new Empleado(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
					codigo, salario, contrasenia, tipoCuenta);
			
			if(!this.empleados.contains(nuevoEmpleado)) {
				this.empleados.add(nuevoEmpleado);
				this.tblDatos2.setItems(empleados);
			} 
	    }
	}
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
    private Button btnAgregar2;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnBuscar2;

    @FXML
    private Button btnSelec2;
    
    @FXML
    private Button btnLimpiar2;
    
    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnEliminar2;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnModificar2;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnVolver1;

    @FXML
    private TableColumn<?, ?> colSaldo1;
    
    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colApellidos2;

    @FXML
    private TableColumn<?, ?> colCedula;

    @FXML
    private TableColumn<?, ?> colCedula2;

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
    private TableColumn<?, ?> colCelular2;

    @FXML
    private TableColumn<?, ?> colCodigo2;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colCorreo2;

    @FXML
    private TableColumn<?, ?> colDireccion;

    @FXML
    private TableColumn<?, ?> colDireccion2;

    @FXML
    private TableColumn<?, ?> colFechaNacimiento;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colNombre2;

    @FXML
    private TableColumn<?, ?> colNumCuenta1;

    @FXML
    private TableColumn<?, ?> colSalario2;

    @FXML
    private TableColumn<?, ?> colTipo2;

    @FXML
    private TableColumn<?, ?> colTipoCuenta;

    @FXML
    private ComboBox<String> comboboxTipoCuenta;

    @FXML
    private ComboBox<String> comboboxTipoEmpleado;

    @FXML
    private Label nombreEmpleado;

    @FXML
    private Label nombreEmpleado1;

    @FXML
    private TableView<Cliente> tblDatos1;

    @FXML
    private TableView<Empleado> tblDatos2;

    @FXML
    private TextField txtSaldo;
    
    @FXML
    private TextArea textArea;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtApellidos2;

    @FXML
    private TextField txtCedula;
    
    @FXML
    private TextField txtNumCuenta;

    @FXML
    private TextField txtSalario;
    
    @FXML
    private TextField txtCedula2;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCedulaCliente2;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtCelular2;

    @FXML
    private TextField txtCodigo2;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private PasswordField txtContrasenia2;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtCorreo2;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtDireccion2;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtFechaNacimiento2;

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
    
    
    //_________________________Todo sobre los empleados_______________________
    
    /*
     * Metodo que permite agregar un empleado tanto a la lista ObservableList como al
     * HashSet recorriendo primeramente las interface que pertenecen al banco. tener
     * en cuenta que se verifican que ningun espacio esta en blanco y que no exista
     * la misma cedula dos veces.
     */
    @FXML
    void agregarEvent2(ActionEvent event) {

    	if(this.txtNombre2.getText().equals("") || this.txtApellidos2.getText().equals("") || this.txtCedulaCliente2.getText().equals("") ||
    			this.txtDireccion2.getText().equals("") || this.txtCelular2.getText().equals("") || this.txtCorreo2.getText().equals("") ||
    			this.txtFechaNacimiento2.getText().equals("") || this.comboboxTipoEmpleado.getValue().equals("") || this.txtContrasenia2.getText().equals("") ||
    			this.txtCodigo2.getText().equals("") || this.txtSalario.getText().equals("")) {
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Notificacion");
			alert.setContentText("Asegurese de rellenar todos los espacios por favor.");
			alert.showAndWait();
			
    		
    	}else {
    		String nombre = this.txtNombre2.getText();
    		String apellidos = this.txtApellidos2.getText();
    		String cedula = this.txtCedulaCliente2.getText();
    		String direccion = this.txtDireccion2.getText();
    		String telefono =  this.txtCelular2.getText();
    		String correo =  this.txtCorreo2.getText();
    		String fechaNacimiento = this.txtFechaNacimiento2.getText();
    		String tipoCuenta = this.comboboxTipoEmpleado.getValue();
    		String contrasenia = this.txtContrasenia2.getText();
    		String codigo = this.txtCodigo2.getText();
    		Double salario = Double.parseDouble(this.txtSalario.getText());

    		Empleado nuevoEmpleado = new Empleado(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
    				codigo, salario, contrasenia, tipoCuenta);
    		
    		if(IBanco.banco.verificarCedulaEmpleado(nuevoEmpleado)) {
    			
    			if(!this.empleados.contains(nuevoEmpleado)){
    				this.empleados.add(nuevoEmpleado);
    				this.tblDatos2.setItems(empleados);
    				
    				IBanco.crearEmpleado(nuevoEmpleado);
    				
    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
    				alert.setHeaderText(null);
    				alert.setTitle("Notificacion");
    				alert.setContentText("Empleado registrado con exito.");
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
    //________________________________________________________________________


    /*
     * Metodo que permite obtener un empleado mediante su cedula e imprimir los datos
     * de este en el textArea.
     */
    @FXML
    void buscarEvent2(ActionEvent event) {

    	String cedula = this.txtCedula2.getText();

    	String busquedadEmpleado= IBanco.obtenerEmpleado(cedula);

    	Empleado objeto = IBanco.obtenerObjetoEmpleado(cedula);

    	if(busquedadEmpleado == null || objeto == null) {
    		textArea2.setText("El cliente no existe en la base de datos.");
    	}else {
    		textArea2.setText(busquedadEmpleado.toString() + "\n" + "Nombre: " + objeto.getNombre() + "\n" + "Apellidos: " + objeto.getApellido() +
    				"\n" + "Cedula: " + objeto.getCedula() + "\n" + "Direccion: " + objeto.getDireccion() + "\n" + "Numero de Celular: " + objeto.getTelefono() + 
    				"\n" + "Correo: " + objeto.getCorreo() + "\n" + "Fecha de Nacimiento: " + objeto.getFechaNacimiento());
    	}
    }
    //________________________________________________________________________


    /*
     * Metodo que permite eliminar un empleado de las listas antes mencionadas.
     */
    @FXML
    void eliminarEvent2(ActionEvent event) {

    	Empleado empleadoSeleccionado = this.tblDatos2.getSelectionModel().getSelectedItem();

    	if(empleadoSeleccionado == null){
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Seleccione primero a un cliente.");
    		alert.showAndWait();
    	}else{

    		this.empleados.remove(empleadoSeleccionado);
    		this.tblDatos2.refresh();

    		boolean eliminacionCliente = IBanco.eliminarEmpleado(empleadoSeleccionado);

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
     * Metodo que permite modificar un empleado.
     */
    @FXML
    void modificarEvent2(ActionEvent event) {

    	Empleado empleado = this.tblDatos2.getSelectionModel().getSelectedItem();

    	if(empleado == null){
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Seleccione primero un cliente.");
    		alert.showAndWait();
    	}else{

    		try{

    			String nombre = this.txtNombre2.getText();
    			String apellidos = this.txtApellidos2.getText();
    			String cedula = this.txtCedulaCliente2.getText();
    			String direccion = this.txtDireccion2.getText();
    			String telefono =  this.txtCelular2.getText();
    			String correo =  this.txtCorreo2.getText();
    			String fechaNacimiento = this.txtFechaNacimiento2.getText();
    			String tipoCuenta = this.comboboxTipoEmpleado.getValue();
    			String contrasenia = this.txtContrasenia2.getText();
    			Double salario = Double.parseDouble(this.txtSalario.getText());
    			String codigo = this.txtCodigo2.getText();

    			Empleado nuevoEmpleado = new Empleado(nombre, apellidos, cedula, direccion, telefono, correo, fechaNacimiento,
    					codigo, salario, contrasenia, tipoCuenta);

    			if(verificarCamposEmpleado(nuevoEmpleado)) {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
    				alert.setHeaderText(null);
    				alert.setTitle("Error");
    				alert.setContentText("Primero seleccione el empleado a modificar el boton ´Seleccionar Empleado´.");
    				alert.showAndWait();
    			}else {
    				empleado.setNombre(nuevoEmpleado.getNombre());
    				empleado.setApellido(nuevoEmpleado.getApellido());
    				empleado.setCedula(nuevoEmpleado.getCedula());
    				empleado.setDireccion(nuevoEmpleado.getDireccion());
    				empleado.setTelefono(nuevoEmpleado.getTelefono());
    				empleado.setCorreo(nuevoEmpleado.getCorreo());
    				empleado.setFechaNacimiento(nuevoEmpleado.getFechaNacimiento());
    				empleado.setCodigo(nuevoEmpleado.getCodigo());
    				empleado.setSalario(nuevoEmpleado.getSalario());
    				empleado.setContrasenia(nuevoEmpleado.getContrasenia());
    				empleado.setTipoCuenta(nuevoEmpleado.getTipoCuenta());

    				IBanco.actualizarEmpleado(nuevoEmpleado);

    				this.tblDatos2.refresh();

    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
    				alert.setHeaderText(null);
    				alert.setTitle("Info");
    				alert.setContentText("Se ha modificado correctamente");
    				alert.showAndWait();
    			}

    		}catch(NumberFormatException e){

    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setHeaderText(null);
    			alert.setTitle("Error");
    			alert.setContentText("Formato incorrecto");
    			alert.showAndWait();
    		}
    	}
    }
    private boolean verificarCamposEmpleado(Empleado nuevoEmpleado) {
    	if(nuevoEmpleado.getNombre().equals("") || nuevoEmpleado.getApellido().equals("") || nuevoEmpleado.getCedula().equals("") ||
    			nuevoEmpleado.getCorreo().equals("") || nuevoEmpleado.getDireccion().equals("")  
    			|| nuevoEmpleado.getFechaNacimiento().equals("")  || 
    			nuevoEmpleado.getContrasenia().equals("") ) {
    		return true;
    	}
    	return false;
    }
    //________________________________________________________________________


    /*
     * Metodo que permite seleccionar un empleado de la tabla de datos y mostrarlos
     * en los espacios de texto
     */
    @FXML
    void selecEvent2(ActionEvent event) {

    	Empleado empleado = this.tblDatos2.getSelectionModel().getSelectedItem();
    	
  
    	this.txtNombre2.setText(empleado.getNombre());
    	this.txtApellidos2.setText(empleado.getApellido());
    	this.txtCedulaCliente2.setText(empleado.getCedula());
    	this.txtDireccion2.setText(empleado.getDireccion());
    	this.txtCelular2.setText(empleado.getTelefono());
    	this.txtCorreo2.setText(empleado.getCorreo());
    	this.comboboxTipoEmpleado.setValue(empleado.getTipoCuenta());
    	this.txtContrasenia2.setText(empleado.getContrasenia());
    	this.txtSalario.setText(empleado.getSalario().toString());
    	this.txtCodigo2.setText(empleado.getCodigo());
    	this.txtFechaNacimiento2.setText(empleado.getFechaNacimiento());
    	
    }
    //________________________________________________________________________
    
    /*
     * Metodo que permite borrar los espacios de texto.
     */
    @FXML
    void limpiarEvent2(ActionEvent event) {
    	txtNombre2.clear();
		txtApellidos2.clear();
		txtCedulaCliente2.clear();
		txtDireccion2.clear();
		txtCelular2.clear();
		txtCorreo2.clear();
		txtFechaNacimiento2.clear();
		txtContrasenia2.clear();
		
		txtCodigo2.clear();
		txtSalario.clear();
    }
    //________________________________________________________________________
    
    //_________________________________________________________________________

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
    //________________________________________________________________________
}
