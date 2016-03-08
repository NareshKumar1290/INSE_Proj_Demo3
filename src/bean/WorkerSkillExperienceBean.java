package bean;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkerSkillExperienceBean {

	private String domainOfWork, specificTask, yearsOfExperience, chargedFee;

	public String getDomainOfWork() {
		return domainOfWork;
	}

	public void setDomainOfWork(String domainOfWork) {
		this.domainOfWork = domainOfWork;
	}

	public String getSpecificTask() {
		return specificTask;
	}

	public void setSpecificTask(String specificTask) {
		this.specificTask = specificTask;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getChargedFee() {
		return chargedFee;
	}

	public void setChargedFee(String chargedFee) {
		this.chargedFee = chargedFee;
	}
	
}