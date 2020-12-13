package misrcConexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSqlite extends Conexion{

    private static String url;
    private static Connection conexion;

    public ConexionSqlite(String url) {
        ConexionSqlite.url = url;
    }

    public void setConexion(boolean bandera) {
        try {
            if (bandera == true) {
                conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
                if (conexion != null) {
                    System.out.println("CONEXION EXITOSA");
                }
            } else {
                conexion.close();
            }
        } catch (SQLException ex) {
            conexion = null;
            System.out.println("SQLEXCEPTION --> ERROR EN ABRIR\\CERRAR CONEXION");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}
/*
C:\\Users\\RAMON\\Documents\\clinica\\mydatabase.clinica
*/