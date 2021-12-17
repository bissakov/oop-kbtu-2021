public class Week4b{
	public static void main(String[] args) {
		Student s1 = new Student();

		// System.out.println(s1.getGPA());
		// s1.setGPA(3.5);
		// System.out.println(s1.getGPA());

		// System.out.println(s1.getYear());
		// s1.setYear(4);
		// System.out.println(s1.getYear());

		// s1.setFaculty("FIT");
		// System.out.println(s1.faculty);
		// s1.faculty = "BS";
		// System.out.println(s1.faculty);

		Student s2 = new Student();
		Student s3 = new Student();

		System.out.println(Student.getNumOfStudents());

	}
}

/*
TASK-1: Add at least 2 more data fields with different access modifiers
TASK-2: Add at least 2 more methods with different access modifiers
TASK-3: Create a class University that includes Student as a data field (group of students, if possible)
*/

class Student {
	public String name;
	public String id;
	private double gpa;
	String specialty;
	private int studyYear = 1; // default
	public String faculty;
	private static int numberOfStudents = 0;

	Student() {
		numberOfStudents++;
	}

	public double getGPA() {
		return gpa;
	}

	public void setGPA(double g) {
		gpa = g;
	}

	static void changeName(Student s){ // s = s1
		s.name = " Alikhan";
	}

	public int getYear() {
		return studyYear;
	}

	public void setYear(int year) {
		studyYear = year;
	}

	public void setFaculty(String s) {
		faculty = s;
	}

	static int getNumOfStudents() {
		return numberOfStudents;
	}

}

class University {

}