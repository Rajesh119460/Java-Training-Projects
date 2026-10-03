package studentmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class StudentFileService {

    private String fileName = "students.txt";

    // Save students to file
    public void saveStudents(StudentService service) {

        try (FileWriter writer = new FileWriter(fileName)) {

            for (Student student : service.getStudents().values()) {

                writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getEmail() + "," +
                    student.getMarks() + "," +
                    student.getAttendance() + "," +
                    student.getStatus() + "\n"
                );
            }

            System.out.println("Students saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving students.");
        }
    }

    // Load students from file
    public void loadStudents(StudentService service) {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                double marks = Double.parseDouble(data[3]);
                int attendance = Integer.parseInt(data[4]);
                StudentStatus status =
                        StudentStatus.valueOf(data[5]);

                Student student = new Student(
                        id,
                        name,
                        email,
                        marks,
                        attendance,
                        status
                );

                service.addStudent(student);
            }

            System.out.println("Students loaded successfully.");

        } catch (IOException e) {

            System.out.println("No existing student file found.");
        }
    }
}