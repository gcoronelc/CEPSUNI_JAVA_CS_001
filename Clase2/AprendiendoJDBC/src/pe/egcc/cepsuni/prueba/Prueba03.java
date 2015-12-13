/**
 * Clase que ilustra el uso del objeto Statement.
 */
package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import java.sql.Statement;
import pe.egcc.cepsuni.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   12/12/2015
 * 
 */
public class Prueba03 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "insert into mensaje "
              + "values('profe','estudiantes',"
              + "'Vamos a comer cachanga con campus')";
      Statement stm = cn.createStatement();
      stm.executeUpdate(sql);
      stm.close();
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
