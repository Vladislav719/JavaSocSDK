package helper.api.db.storing;

/**
 * Created by vladislav on 15.08.14.
 */
public class DBConstants {
    public static final String TABLE_NAME = "USER_DATA";
    public static final String INSERT_QUERY = "insert into " + TABLE_NAME + "(id, vk_id, access_token) values (?,?,?)";
}
