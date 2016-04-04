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
public class TestCase4 {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		WorkerSkillExperienceBean workerSkillExperienceBean = testCase4WorkerBean();
		
		WorkerSkillExperienceDao workerSkillExperienceDao = new WorkerSkillExperienceDao();
		
		assertEquals(true, workerSkillExperienceDao.validate(workerSkillExperienceBean));
	}
	
	public WorkerSkillExperienceBean testCase4WorkerBean(){
		WorkerSkillExperienceBean workerSkillExperienceBean = new WorkerSkillExperienceBean();
		
		workerSkillExperienceBean.setDomainOfWork1("Java");
		workerSkillExperienceBean.setSpecificTask1("HTML");
		workerSkillExperienceBean.setYearsOfExperience1(5+"");
		workerSkillExperienceBean.setChargedFee1(1050+"");
		workerSkillExperienceBean.setAvailable("AvailableYes");
		workerSkillExperienceBean.setLoginId(1000);;
		
		return workerSkillExperienceBean;
	}

}
