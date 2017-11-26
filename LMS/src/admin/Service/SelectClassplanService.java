package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classplan.DTO.ClassplanDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class SelectClassplanService {
	private static SelectClassplanService instance = new SelectClassplanService();
	
	public static SelectClassplanService getInstance(){
		return instance;
	}
	private SelectClassplanService(){}
	public List<ClassplanDataBean> getItemList(String p_id){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ClassplanDataBean> itemList = adminDao.selectClassplan(conn, p_id);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
