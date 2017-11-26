package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class DeleteDepartmentService {

private static DeleteDepartmentService instance = new DeleteDepartmentService();
	
	public static DeleteDepartmentService getInstance(){
		return instance;
	}
	private DeleteDepartmentService(){}
	
	public int delItem(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int count = adminDao.deleteDepartment(conn, d_num);
			return count;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
