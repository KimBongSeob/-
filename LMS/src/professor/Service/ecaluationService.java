package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;
import professor.DAO.Professor_All_DataBean;

public class ecaluationService {
	
	private static ecaluationService instance = new ecaluationService();
	
	public static ecaluationService getInstance(){
		return instance;
	}

	private ecaluationService(){}
	
	public List<Professor_All_DataBean> getItemList(String id){

		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<Professor_All_DataBean> ItemList = LmsDao.getYearSemester(id);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}

	public List<Professor_All_DataBean> getItemList_content(String id,String cp_year,String cp_semester){

		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<Professor_All_DataBean> ItemList = LmsDao.getEcaluationlist(id,cp_year,cp_semester);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	public int getResult(int cp_num){
		
		ProfessorDao LmsDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int gnum = LmsDao.getGnum(conn , cp_num);
			return gnum;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	



}
