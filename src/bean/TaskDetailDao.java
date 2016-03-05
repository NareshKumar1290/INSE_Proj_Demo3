package bean;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
			ps.setString(7, bean.getTaskStatusString());
			ps.setInt(8, bean.getClientId());
		
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			ps.setString(6, dateFormat.format(cal.getTime()));
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
}
