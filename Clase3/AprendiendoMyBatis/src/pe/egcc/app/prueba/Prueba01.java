package pe.egcc.app.prueba;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pe.egcc.app.model.EmpleadoBean;
import pe.egcc.mybatis.espec.EmpleadoMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 * @date 19/12/2015
 *
 */
public class Prueba01 {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    EmpleadoMapper empleadoMapper;
    List<EmpleadoBean> lista;
    
    try {
      
      String resource = "pe/egcc/mybatis/db/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      sqlSession = sqlSessionFactory.openSession();
      
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
