package pe.egcc.mybatis.db;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   www.desarrollasoftware.com
 * @date   19/12/2015
 * 
 */
public final class AccesoDB {
  
  
  private static SqlSessionFactory sqlSessionFactory;
  
  static {
    try {
      String resource = "pe/egcc/mybatis/db/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (Exception e) {
    }
  }
  
  public static SqlSession getSqlSession(){
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
    } catch (Exception e) {
      throw new RuntimeException("No se tiene acceso a la fuente de datos.");
    }
    return sqlSession;
  }
}
