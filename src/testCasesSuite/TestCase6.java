/**
 * 
 */
package testCasesSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.SearchForWorker;

/**
 * @author Naresh
 *
 */
public class TestCase6 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		
		assertEquals(true, testCase6SearchForWorker() != null && testCase6SearchForWorker().length() > 0);
	}
	
	@SuppressWarnings("static-access")
	public String testCase6SearchForWorker(){
		
		SearchForWorker searchForWorker = new SearchForWorker();
		return searchForWorker.getLoginName("1");
	}

}
