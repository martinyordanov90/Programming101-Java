package week03;

public class Task {
	private double hoursRequired;
	private boolean isHighPriority;
	
	public Task(double hoursRequired) {
		this.hoursRequired = hoursRequired;
	}
	
	public Task(double hoursRequired, boolean isHighPriority) {
		this.hoursRequired = hoursRequired;
		this.isHighPriority = isHighPriority;
	}
	
	public double getHours() {
		return hoursRequired;
	}
	
	public void setHours(double hoursRequired) {
		this.hoursRequired = hoursRequired;
	}
	
	public boolean isHighPriority() {
		return isHighPriority;
	}
	
	public void togglePriority() {
		isHighPriority = !isHighPriority;
	}
}
