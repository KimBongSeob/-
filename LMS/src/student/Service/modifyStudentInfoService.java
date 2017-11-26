package student.Service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;
import student.DTO.RegisterDataBean;
import student.DTO.StudentDataBean;
import student.DTO.StudentRegisterDataBean;

public class modifyStudentInfoService {
	private static modifyStudentInfoService instance = new modifyStudentInfoService();
	
	public static modifyStudentInfoService getInstance(){
		return instance;
	}
	private modifyStudentInfoService(){}
	
	public void InfoUpdate(int id, String sd_passwd,String sd_hpone,String sd_address,String sd_email){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			//StudentDataBean item = 
					studentDao.UpdateRegister_modify(conn, id, sd_passwd,sd_hpone,sd_address,sd_email);
			//return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
