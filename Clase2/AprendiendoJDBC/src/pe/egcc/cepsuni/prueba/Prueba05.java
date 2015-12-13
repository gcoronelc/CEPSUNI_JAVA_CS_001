package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.cepsuni.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 12/12/2015
 *
 */
public class Prueba05 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select * from cuenta where chr_cliecodigo=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, "00005");
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        System.out.println("Cuenta: " + rs.getString("chr_cuencodigo"));
        System.out.println("Saldo: " + rs.getDouble("dec_cuensaldo"));
        System.out.println("--------------------------");
      }
      rs.close();
      pstm.close();
      System.out.println("----- OK -----");
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
