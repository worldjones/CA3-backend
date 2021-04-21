package dtos;

public class JeopardyDTO {
    private String question;
    private String answer;
    private int value;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JeopardyDTO{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", value=" + value +
                '}';
    }
}
