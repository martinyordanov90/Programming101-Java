package week03;

import java.util.Collections;
import java.util.List;

public class SortStudents {
	static void byGrade(List<Student> students) {
		Collections.sort(students, new StudentComparator());
	}
}
