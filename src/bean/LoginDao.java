package bean;
import java.sql.*;

public class LoginDao {
	static Connection con = null;
	public static Integer validate(LoginBean bean){
		
		Integer loginIdInt = 0;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			PreparedStatement ps=con.prepareStatement("select * from login_details where emailAddress=? and password=? ;");
			ps.setString(1,bean.getEmailAddress());
			ps.setString(2, bean.getPassword());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Object loginIdObj = rs.getObject("Id");
				if(loginIdObj != null){
					loginIdInt = Integer.parseInt(loginIdObj.toString());
				}
			}
		}catch(Exception e){}
		return loginIdInt;
	}
	
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
