package pe.egcc.uni.eureka.dao.impl;

import java.util.List;
import pe.egcc.uni.eureka.dao.espec.CrudClienteEspec;
import pe.egcc.uni.eureka.model.ClienteModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   26/12/2015
 * 
 */
public class CrudClienteImpl implements CrudClienteEspec{

  @Override
  public ClienteModel leerPorCodigo(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<ClienteModel> leerPorNombre(ClienteModel model) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
