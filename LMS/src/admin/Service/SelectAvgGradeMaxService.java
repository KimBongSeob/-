package admin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import admin.DAO.AdminDao;
import student.DTO.StudentDataBean;

//전체 과목 select service
public class SelectAvgGradeMaxService {
	private static SelectAvgGradeMaxService instance = new SelectAvgGradeMaxService();
	
	public static SelectAvgGradeMaxService getInstance(){
		return instance;
	}
	private SelectAvgGradeMaxService(){}
	public List<StudentDataBean> getItemList(String year, String semester, String d_num, int grade){

		AdminDao adminDao = AdminDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<StudentDataBean> itemList = adminDao.selectAvgGradeMax(conn, year, semester, d_num, grade);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
