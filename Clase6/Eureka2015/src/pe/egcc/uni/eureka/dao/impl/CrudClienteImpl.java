package pe.egcc.uni.eureka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
    Connection cn = null;
    try {
      // Obtener el objeto connection
      cn = AccesoDB.getConnection();
      // Iniciar Tx
      cn.setAutoCommit(false);
      // Obtener el contador
      String sql = "select int_contitem, int_contlongitud "
              + "from contador "
              + "WITH (updlock) "
              + "where vch_conttabla = 'Cliente' ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("No se tiene acceso a la fuente de datos.");
      }
      int cont = rs.getInt("int_contitem");
      int longitud = rs.getInt("int_contlongitud");
      rs.close();
      pstm.close();
      // Generar codigo
      cont++;
      String formato = "";
      for (int i = 1; i <= longitud; i++) {
        formato += "0";
      }
      DecimalFormat df = new DecimalFormat(formato);
      String codigo = df.format(cont);
      // Actualizar el contador
      Thread.currentThread().sleep(1000);
      sql = "update contador  "
              + "set  int_contitem = ? "
              + "where vch_conttabla = 'Cliente'";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, cont);
      pstm.executeUpdate();
      pstm.close();
      // Proceso deinserción
      sql = "insert into cliente (chr_cliecodigo,vch_cliepaterno,"
              + "vch_cliematerno,vch_clienombre,chr_cliedni,"
              + "vch_clieciudad,vch_cliedireccion,vch_clietelefono,"
              + "vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      pstm.setString(2, model.getPaterno());
      pstm.setString(3, model.getMaterno());
      pstm.setString(4, model.getNombre());
      pstm.setString(5, model.getDni());
      pstm.setString(6, model.getCiudad());
      pstm.setString(7, model.getDireccion());
      pstm.setString(8, model.getTelefono());
      pstm.setString(9, model.getEmail());
      pstm.executeUpdate();
      pstm.close();
      model.setCodigo(codigo);
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public void actualizar(ClienteModel model) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false); // Inicia la Tx
      String sql = "update cliente set  vch_cliepaterno = ?, "
              + "vch_cliematerno = ?, vch_clienombre = ?, "
              + "chr_cliedni = ?, vch_clieciudad = ?, "
              + "vch_cliedireccion = ?, vch_clietelefono = ?, "
              + "vch_clieemail = ? "
              + "where chr_cliecodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, model.getPaterno());
      pstm.setString(2, model.getMaterno());
      pstm.setString(3, model.getNombre());
      pstm.setString(4, model.getDni());
      pstm.setString(5, model.getCiudad());
      pstm.setString(6, model.getDireccion());
      pstm.setString(7, model.getTelefono());
      pstm.setString(8, model.getEmail());
      pstm.setString(9, model.getCodigo());
      pstm.executeUpdate();
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
