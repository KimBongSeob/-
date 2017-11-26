package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import subject.DTO.SubjectDataBean;

public class SelectSubjectNumService {
	private static SelectSubjectNumService instance = new SelectSubjectNumService();
	
	public static SelectSubjectNumService getInstance(){
		return instance;
	}
	private SelectSubjectNumService(){}
	public SubjectDataBean getItem(String s_id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			SubjectDataBean item = studentDao.selectSubjectNum(conn, s_id);
			return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
