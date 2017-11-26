package professor.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classplan.DTO.ClassplanDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

public class SelectD_ClassplanService {
	private static SelectD_ClassplanService instance = new SelectD_ClassplanService();
	
	public static SelectD_ClassplanService getInstance(){
		return instance;
	}
	private SelectD_ClassplanService(){}
	public List<ClassplanDataBean> getItemList(String d_num){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ClassplanDataBean> itemList = studentDao.selectD_Classplan(conn, d_num);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
