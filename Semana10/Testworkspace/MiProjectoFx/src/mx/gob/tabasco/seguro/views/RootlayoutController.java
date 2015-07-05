package mx.gob.tabasco.seguro.views;

import javafx.fxml.FXML;
import mx.gob.tabasco.seguro.MainApp;

public class RootlayoutController {


    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void handleAbrirAsegurado() {
    	mainApp.showAsegurado();
        
    }
    
    @FXML
    private void handleAgregarAsegurado() {
    	boolean ok = mainApp.showFormAsegurado();
    	if(ok){
    		handleAbrirAsegurado();
    		
    	}
        
    }

}
