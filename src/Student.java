import java.util.ArrayList;

public class Student extends User
{
    private ArrayList<Course> enrolledCourses ;
    private ArrayList<Certificate> certificates ;
    private Analytics analytics;

    public Student(int userId, String userName, String email, String password)
 {
     super(userId, userName, email, password);
     this.analytics = new Analytics();
     this.certificates = new ArrayList<>();
     this.enrolledCourses = new ArrayList<>();

 }
    public void enrollInCourse(Course course)
    {
        if(!enrolledCourses.contains(course))
        {
            enrolledCourses.add(course);
            System.out.println("Enrolled Successfully..");
        }
        else System.out.println("You Already Enrolled In This Course..");
    };
    public void completeLesson(Lesson lesson) {
        analytics.recordLessonCompletion(lesson);
        System.out.println(getUserName() + " completed lesson: " + lesson.getTitle());
    }


    public void takeQuiz(Quiz quiz, ArrayList<String> studentAnswers, Course course)
    {
        System.out.println(getUserName() + " started quiz: " + quiz.getQuizId());
        int score = quiz.evaluateAnswers(studentAnswers);
        System.out.println("Score: " + score);

        if (quiz.isPassed(score))
        {
            System.out.println("Quiz passed!");
            boolean allQuizzesPassed = true;
            for (Quiz q : course.getQuizzes())
            {
                if (!q.isPassed(score))
                {
                    allQuizzesPassed = false;
                    break;
                }
            }
            if (allQuizzesPassed) {
                earnCertificate(course);
            }
        } else {
            System.out.println("Quiz not passed.");
        }
    }



    public void earnCertificate(Course course) {
        Certificate cert = new Certificate(this, course);
        certificates.add(cert);
        System.out.println("Certificate earned for course: " + course.getTitle());
    }


    public ArrayList<Course> getEnrolledCourses() {return enrolledCourses;}
    public Analytics getAnalytics() {return analytics;}
    public ArrayList<Certificate> getCertificates() {return certificates;}


}
