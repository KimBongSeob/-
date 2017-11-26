package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class SumProfessorService {
	private static SumProfessorService instance = new SumProfessorService();
	
	public static SumProfessorService getInstance(){
		return instance;
	}
	private SumProfessorService(){}
	
	public static int getResult(){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.getCountProfessor(conn);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
