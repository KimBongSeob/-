package admin.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class UpdateReinstatementService {
	private static UpdateReinstatementService instance = new UpdateReinstatementService();
	
	public static UpdateReinstatementService getInstance(){
		return instance;
	}
	private UpdateReinstatementService(){}
	
	public int setLoa(int sd_num,Date LOA_A_DATE){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateReinstatementLOA(conn, sd_num, LOA_A_DATE);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	public int setLoaExtension(int sd_num,Date LOA_A_DATE,String LOA_END_YEAR,String LOA_END_SEMESTER){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateReinstatementLoaExtension(conn, sd_num, LOA_A_DATE,LOA_END_YEAR,LOA_END_SEMESTER);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
