package model;

import model.Survey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SurveyResponse {

    //map object created to hold the question id and the answers to the question as integers with values from 1-5
   private Map<Integer, ArrayList<Integer>> responses = new HashMap<>();
   public SurveyResponse(){}

    public Map<Integer, ArrayList<Integer>> getResponses() {
        return responses;
    }

    public void setResponses(Map<Integer, ArrayList<Integer>> responses) {
        this.responses = responses;
    }
}
