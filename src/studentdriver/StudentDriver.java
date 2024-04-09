package studentdriver;

/**
 *
 * Class: 44-241 Computer Programming II
 *
 * Author: Hayden Bindel and Chanse Summers
 *
 * Description: Create a program that will calculate and display the fee amount
 * to be paid by students at the university. You will calculate the average fee
 * paid by UG students, Graduate students and Online students. You will also
 * print out the count of UG students who received a scholarship and Graduate
 * students who received an assistantship.
 *
 * Due: 4/10/24
 *
 * I pledge that I have completed the programming assignment independently.
 *
 * I have not copied the code from a student or any source.
 *
 * I have not given my code to any other student and will not share this code
 * with anyone under any circumstances.
 *
 */
import java.util.*;
import java.io.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner input = new Scanner(System.in)) {
            // aks user for input
            System.out.print("Enter the no of UG Students: ");
            int ugStudents = input.nextInt();
            System.out.print("Enter the no of Graduate students: ");
            int gradStudents = input.nextInt();
            System.out.print("Enter the no of online students: ");
            int onlineStudent = input.nextInt();

            StudentFees[] students = new StudentFees[12];
            //BufferedReader is to make the file easier to read
            try (BufferedReader br = new BufferedReader(new FileReader("input.csv"))) {
                String line;
                int index = 0;

                System.out.println("\n**********Undergraduate students list**********");
                double ugTotalFee = 0;
                int ugTotalCourses = 0;
                int scholarcount = 0;
                //reading each line of the ugStudents and separating them into a array which each index goes into the variable then into class
                for (int i = 0; i < ugStudents; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int courses = Integer.parseInt(parts[3].trim());
                    boolean hasscholarship = Boolean.parseBoolean(parts[4].trim());
                    int totalScholarship = Integer.parseInt(parts[5].trim());

                    students[index] = new UGStudent(name, id, Enrolled, hasscholarship, totalScholarship, courses);
                    System.out.println(students[index].toString());
                    System.out.println();
                    //making sure the count is correct and not counting every student
                    if (hasscholarship == true) {
                        scholarcount++;
                    }
                    ugTotalFee += students[index].getPayableAmount();
                    if (Enrolled == true) {
                        ugTotalCourses += courses;
                    }

                    index++;
                }

                System.out.println("**********Graduate students list**********");
                double gradTotalFee = 0;
                int gradAssistantCount = 0;
                int gradTotalCourses = 0;
                //reading each line of the ugStudents and separating them into a array which each index goes into the variable then into class
                for (int i = 0; i < gradStudents; i++) {
                    line = br.readLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    boolean Enrolled = Boolean.parseBoolean(parts[2].trim());
                    int courses = Integer.parseInt(parts[3].trim());
                    boolean gradassitant = Boolean.parseBoolean(parts[4].trim());
                    // this is to make sure that when reading the file that there is no null
                    //if so then it gives an error of that this wasn't a 5th index
                    String assistantType;
                    if (parts.length > 5) {
                        assistantType = parts[5].trim();
                    } else {
                        assistantType = "";
                    }

                    students[index] = new GraduateStudent(name, id, Enrolled, gradassitant, assistantType, courses);
                    System.out.println(students[index].toString());
                    System.out.println();

                    gradTotalFee += students[index].getPayableAmount();
                    if (gradassitant == true) {
                        gradAssistantCount++; // Increment count for each graduate student
                    }
                    gradTotalCourses += courses;

                    index++;
                }

                System.out.println("**********Online student list**********");
                double onlineTotalFee = 0;
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

                    index++;
                }

                // Print summary details
                System.out.println("**********Undergraduate Students details**********");
                System.out.println("Average Students fee: " + (ugTotalFee / 4));
                System.out.println("Scholarship count: " + scholarcount); // Assuming ugStudents is the count of students with scholarship
                System.out.println("Total number of courses: " + ugTotalCourses);

                System.out.println("\n**********Graduate Students details**********");
                double avgGrad = gradTotalFee / gradStudents;
                System.out.printf("Average Students fee: %.2f \n", avgGrad);
                System.out.println("Graduate Assistantship count: " + gradAssistantCount);
                System.out.println("Total number of courses: " + gradTotalCourses);

                System.out.println("\n**********Online Students details**********");
                double avgOS = (onlineTotalFee / onlineStudent);
                System.out.printf("Average Students fee: %.2f\n", avgOS);
                // both catches are for the file and anything that is not working
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}
