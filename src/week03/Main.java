package week03;

public class Main {
	public static void main(String[] args) {
		ToDoList todo = new ToDoList();
		
		todo.add(new Task(10));
		todo.add(new Task(5, true));
		
		System.out.println(todo.getTop().getHours());
	}
}
