package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import pe.egcc.cepsuni.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   12/12/2015
 * 
 */
public class Prueba02 {

  public static void main(String[] args) {
    Connection cn;
    try {
      cn = AccesoDB.getConnection();
      System.out.println("Conexión ok.");
      cn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
