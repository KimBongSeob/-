package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class UpdateRegistrationClassplanService {
	private static UpdateRegistrationClassplanService instance = new UpdateRegistrationClassplanService();
	
	public static UpdateRegistrationClassplanService getInstance(){
		return instance;
	}
	private UpdateRegistrationClassplanService(){}
	
	public int setItem(String CP_TIME,String CR_NUM,int cp_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateRegistrationClassplan(conn, CP_TIME, CR_NUM, cp_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
