package professor.Service;


	import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import professor.DAO.ProfessorDao;
import professor.DTO.ProfessorDataBean;

	public class modifyProfessorService {
		private static modifyProfessorService instance = new modifyProfessorService();
		
		public static modifyProfessorService getInstance(){
			return instance;
		}
		private modifyProfessorService(){}
		public ProfessorDataBean getItem(String id){

			ProfessorDao professorDao = ProfessorDao.getInstance();
			Connection conn = null;
			try{
				conn = ConnectionProvider.getConnection();
				ProfessorDataBean item =professorDao.selectRegister_modify(conn, id);
				return item;
			}catch(SQLException e){
				throw new RuntimeException("DB 에러:"+e.getMessage(), e);
			}finally{
				jdbcUtil.close(conn);
			}
		}
	}
