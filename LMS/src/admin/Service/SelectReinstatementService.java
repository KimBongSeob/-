package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.ReinstatementDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
public class SelectReinstatementService {
private static SelectReinstatementService instance = new SelectReinstatementService();
	
	public static SelectReinstatementService getInstance(){
		return instance;
	}
	private SelectReinstatementService(){}
	
	public List<ReinstatementDataBean> getItemList(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ReinstatementDataBean> ItemList = adminDao.selectReinstatement(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	public List<ReinstatementDataBean> getItemList_B(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ReinstatementDataBean> ItemList = adminDao.selectReinstatement_B(conn, d_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
	
}
