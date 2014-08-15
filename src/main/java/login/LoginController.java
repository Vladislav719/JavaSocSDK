package login;

import helper.api.vk.Auth;
import helper.api.vk.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Владислав on 15.08.14.
 */
public class LoginController{

    @FXML TextField nameLoginField;
    @FXML PasswordField passwordLoginField;
    @FXML ProgressIndicator progressLoginForm;
    @FXML Button loginButton;
    @FXML WebView authView;
    @FXML AnchorPane anchorWeb;
    private WebEngine engine;

    @FXML
    public void login() throws UnsupportedEncodingException {
        progressLoginForm.setVisible(true);
        new CommonController().createWindow("/fxml/authorizePage.fxml","Авторизация");
    }

}
