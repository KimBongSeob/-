package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.RegisterDataBean;

//학적변동 select service
public class SelectRegisterService {
	private static SelectRegisterService instance = new SelectRegisterService();
	
	public static SelectRegisterService getInstance(){
		return instance;
	}
	private SelectRegisterService(){}
	public List<RegisterDataBean> getItem(int id){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<RegisterDataBean> itemList = studentDao.selectRegister(conn, id);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
