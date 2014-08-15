package login;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Владислав on 15.08.14.
 */
public class LoginController {

    @FXML TextField nameLoginField;
    @FXML PasswordField passwordLoginField;
    @FXML ProgressIndicator progressLoginForm;
    @FXML Button loginButton;

    public void login(){
        progressLoginForm.setVisible(true);

    }
}
