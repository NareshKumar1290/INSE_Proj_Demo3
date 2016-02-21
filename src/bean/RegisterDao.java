package bean;
import java.sql.*;

public class RegisterDao {
	public static boolean validate(RegisterBean bean){
		boolean status=false;
		try{
			Connection con=ConnectionProvider.getCon();
			
			//PreparedStatement ps=con.prepareStatement("insert into login_info values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			PreparedStatement ps=con.prepareStatement("insert into login_details(firstName, middleName, lastName, emailAddress, password, phoneNumber, addressLine1, addressLine2, city, province, postalCode, country) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
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
			
			int one = ps.executeUpdate();
			status = one == 1 ? true : false;
			con.commit();
			
		}catch(Exception e){}
		return status;
	}
}
