package admin.Service;
import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;


public class DeleteStudentService{
private static DeleteStudentService instance = new DeleteStudentService();
	
	public static DeleteStudentService getInstance(){
		return instance;
	}
	private DeleteStudentService(){}
	
	public int deleteItemList(int sd_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int delete = adminDao.deleteStudent(conn,sd_num);
			return delete;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
