package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.StudentDataBean;

//학생 테이블의 모든 속성 select service
public class SelectStudentService {
	private static SelectStudentService instance = new SelectStudentService();
	
	public static SelectStudentService getInstance(){
		return instance;
	}
	private SelectStudentService(){}
	public StudentDataBean getItem(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			StudentDataBean Item = studentDao.selectStudent(conn, id);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
