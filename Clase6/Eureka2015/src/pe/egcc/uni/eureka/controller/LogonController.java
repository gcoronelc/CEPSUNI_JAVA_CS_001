package pe.egcc.uni.eureka.controller;

import pe.egcc.uni.eureka.model.EmpleadoModel;
import pe.egcc.uni.eureka.service.LogonService;
import pe.egcc.uni.eureka.util.Session;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService service = new LogonService();
    EmpleadoModel model = service.validar(usuario, clave);
    Session.put("usuario", model);
  }

}
