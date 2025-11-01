import java.util.ArrayList;

public class Quiz {
    private int nextId = 1;
    private int quizId;
    private ArrayList<Question> questions;
    private int passingScore;


    public Quiz(int passingScore)
    {
        this.quizId = nextId++;
        this.questions = new ArrayList<>();
        this.passingScore = passingScore;
    }

    public void setQuizId(int quizId) {this.quizId = quizId;}
    public void setQuestions(ArrayList<Question> questions) {this.questions = questions;}
    public void setPassingScore(int passingScore) {this.passingScore = passingScore;}
    public int getQuizId() {return quizId;}
    public ArrayList<Question> getQuestions() {return questions;}
    public int getPassingScore() {return passingScore;}

    public int evaluateAnswers(ArrayList<String> studentAnswers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer().equals(studentAnswers.get(i))) {
                score += questions.get(i).getPoints();
            }
        }
        return score;
    }


    public boolean isPassed(int score) {
        return score >= passingScore;
    }
}
