package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public String user, password, url, dbName, driver;
    public Connection conexion; 

    public Conexion(){
        driver="com.mysql.jdbc.Driver";
        user="root";
        password="";
        dbName="sondeos";
        url="jdbc:mysql://localhost:3306/"+dbName;

        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa: "+dbName);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public Connection obtenerConexion(){
        return conexion;
    }

    public void cerrarConexion() throws SQLException{
        conexion.close();        
    }

    public static void main(String[] args) {
        new Conexion();
    }
}
