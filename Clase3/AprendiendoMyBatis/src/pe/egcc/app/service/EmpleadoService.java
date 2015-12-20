package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.egcc.app.model.EmpleadoBean;
import pe.egcc.mybatis.db.AccesoDB;
import pe.egcc.mybatis.espec.EmpleadoMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   www.desarrollasoftware.com
 * @date   19/12/2015
 * 
 */
public class EmpleadoService {

  public List<EmpleadoBean> traerEmpleados(EmpleadoBean empleadoBean){
    List<EmpleadoBean> lista = null;
    SqlSession sqlSession = null;
    try {
      sqlSession = AccesoDB.getSqlSession();
      EmpleadoMapper empleadoMapper;
      empleadoMapper = sqlSession.getMapper(EmpleadoMapper.class);
      lista = empleadoMapper.getTraerEmpleados(empleadoBean);
    } catch (Exception e) {
      lista = new ArrayList<>();
    } finally {
      try {
        sqlSession.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
}
