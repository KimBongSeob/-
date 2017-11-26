package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class InsertSubjectService {
	private static InsertSubjectService instance = new InsertSubjectService();
	
	public static InsertSubjectService getInstance(){
		return instance;
	}
	private InsertSubjectService(){}
	public int addItem(String s_num, String s_name,String s_cp_division, int s_cp_credits, String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.insertSubject(conn, s_num, s_name, s_cp_division, s_cp_credits, d_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
