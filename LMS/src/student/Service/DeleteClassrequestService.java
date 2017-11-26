package student.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

//수강신청 delete service
public class DeleteClassrequestService {
	private static DeleteClassrequestService instance = new DeleteClassrequestService();
	
	public static DeleteClassrequestService getInstance(){
		return instance;
	}
	private DeleteClassrequestService(){}
	public int delItem(int cp_num,int sd_num){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = studentDao.deleteClassrequest(conn, cp_num, sd_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
