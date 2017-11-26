package professor.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class UpdateClassplanService {
	private static UpdateClassplanService instance = new UpdateClassplanService();
	
	public static UpdateClassplanService getInstance(){
		return instance;
	}
	private UpdateClassplanService(){}
	public int setItem(int CP_NUM, int CP_MAX_NO, String CP_YEAR, String CP_SEMESTER, String S_NUM , String CP_TIME, String D_NUM, String CR_NUM, String PF_NUM, String CP_OUTLINE, String CP_TEXTBOOK, String CP_SUB_TEXTBOOK, String CP_VALUATION,Date CP_DATE){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.updateClassplan(conn, CP_NUM, CP_MAX_NO, CP_YEAR, CP_SEMESTER, S_NUM, CP_TIME, D_NUM, CR_NUM, PF_NUM, CP_OUTLINE, CP_TEXTBOOK, CP_SUB_TEXTBOOK, CP_VALUATION, CP_DATE);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
