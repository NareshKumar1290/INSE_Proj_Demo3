package bean;
import java.sql.*;

public class LoginDao {
	public static boolean validate(LoginBean bean){
		boolean status=false;
		try{
			Connection con=ConnectionProvider.getCon();
			
			// TODO: instead of select *, use id to check, if Id > 0 then email and password is correct otherwise not found and email address not valid
			PreparedStatement ps=con.prepareStatement("select * from login_info where email=? and password=? ;");
			ps.setString(1,bean.getEmail());
			ps.setString(2, bean.getPassword());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			//TODO : also use the type field to determine whether the login person is a client or a worker
		}catch(Exception e){}
		return status;
	}
}
