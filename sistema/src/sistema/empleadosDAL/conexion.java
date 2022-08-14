/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jvega
 */
public class conexion {

    private String strConexionDB = "jdbc:sqlite:C:/Proyectos Java/SQLlite-DB/sistema.s3db";
    Connection conn = null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexión establecida");
            
        } catch (Exception e) {
            
            System.out.println("Error de conexión: " + e);
        }
    }
    
    public int ejecutarSentenciaSQL(String sentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(sentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String sentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(sentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }
    
}
