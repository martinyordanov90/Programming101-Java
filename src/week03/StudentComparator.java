package week03;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getGrade() == s2.getGrade()) {
			return s1.getName().compareTo(s2.getName());
		}
		
		return Integer.compare(s1.getGrade(), s2.getGrade());
	}
}
