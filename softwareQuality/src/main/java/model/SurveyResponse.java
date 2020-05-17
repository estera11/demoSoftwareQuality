package model;

import model.Survey;

import java.util.Map;

public class SurveyResponse {

    //map object created with question id and response integer value between 1 and 5
    private Map<Integer, Integer> response;

    public SurveyResponse(){}

    public Map<Integer, Integer> getResponse() { return response; }

    public void setResponse(Map<Integer, Integer> responses) { this.response = responses; }
}
