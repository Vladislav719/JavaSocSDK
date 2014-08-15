package login;

import helper.api.db.storing.DBQuery;
import helper.api.vk.Auth;
import helper.api.vk.Constants;
import helper.api.vk.utils.BaseUtil;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by vladislav on 15.08.14.
 */
public class AuthController implements Initializable {
    @FXML
    WebView webViewAuth;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final WebEngine engine = webViewAuth.getEngine();
        try {
            engine.load(Auth.getUrl(Constants.APP_ID, Auth.getSettings()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("erorororoor ERROR!!!");
        }
        engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                if (event.getSource() instanceof WebEngine){
                    WebEngine tmpEngine = (WebEngine) event.getSource();
                    String location = tmpEngine.getLocation();
                    if (location.startsWith(Auth.redirect_url) && location.contains("access_token")){
                        try {
                            URL url = new URL(location);
                            Map<String, String> map = BaseUtil.explodeQueryString(url.getRef());
                            new DBQuery().saveTokenID(map.get("access_token"), map.get("user_id"));
                        }catch (MalformedURLException e){
                        }
                    }
                }
            }
        });
    }
}
