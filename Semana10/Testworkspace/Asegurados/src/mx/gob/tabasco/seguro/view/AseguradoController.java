package mx.gob.tabasco.seguro.view;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import mx.gob.tabasco.seguro.MainApp;
import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.util.AseguradoWebService;

public class AseguradoController {
	
	
	@FXML
	private Label nombreLabel;
	@FXML
	private Label apellidosLabel;
	@FXML
	private Label edadLabel;
	@FXML
	private Label sexoLabel;
	@FXML
	private Label numeroSeguroSocialLabel;
	
	@FXML
    private TableView<Asegurado> aseguradoTable;
	@FXML
	private TableColumn<Asegurado,String> nombreColumn;
	@FXML
	private TableColumn<Asegurado,String> apellidosColumn;
	@FXML
	private TableColumn<Asegurado,Number> edadColumn;
	@FXML
	private TableColumn<Asegurado, String> sexoColumn;
	@FXML
	private TableColumn<Asegurado, String> numeroSeguroSocialColumn;
	
	private ObservableList<Asegurado> aseguradoData = FXCollections.observableArrayList();
	
	
	private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private void cargarTablaAsegurado(){
    	aseguradoTable.setItems(aseguradoData);
    	nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    	apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
    	edadColumn.setCellValueFactory(cellData -> cellData.getValue().edadProperty());
    	sexoColumn.setCellValueFactory(cellData -> cellData.getValue().sexoProperty());
    	sexoColumn.setCellFactory(new Callback<TableColumn<Asegurado,String>, TableCell<Asegurado,String>>() {
            @Override
            public TableCell<Asegurado, String> call( TableColumn<Asegurado, String> param) {
                final TableCell<Asegurado, String> cell = new TableCell<Asegurado, String>() {
                    private Text text;
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if(item.toString().trim().equals("M")){
                                text = new Text("Masculino");
                            }else{
                                text = new Text("Femenino");
                            }
                            setGraphic(text);
                        }else{
                            text = new Text("");
                            setGraphic(text);
                        }
                    }
                };
                return cell;
            }
        });    	
    	numeroSeguroSocialColumn.setCellValueFactory(cellData -> cellData.getValue().numeroSeguroSocialProperty());
    	
    	aseguradoTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
                    selectRowAsegurados();
                }
            }
        });
    	
    }
    
    
    public void selectRowAsegurados(){
    	Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
    	if(asegurado!=null){
    		nombreLabel.setText(asegurado.getNombre());
    		apellidosLabel.setText(asegurado.getApellido());
    		edadLabel.setText(Integer.toString(asegurado.getEdad()));
    		sexoLabel.setText(asegurado.getSexo().equals("M")?"Masculino":"Femenino");
    		numeroSeguroSocialLabel.setText(asegurado.getNumeroSeguroSocial());
    	}else{
    		Dialogs.create()
            .title("Aviso")
            .masthead("No se encuentran elementos seleccionados")
            .showWarning();
    	}    	
    }
    
    public void cargarAsegurados(){
    	AseguradoWebService ws = new AseguradoWebService();
    	ws.loadAsegurados(aseguradoData);
    	cargarTablaAsegurado();
    }

    @FXML
    private void handleEliminar() {

    }
    
    @FXML
    private void handleEditar() {
    	Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
    	if(asegurado!=null){
    		boolean result = this.mainApp.showAseguradoForm(asegurado);
    		if(result){
        		Dialogs.create()
        		.title("Aviso")
        		.masthead("Se guardo de forma exitosa")
        		.showInformation();
        		this.cargarAsegurados();
        	}
    	}else{
    		Dialogs.create()
    		.title("Aviso")
    		.masthead("Seleccione un Asegurado.")
    		.showWarning();
    	}
    }
    
    @FXML
    private void handleAgregar(){
    	boolean result = this.mainApp.showAseguradoForm(null);
    	if(result){
    		Dialogs.create()
    		.title("Aviso")
    		.masthead("Se guardo de forma exitosa")
    		.showInformation();
    	}
    }
    
}
