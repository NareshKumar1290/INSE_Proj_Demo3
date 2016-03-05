package bean;

public class TaskDetailBean {
	
	private int taskId, numberOfWorkerRequired, budgetPerWorker, taskStatusInt, clientId;
	private String taskName, domain, taskDescription, taskStatusString;
	public int getTaskId() {
		return taskId;
	}
	public int getNumberOfWorkerRequired() {
		return numberOfWorkerRequired;
	}
	public void setNumberOfWorkerRequired(int numberOfWorkerRequired) {
		this.numberOfWorkerRequired = numberOfWorkerRequired;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getBudgetPerWorker() {
		return budgetPerWorker;
	}
	public void setBudgetPerWorker(int budgetPerWorker) {
		this.budgetPerWorker = budgetPerWorker;
	}
	public int getTaskStatusInt() {
		return taskStatusInt;
	}
	public void setTaskStatusInt(int taskStatusInt) {
		this.taskStatusInt = taskStatusInt;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskStatusString() {
		return taskStatusString;
	}
	public void setTaskStatusString(String taskStatusString) {
		this.taskStatusString = taskStatusString;
	}
	
	}
