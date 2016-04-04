/**
 * 
 */
package testCasesSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.RegisterBean;
import bean.RegisterDao;

/**
 * @author Naresh
 *
 */
public class TestCase1 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		RegisterBean regBean = testCase1RegBean();

		RegisterDao regDAO = new RegisterDao();
		
		assertEquals(true, regDAO.validate(regBean));
	}
	
	public RegisterBean testCase1RegBean(){
		RegisterBean regBean = new RegisterBean();
		regBean.setFirstName("Muhammad");
		regBean.setLastName("Nadir");
		regBean.setEmailAddress("nadir@nadir.com");
		regBean.setPassword("123456");
		regBean.setPhoneNumber("4");
		regBean.setAddressLine1("St Matheiu St");
		regBean.setAddressLine2("App 402");
		regBean.setCity("Burlington");
		regBean.setProvince("Ontario");
		regBean.setPostalCode("H3H1H4");
		regBean.setCountry("Canada");
		regBean.setOptionValue("Client");
		regBean.setCreditCardNumber("1234567890");
		return regBean;
	}

}
