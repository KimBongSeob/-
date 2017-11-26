package admin.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class RegisterStudentService{
private static RegisterStudentService instance = new RegisterStudentService();
	
	public static RegisterStudentService getInstance(){
		return instance;
	}
	private RegisterStudentService(){}
	
	public int insertStudentService(int sd_num, String sd_passwd, String sd_name, Date sd_jumin_date, String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.insertStudent(conn, sd_num, sd_passwd, sd_name, sd_jumin_date, d_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}

