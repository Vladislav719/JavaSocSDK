package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Владислав on 15.08.14.
 */
public class CommonController {

    public void createWindow(String fxml, String title){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
