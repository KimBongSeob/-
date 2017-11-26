package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;

import classplan.DTO.ClassplanModifyDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class selectClassplanModifyService {
	private static selectClassplanModifyService instance = new selectClassplanModifyService();
	
	public static selectClassplanModifyService getInstance(){
		return instance;
	}
	private selectClassplanModifyService(){}
	public ClassplanModifyDataBean getItem(String c_id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ClassplanModifyDataBean item = studentDao.selectClassplanModify(conn, c_id);
			return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
