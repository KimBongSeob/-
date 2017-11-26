package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.DepartmentDataBean;

public class SelectAllDepartmentService {
private static SelectAllDepartmentService instance = new SelectAllDepartmentService();
	
	public static SelectAllDepartmentService getInstance(){
		return instance;
	}
	private SelectAllDepartmentService(){}
	
	public List<student.DTO.DepartmentDataBean> getItemList(){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<DepartmentDataBean> ItemList = studentDao.selectDepartment_All(conn);
			return ItemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
	
}
