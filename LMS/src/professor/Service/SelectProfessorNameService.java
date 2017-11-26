package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DTO.ProfessorSubDataBean;
import student.DAO.StudentDao;

public class SelectProfessorNameService {
	private static SelectProfessorNameService instance = new SelectProfessorNameService();
	
	public static SelectProfessorNameService getInstance(){
		return instance;
	}
	private SelectProfessorNameService(){}
	public ProfessorSubDataBean getItem(String id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ProfessorSubDataBean item = studentDao.selectProfessorName(conn, id);
			return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
