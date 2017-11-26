package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.DepartmentDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectAllDepartmentService {
private static SelectAllDepartmentService instance = new SelectAllDepartmentService();
	
	public static SelectAllDepartmentService getInstance(){
		return instance;
	}
	private SelectAllDepartmentService(){}
	
	public List<DepartmentDataBean> getItemList(){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<DepartmentDataBean> ItemList = adminDao.selectDepartment_All(conn);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
