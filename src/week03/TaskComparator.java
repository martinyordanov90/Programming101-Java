package week03;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
	@Override
	public int compare(Task t1, Task t2) {
		if (t1.isHighPriority() && t2.isHighPriority()) {
			return Double.compare(t2.getHours(), t1.getHours());
		} else if (t1.isHighPriority()) {
			return -1;
		} else {
			return 1;
		}
	}
}
