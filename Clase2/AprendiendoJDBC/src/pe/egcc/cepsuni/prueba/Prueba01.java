package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   12-12-2015 20:08 Horas
 * 
 */
public class Prueba01 {
 
  public static void main(String[] args) {
    try {
      // Parámetros para la conexión
      String driver = "net.sourceforge.jtds.jdbc.Driver";
      String urlDB = "jdbc:jtds:sqlserver://localhost:1433/EUREKABANK";
      String user = "eureka";
      String pass = "admin";
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Realizar la conexión
      Connection cn = DriverManager.getConnection(urlDB, user, pass);
      // Mensaje
      System.out.println("Conexión ok.");
      // Cerrar la conexión
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
