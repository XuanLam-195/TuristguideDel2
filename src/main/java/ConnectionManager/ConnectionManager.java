package ConnectionManager;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conn;

    @Value("${spring.datasource.url}")
    private static String db_url="jdbc:mysql://databasedeployment.mysql.database.azure.com:3306/tourist_attraction";

    @Value("${spring.datasource.username}")
    private static String uid="Lam";

    @Value("${spring.datasource.password}")
    private static String pwd="Peterlin0613847925";

    public ConnectionManager(){
    }

     public static Connection  getConnection(){
        if (conn != null) return conn;
        try{
            conn = DriverManager.getConnection(db_url, uid, pwd);
        }catch (SQLException e){
            System.out.println("Couldn't connect to db");
           // e.printStackTrace();
        }
        return conn;

     }
}
