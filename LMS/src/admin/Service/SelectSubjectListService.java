package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;
import admin.DTO.ClassplanDataBean2;

public class SelectSubjectListService {
private static SelectSubjectListService instance = new SelectSubjectListService();
	
	public static SelectSubjectListService getInstance(){
		return instance;
	}
	private SelectSubjectListService(){}
	
	public List<ClassplanDataBean2> getItemList(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ClassplanDataBean2> ItemList = adminDao.SelectSubjectList_All(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
