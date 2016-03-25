package week03;

import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {
	private int timeAvailable;
	private Queue<Task> tasks;
	
	public ToDoList() {
		tasks = new PriorityQueue<>(10, new TaskComparator());
	}
	
	public ToDoList(int timeAvailable) {
		this.timeAvailable = timeAvailable;
		tasks = new PriorityQueue<>(10, new TaskComparator());
	}
	
	public void add(Task t) {
		tasks.add(t);
	}
	
	public Task getTop() {
		return tasks.peek();
	}
	
	public int getRemainingTime() {
		int timeRequired = 0;
		for (Task t : tasks) {
			timeRequired += t.getHours();
		}
		return timeAvailable - timeRequired;
	}
	
	public boolean canFinish() {
		return getRemainingTime() >= 0;
	}
}
