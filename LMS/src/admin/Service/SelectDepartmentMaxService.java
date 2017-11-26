package admin.Service;
//selectStudentSdnum

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.DepartmentDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectDepartmentMaxService {
private static SelectDepartmentMaxService instance = new SelectDepartmentMaxService();
	
	public static SelectDepartmentMaxService getInstance(){
		return instance;
	}
	private SelectDepartmentMaxService(){}
	
	public DepartmentDataBean getItem(){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			DepartmentDataBean Item = adminDao.selectDepartmentMax(conn);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
