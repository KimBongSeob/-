package admin.Service;
//selectStudentSdnum

import java.sql.Connection;
import java.sql.SQLException;

import admin.DAO.AdminDao;
import admin.DTO.ProfessorDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

public class SelectProfessorPfnumService {
private static SelectProfessorPfnumService instance = new SelectProfessorPfnumService();
	
	public static SelectProfessorPfnumService getInstance(){
		return instance;
	}
	private SelectProfessorPfnumService(){}
	
	public ProfessorDataBean getItem(String d_num){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ProfessorDataBean Item = adminDao.selectProfessorPfnum(conn, d_num);
			return Item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
