package helper.api.db.storing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vladislav on 15.08.14.
 */
public class DBQuery {
    private Connection connection;

    public DBQuery(){
        connection = DBConnection.getDBConnection();
    }

    public void saveTokenID(String token, String id){
        try {
            PreparedStatement statement = connection.prepareStatement(DBConstants.INSERT_QUERY);
            statement.setString(1,"");
            statement.setString(2,id);
            statement.setString(3, token);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
