package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by idoudou on 16/7/15.
 */
public class DBconn {
    public Connection getConnection(String ip, String database, String username, String password) throws SQLException {
        Connection con=null;
     //   String urlstr="jdbc:mysql://"+ip+":3306/"+database+"?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String urlstr="jdbc:mysql://"+ip+":3306/"+database+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(urlstr,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
