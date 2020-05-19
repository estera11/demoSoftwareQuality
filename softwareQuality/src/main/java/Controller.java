import model.Question;
import model.Survey;
import model.SurveyResponse;

import java.util.*;

public class Controller {
    private static Survey survey;
    private static Survey survey2;
    private static List<Survey> surveys = new ArrayList<>();
    private static List<SurveyResponse> surveyResponses = new ArrayList<>();
    private  static SurveyResponse response;



    Controller(){}

    //method to create survey
    public Survey createSurvey(String title){
       Survey survey = new Survey(title);
       surveys.add(survey);
       return survey;
    }

    //method to add question to survey
    public void addQuestionToSurvey(Question question, Survey s){
        if(s.getQuestionList().size()<10) {
            s.addQuestion(question);
        }
        else{
            throw new RuntimeException("Questions number limit reached.");
        }

    }

    //method to display all surveys
    public String displaySurveys(List<Survey> surveys){
        String response = "";
        if(surveys.size()==0){
            response = "No surveys";
            throw new NoSuchElementException("There are no surveys");
        }else{
            response = "Surveys displayed";
            for(Survey s : surveys){
                System.out.println("Survey Title: "+s.getTitle());
                for (Question q: s.getQuestionList()) {
                    System.out.println("Question: "+q.getQuestion());
                }
                System.out.println("");
            }
        }
       return response;
    }

    //method to get survey by name
    public Survey getSurveyByName(String surveyName){
        boolean found = false;
        Survey survey = null;
        int index =0;
        for (int i=0;i<surveys.size();i++){
            if(surveys.get(i).getTitle().equals(surveyName)){
                found = true;
                index = i;
            }
        }
        if(found){
            survey = surveys.get(index);
        } else{
            throw new NoSuchElementException();
        }
        return survey;
    }

    private void displaySurvey(Survey survey){
        System.out.println("Survey Title: "+survey.getTitle());
        for (Question q: survey.getQuestionList()) {
                System.out.println("Question "+q.getId()+ ": "+q.getQuestion());
            }
    }

    //method to create surveyResponse
    public SurveyResponse createSurveyResponse(int questionId,  ArrayList<Integer> answers, Survey survey){
        SurveyResponse response = new SurveyResponse();
        Map<Integer, ArrayList<Integer>> responses = new HashMap<>();
        responses.put(questionId,answers);
        response.setResponses(responses);
        surveyResponses.add(response);
        survey.setSurveyResponses(surveyResponses);
        return response;
    }

    //display all responses for a survey

    public void displaysResponsesForSurvey(Survey survey){
        List<SurveyResponse> responseList = survey.getSurveyResponses();
        System.out.println(survey.getTitle());
        for (SurveyResponse sr : responseList) {
           // System.out.println("Question: "+sr.getResponse().);
            sr.getResponses().forEach((k,v)->{
                System.out.println("Question: "+k);
                for (Integer answer:v) {
                    int index = v.indexOf(answer)+1;
                    System.out.println("Answer "+index+": "+ answer);
                }
                System.out.println("");

            });
        }
    }




    public static void main(String[] args) {
        Controller c = new Controller();

        //create surveys and display their titles
        survey = c.createSurvey("First Survey");
        System.out.println("Survey created with title: "+survey.getTitle());
        System.out.println("");

        survey2 = c.createSurvey("Second Survey");
        System.out.println("Survey created with title: "+survey2.getTitle());
        System.out.println("");


        //creating the questions and adding them to the survey
        Question q1 = new Question(1,"Service Quality");
        Question q2 = new Question(2, "Cleanliness");
        Question q3 = new Question(3, "Comfort");

        Question q4 = new Question(4, "Facilities");
        Question q5 = new Question(5, "Service Diversification");

        c.addQuestionToSurvey(q1, survey);
        c.addQuestionToSurvey(q2, survey);
        c.addQuestionToSurvey(q3, survey);


        c.addQuestionToSurvey(q4, survey2);
        c.addQuestionToSurvey(q5, survey2);

        //display the surveys
        c.displaySurveys(surveys);


        //get survey by name and display it
         Survey s = c.getSurveyByName("First Survey");
         c.displaySurvey(s);


         //create survey response and add it to specific survey
        ArrayList<Integer> answersToFirstQ = new ArrayList<>();
        answersToFirstQ.add(3);
        answersToFirstQ.add(5);
        answersToFirstQ.add(2);
        c.createSurveyResponse(1,answersToFirstQ, survey);

        ArrayList<Integer> answersToSecondQ = new ArrayList<>();
        answersToSecondQ.add(4);
        answersToSecondQ.add(2);
        answersToSecondQ.add(3);

        c.createSurveyResponse(2,answersToSecondQ, survey);

        System.out.println("");
        c. displaysResponsesForSurvey(survey);

    }

}
