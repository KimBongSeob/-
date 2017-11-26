package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.SubjectDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectSubjectService {
private static SelectSubjectService instance = new SelectSubjectService();
	
	public static SelectSubjectService getInstance(){
		return instance;
	}
	private SelectSubjectService(){}
	
	public List<SubjectDataBean> getItemList(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<SubjectDataBean> ItemList = adminDao.selectSubject(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
