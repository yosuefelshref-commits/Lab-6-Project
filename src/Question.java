import java.util.ArrayList;

public class Question {
    private String questionText;
    private int points;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(String questionText, int points, ArrayList<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.points = points;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() { return questionText; }
    public int getPoints() { return points; }
    public ArrayList<String> getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public void setPoints(int points) { this.points = points; }
    public void setOptions(ArrayList<String> options) { this.options = options; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public boolean checkAnswer(String answer)
    {
      return correctAnswer.equals(answer);
    }
}
