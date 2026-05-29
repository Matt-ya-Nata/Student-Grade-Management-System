package gradesystem;

public class Student {

    private int studentId;
    private String name;

    private String subject1Name;
    private double subject1Mark;

    private String subject2Name;
    private double subject2Mark;

    private String subject3Name;
    private double subject3Mark;

    // Constructor without ID
    public Student(
            String name,
            String subject1Name,
            double subject1Mark,
            String subject2Name,
            double subject2Mark,
            String subject3Name,
            double subject3Mark
    ) {

        this.name = name;

        this.subject1Name = subject1Name;
        this.subject1Mark = subject1Mark;

        this.subject2Name = subject2Name;
        this.subject2Mark = subject2Mark;

        this.subject3Name = subject3Name;
        this.subject3Mark = subject3Mark;
    }

    // Constructor with ID
    public Student(
            int studentId,
            String name,
            String subject1Name,
            double subject1Mark,
            String subject2Name,
            double subject2Mark,
            String subject3Name,
            double subject3Mark
    ) {

        this.studentId = studentId;
        this.name = name;

        this.subject1Name = subject1Name;
        this.subject1Mark = subject1Mark;

        this.subject2Name = subject2Name;
        this.subject2Mark = subject2Mark;

        this.subject3Name = subject3Name;
        this.subject3Mark = subject3Mark;
    }

    // Getters

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getSubject1Name() {
        return subject1Name;
    }

    public double getSubject1Mark() {
        return subject1Mark;
    }

    public String getSubject2Name() {
        return subject2Name;
    }

    public double getSubject2Mark() {
        return subject2Mark;
    }

    public String getSubject3Name() {
        return subject3Name;
    }

    public double getSubject3Mark() {
        return subject3Mark;
    }
}