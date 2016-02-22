package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterDao {
	public static boolean validate(RegisterBean bean){
		boolean status=false;
		try{
			Connection con=ConnectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into login_details(firstName, middleName, lastName, emailAddress, password, phoneNumber, addressLine1, addressLine2, city, province, postalCode, country, type, typeString, creditCard_paypalAcc, dateTime) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getMiddleName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getEmailAddress());
			ps.setString(5, bean.getPassword());
			ps.setString(6, bean.getPhoneNumber());
			ps.setString(7, bean.getAddressLine1());
			ps.setString(8, bean.getAddressLine2());
			ps.setString(9, bean.getCity());
			ps.setString(10, bean.getProvince());
			ps.setString(11, bean.getPostalCode());
			ps.setString(12, bean.getCountry());
			
			if(bean.getOptionValue().equals("Client") || bean.getOptionValue().equals("client")){
				ps.setInt(13, 1);
				ps.setString(14, "Client");
			}else if(bean.getOptionValue().equals("Worker") || bean.getOptionValue().equals("worker")){
				ps.setInt(13, 2);
				ps.setString(14, "Worker");
			}
			
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			ps.setString(16, dateFormat.format(cal.getTime()));
			ps.setString(15, bean.getCreditCardNumber());
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
}
