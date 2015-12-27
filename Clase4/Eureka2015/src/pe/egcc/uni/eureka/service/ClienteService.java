package pe.egcc.uni.eureka.service;

import java.util.List;
import pe.egcc.uni.eureka.dao.espec.CrudClienteEspec;
import pe.egcc.uni.eureka.dao.impl.CrudClienteImpl;
import pe.egcc.uni.eureka.model.ClienteModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public class ClienteService {

  private CrudClienteEspec crudCliente;

  public ClienteService() {
    crudCliente = new CrudClienteImpl();
  }

  public List<ClienteModel> buscar(String criterio) {
    ClienteModel model = new ClienteModel();
    model.setNombre(criterio + "%");
    model.setPaterno(criterio + "%");
    model.setMaterno(criterio + "%");
    return crudCliente.leerPorNombre(model);
  }

}
