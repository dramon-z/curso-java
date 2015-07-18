package mx.gob.tabasco.seguro;

import java.io.IOException;

import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.view.AseguradoController;
import mx.gob.tabasco.seguro.view.AseguradoFormController;
import mx.gob.tabasco.seguro.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	     this.primaryStage.setTitle("Seguro");	     
	     
	     initRootLayout();

	}

	public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);            
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showAsegurados(){        	
			try {
				FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/AseguradoView.fxml"));
				AnchorPane aseguradoFxml = (AnchorPane) loader.load();
				
				AseguradoController controller = loader.getController();
				controller.setMainApp(this);
				controller.cargarAsegurados();
				
				rootLayout.setCenter(aseguradoFxml);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public boolean showAseguradoForm(Asegurado asegurado){		
		try {
			FXMLLoader loader = new  FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AseguradoFormView.fxml"));
			AnchorPane aseguradoFormFxml = (AnchorPane) loader.load();
			
			AseguradoFormController controller = loader.getController();
			controller.setMainApp(this);
			if(asegurado!=null){
				controller.setAsegurado(asegurado);
			}
			
			Stage dialogStage = new Stage();
            dialogStage.setTitle("Asegurado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(aseguradoFormFxml);
            dialogStage.setScene(scene);
			
            controller.setDialoStage(dialogStage);
			dialogStage.showAndWait();
			return controller.isClicked();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
    
	public static void main(String[] args) {
		launch(args);
	}
}
