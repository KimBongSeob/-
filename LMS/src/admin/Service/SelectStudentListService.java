package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DTO.StudentDataBean;

public class SelectStudentListService {
private static SelectStudentListService instance = new SelectStudentListService();
	
	public static SelectStudentListService getInstance(){
		return instance;
	}
	private SelectStudentListService(){}
	
	public List<StudentDataBean> getItemList(String d_name){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<StudentDataBean> ItemList = adminDao.selectStudent_All(conn, d_name);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
