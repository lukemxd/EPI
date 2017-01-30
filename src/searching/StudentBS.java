package searching;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Problem 12.0
public class StudentBS {

	public static class Student {
		public String name;
		public double GPA;
		
		public Student(String name, double gpa){
			this.name = name;
			this.GPA = gpa;
		}
	}
	//Customized comparator
	private static final Comparator<Student> compareGPA = new Comparator<StudentBS.Student>() {
		@Override
		public int compare(Student s1, Student s2){
			if(s1.GPA != s2.GPA){
				return Double.compare(s1.GPA, s2.GPA);	
			}
			return s1.name.compareTo(s2.name);
		}
	};
	
	public static boolean searchStudent(List<Student> students, Student target){
		return Collections.binarySearch(students, target, compareGPA) >= 0;
	}
	
}
