package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;
    private static BorderPane rootLayout;
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("IST 411 POS");
 

        initRootLayout();

        showPersonOverview();
    }


    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

           
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    public static void showAccount() {
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("AccountView.fxml"));
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    
    

    public static void showNav() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("NavigationView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
    }
    public static void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("LoginView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean showPersonEditDialog() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RegisterView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

         
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            RegisterController controller = loader.getController();
            controller.setDialogStage(dialogStage);


            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
