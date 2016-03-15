package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkerSkillExperienceDao {
	static Connection con = null;
	public static boolean validate(WorkerSkillExperienceBean bean){
		boolean status=false;
		try{
			
			if(saveSkillSet1(bean) && saveSkillSet2(bean) 
					&& saveSkillSet3(bean) && saveSkillSet4(bean)
					&& saveSkillSet5(bean)){
				status = true;
			}
		}catch(Exception e){}
		return status;
	}
	
	public static boolean saveSkillSet1(WorkerSkillExperienceBean bean) throws SQLException{
		boolean status = false;
		if(con == null){
			con=ConnectionProvider.getCon();
		}
		
		PreparedStatement ps=con.prepareStatement("insert into worker"
				+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee, availability, credibility, Login_Details_Id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);");
		
		ps.setString(1, bean.getDomainOfWork1());
		ps.setString(2, bean.getSpecificTask1());
		ps.setString(3, bean.getYearsOfExperience1());
		ps.setString(4, bean.getChargedFee1());
		ps.setString(5, bean.getAvailable());
		ps.setString(6, "0.5");
		ps.setInt(7, bean.getLoginId());
		
		int one = ps.executeUpdate();
		status = one == 1 ? true : false;
		
		return status;
	}
	
	public static boolean saveSkillSet2(WorkerSkillExperienceBean bean) throws SQLException{
		boolean status = false;
		if(con == null){
			con=ConnectionProvider.getCon();
		}
		
		PreparedStatement ps=con.prepareStatement("insert into worker"
				+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee, availability, credibility, Login_Details_Id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);");
		
		ps.setString(1, bean.getDomainOfWork2());
		ps.setString(2, bean.getSpecificTask2());
		ps.setString(3, bean.getYearsOfExperience2());
		ps.setString(4, bean.getChargedFee2());
		ps.setString(5, bean.getAvailable());
		ps.setString(6, "0.5");
		ps.setInt(7, bean.getLoginId());
		
		int one = ps.executeUpdate();
		status = one == 1 ? true : false;
		
		return status;
	}
	
	public static boolean saveSkillSet3(WorkerSkillExperienceBean bean) throws SQLException{
		boolean status = false;
		if(con == null){
			con=ConnectionProvider.getCon();
		}
		
		PreparedStatement ps=con.prepareStatement("insert into worker"
				+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee, availability, credibility, Login_Details_Id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);");
		
		ps.setString(1, bean.getDomainOfWork3());
		ps.setString(2, bean.getSpecificTask3());
		ps.setString(3, bean.getYearsOfExperience3());
		ps.setString(4, bean.getChargedFee3());
		ps.setString(5, bean.getAvailable());
		ps.setString(6, "0.5");
		ps.setInt(7, bean.getLoginId());
		
		int one = ps.executeUpdate();
		status = one == 1 ? true : false;
		
		return status;
	}
	
	public static boolean saveSkillSet4(WorkerSkillExperienceBean bean) throws SQLException{
		boolean status = false;
		if(con == null){
			con=ConnectionProvider.getCon();
		}
		
		PreparedStatement ps=con.prepareStatement("insert into worker"
				+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee, availability, credibility, Login_Details_Id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);");
		
		ps.setString(1, bean.getDomainOfWork4());
		ps.setString(2, bean.getSpecificTask4());
		ps.setString(3, bean.getYearsOfExperience4());
		ps.setString(4, bean.getChargedFee4());
		ps.setString(5, bean.getAvailable());
		ps.setString(6, "0.5");
		ps.setInt(7, bean.getLoginId());
		
		int one = ps.executeUpdate();
		status = one == 1 ? true : false;
		
		return status;
	}
	public static boolean saveSkillSet5(WorkerSkillExperienceBean bean) throws SQLException{
		boolean status = false;
		if(con == null){
			con=ConnectionProvider.getCon();
		}
		
		PreparedStatement ps=con.prepareStatement("insert into worker"
				+ "(domainOfWork, specificTask, yearsOfExperience, chargedFee, availability, credibility, Login_Details_Id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);");
		
		ps.setString(1, bean.getDomainOfWork5());
		ps.setString(2, bean.getSpecificTask5());
		ps.setString(3, bean.getYearsOfExperience5());
		ps.setString(4, bean.getChargedFee5());
		ps.setString(5, bean.getAvailable());
		ps.setString(6, "0.5");
		ps.setInt(7, bean.getLoginId());
		
		int one = ps.executeUpdate();
		status = one == 1 ? true : false;
		
		return status;
	}
}