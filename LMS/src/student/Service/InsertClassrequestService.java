package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

//수강신청 insert service
public class InsertClassrequestService {
	private static InsertClassrequestService instance = new InsertClassrequestService();
	
	public static InsertClassrequestService getInstance(){
		return instance;
	}
	private InsertClassrequestService(){}
	public int addItem(int CP_NUM,int SD_NUM){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.insertClassrequest(conn, CP_NUM, SD_NUM);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
