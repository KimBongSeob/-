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

	public class modifyStudentService {
		private static modifyStudentService instance = new modifyStudentService();
		
		public static modifyStudentService getInstance(){
			return instance;
		}
		private modifyStudentService(){}
		public StudentDataBean getItem(int id){

			StudentDao studentDao = StudentDao.getInstance();
			Connection conn = null;
			try{
				conn = ConnectionProvider.getConnection();
				StudentDataBean item = studentDao.selectRegister_modify(conn, id);
				return item;
			}catch(SQLException e){
				throw new RuntimeException("DB 에러:"+e.getMessage(), e);
			}finally{
				jdbcUtil.close(conn);
			}
		}
	}
