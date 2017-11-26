package professor.Service;


import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;

public class modifyProfessorInfoService {
	private static modifyProfessorInfoService instance = new modifyProfessorInfoService();
	
	public static modifyProfessorInfoService getInstance(){
		return instance;
	}
	private modifyProfessorInfoService(){}
	
	public void InfoUpdate(String id, String pf_passwd,String pf_hpone,String pf_address,String pf_email){

		ProfessorDao professorDao = ProfessorDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			//StudentDataBean item = 
			professorDao.UpdateRegister_modify(conn, id, pf_passwd,pf_hpone,pf_address,pf_email);
			//return item;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
