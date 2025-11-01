import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analytics {
    private Map<Course, Integer> quizScores;
    private List<Course> completedCourses;
    private Map<Course, Integer> lessonsCompleted;


    public Analytics()
    {
        quizScores = new HashMap<>();
        completedCourses = new ArrayList<>();
        lessonsCompleted = new HashMap<>();

    }

    public void updateQuizScore(Course course, int score)
    {
        quizScores.put(course, score);
    }

    public void recordLessonCompletion(Lesson lesson) {
        Course course = lesson.getCourse();
        lessonsCompleted.put(course, lessonsCompleted.getOrDefault(course, 0) + 1);
    }


    public void markCourseCompleted(Course course)
    {
        if (!completedCourses.contains(course)) {
            completedCourses.add(course);
        }
    }

    public Map<Course, Integer> getQuizScores() { return quizScores; }
    public List<Course> getCompletedCourses() { return completedCourses; }
}

