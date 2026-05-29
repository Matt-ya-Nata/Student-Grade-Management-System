package gradesystem;

public class GradeCalculator {

    // Method Overloading Example
    public double calculateAverage(double s1, double s2, double s3) {
        return (s1 + s2 + s3) / 3;
    }

    public double calculateAverage(int total, int numberOfSubjects) {
        return total / numberOfSubjects;
    }

    public String getStatus(double average) {

        if (average >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
    
    
    
    
}