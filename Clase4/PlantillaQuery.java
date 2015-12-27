Connection cn = null;
try {
  cn = AccesoDB.getConnection();
  
} catch (SQLException e) {
  
} catch (Exception e) {
  
} finally{
  try {
	cn.close();
  } catch (Exception e) {
  }
}