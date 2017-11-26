package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;
import admin.DTO.StudentRegisterDataBean;

public class SelectStudentListCheckService {
private static SelectStudentListCheckService instance = new SelectStudentListCheckService();
	
	public static SelectStudentListCheckService getInstance(){
		return instance;
	}
	private SelectStudentListCheckService(){}
	
	public List<StudentRegisterDataBean> getItemList(int sd_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<StudentRegisterDataBean> ItemList = adminDao.selectStudent_Check(conn, sd_num);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
