package mx.gob.tabasco.seguro.view;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mx.gob.tabasco.seguro.MainApp;
import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.util.AseguradoWebService;

public class AseguradoFormController {
	
	@FXML
	private TextField nombreField;
	@FXML
	private TextField apellidosField;
	@FXML
	private TextField edadField;
	@FXML
	private ComboBox<String> sexoComboBox;
	@FXML
	private TextField numeroSeguroSocial;
	
	private Stage dialoStage;
	private Asegurado asegurado;
	private MainApp mainApp;
	private boolean clickOk=false;
	
	@FXML
	private void initialize(){
		sexoComboBox.setItems(FXCollections.observableArrayList(
                "Femenino",
                "Masculino"
            ));
        sexoComboBox.getSelectionModel().select(0);
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
	private void handleGuarda(){
		if(asegurado==null){
			asegurado = new Asegurado();
		}
		try {
			asegurado.setNombre(nombreField.getText());
			asegurado.setApellido(apellidosField.getText());
			asegurado.setEdad(Integer.parseInt(edadField.getText()));
			asegurado.setNumeroSeguroSocial(numeroSeguroSocial.getText());
			asegurado.setSexo(sexoComboBox.getValue().equals("Masculino")?"M":"F");
			AseguradoWebService ws = new AseguradoWebService();
			
			this.clickOk=ws.guardarAsegurado(asegurado);
			this.dialoStage.close();
		} catch (Exception e) {
			Dialogs.create()
				.title("Error")
				.masthead("Ocurrio un error en la asignacion de asegurados")
				.showException(e);
			this.dialoStage.close();
		}
		
	}
	
	@FXML
	private void handleCancelar(){
		this.dialoStage.close();
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void setDialoStage(Stage dialoStage){
		this.dialoStage = dialoStage;
	}
	
	public boolean isClicked(){
		return this.clickOk;
	}
	
	public void setAsegurado(Asegurado asegurado){
		this.asegurado = asegurado;
		nombreField.setText(asegurado.getNombre());
		apellidosField.setText(asegurado.getApellido());
		edadField.setText(Integer.toString(asegurado.getEdad()));
		numeroSeguroSocial.setText(asegurado.getNumeroSeguroSocial());		
		sexoComboBox.getSelectionModel().select(asegurado.getSexo().equals("F")?0:1);

	}

}
