package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class SumDepartmentService {
	private static SumDepartmentService instance = new SumDepartmentService();
	
	public static SumDepartmentService getInstance(){
		return instance;
	}
	private SumDepartmentService(){}
	
	public static int getResult(){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.getCountDepartment(conn);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
