package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class Prueba04 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select de, para, mensaje from mensaje";
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
        System.out.println(rs.getString("de") + " - " 
                + rs.getString("para") + " - " 
                + rs.getString("mensaje"));
      }
      rs.close();
      stm.close();
      System.out.println("Todo ok.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
