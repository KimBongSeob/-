package professor.Service;

import java.sql.Connection;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;

public class GradeService {
	private static GradeService instance = new GradeService();
	
	public static GradeService getInstance(){
		
		return instance;
	}

    private GradeService(){}

    public List getItemList(String id, String cp_year, String cp_semester) throws Exception{
           ProfessorDao LmsDao = ProfessorDao.getInstance();
           Connection conn = null;
           try{
                  conn = ConnectionProvider.getConnection();
                  List ItemList = LmsDao.getGradelist(id, cp_year, cp_semester);
                  return ItemList;
           }catch(Exception e){
                  throw new RuntimeException("DB 에러:"+e.getMessage(), e);
           }finally{
                  jdbcUtil.close(conn);
           }
    }
    

}
