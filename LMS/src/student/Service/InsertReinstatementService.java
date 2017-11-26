package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

//휴학신청 insert service
public class InsertReinstatementService {
	private static InsertReinstatementService instance = new InsertReinstatementService();
	
	public static InsertReinstatementService getInstance(){
		return instance;
	}
	private InsertReinstatementService(){}
	public int addItem(int id,String LOA_END_YEAR,String LOA_END_SEMESTER){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.insertReinstatementLOA(conn, id, LOA_END_YEAR, LOA_END_SEMESTER);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
