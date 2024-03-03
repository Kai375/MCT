import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * JavaFX class Main.
 *
 * @author Kai Toledano
 */
public class Main extends Application
{
    /**
    * This is the start method, when take a class and extends it using the Appilcation interface, we most use this method.
    * From here the program will load the fxml file and create a scene based on it's data.
    *
    * @param Stage stage
    */
   
    
    public void start(Stage stage) throws IOException 
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MCT.fxml")); // Fetch the fxml file.
       
            Scene scene = new Scene(root, 500, 300);  // Create the scene.
                   
            stage.setTitle("MCT.");
            stage.setScene(scene);           
            stage.show();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
       
    public static void main(String[] args) 
    {        
        launch();
    }
}
