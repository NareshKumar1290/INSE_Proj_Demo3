/**
 * 
 */
package testCasesSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.LoginDao;

/**
 * @author Naresh
 *
 */
public class TestCase3 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		
		assertEquals(true, testCase3LoginDao() == 1 || testCase3LoginDao() == 2);
	}
	
	public Integer testCase3LoginDao(){
		
		LoginDao loginDao = new LoginDao();
		return loginDao.getCheckType(1);
	}

}
