package admin.Service;
//selectStudentSdnum

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DTO.StudentDataBean;

public class SelectStudentSdnumService {
private static SelectStudentSdnumService instance = new SelectStudentSdnumService();
	
	public static SelectStudentSdnumService getInstance(){
		return instance;
	}
	private SelectStudentSdnumService(){}
	
	public StudentDataBean getItem(String sd_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			StudentDataBean Item = adminDao.selectStudentSdnum(conn, sd_num);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
