package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class InsertDepartmentService {
	private static InsertDepartmentService instance = new InsertDepartmentService();
	
	public static InsertDepartmentService getInstance(){
		return instance;
	}
	private InsertDepartmentService(){}
	public int addItem(String d_num,String d_name){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.insertDepartment(conn, d_num, d_name);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
