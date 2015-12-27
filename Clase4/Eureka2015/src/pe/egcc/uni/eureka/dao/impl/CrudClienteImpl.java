package pe.egcc.uni.eureka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.uni.eureka.dao.espec.CrudClienteEspec;
import pe.egcc.uni.eureka.db.AccesoDB;
import pe.egcc.uni.eureka.model.ClienteModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public class CrudClienteImpl implements CrudClienteEspec {

  @Override
  public ClienteModel leerPorCodigo(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<ClienteModel> leerPorNombre(ClienteModel model) {
    List<ClienteModel> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
              + "vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, "
              + "vch_clietelefono, vch_clieemail "
              + "from cliente "
              + "where vch_cliepaterno like ? "
              + "or vch_cliematerno like ? "
              + "or vch_clienombre like ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, model.getPaterno());
      pstm.setString(2, model.getMaterno());
      pstm.setString(3, model.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        ClienteModel model2 = new ClienteModel();
        model2.setCodigo(rs.getString("chr_cliecodigo"));
        model2.setPaterno(rs.getString("vch_cliepaterno"));
        model2.setMaterno(rs.getString("vch_cliematerno"));
        model2.setNombre(rs.getString("vch_clienombre"));
        model2.setDni(rs.getString("chr_cliedni"));
        model2.setCiudad(rs.getString("vch_clieciudad"));
        model2.setDireccion(rs.getString("vch_cliedireccion"));
        model2.setTelefono(rs.getString("vch_clietelefono"));
        model2.setEmail(rs.getString("vch_clieemail"));
        lista.add(model2);
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error, no se pudo completar la operación.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  @Override
  public void insertar(ClienteModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizar(ClienteModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
