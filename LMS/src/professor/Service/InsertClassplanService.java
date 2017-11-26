package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class InsertClassplanService {
	private static InsertClassplanService instance = new InsertClassplanService();
	
	public static InsertClassplanService getInstance(){
		return instance;
	}
	private InsertClassplanService(){}
	public int addItem(int CP_MAX_NO, String CP_YEAR, String CP_SEMESTER, String S_NUM , String CP_TIME, String D_NUM, String CR_NUM, String PF_NUM, String PF_EMAIL, String CP_OUTLINE, String CP_TEXTBOOK, String CP_SUB_TEXTBOOK, String CP_VALUATION){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.insertClassplan(conn, CP_MAX_NO, CP_YEAR, CP_SEMESTER, S_NUM, CP_TIME, D_NUM, CR_NUM, PF_NUM, PF_EMAIL, CP_OUTLINE, CP_TEXTBOOK, CP_SUB_TEXTBOOK, CP_VALUATION);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
