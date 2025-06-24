import java.util.*;

public class GradeManager {
    private List<Student> students;
    
    public GradeManager() {
        this.students = new ArrayList<>();
    }
    
    public boolean addStudent(String name, String studentId, double subject1, double subject2, double subject3) {
        // Check if student ID already exists
        if (findStudentById(studentId) != null) {
            return false; // Student ID already exists
        }
        
        Student student = new Student(name, studentId, subject1, subject2, subject3);
        students.add(student);
        return true;
    }
    
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    public boolean updateStudentMarks(String studentId, double subject1, double subject2, double subject3) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.updateMarks(subject1, subject2, subject3);
            return true;
        }
        return false;
    }
    
    public boolean deleteStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public int getTotalStudents() {
        return students.size();
    }
    
    public double getClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        
        double totalAverage = 0.0;
        for (Student student : students) {
            totalAverage += student.getAverage();
        }
        return totalAverage / students.size();
    }
    
    public Map<Character, Integer> getGradeDistribution() {
        Map<Character, Integer> distribution = new HashMap<>();
        distribution.put('A', 0);
        distribution.put('B', 0);
        distribution.put('C', 0);
        distribution.put('D', 0);
        distribution.put('F', 0);
        
        for (Student student : students) {
            char grade = student.getGrade();
            distribution.put(grade, distribution.get(grade) + 1);
        }
        
        return distribution;
    }
    
    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }
    
    public static boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty();
    }
    
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
} 
