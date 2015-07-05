package mx.gob.tabasco.seguro.views;


import mx.gob.tabasco.seguro.MainApp;
import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.util.AseguradoWebService;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AseguradoFormOverviewController {
	
	
	@FXML
	private TextField nombreField;
	@FXML
	private TextField apellidosField;
	@FXML
	private TextField edadField;
	@FXML
	private ComboBox<String> sexoComboBox;
	@FXML
	private TextField numeroSeguroField;
	
	private Stage dialogStage;
	private Asegurado asegurado;
	private boolean okClicked = false;

	@SuppressWarnings("unused")
	private MainApp mainApp;
	private ObservableList<Asegurado> aseguradoData; 
	
	@FXML
	private void initialize(){
		sexoComboBox.setItems(FXCollections.observableArrayList(
	            "Femenino",
	            "Masculino"
	        ));
		sexoComboBox.getSelectionModel().select(1);
		edadField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			public void handle( KeyEvent t ) {
				char ar[] = t.getCharacter().toCharArray();
	            char ch = ar[t.getCharacter().toCharArray().length - 1];
	            if (!(ch >= '0' && ch <= '9')) {	               
	               t.consume();
	            }
	        }
	     });
	}
	@FXML
	public void handleOK(){
		if(isInputValid()){
			if(asegurado == null){
				asegurado = new Asegurado();
			}
			asegurado.setNombre(nombreField.getText());
			asegurado.setApellido(apellidosField.getText());
			asegurado.setEdad(Integer.parseInt(edadField.getText()));
			asegurado.setNumeroSeguroSocial(numeroSeguroField.getText());
			asegurado.setSexo(sexoComboBox.getValue()=="Masculino"?"M":"F");
			AseguradoWebService ws = new AseguradoWebService();
						
			okClicked = ws.guardarAsegurado(asegurado,aseguradoData);
			if(okClicked){
				Dialogs.create()
	            .title("Aviso")
	            .masthead("El asegurado se guardo de forma correcta.")
	            .message("Se registro con el id :"+asegurado.getId())
	            .showInformation();
				dialogStage.close();
			}
			
		}		
	}
	
	@FXML
    private void handleCancel() {
        dialogStage.close();
    }
	
	private boolean isInputValid() {
		String errorMessage = "";
		 if (nombreField.getText() == null || nombreField.getText().length() == 0) {
	            errorMessage += "El nombre es un valor requerido!\n"; 
	        }
		 if (apellidosField.getText() == null || apellidosField.getText().length() == 0) {
	            errorMessage += "Los apellido son valores requerido!\n"; 
	        }
		 if (edadField.getText() == null || edadField.getText().length() == 0) {
	            errorMessage += "La edad es un valor requerido!\n"; 
	        }
		 if (numeroSeguroField.getText() == null || numeroSeguroField.getText().length() == 0) {
	            errorMessage += "El numero de seguro social es un valor requerido!\n"; 
	        }
		
		if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                .title("Campos Invalidos")
                .masthead("Porfavor corrija los campos invalidos")
                .message(errorMessage)
                .showError();
            return false;
        }
	}
	
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	public boolean isOkClicked(){		
		return okClicked;
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        aseguradoData = mainApp.getAsegurdosData();
    }
	
	public void setAsegurado(Asegurado asegurado){
		this.asegurado = asegurado;
		nombreField.setText(asegurado.getNombre());
		apellidosField.setText(asegurado.getApellido());
		edadField.setText(Integer.toString(asegurado.getEdad()));
		sexoComboBox.getSelectionModel().select(asegurado.getSexo()=="M"?1:0);
		numeroSeguroField.setText(asegurado.getNumeroSeguroSocial());
	}
	
}
