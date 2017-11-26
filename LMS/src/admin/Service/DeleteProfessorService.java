package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class DeleteProfessorService {

private static DeleteProfessorService instance = new DeleteProfessorService();
	
	public static DeleteProfessorService getInstance(){
		return instance;
	}
	private DeleteProfessorService(){}
	
	public int deleteItemList(String pf_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int delete = adminDao.deleteProfessor(conn,pf_num);
			return delete;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
