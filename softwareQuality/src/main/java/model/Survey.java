package model;

import model.Question;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    private List<Question> questionList = new ArrayList<>();
    private String title;

    public Survey(String title) {
        this.title = title;
    }

    public Survey(){}

    public void addQuestion(Question question){
        this.questionList.add(question);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

