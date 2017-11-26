package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class Submit_checkService {
	private static Submit_checkService instance = new Submit_checkService();
	
	public static Submit_checkService getInstance(){
		return instance;
	}
	private Submit_checkService(){}
	public int getItem(String CP_TIME, String CR_NUM){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int count = adminDao.Submit_checkModify(conn, CP_TIME, CR_NUM);
			return count;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
