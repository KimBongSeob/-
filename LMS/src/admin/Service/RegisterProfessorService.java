package admin.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class RegisterProfessorService {
private static RegisterProfessorService instance = new RegisterProfessorService();
	
	public static RegisterProfessorService getInstance(){
		return instance;
	}
	private RegisterProfessorService(){}
	
	public int insertProfessorService(String pf_num, String pf_passwd, String pf_name, Date pf_jumin_date, String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.insertProfessor(conn, pf_num, pf_passwd, pf_name, pf_jumin_date, d_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}

