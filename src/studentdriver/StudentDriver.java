package studentdriver;

import java.util.*;
import java.io.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project02");
        try (Scanner input = new Scanner(System.in)) {
            // aks user for input
            System.out.print("Enter the no of UG Students: ");
            int ugStudents = input.nextInt();
            System.out.print("Enter the no of Graduate students: ");
            int gradStudents = input.nextInt();
            System.out.print("Enter the no of online students: ");
            int onlineStudent = input.nextInt();

            StudentFees[] students = new StudentFees[12];
            try (BufferedReader br = new BufferedReader(new FileReader("input.csv"))) {
                String line;
                int index = 0;

                System.out.println("\n**********Undergraduate students list**********");
                double ugTotalFee = 0;
                int ugTotalCourses = 0;
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
                    System.out.println(students[index].toString());
                    System.out.println();
                    
                    ugTotalFee += students[index].getPayableAmount();
                    ugTotalCourses += courses;
                    
                    index++;
                }
                
                System.out.println("\n**********Graduate students list**********");
                double gradTotalFee = 0;
                int gradAssistantCount = 0;
                int gradTotalCourses = 0;
                for (int i = 0; i < gradStudents; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int courses = Integer.parseInt(parts[3].trim());
                    boolean gradassitant = Boolean.parseBoolean(parts[4].trim());
                    String assitantType = parts[4].trim();

                    students[index] = new GraduateStudent(name, id, Enrolled, gradassitant, assitantType, courses);
                    System.out.println(students[index].toString());
                    System.out.println();
                    
                    gradTotalFee += students[index].getPayableAmount();
                    gradAssistantCount++; // Increment count for each graduate student

                    gradTotalCourses += courses;
                    
                    index++;
                }
                
                System.out.println("\n**********Online student list**********");
                double onlineTotalFee = 0;
                int onlineTotalMonths = 0;
                for (int i = 0; i < onlineStudent; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int noMonths = Integer.parseInt(parts[3].trim());

                    students[index] = new OnlineStudent(name, id, Enrolled, noMonths);
                    System.out.println(students[index].toString());
                    System.out.println();
                    
                    onlineTotalFee += students[index].getPayableAmount();
                    onlineTotalMonths += noMonths;
                    
                    index++;
                }
                
                // Print summary details
                System.out.println("\n**********Undergraduate Students details**********");
                System.out.println("Average Students fee: " + (ugTotalFee / ugStudents));
                System.out.println("Scholarship count: " + ugStudents); // Assuming ugStudents is the count of students with scholarship
                System.out.println("Total number of courses: " + ugTotalCourses);

                System.out.println("\n**********Graduate Students details**********");
                System.out.println("Average Students fee: " + (gradTotalFee / gradStudents));
                System.out.println("Graduate Assistantship count: " + gradAssistantCount);
                System.out.println("Total number of courses: " + gradTotalCourses);

                System.out.println("\n**********Online Students details**********");
                System.out.println("Average Students fee: " + (onlineTotalFee / onlineStudent));
                System.out.println("Total number of months: " + onlineTotalMonths);
                
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            
            catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            }
            
        }

    }
}


