import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ---------------------------
        // Platform Data
        // ---------------------------
        ArrayList<User> allUsers = new ArrayList<>();
        ArrayList<Course> allCourses = new ArrayList<>();

        // ---------------------------
        // Create Admin
        // ---------------------------
        Admin admin = new Admin(1, "Admin1", "admin@skillforge.com", "admin123");
        allUsers.add(admin);

        // ---------------------------
        // Create Instructor
        // ---------------------------
        Instructor instructor = new Instructor(2, "John Doe", "john@skillforge.com", "pass123");
        allUsers.add(instructor);

        // ---------------------------
        // Instructor creates a course
        // ---------------------------
        instructor.createCourse("Java Basics", "Learn Java from scratch");
        Course javaCourse = instructor.getCreatedCourses().get(0);
        allCourses.add(javaCourse);

        // ---------------------------
        // Add lessons to course
        // ---------------------------
        Lesson lesson1 = new Lesson("Introduction", "Java Introduction Content", null, javaCourse);
        Lesson lesson2 = new Lesson("Variables", "Variables and Data Types", null, javaCourse);

        instructor.uploadLesson(javaCourse, lesson1);
        instructor.uploadLesson(javaCourse, lesson2);

        // ---------------------------
        // Add a quiz to the course
        // ---------------------------
        ArrayList<String> options = new ArrayList<>();
        options.add("8"); options.add("10"); options.add("12"); options.add("14");
        Question q1 = new Question("What is 5+5?", 10, options, "10");
        Quiz quiz1 = new Quiz(100);
        quiz1.getQuestions().add(q1);

        instructor.createQuiz(javaCourse, quiz1);

        // ---------------------------
        // Create a Student
        // ---------------------------
        Student student = new Student(3, "Alice", "alice@skillforge.com", "alice123");
        allUsers.add(student);

        // ---------------------------
        // Student enrolls in the course
        // ---------------------------
        student.enrollInCourse(javaCourse);

        // ---------------------------
        // Student completes lessons
        // ---------------------------
        student.completeLesson(lesson1);
        student.completeLesson(lesson2);

        // ---------------------------
        // Student takes the quiz
        // ---------------------------
        ArrayList<String> answers = new ArrayList<>();
        answers.add("10"); // Correct answer
        student.takeQuiz(quiz1, answers, javaCourse);

        // ---------------------------
        // Admin approves the course
        // ---------------------------
        admin.removeCourse(allCourses, javaCourse); // just as an example

        // ---------------------------
        // Admin promotes the student
        // ---------------------------
        admin.manageUser(allUsers, student, "promote");

        // ---------------------------
        // Show all users
        // ---------------------------
        System.out.println("\nAll Users on Platform:");
        for (User u : allUsers) {
            System.out.println(u.getUserName() + " (" + u.getClass().getSimpleName() + ")");
        }
    }
}
