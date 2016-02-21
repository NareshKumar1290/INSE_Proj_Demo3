package bean;
import java.sql.*;

public class TaskDetailDao {
	public static boolean validate(TaskDetailBean bean){
		boolean status=false;
		try{
			Connection con=ConnectionProvider.getCon();
			
			// TODO : taskDetail Information should be carried here and inserted into its respective table
			PreparedStatement ps=con.prepareStatement("insert into login_info(firstName, email, password) values ();");
		
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
}
