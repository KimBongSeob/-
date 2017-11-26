package admin.Service;
//selectStudentSdnum

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.DepartmentDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectDepartmentDnumService {
private static SelectDepartmentDnumService instance = new SelectDepartmentDnumService();
	
	public static SelectDepartmentDnumService getInstance(){
		return instance;
	}
	private SelectDepartmentDnumService(){}
	
	public DepartmentDataBean getItem(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			DepartmentDataBean Item = adminDao.selectDepartmentDnum(conn, d_num);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
