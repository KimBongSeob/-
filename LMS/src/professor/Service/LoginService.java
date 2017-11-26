package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;

public class LoginService {
	private static LoginService instance = new LoginService();
	
	public static LoginService getInstance(){
		return instance;
	}
	private LoginService(){}
	public int studentCheck(String id,String passwd){

		
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = ProfessorDao.getInstance().professorCheck(conn, id, passwd);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	public int professorCheck(String id,String passwd){

		ProfessorDao studentDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.professorCheck(conn,id, passwd);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
