package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.StudentDataBean;

// 재학,휴학 상태인 학생 데이터 select service
public class SelectStudentLoaService {
	private static SelectStudentLoaService instance = new SelectStudentLoaService();
	
	public static SelectStudentLoaService getInstance(){
		return instance;
	}
	private SelectStudentLoaService(){}
	public StudentDataBean getItem(int id,String loa){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			StudentDataBean Item = studentDao.selectLOA(conn, id, loa);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
