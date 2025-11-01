import java.util.ArrayList;

public class Course {
    private static int nextId = 1;
    private int courseId;
    private String title;
    private String description;
    private Instructor instructor;
    private ArrayList<Lesson> lessons;
    private ArrayList<Quiz> quizzes;

    public void setCourseId(int courseId) {this.courseId = courseId;}
    public void setDescription(String description) {this.description = description;}
    public void setInstructor(Instructor instructor) {this.instructor = instructor;}
    public void setLessons(ArrayList<Lesson> lessons) {this.lessons = lessons;}
    public void setQuizzes(ArrayList<Quiz> quizzes) {this.quizzes = quizzes;}
    public void setTitle(String title) {this.title = title;}
    public int getCourseId() {return courseId;}
    public Instructor getInstructor() {return instructor;}
    public String getTitle() {return title;}
    public ArrayList<Lesson> getLessons() {return lessons;}
    public String getDescription() {return description;}
    public ArrayList<Quiz> getQuizzes() { return quizzes; }


    public Course(String title, String description, Instructor instructor)
    {
        this.courseId = nextId++;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.lessons = new ArrayList<>();
        this.quizzes = new ArrayList<>();
    }


    public void addLesson(Lesson lesson)
    {
        if(!lessons.contains(lesson))
        {
            lessons.add(lesson);
            System.out.println("Lesson Added Successfully..");
        }
        else System.out.println("This Lesson Is Already Exists..");
    }
    public void addQuiz(Quiz quiz)
    {
        if(!quizzes.contains(quiz))
        {
            quizzes.add(quiz);
            System.out.println("Quiz Added Successfully..");
        }
        else System.out.println("This Quiz Is Already Exists..");
    }
  //  public boolean isCompletedBy(Student student) { return false; }
}
