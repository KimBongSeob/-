package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import subject.DTO.SubjectDataBean;

public class SelectSubjectNameService {
	private static SelectSubjectNameService instance = new SelectSubjectNameService();
	
	public static SelectSubjectNameService getInstance(){
		return instance;
	}
	private SelectSubjectNameService(){}
	public List<SubjectDataBean> getItemList(String id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<SubjectDataBean> itemList = studentDao.selectSubjectName(conn, id);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
