package admin.Service;
import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;


public class DeleteSubjectService{
private static DeleteSubjectService instance = new DeleteSubjectService();
	
	public static DeleteSubjectService getInstance(){
		return instance;
	}
	private DeleteSubjectService(){}
	
	public int delItem(String s_num,String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int count = adminDao.deleteSubject(conn, s_num, d_num);
			return count;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
