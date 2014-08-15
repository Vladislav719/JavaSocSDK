package helper.api.vk;

import helper.api.vk.utils.BaseUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Владислав on 15.08.14.
 */
public class Auth {

    public static String redirect_url="https://oauth.vk.com/blank.html";

    public static String getUrl(String api_id, String settings) throws UnsupportedEncodingException {
        return "https://oauth.vk.com/authorize?client_id="+api_id+"&display=mobile&scope="+settings+"&redirect_uri="
                +URLEncoder.encode(redirect_url,"UTF-8")+"&response_type=token"
                +"&v="+ URLEncoder.encode(Api.API_VERSION, "UTF-8");
    }

    public static String getSettings(){
        //http://vk.com/dev/permission
        return "notify,friends,audio,docs,status,notes,pages,wall,groups,messages,offline,notifications";
    }

    public static String[] parseRedirectUrl(String url) throws Exception {
        String accessToken = BaseUtil.extractPattern(url, "access_token=(.*?)&");
        String userID = BaseUtil.extractPattern(url, "user_id=(\\d*)");
        if (userID == null || userID.length() == 0 || accessToken == null || accessToken.length() == 0) {
            throw new Exception("Failed on :" + url);
        }
        return new String[]{accessToken, userID};
    }

    public static void main(String[] args) throws Exception {


    }

}
