package pe.egcc.uni.eureka.service;

import pe.egcc.uni.eureka.dao.espec.CrudEmplEspec;
import pe.egcc.uni.eureka.dao.impl.CrudEmplImpl;
import pe.egcc.uni.eureka.model.EmpleadoModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   26/12/2015
 * 
 */
public class LogonService {

  public EmpleadoModel validar(String usuario, String clave) {
    CrudEmplEspec crudEmpl = new CrudEmplImpl();
    EmpleadoModel model = crudEmpl.validar(usuario, clave);
    if(model == null){
      throw new RuntimeException("Datos incorrectos.");
    }
    return model;
  }

  
  
}
