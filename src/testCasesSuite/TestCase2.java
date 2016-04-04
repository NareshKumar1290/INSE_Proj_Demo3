/**
 * 
 */
package testCasesSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.RegisterDao;
import bean.TaskDetailBean;
import bean.TaskDetailDao;

/**
 * @author Naresh
 *
 */
public class TestCase2 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		TaskDetailBean taskBean = testCase2TaskBean();

		TaskDetailDao taskDAO = new TaskDetailDao();
		
		assertEquals(true, taskDAO.validate(taskBean));
	}
	
	public TaskDetailBean testCase2TaskBean(){
		TaskDetailBean taskBean = new TaskDetailBean();
		
		taskBean.setTaskName("Task Test Z");
		taskBean.setDomain("Java");
		taskBean.setTaskDescription("HTML");
		taskBean.setNumberOfWorkerRequired(2);
		taskBean.setBudgetPerWorker(1050);
		taskBean.setTaskStatusString("Affirmative");
		taskBean.setClientId(500);
		return taskBean;
	}

}
