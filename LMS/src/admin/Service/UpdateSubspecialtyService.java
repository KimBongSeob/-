package admin.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class UpdateSubspecialtyService {
	private static UpdateSubspecialtyService instance = new UpdateSubspecialtyService();
	
	public static UpdateSubspecialtyService getInstance(){
		return instance;
	}
	private UpdateSubspecialtyService(){}
	
	public int setItem(int sd_num, int sp_no, String d_sub_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateSubspecialty(conn, sd_num, sp_no, d_sub_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	public int setItem_B(int sd_num, int sp_no, String d_sub_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateSubspecialty_B(conn, sd_num, sp_no, d_sub_num);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
