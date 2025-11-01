import java.util.ArrayList;

public class Instructor extends User
{
    private ArrayList<Course> createdCourses;

    public Instructor(int userId, String userName, String email, String password) {
        super(userId, userName, email, password);
        this.createdCourses = new ArrayList<>();
    }

    public void setCreatedCourses(ArrayList<Course> createdCourses) {this.createdCourses = createdCourses;}
    public ArrayList<Course> getCreatedCourses() {return createdCourses;}

    public void createCourse(String title, String description)
    {
        for(Course c : createdCourses)
        {
         if(c.getTitle() == title) {
             System.out.println("This Course Is Already Exists..");
             return;
         }
        }
        Course course = new Course(title, description,this);
        createdCourses.add(course);
    }

    public void uploadLesson(Course course, Lesson lesson)
    {
        if (createdCourses.contains(course)) {
            course.addLesson(lesson);
        } else {
            System.out.println("You Can't Add a Lesson To a Course You Didn't Create..");
        }
    }

    public void createQuiz(Course course, Quiz quiz)
    {
        if (createdCourses.contains(course)) {
            course.addQuiz(quiz);
        } else {
            System.out.println("You Can't Add a Quiz To a Course You Didn't Create..");
        }
    }
}
