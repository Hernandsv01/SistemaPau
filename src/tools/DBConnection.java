package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    
    private static Connection conn = null;
    private PreparedStatement prepSt;
    private ResultSet rs;
    
    private static DBConnection dbconn = null;
    
    private DBConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyectopau", "root", "");
            System.out.println("Conexión exitosa");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static DBConnection getInstance(){
        if(dbconn == null){
            dbconn = new DBConnection();
        }
        return dbconn;
    }
    
    public List<String[]> selectStatement(String statement, int numColumnas){
        List<String[]> results = new ArrayList();
        try{
            System.out.println(statement);
            prepSt = conn.prepareStatement(statement);
            rs = prepSt.executeQuery();
            while(rs.next()){
                String[] str = new String[numColumnas];
                for(int i = 1; i <= numColumnas; i++){
                    str[i-1] = rs.getString(i);
                }
                results.add(str);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return results;
    }
    
    public boolean modificationStatement(String statement){
        try {
            System.out.println(statement);
            prepSt = conn.prepareStatement(statement);
            prepSt.execute();
            prepSt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
