package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;

import classplan.DTO.ClassplanModifyDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;

public class selectClassplanModifyService {
	private static selectClassplanModifyService instance = new selectClassplanModifyService();
	
	public static selectClassplanModifyService getInstance(){
		return instance;
	}
	private selectClassplanModifyService(){}
	public ClassplanModifyDataBean getItem(String c_id){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ClassplanModifyDataBean item = adminDao.selectClassplanModify(conn, c_id);
			return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
