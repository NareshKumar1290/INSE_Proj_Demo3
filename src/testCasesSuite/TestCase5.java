/**
 * 
 */
package testCasesSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.WorkerSkillExperienceBean;
import bean.WorkerSkillExperienceDao;

/**
 * @author Naresh
 *
 */
public class TestCase5 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		WorkerSkillExperienceBean workerSkillExperienceBean = testCase5WorkerBean();
		
		WorkerSkillExperienceDao workerSkillExperienceDao = new WorkerSkillExperienceDao();
		
		assertEquals(true, workerSkillExperienceDao.validate(workerSkillExperienceBean));
	}
	
	public WorkerSkillExperienceBean testCase5WorkerBean(){
		WorkerSkillExperienceBean workerSkillExperienceBean = new WorkerSkillExperienceBean();
		
		workerSkillExperienceBean.setDomainOfWork5("Java");
		workerSkillExperienceBean.setSpecificTask5("Server");
		workerSkillExperienceBean.setYearsOfExperience5(3+"");
		workerSkillExperienceBean.setChargedFee5(750+"");
		workerSkillExperienceBean.setAvailable("AvailableYes");
		workerSkillExperienceBean.setLoginId(1000);;
		
		return workerSkillExperienceBean;
	}

}
