package pe.egcc.uni.eureka.controller;

import java.util.List;
import pe.egcc.uni.eureka.model.ClienteModel;
import pe.egcc.uni.eureka.service.ClienteService;
import pe.egcc.uni.eureka.util.EurekaUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public class ClienteController {

  private ClienteService clienteService;

  public ClienteController() {
    clienteService = new ClienteService();
  }

  public List<ClienteModel> buscar(String criterio) {
    return clienteService.buscar(criterio);
  }

  public void grabar(String accion, ClienteModel model) {
    ClienteService clienteService = new ClienteService();
    switch(accion){
      case EurekaUtil.CRUD_NUEVO:
        clienteService.insertar(model);
        break;
      case EurekaUtil.CRUD_EDITAR:
        clienteService.modificar(model);
        break;
      case EurekaUtil.CRUD_ELIMINAR:
        clienteService.eliminar(model);
        break;        
    }
  }

}
