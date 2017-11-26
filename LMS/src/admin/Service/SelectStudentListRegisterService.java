package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.RegisterDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectStudentListRegisterService {
private static SelectStudentListRegisterService instance = new SelectStudentListRegisterService();
	
	public static SelectStudentListRegisterService getInstance(){
		return instance;
	}
	private SelectStudentListRegisterService(){}
	
	public List<RegisterDataBean> getItemList(int sd_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<RegisterDataBean> ItemList = adminDao.selectStudent_Register(conn, sd_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	

	
}
