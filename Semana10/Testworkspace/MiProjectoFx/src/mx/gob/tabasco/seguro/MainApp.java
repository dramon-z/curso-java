package mx.gob.tabasco.seguro;

import java.io.IOException;

import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.views.AseguradoFormOverviewController;
import mx.gob.tabasco.seguro.views.AseguradoOverviewController;
import mx.gob.tabasco.seguro.views.RootlayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private ObservableList<Asegurado> aseguradoData = FXCollections.observableArrayList();

	private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nuestro Tituto");

        initRootLayout();

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Rootlayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            // Give the controller access to the main app.
            RootlayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showAsegurado(){
    	 try {
             
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("views/AseguradoOverview.fxml"));
             AnchorPane aseguradoOverview = (AnchorPane) loader.load();
             
             AseguradoOverviewController controller = loader.getController();
             controller.setMainApp(this);
             
             rootLayout.setCenter(aseguradoOverview);
         } catch (IOException e) {
             e.printStackTrace();
         }
    	
    }
    
    public boolean showFormEditarAsegurado(Asegurado asegurado){
    	try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/AseguradoFormOverview.fxml"));
            AnchorPane aseguradoFormOverview = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Asegurado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(aseguradoFormOverview);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            
            AseguradoFormOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setAsegurado(asegurado);
            	
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showFormAsegurado(){
    	try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/AseguradoFormOverview.fxml"));
            AnchorPane aseguradoFormOverview = (AnchorPane) loader.load();
            
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Asegurado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(aseguradoFormOverview);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            
            AseguradoFormOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            	
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ObservableList<Asegurado> getAsegurdosData(){
    	return aseguradoData;
    }
    

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
