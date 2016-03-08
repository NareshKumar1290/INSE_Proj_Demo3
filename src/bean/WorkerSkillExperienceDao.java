package bean;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkerSkillExperienceDao {
	static Connection con = null;
	public static boolean validate(WorkerSkillExperienceBean bean){
		boolean status=false;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into worker"
					+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee) "
					+ "values (?, ?, ?, ?);");
			
			ps.setString(1, bean.getDomainOfWork());
			ps.setString(2, bean.getSpecificTask());
			ps.setString(3, bean.getYearsOfExperience());
			ps.setString(4, bean.getChargedFee());
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
}