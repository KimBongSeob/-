package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.SubspecialtyDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectSubspecialtyBfService {
private static SelectSubspecialtyBfService instance = new SelectSubspecialtyBfService();
	
	public static SelectSubspecialtyBfService getInstance(){
		return instance;
	}
	private SelectSubspecialtyBfService(){}
	
	public List<SubspecialtyDataBean> getItemList(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<SubspecialtyDataBean> ItemList = adminDao.selectSubspecialtyBf(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	public List<SubspecialtyDataBean> getItemList_B(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<SubspecialtyDataBean> ItemList = adminDao.selectSubspecialtyBf_B(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
