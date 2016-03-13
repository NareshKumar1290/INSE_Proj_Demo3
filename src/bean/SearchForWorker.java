package bean;
import java.sql.*;

public class SearchForWorker {
	static Connection con = null;
	
	public static Integer getCheckType(Integer loginId){
		Integer loginIdType = 0;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			PreparedStatement ps=con.prepareStatement("select * from login_details where Id = "+loginId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Object loginIdTypeObj = rs.getObject("type");
				if(loginIdTypeObj != null){
					loginIdType = Integer.parseInt(loginIdTypeObj.toString());
				}
			}
		}catch(Exception e){}
		return loginIdType;
	}
			
}
