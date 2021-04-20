package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class DBConnection {
    
    private Connection conn = null;
    private PreparedStatement prepSt;
    private ResultSet rs;
    
    public DBConnection(){
        connection();
    }
    
    public Connection connection(){
        try{
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sistemapau", "root", "");
            System.out.println("Conexión exitosa");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    
    public List<String[]> selectStatement(String statement, TablasDB tablasDB){
        ArrayList<String[]> list = new ArrayList();
        try {
            System.out.println(statement);
            prepSt = conn.prepareStatement(statement);
            rs = prepSt.executeQuery();
            while(rs.next()){
                switch(tablasDB){
                    case alumnos:
                        String[] str1 = {rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Mail"), rs.getString("Telefono"), rs.getString("Edad"), rs.getString("FechaInicio"), rs.getString("Estado")};
                        list.add(str1);
                        break;
                    case clasesemanal:
                        String[] str2 = {rs.getString("ID"), rs.getString("Diasemana"), rs.getString("Hora"), rs.getString("Numero"), rs.getString("Cantidad"), rs.getString("Tematica")};
                        list.add(str2);
                        break;
                    case clasesalumnos:
                        String[] str3 = {rs.getString("dni_alumno"), rs.getString("id_clase")};
                        list.add(str3);
                        break;
                    case comentarios:
                        String[] str4 = {rs.getString("DNI"), rs.getString("Comentario")};
                        list.add(str4);
                        break;
                }
            }
            prepSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
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
