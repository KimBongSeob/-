package admin.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import admin.DAO.AdminDao;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class updateLoaApprovalService {
	private static updateLoaApprovalService instance = new updateLoaApprovalService();
	
	public static updateLoaApprovalService getInstance(){
		return instance;
	}
	private updateLoaApprovalService(){}
	
	public int setItem( int SD_NUM,Date RE_LOA_DATE,Date SRC_REQUEST_DATE,String SRC_VALUE){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateLoaApproval(conn,SD_NUM, RE_LOA_DATE, SRC_REQUEST_DATE, SRC_VALUE);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	public int setItem_B( int SD_NUM,Date RE_START_DATE,Date SRC_REQUEST_DATE,String SRC_VALUE){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			int check = adminDao.updateLoaApproval_B(conn, SD_NUM, RE_START_DATE, SRC_REQUEST_DATE, SRC_VALUE);
			return check;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
