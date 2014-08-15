import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    Button btn;

    public void newWindow(){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("new.fxml"));
            Stage stage = new Stage();
            stage.setTitle("new Window");
            stage.setScene(new Scene(root,300,300));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
