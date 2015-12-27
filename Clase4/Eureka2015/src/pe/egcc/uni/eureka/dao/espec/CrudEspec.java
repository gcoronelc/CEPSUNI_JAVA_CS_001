package pe.egcc.uni.eureka.dao.espec;

import java.util.List;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 12/12/2015
 *
 */
public interface CrudEspec<T> {
  
  T leerPorCodigo(String codigo);
  
  List<T> leerPorNombre(T model);
  
  void insertar(T model);
  
  void actualizar(T model);
  
  void eliminar(String codigo);
  
}
