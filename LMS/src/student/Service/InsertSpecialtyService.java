package student.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class InsertSpecialtyService {

	private static InsertSpecialtyService instance = new InsertSpecialtyService();
	
	public static InsertSpecialtyService getInstance(){
		return instance;
	}
	private InsertSpecialtyService(){}
	
	public int requestSpecialty(int sd_num, String d_sub_num, Date dm_date, Date m_date){
		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int count = studentDao.insertSpecialty(conn, sd_num, d_sub_num, dm_date, m_date);
			return count;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}	
	}
}
