package pe.egcc.uni.eureka.prueba;

import pe.egcc.uni.eureka.dao.espec.CrudEmplEspec;
import pe.egcc.uni.eureka.dao.impl.CrudEmplImpl;
import pe.egcc.uni.eureka.model.EmpleadoModel;
import pe.egcc.uni.eureka.service.LogonService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   26/12/2015
 * 
 */
public class Prueba01 {

  public static void main(String[] args) {
    LogonService service = new LogonService();
    EmpleadoModel model;
    model = service.validar("cromero", "chicho");
    System.out.println("Nombre: " + model.getNombre());
  }
}
