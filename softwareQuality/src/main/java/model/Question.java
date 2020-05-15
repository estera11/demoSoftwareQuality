
package model;

public class Question {

    private int id;
    private String question;

    public Question(int id, String question) {
        this.question = question;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
