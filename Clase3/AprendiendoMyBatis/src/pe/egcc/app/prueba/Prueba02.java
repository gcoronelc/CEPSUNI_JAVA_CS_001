package pe.egcc.app.prueba;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pe.egcc.app.model.EmpleadoBean;
import pe.egcc.mybatis.db.AccesoDB;
import pe.egcc.mybatis.espec.EmpleadoMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 19/12/2015
 *
 */
public class Prueba02 {

  public static void main(String[] args) {
    
    SqlSession sqlSession = null;
    EmpleadoMapper empleadoMapper;
    List<EmpleadoBean> lista;
    
    try {
      sqlSession = AccesoDB.getSqlSession();
      
      empleadoMapper = sqlSession.getMapper(EmpleadoMapper.class);
      
      lista = empleadoMapper.getTodosEmpleados();
      for (EmpleadoBean empleadoBean : lista) {
        System.out.println(empleadoBean.getCodigo()
                + " - " + empleadoBean.getNombre());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        sqlSession.close();
      } catch (Exception e) {
      }
    }
  }
}
