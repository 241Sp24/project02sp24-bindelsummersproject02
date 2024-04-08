package studentdriver;

import java.util.*;
import java.io.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project02");
        try (Scanner input = new Scanner(System.in)) {
            // aks user for input
            System.out.println("Enter the no of UG Students: ");
            int ugStudents = input.nextInt();
            System.out.println("Enter the no of Graduate students: ");
            int gradStudents = input.nextInt();
            System.out.println("Enter the no of online students: ");
            int onlineStudent = input.nextInt();

            StudentFees[] students = new StudentFees[12];
            try (BufferedReader br = new BufferedReader(new FileReader("input.csv"))) {
                String line;
                int index = 0;

                for (int i = 0; i < ugStudents; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean hasscholarship = Boolean.parseBoolean(parts[2].trim());
                    int courses = Integer.parseInt(parts[3].trim());
                    boolean Enrolled = Boolean.parseBoolean(parts[4].trim());
                    int totalScholarship = Integer.parseInt(parts[5].trim());

                    students[index] = new UGStudent(name, id, Enrolled, hasscholarship, totalScholarship, courses);
                    index++;
                }
                for (int i = 0; i < gradStudents; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int courses = Integer.parseInt(parts[3].trim());
                    boolean gradassitant = Boolean.parseBoolean(parts[4].trim());
                    String assitantType = parts[5].trim();

                    students[index] = new GraduateStudent(name, id, Enrolled, gradassitant, assitantType, courses);
                    index++;
                }
                for (int i = 0; i < onlineStudent; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int noMonths = Integer.parseInt(parts[3].trim());

                    students[index] = new OnlineStudent(name, id, Enrolled, noMonths);
                    index++;
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        }
    }

}
