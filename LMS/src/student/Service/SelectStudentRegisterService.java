package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.StudentRegisterDataBean;

//학적 조회 select service
public class SelectStudentRegisterService {
	private static SelectStudentRegisterService instance = new SelectStudentRegisterService();
	
	public static SelectStudentRegisterService getInstance(){
		return instance;
	}
	private SelectStudentRegisterService(){}
	public StudentRegisterDataBean getItem(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			StudentRegisterDataBean Item = studentDao.selectStudentRegister(conn, id);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
