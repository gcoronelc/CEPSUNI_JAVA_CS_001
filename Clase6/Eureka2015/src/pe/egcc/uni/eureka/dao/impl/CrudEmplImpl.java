package pe.egcc.uni.eureka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.uni.eureka.dao.espec.CrudEmplEspec;
import pe.egcc.uni.eureka.db.AccesoDB;
import pe.egcc.uni.eureka.model.EmpleadoModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public class CrudEmplImpl implements CrudEmplEspec {

  @Override
  public EmpleadoModel validar(String usuario, String clave) {
    Connection cn = null;
    EmpleadoModel model = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno, vch_emplmaterno,"
              + "vch_emplnombre, vch_emplciudad, vch_empldireccion,"
              + "vch_emplusuario from empleado "
              + "where vch_emplusuario=? and vch_emplclave=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        model = new EmpleadoModel();
        model.setCodigo(rs.getString("chr_emplcodigo"));
        model.setPaterno(rs.getString("vch_emplpaterno"));
        model.setMaterno(rs.getString("vch_emplmaterno"));
        model.setNombre(rs.getString("vch_emplnombre"));
        model.setCiudad(rs.getString("vch_emplciudad"));
        model.setDireccion(rs.getString("vch_empldireccion"));
        model.setUsuario(rs.getString("vch_emplusuario"));
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("No se tiene acceso al servidor.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return model;
  }

  @Override
  public EmpleadoModel leerPorCodigo(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<EmpleadoModel> leerPorNombre(EmpleadoModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void insertar(EmpleadoModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizar(EmpleadoModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
