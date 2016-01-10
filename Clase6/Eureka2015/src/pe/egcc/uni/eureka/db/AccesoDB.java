package pe.egcc.uni.eureka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 12/12/2015
 *
 */
public class AccesoDB {

  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException {
    Connection cn = null;
    try {
      // Parámetros para la conexión
      String driver = "net.sourceforge.jtds.jdbc.Driver";
      String urlDB = "jdbc:jtds:sqlserver://192.168.30.42:1433/EUREKABANK";
      String user = "eureka";
      String pass = "admin";
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Realizar la conexión
      cn = DriverManager.getConnection(urlDB, user, pass);
    } catch (SQLException e) {
      throw e;
    } catch(Exception e){
      throw new SQLException("ERROR, no se tiene acceso a la BD.");
    }
    return cn;
  }

}
