package model;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    private List<Question> questionList = new ArrayList<>();
    private String title;
    private List<SurveyResponse> surveyResponses;

    public Survey(String title) { this.title = title; }

    public Survey(){}

    public void addQuestion(Question question){ this.questionList.add(question); }

    public List<Question> getQuestionList() { return questionList; }


    public void setQuestionList(List<Question> questionList) { this.questionList = questionList; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public List<SurveyResponse> getSurveyResponses() {
        return surveyResponses;
    }

    public void setSurveyResponses(List<SurveyResponse> surveyResponses) {
        this.surveyResponses = surveyResponses;
    }

    public void addSurveyResponses(SurveyResponse surveyResponse){
        this.surveyResponses.add(surveyResponse);
    }
}

