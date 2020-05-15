package model;

import model.Survey;

import java.util.Map;

public class SurveyResponse {

    private Survey survey;
    private Map<Integer, Integer> responses;

    public SurveyResponse(){}

    public Survey getSurvey() { return survey; }

    public void setSurvey(Survey survey) { this.survey = survey; }

    public Map<Integer, Integer> getResponses() { return responses; }

    public void setResponses(Map<Integer, Integer> responses) { this.responses = responses; }
}
