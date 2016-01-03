package pe.egcc.cepsuni.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pe.egcc.cepsuni.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 12/12/2015
 *
 */
public class Prueba06 {

  public static void main(String[] args) {
    Connection cn = null;
    String codigo;
    try {
      
      codigo = JOptionPane.showInputDialog("Codigo");
      
      cn = AccesoDB.getConnection();
      String sql = "select * from cuenta "
              + "where chr_cuencodigo = '" + codigo + "'";
      System.out.println(sql);
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
        System.out.println("Cuenta: " + rs.getString("chr_cuencodigo"));
        System.out.println("Saldo: " + rs.getDouble("dec_cuensaldo"));
        System.out.println("--------------------------");
      }
      rs.close();
      stm.close();
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