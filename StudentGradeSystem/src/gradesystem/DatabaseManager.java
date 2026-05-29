package gradesystem;

import java.sql.*;

public class DatabaseManager {

    private final String URL = "jdbc:mysql://localhost:3306/schooldb";
    private final String USER = "root";
    private final String PASSWORD = "";

    // DATABASE CONNECTION
    public Connection connect() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }

    // ADD STUDENT
    public void addStudent(Student student, double average, String status) {

        String query = "INSERT INTO students(name, subject1_name, subject1_mark, subject2_name, subject2_mark, subject3_name, subject3_mark, average_mark, status) VALUES(?,?,?,?,?,?,?,?,?)";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());

            ps.setString(2, student.getSubject1Name());
            ps.setDouble(3, student.getSubject1Mark());

            ps.setString(4, student.getSubject2Name());
            ps.setDouble(5, student.getSubject2Mark());

            ps.setString(6, student.getSubject3Name());
            ps.setDouble(7, student.getSubject3Mark());

            ps.setDouble(8, average);
            ps.setString(9, status);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Added Successfully!");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // VIEW ALL STUDENTS
    public void viewStudents() {

        String query = "SELECT * FROM students";

        try {

            Connection conn = connect();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            boolean hasData = false;

            while (rs.next()) {

                hasData = true;

                System.out.println("\n========================");
                System.out.println("ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));

                System.out.println(
                        rs.getString("subject1_name")
                        + ": "
                        + rs.getDouble("subject1_mark")
                );

                System.out.println(
                        rs.getString("subject2_name")
                        + ": "
                        + rs.getDouble("subject2_mark")
                );

                System.out.println(
                        rs.getString("subject3_name")
                        + ": "
                        + rs.getDouble("subject3_mark")
                );

                System.out.println("Average: " + rs.getDouble("average_mark"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("========================");
            }

            if (!hasData) {

                System.out.println("No students found.");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // VIEW STUDENT BY ID
    public void viewStudentById(int id) {

        String query = "SELECT * FROM students WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n========================");
                System.out.println("STUDENT DETAILS");
                System.out.println("========================");

                System.out.println("ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));

                System.out.println(
                        rs.getString("subject1_name")
                        + ": "
                        + rs.getDouble("subject1_mark")
                );

                System.out.println(
                        rs.getString("subject2_name")
                        + ": "
                        + rs.getDouble("subject2_mark")
                );

                System.out.println(
                        rs.getString("subject3_name")
                        + ": "
                        + rs.getDouble("subject3_mark")
                );

                System.out.println("Average: " + rs.getDouble("average_mark"));
                System.out.println("Status: " + rs.getString("status"));

                System.out.println("========================");

            } else {

                System.out.println("Student Not Found!");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE STUDENT NAME
    public void updateStudentName(int id, String newName) {

        String query = "UPDATE students SET name=? WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, newName);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Name Updated!");

            } else {

                System.out.println("Student ID Not Found!");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE SUBJECT 1
    public void updateSubject1(int id, String subjectName, double mark) {

        String query = "UPDATE students SET subject1_name=?, subject1_mark=? WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, subjectName);
            ps.setDouble(2, mark);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Subject 1 Updated!");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE SUBJECT 2
    public void updateSubject2(int id, String subjectName, double mark) {

        String query = "UPDATE students SET subject2_name=?, subject2_mark=? WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, subjectName);
            ps.setDouble(2, mark);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Subject 2 Updated!");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE SUBJECT 3
    public void updateSubject3(int id, String subjectName, double mark) {

        String query = "UPDATE students SET subject3_name=?, subject3_mark=? WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, subjectName);
            ps.setDouble(2, mark);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Subject 3 Updated!");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // RECALCULATE AVERAGE AND STATUS
    public void recalculateResults(int id) {

        String selectQuery = "SELECT * FROM students WHERE student_id=?";

        String updateQuery = "UPDATE students SET average_mark=?, status=? WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement selectPs = conn.prepareStatement(selectQuery);

            selectPs.setInt(1, id);

            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {

                double s1 = rs.getDouble("subject1_mark");
                double s2 = rs.getDouble("subject2_mark");
                double s3 = rs.getDouble("subject3_mark");

                double average = (s1 + s2 + s3) / 3;

                String status;

                if (average >= 50) {

                    status = "PASS";

                } else {

                    status = "FAIL";
                }

                PreparedStatement updatePs = conn.prepareStatement(updateQuery);

                updatePs.setDouble(1, average);
                updatePs.setString(2, status);
                updatePs.setInt(3, id);

                updatePs.executeUpdate();

                System.out.println("Average and Status Updated!");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE student_id=?";

        try {

            Connection conn = connect();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Deleted Successfully!");

            } else {

                System.out.println("Student ID Not Found!");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}