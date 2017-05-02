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
    public void start(Stage primaryStage) { // starts the application, sets name of program
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("IST 411 POS");
 

        initRootLayout();

        showPersonOverview();
    }


    public void initRootLayout() { // initializes root layout
        try {
           
            FXMLLoader loader = new FXMLLoader(); // creates a loader object, used in every method to obtain appropriate XML data
            loader.setLocation(Main.class.getResource("RootLayout.fxml")); 
            rootLayout = (BorderPane) loader.load();

           
            Scene scene = new Scene(rootLayout); // creates scene based upon the rootlayout
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showOrder() { // reveals the order the customer has made
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("OrderView.fxml"));
             AnchorPane personOverview = (AnchorPane) loader.load(); // AnchorPane acts as a container for DialogStage
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void showCheckout() { // reveals the checkout option for the customer
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("CheckoutView.fxml")); // from XML doc
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    
    public static void showReturn() { // return
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("CheckoutView.fxml")); 
    }
    
    
    public static void showCart() { // reveals the items the customer has added
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("CartView.fxml")); // obtains the cart from XML doc
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void showAccount() { // reveals the customer's account info
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(Main.class.getResource("AccountView.fxml")); // obtained from XML doc
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    
    

    public static void showNav() { // reveals navigation layout for user
        try {
            
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("NavigationView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
    }
    public static void showPersonOverview() { // loads person overview
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("LoginView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // sets person overview into the center of root layout.
            rootLayout.setCenter(personOverview); // sets person overview into the center of root layout
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
    public static Stage getPrimaryStage() { // getter for PrimaryStage
        return primaryStage;
    }

    public static void main(String[] args) { // executes application
        launch(args);
        
    }
}
