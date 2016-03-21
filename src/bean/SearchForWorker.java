package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchForWorker {
	static Connection con = null;
	
	public static ArrayList<HashMap<String, String>> getWorkerDetailList(String taskId){
		
		ArrayList<HashMap<String, String>> arrayListMapOfTaskAndWorker = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hashMapOfTaskAndWorker = null;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			PreparedStatement ps=con.prepareStatement("select * from worker workerTable, task_details taskDetails "
					+ " where workerTable.domainOfWork = taskDetails.domainOfWork "
					+ " and workerTable.chargedFee <= taskDetails.BudgetPerWorker "
					+ " and workerTable.specificTask like CONCAT('%', taskDetails.specificTask, '%') "
					+ " and workerTable.availability = 'availableYes' "
					+ " and taskDetails.status = 'Affirmative' "
					+ " and taskDetails.taskDetailId = " + taskId 
					+ " order by workerTable.yearsOfExperience desc , credibility desc"
					+ " LIMIT 10 ;" ); 
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				hashMapOfTaskAndWorker = new HashMap<String, String>();
				hashMapOfTaskAndWorker.put("workerName", getLoginName(rs.getObject("Login_Details_Id").toString()));
				hashMapOfTaskAndWorker.put("domainOfWork", rs.getObject("domainOfWork").toString());
				hashMapOfTaskAndWorker.put("specificTask", rs.getObject("specificTask").toString());
				hashMapOfTaskAndWorker.put("credibility", rs.getObject("credibility").toString());
				hashMapOfTaskAndWorker.put("yearsOfExperience", rs.getObject("yearsOfExperience").toString());
				hashMapOfTaskAndWorker.put("chargedFee", rs.getObject("chargedFee").toString());
				hashMapOfTaskAndWorker.put("workerId", rs.getObject("Login_Details_Id").toString());
				hashMapOfTaskAndWorker.put("status", rs.getObject("status").toString());

				arrayListMapOfTaskAndWorker.add(hashMapOfTaskAndWorker);
				
			}
			
		}catch(Exception e){}
		return arrayListMapOfTaskAndWorker;
	}
		
	public static String getLoginName(String loginId){
		
		String loginName = "";
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			PreparedStatement ps=con.prepareStatement("SELECT CONCAT(firstName, ' ', lastName) "
					+ "as loginName FROM login_details where Id = " +loginId ); 
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				loginName = rs.getObject("loginName").toString();
			}
			
		}catch(Exception e){}
		return loginName;
	}
}
