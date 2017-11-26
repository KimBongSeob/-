package admin.Service;

	import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.DAO.AdminDao;
import admin.DTO.ProfessorDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;

	public class SelectProfessorListCheckService {
	private static SelectProfessorListCheckService  instance = new SelectProfessorListCheckService();
		
		public static SelectProfessorListCheckService getInstance(){
			return instance;
		}
		private SelectProfessorListCheckService(){}
		
		public List<ProfessorDataBean> getItemList(String pf_num){

			AdminDao adminDao = AdminDao.getInstance();
			Connection conn = null;
			try{
				conn = ConnectionProvider.getConnection();
				List<ProfessorDataBean> ItemList = adminDao.selectProfessor_Check(conn, pf_num);
				return ItemList;
			}catch(SQLException e){
				throw new RuntimeException("DB 에러:"+e.getMessage(), e);
			}finally{
				jdbcUtil.close(conn);
			}
		}
		
	}
