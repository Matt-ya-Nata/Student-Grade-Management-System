package gradesystem;

import java.util.Scanner;

public class SchoolSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DatabaseManager db = new DatabaseManager();
        GradeCalculator gc = new GradeCalculator();

        int choice;

        do {

            System.out.println("\n===== STUDENT GRADE SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                // ADD STUDENT
                case 1:

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    // SUBJECT 1
                    System.out.print("Enter Subject 1 Name: ");
                    String sub1Name = scanner.nextLine();

                    System.out.print("Enter " + sub1Name + " Mark: ");
                    double sub1Mark = scanner.nextDouble();

                    scanner.nextLine();

                    // SUBJECT 2
                    System.out.print("Enter Subject 2 Name: ");
                    String sub2Name = scanner.nextLine();

                    System.out.print("Enter " + sub2Name + " Mark: ");
                    double sub2Mark = scanner.nextDouble();

                    scanner.nextLine();

                    // SUBJECT 3
                    System.out.print("Enter Subject 3 Name: ");
                    String sub3Name = scanner.nextLine();

                    System.out.print("Enter " + sub3Name + " Mark: ");
                    double sub3Mark = scanner.nextDouble();

                    Student student = new Student(
                            name,
                            sub1Name,
                            sub1Mark,
                            sub2Name,
                            sub2Mark,
                            sub3Name,
                            sub3Mark
                    );

                    double average = gc.calculateAverage(
                            sub1Mark,
                            sub2Mark,
                            sub3Mark
                    );

                    String status = gc.getStatus(average);

                    db.addStudent(student, average, status);

                    break;

                // VIEW STUDENT BY ID
                case 2:

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();

                    db.viewStudentById(studentId);

                    break;

                // VIEW ALL STUDENTS
                case 3:

                    db.viewStudents();

                    break;

                // UPDATE STUDENT
                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = scanner.nextInt();

                    System.out.println("\nWhat would you like to update?");
                    System.out.println("1. Student Name");
                    System.out.println("2. Subject 1");
                    System.out.println("3. Subject 2");
                    System.out.println("4. Subject 3");

                    System.out.print("Enter Option: ");
                    int updateChoice = scanner.nextInt();

                    scanner.nextLine();

                    switch (updateChoice) {

                        case 1:

                            System.out.print("Enter New Student Name: ");
                            String newName = scanner.nextLine();

                            db.updateStudentName(updateId, newName);

                            break;

                        case 2:

                            System.out.print("Enter New Subject 1 Name: ");
                            String subject1Name = scanner.nextLine();

                            System.out.print("Enter New Mark: ");
                            double subject1Mark = scanner.nextDouble();

                            db.updateSubject1(
                                    updateId,
                                    subject1Name,
                                    subject1Mark
                            );

                            db.recalculateResults(updateId);

                            break;

                        case 3:

                            System.out.print("Enter New Subject 2 Name: ");
                            String subject2Name = scanner.nextLine();

                            System.out.print("Enter New Mark: ");
                            double subject2Mark = scanner.nextDouble();

                            db.updateSubject2(
                                    updateId,
                                    subject2Name,
                                    subject2Mark
                            );

                            db.recalculateResults(updateId);

                            break;

                        case 4:

                            System.out.print("Enter New Subject 3 Name: ");
                            String subject3Name = scanner.nextLine();

                            System.out.print("Enter New Mark: ");
                            double subject3Mark = scanner.nextDouble();

                            db.updateSubject3(
                                    updateId,
                                    subject3Name,
                                    subject3Mark
                            );

                            db.recalculateResults(updateId);

                            break;

                        default:

                            System.out.println("Invalid Update Option!");
                    }

                    break;

                // DELETE STUDENT
                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = scanner.nextInt();

                    db.deleteStudent(deleteId);

                    break;

                // EXIT
                case 6:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}