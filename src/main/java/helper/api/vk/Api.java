package helper.api.vk;

/**
 * Created by Владислав on 15.08.14.
 */
public class Api {
    public static final String BASE_URL = "https://api.vk.com/method/";
    public static final String API_VERSION = "5.5";

    private String accessToken;
    private String appId;

    /**
     *
     * @param accessToken
     * @param appId
     */
    public Api(String accessToken, String appId) {
        this.accessToken = accessToken;
        this.appId = appId;
    }


}
