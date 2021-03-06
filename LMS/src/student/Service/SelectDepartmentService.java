package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.DepartmentDataBean;

//전체 과목 select service
public class SelectDepartmentService {
	private static SelectDepartmentService instance = new SelectDepartmentService();
	
	public static SelectDepartmentService getInstance(){
		return instance;
	}
	private SelectDepartmentService(){}
	public List<DepartmentDataBean> getItemList(){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<DepartmentDataBean> itemList = studentDao.selectDepartment(conn);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
