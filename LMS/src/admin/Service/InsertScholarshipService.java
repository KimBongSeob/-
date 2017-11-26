package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class InsertScholarshipService {
	private static InsertScholarshipService instance = new InsertScholarshipService();
	
	public static InsertScholarshipService getInstance(){
		return instance;
	}
	private InsertScholarshipService(){}
	public int addItem(int sd_num,String year,int grade,String semester,String name,int sum){

		AdminDao studentDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.insertScholarship(conn, sd_num, year, grade, semester, name, sum);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
