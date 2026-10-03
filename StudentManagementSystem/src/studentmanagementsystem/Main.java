package studentmanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();
        StudentFileService fileService = new StudentFileService();

        // Load existing students
        fileService.loadStudents(service);

        int choice;

        do {

            System.out.println("\n---- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Calculate Grade");
            System.out.println("8. Remove Student");
            System.out.println("9. Display Topper");
            System.out.println("10. Save Students");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                System.out.print("Enter Attendance: ");
                int attendance = sc.nextInt();

                System.out.println("Choose Student Status:");
                System.out.println("1. ACTIVE");
                System.out.println("2. INACTIVE");
                System.out.println("3. COMPLETED");

                System.out.print("Enter status choice: ");
                int statusChoice = sc.nextInt();

                StudentStatus status;

                switch (statusChoice) {

                case 1:
                    status = StudentStatus.ACTIVE;
                    break;

                case 2:
                    status = StudentStatus.INACTIVE;
                    break;

                case 3:
                    status = StudentStatus.COMPLETED;
                    break;

                default:
                    status = StudentStatus.ACTIVE;
                    System.out.println("Invalid status. ACTIVE selected.");
                }

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks.");
                    break;
                }

                if (attendance < 0 || attendance > 100) {
                    System.out.println("Invalid attendance.");
                    break;
                }

                Student student = new Student(
                        id,
                        name,
                        email,
                        marks,
                        attendance,
                        status
                );

                service.addStudent(student);

                break;

            case 2:

                service.displayAllStudents();

                break;

            case 3:

                System.out.print("Enter Student ID: ");
                int searchId = sc.nextInt();

                Student foundStudent = service.searchById(searchId);

                if (foundStudent == null) {

                    System.out.println("Student ID not found.");

                } else {

                    System.out.println("Student Found:");
                    System.out.println("ID: " + foundStudent.getId());
                    System.out.println("Name: " + foundStudent.getName());
                    System.out.println("Email: " + foundStudent.getEmail());
                    System.out.println("Marks: " + foundStudent.getMarks());
                    System.out.println("Attendance: "
                            + foundStudent.getAttendance());
                    System.out.println("Status: "
                            + foundStudent.getStatus());
                }

                break;

            case 4:

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String searchName = sc.nextLine();

                Student studentByName =
                        service.searchByName(searchName);

                if (studentByName == null) {

                    System.out.println("Student not found.");

                } else {

                    System.out.println("Student Found:");
                    System.out.println("ID: " + studentByName.getId());
                    System.out.println("Name: " + studentByName.getName());
                    System.out.println("Email: " + studentByName.getEmail());
                    System.out.println("Marks: "
                            + studentByName.getMarks());
                    System.out.println("Attendance: "
                            + studentByName.getAttendance());
                    System.out.println("Status: "
                            + studentByName.getStatus());
                }

                break;

            case 5:

                System.out.print("Enter Student ID: ");
                int marksId = sc.nextInt();

                System.out.print("Enter New Marks: ");
                double newMarks = sc.nextDouble();

                service.updateMarks(marksId, newMarks);

                break;

            case 6:

                System.out.print("Enter Student ID: ");
                int attendanceId = sc.nextInt();

                System.out.print("Enter New Attendance: ");
                int newAttendance = sc.nextInt();

                service.updateAttendance(
                        attendanceId,
                        newAttendance
                );

                break;

            case 7:

                System.out.print("Enter Student ID: ");
                int gradeId = sc.nextInt();

                String grade = service.calculateGrade(gradeId);

                System.out.println("Grade: " + grade);

                break;

            case 8:

                System.out.print("Enter Student ID to remove: ");
                int removeId = sc.nextInt();

                service.removeStudent(removeId);

                break;

            case 9:

                Student topper = service.displayTopper();

                if (topper == null) {

                    System.out.println("No students found.");

                } else {

                    System.out.println("===== TOPPER =====");
                    System.out.println("ID: " + topper.getId());
                    System.out.println("Name: " + topper.getName());
                    System.out.println("Marks: " + topper.getMarks());
                    System.out.println("Attendance: "
                            + topper.getAttendance());
                    System.out.println("Status: "
                            + topper.getStatus());
                }

                break;

            case 10:

                fileService.saveStudents(service);

                break;

            case 11:

                // Save before exit
                fileService.saveStudents(service);

                System.out.println(
                        "Thank you for using Student Management System!"
                );

                break;

            default:

                System.out.println("Invalid choice.");
            }

        } while (choice != 11);

        sc.close();
    }
}
