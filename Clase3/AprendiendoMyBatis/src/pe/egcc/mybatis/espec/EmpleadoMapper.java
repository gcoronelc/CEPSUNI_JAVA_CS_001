
package pe.egcc.mybatis.espec;

import java.util.List;
import pe.egcc.app.model.EmpleadoBean;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 19/12/2015
 *
 */
public interface EmpleadoMapper {
  
  List<EmpleadoBean> getTodosEmpleados();
  
  List<EmpleadoBean> getTraerEmpleados(EmpleadoBean empleadoBean);
  
  
  
}
