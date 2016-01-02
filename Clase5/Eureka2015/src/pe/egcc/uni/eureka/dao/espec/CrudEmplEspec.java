package pe.egcc.uni.eureka.dao.espec;

import pe.egcc.uni.eureka.model.EmpleadoModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 26/12/2015
 *
 */
public interface CrudEmplEspec extends CrudEspec<EmpleadoModel>{

  EmpleadoModel validar(String usuario, String clave);
}
