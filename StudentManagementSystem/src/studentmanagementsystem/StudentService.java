package studentmanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
	
	private HashMap<Integer,Student> students=new HashMap<>();
	
	public void addStudent(Student student) {
		
		if(students.containsKey(student.getId())) {
			System.out.println("Styudent ALready Exist");
			return;
		}
		
		students.put(student.getId(), student);
		System.out.println("Student added successfully.");
	}
	
	//display students
	
	public void displayAllStudents() {
		
		if(students.isEmpty()) {
			System.out.println("No Student Found");
			return;
		}
		
		for(Student student:students.values()) {
			
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("Attendance: " + student.getAttendance());
            System.out.println("Status: " + student.getStatus());
            System.out.println("----------------------");	
		}
	}
	
	//search by id
	
	public Student searchById(int id) {
		return students.get(id);
	}
	
	//by name 
	public Student searchByName(String name) {
		for(Student student:students.values()) {
			if(student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}
	
	//update marks
	
	public void updateMarks(int id,double marks) {
		
		Student student =students.get(id);
		
		if(student==null) {
			System.out.println("Student Id doesnt exist");
			return;
		}
		if(marks<0 || marks>100) {
			System.out.println("Enter marks between 0 and 100");
			return;
		}
		
		student.setMarks(marks);
		System.out.println("Marks updated successfully.");
	}
	
	//attendance update
	
	 public void updateAttendance(int id, int attendance) {

	        Student student = students.get(id);

	        if (student == null) {
	            System.out.println("Student ID not found.");
	            return;
	        }

	        if (attendance < 0 || attendance > 100) {
	            System.out.println("Invalid attendance. Enter between 0 and 100.");
	            return;
	        }

	        student.setAttendance(attendance);

	        System.out.println("Attendance updated successfully.");
	    }
	 
	 //grade calc
	 public String calculateGrade(int id) {

	        Student student = students.get(id);

	        if (student == null) {
	            return "Student ID not found.";
	        }

	        double marks = student.getMarks();

	        if (marks >= 90) {
	            return "A";
	        } else if (marks >= 75) {
	            return "B";
	        } else if (marks >= 60) {
	            return "C";
	        } else if (marks >= 50) {
	            return "D";
	        } else {
	            return "F";
	        }
	    }
	 //student remove
	 public void removeStudent(int id) {

	        if (students.containsKey(id)) {
	            students.remove(id);
	            System.out.println("Student removed successfully.");
	        } else {
	            System.out.println("Student ID not found.");
	        }
	    }
	 //topper display
	 
	 public Student displayTopper() {

	        Student topper = null;

	        for (Student student : students.values()) {

	            if (topper == null ||
	                student.getMarks() > topper.getMarks()) {

	                topper = student;
	            }
	        }

	        return topper;
	    }
	 // Get all students
	    public Map<Integer, Student> getStudents() {
	    	
	        return students;
	    }
}
