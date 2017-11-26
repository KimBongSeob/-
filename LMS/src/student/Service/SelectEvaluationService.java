package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.EvaluationDataBean;

public class SelectEvaluationService {
private static SelectEvaluationService instance = new SelectEvaluationService();
	
	public static SelectEvaluationService getInstance(){
		return instance;
	}
	private SelectEvaluationService(){}
	
	public List<EvaluationDataBean> getClassList(int sd_num, String cp_year, String cp_semester, String registration){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<EvaluationDataBean> ItemList = studentDao.selectClass_All(conn, sd_num, cp_year, cp_semester, registration);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
