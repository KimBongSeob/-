package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;
import admin.DTO.ClassplanDataBean2;
import admin.DTO.SubjectDataBean;

public class SelectSubjectMaxService {
private static SelectSubjectMaxService instance = new SelectSubjectMaxService();
	
	public static SelectSubjectMaxService getInstance(){
		return instance;
	}
	private SelectSubjectMaxService(){}
	
	public SubjectDataBean getItem(String s_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			SubjectDataBean Item = adminDao.selectSubjectMax(conn, s_num);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
