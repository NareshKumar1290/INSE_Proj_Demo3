package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class TaskDetailDao {
	static Connection con = null;
	public static boolean validate(TaskDetailBean bean){
		boolean status=false;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into task_details"
					+ "(taskName, domainOfWork, specificTask, WorkersRequired, BudgetPerWorker, Date, status, clientId) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, bean.getTaskName());
			ps.setString(2, bean.getDomain());
			ps.setString(3, bean.getTaskDescription());
			ps.setInt(4, bean.getNumberOfWorkerRequired());
			ps.setInt(5, bean.getBudgetPerWorker());
			
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			ps.setString(6, dateFormat.format(cal.getTime()));
			
			ps.setString(7, bean.getTaskStatusString());
			ps.setInt(8, bean.getClientId());
		
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
	
	public static ArrayList<TaskDetailBean> fetchClientTaskRecords(String loginId){
		return fetchClientTaskRecords(loginId, null);
	}
	
	public static ArrayList<TaskDetailBean> fetchClientTaskRecords(String loginId, String taskIdStr){
		
		ArrayList<TaskDetailBean> taskDetailBeanArray = new ArrayList<TaskDetailBean>();
		String taskName="", domain="", taskDescription="", taskStatusString="" ;
		int numberOfWorkerRequired=0, budgetPerWorker=0, taskId = 0;
		Integer loginIdInt = Integer.parseInt(loginId);
		
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			String queryToExecute = "select * from task_details where clientId = " + loginIdInt;
			if(taskIdStr != null && taskIdStr.length() > 0 && Integer.parseInt(taskIdStr) > 0){
				queryToExecute += " where taskDetailId = "+taskIdStr; 
			}
			
			PreparedStatement ps=con.prepareStatement(queryToExecute);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TaskDetailBean taskDetailBeanObj = new TaskDetailBean();
				Object taskNameObj = rs.getObject("taskName");
				if(taskNameObj != null){
					taskName = taskNameObj.toString();
				}
				taskDetailBeanObj.setTaskName(taskName);
				
				Object domainObj = rs.getObject("domainOfWork");
				if(domainObj != null){
					domain = domainObj.toString();
				}
				taskDetailBeanObj.setDomain(domain);
				
				Object taskDescriptionObj = rs.getObject("specificTask");
				if(taskDescriptionObj != null){
					taskDescription = taskDescriptionObj.toString();
				}
				taskDetailBeanObj.setTaskDescription(taskDescription);
				
				Object numberOfWorkerRequiredObj = rs.getObject("WorkersRequired");
				if(numberOfWorkerRequiredObj != null){
					numberOfWorkerRequired = Integer.parseInt(numberOfWorkerRequiredObj.toString());
				}
				taskDetailBeanObj.setNumberOfWorkerRequired(numberOfWorkerRequired);
				
				Object budgetPerWorkerObj = rs.getObject("BudgetPerWorker");
				if(budgetPerWorkerObj != null){
					budgetPerWorker = Integer.parseInt(budgetPerWorkerObj.toString());
				}
				taskDetailBeanObj.setBudgetPerWorker(budgetPerWorker);
				
				Object taskStatusStringObj = rs.getObject("status");
				if(taskStatusStringObj != null){
					taskStatusString = taskStatusStringObj.toString();
				}
				taskDetailBeanObj.setTaskStatusString(taskStatusString);
				
				
				Object taskIdObj = rs.getObject("taskDetailId");
				if(taskIdObj != null){
					taskId = Integer.parseInt(taskIdObj.toString());
				}
				
				taskDetailBeanObj.setTaskId(taskId);
				
				taskDetailBeanObj.setClientId(loginIdInt);
				
				taskDetailBeanArray.add(taskDetailBeanObj);
			}
			
		}catch(Exception e){}
		return taskDetailBeanArray;
	}
			
	
	public static boolean updateTaskStatus(String taskId, String taskStatus){
		boolean status=true;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement(" update task_details " 
					+ " set status = '" + taskStatus + "' "
					+ " where taskDetailId = "+taskId);
			
			ps.executeUpdate();
			status = true;
		} catch (Exception e)
	    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		      status = false;
		      
		 }
		return status;
	}
	
	public static ArrayList<HashMap<String, String>> assignedTaskToWorker(String workerId){
		return assignedTaskToWorker(workerId, null);
	}
	
	public static ArrayList<HashMap<String, String>> assignedTaskToWorker(String workerId, String taskId){
		
		ArrayList<HashMap<String, String>> listOfTaskAssignedToWorker = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mapOfTaskAssignedToWorker = new HashMap<String, String>();

		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			String queryToExecute = "select * from task_details taskDetails "
					+ " JOIN task_details_per_worker taskDetailsPerWorker "
					+ " where taskDetails.taskDetailId = taskDetailsPerWorker.Task_Details_Id "
					+ " and taskDetailsPerWorker.Worker_id = " + workerId;
			
			if(taskId != null && taskId.length() > 0){
				queryToExecute += " and taskDetails.taskDetailId = " + taskId;
			}
			
			PreparedStatement ps=con.prepareStatement(queryToExecute);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				mapOfTaskAssignedToWorker.put("taskDetailId",rs.getString("taskDetailId"));
				mapOfTaskAssignedToWorker.put("taskName",rs.getString("taskName"));
				mapOfTaskAssignedToWorker.put("domainOfWork",rs.getString("domainOfWork"));
				mapOfTaskAssignedToWorker.put("specificTask",rs.getString("specificTask"));
				mapOfTaskAssignedToWorker.put("Budget",rs.getString("BudgetPerWorker"));
				mapOfTaskAssignedToWorker.put("status",rs.getString("status"));
				mapOfTaskAssignedToWorker.put("completionPercentage",rs.getInt("CompletionPercentage")+"");
				
				listOfTaskAssignedToWorker.add(mapOfTaskAssignedToWorker);
			}
			
		} catch (Exception e)
	    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		      
		 }
		return listOfTaskAssignedToWorker;
	}
	
	public static boolean insertIntoWorkerTaskDetails(String taskId, String taskStatus, String workerId){
		boolean status = false;
		try{
			if(con == null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into task_details_per_worker"
					+ "(Worker_Id, Worker_Login_Details_Id, Task_Details_Id, CompletionPercentage, Client_Feedback, Client_Credibility) "
					+ "values (?, ?, ?, ?, ?, ?);");
			
			
			ps.setString(1, workerId);
			ps.setString(2, workerId);
			ps.setString(3, taskId);
			ps.setInt(4, 0);
			ps.setString(5, " ");
			ps.setString(6, " ");

			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		} catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		      status = false;
		 }
		return status;
	}
	
	// Task Percentage would be changed by worker when he is starting to change the task
	public static boolean updatePercentageOfTaskByWorker(String taskId, String taskPercentage){
		boolean status = false;
		
		try{
			if(con==null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement("update task_details_per_worker"
					+ " set CompletionPercentage = " + taskPercentage
					+ " where Task_Details_Id = " + taskId);
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		} catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		      status = false;
		 }
		return status;
	}
	
	// Task Status would be updated by Worker after being assigned
	public static boolean updateStatusOfTaskByWorker(String taskId, String taskStatus){
		boolean status = false;
		
		try{
			if(con==null){
				con=ConnectionProvider.getCon();
			}
			
			PreparedStatement ps=con.prepareStatement("update task_details"
					+ " set status = '" + taskStatus + "' "
					+ " where taskDetailId = " + taskId);
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		} catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		      status = false;
		 }
		return status;
	}
	
	// Client Feedback and Client Rating to be saved and updated
		public static boolean updateClientStatusAndFeedbackOfTaskByClient(String taskId, String clientRating, String clientFeedback){
			boolean status = false;
			
			try{
				if(con==null){
					con=ConnectionProvider.getCon();
				}
				
				PreparedStatement ps=con.prepareStatement("update task_details_per_worker"
						+ " set Client_Credibility = '" + clientFeedback + "' "
						+ " and Client_Feedback = '" + clientRating + "' "
						+ " where Task_Details_Id = " + taskId);
				
				int one = ps.executeUpdate();
				status = one == 1 ? true : false;
				con.commit();
				
			} catch (Exception e){
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			      status = false;
			 }
			return status;
		}
}