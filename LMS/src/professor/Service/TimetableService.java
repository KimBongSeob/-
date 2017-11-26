package professor.Service;

import java.sql.Connection;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;

public class TimetableService {
	private static TimetableService instance = new TimetableService();
	
	public static TimetableService getInstance(){
		
		return instance;
	}

    private TimetableService(){}

    public List getItemList(String id, String cp_year, String cp_semester) throws Exception{
           ProfessorDao LmsDao = ProfessorDao.getInstance();
           Connection conn = null;
           try{
                  conn = ConnectionProvider.getConnection();
                  List ItemList = LmsDao.getTimelist(id,cp_year,cp_semester);
                  return ItemList;
           }catch(Exception e){
                  throw new RuntimeException("DB 에러:"+e.getMessage(), e);
           }finally{
                  jdbcUtil.close(conn);
           }
    }


}
