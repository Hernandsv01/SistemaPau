package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public Connection connection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sistemapau", "root", "");
            System.out.println("Conexión exitosa");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    
}
