import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data mahasiswa
        System.out.println("Enter student's name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter student's address:");
        String studentAddress = scanner.nextLine();
        Student student = new Student(studentName, studentAddress);

        // Input data mata kuliah dan nilai mahasiswa
        System.out.println("Enter number of courses:");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        StringBuilder csvData = new StringBuilder(); // Membuat objek StringBuilder untuk menyimpan data CSV
        csvData.append("Student Name,Student Address,Course Name,Grade\n"); // Menulis header CSV
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course name:");
            String courseName = scanner.nextLine();
            System.out.println("Enter grade for " + courseName + ":");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            student.addCourseGrade(courseName, grade); // Tambahkan course name dan grade ke dalam objek student
            csvData.append(studentName).append(",").append(studentAddress).append(",").append(courseName).append(",")
                    .append(grade).append("\n"); // Menyimpan data dalam format CSV
        }

        // Input data dosen
        System.out.println("Enter teacher's name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter teacher's address:");
        String teacherAddress = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName, teacherAddress);

        // Input data mata kuliah yang diampu oleh dosen
        System.out.println("Enter number of courses taught by the teacher:");
        int numCoursesTeacher = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numCoursesTeacher; i++) {
            System.out.println("Enter course name:");
            String courseName = scanner.nextLine();
            teacher.addCourse(courseName);
        }

        // Menampilkan informasi mahasiswa
        System.out.println(student.toString());
        student.printGrades();
        System.out.println("Average Grade: " + student.getAverageGrade());

        // Menampilkan informasi dosen
        System.out.println(teacher.toString());

        // Menyimpan data ke dalam file CSV
        try (FileWriter writer = new FileWriter("datamahasiswa.csv")) {
            writer.write(csvData.toString());
            System.out.println("Data has been written to datamahasiswa.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }

}
