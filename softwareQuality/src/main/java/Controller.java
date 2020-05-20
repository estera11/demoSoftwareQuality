import model.Question;
import model.Survey;
import model.SurveyResponse;

import java.lang.reflect.Array;
import java.util.*;

public class Controller {
    private static Survey survey;
    private static Survey survey2;
    private static List<Survey> surveys = new ArrayList<>();
    private static List<SurveyResponse> surveyResponses = new ArrayList<>();



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
    public SurveyResponse createSurveyResponse(int questionId,  ArrayList<Integer> answers, Survey survey, List<SurveyResponse> resp){
        SurveyResponse response = new SurveyResponse();
        Map<Integer, ArrayList<Integer>> responses = new HashMap<>();
        responses.put(questionId,answers);
        response.setResponses(responses);
        resp.add(response);
        survey.setSurveyResponses(resp);
        return response;
    }

    //display all responses for a survey

    public void displaysResponsesForSurvey(Survey survey){
        List<SurveyResponse> responseList = survey.getSurveyResponses();
        System.out.println(survey.getTitle());
        for (SurveyResponse sr : responseList) {
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

    public double calcultateSurveyAverage(String surveyTitle){
       Survey survey = getSurveyByName(surveyTitle);
        double average = 0;
        double sum = 0;
        int count = 0;
        List<SurveyResponse> responseList = survey.getSurveyResponses();
        for (SurveyResponse sr : responseList) {
            Map<Integer, ArrayList<Integer>> responses = sr.getResponses();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : responses.entrySet()) {
                count =count + entry.getValue().size();
               for(Integer value :entry.getValue()){
                   sum = sum + value;
               }
            }
        }
//        System.out.println("Sum "+ sum);
//        System.out.println("Count "+ count);
        average = sum/count;
        return average;
    }

    public int getMaxForSurvey(String surveyTitle){
        Survey s = getSurveyByName(surveyTitle);
        int max =0;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        for (SurveyResponse sr : responseList) {
            Map<Integer, ArrayList<Integer>> responses = sr.getResponses();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : responses.entrySet()) {
                for(Integer value :entry.getValue()){
                    if(value>max)
                        max = value;
                }
            }
        }
        return max;
    }


    public int getMinForSurvey(String surveyTitle){
        Survey s = getSurveyByName(surveyTitle);
        int min = Integer.MAX_VALUE;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        for (SurveyResponse sr : responseList) {
            Map<Integer, ArrayList<Integer>> responses = sr.getResponses();

            for (Map.Entry<Integer, ArrayList<Integer>> entry : responses.entrySet()) {
                for(Integer value :entry.getValue()){
                    if (value<min)
                        min = value;
                }
            }
        }
        return min;
    }

    public double getStandardDev(String surveyTitle) {
        Survey s = getSurveyByName(surveyTitle);
        double sum  = 0.0, standardDeviation = 0.0, mean = 0.0;
        double variance = 0;
        int count = 0;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        for (SurveyResponse sr : responseList) {
            Map<Integer, ArrayList<Integer>> responses = sr.getResponses();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : responses.entrySet()) {
                count = count + entry.getValue().size();
                for(Integer value :entry.getValue()){
                    sum = sum + value;
                }
                mean = (double)sum/ (double) count;
                for(Integer value :entry.getValue()){
                   variance = variance + Math.pow(value - mean, 2);
                }
            }

        }
        standardDeviation = variance/count;

//        System.out.println("Mean"+mean);
//        System.out.println("Sum "+sum);
//        System.out.println(variance/count);
//        System.out.println(Math.sqrt(standardDeviation));

        return Math.sqrt(standardDeviation);
    }

    public double getAverageForQuestion(String surveyTitle, Integer id){
        Survey s = getSurveyByName(surveyTitle);
        double sum = 0;
        int count = 0;
        double average = 0.0;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        List<Integer> answers;
        for (SurveyResponse sr : responseList) {
            //answers for the question got by question id
            if(sr.getResponses().containsKey(id)){
                answers =  sr.getResponses().get(id);
                for (Integer a: answers) {
                    sum = sum + a;
                    count = count +1;
                }
            }
            else{
                average = 0;
            }
        }
        average = sum/count;
        return average;
    }

    public int getMaxForQuestion(String surveyTitle, Integer id){
        Survey s = getSurveyByName(surveyTitle);
        int max = 0;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        List<Integer> answers;
        for (SurveyResponse sr : responseList) {
            //answers for the question got by question id
            if(sr.getResponses().containsKey(id)){
                answers =  sr.getResponses().get(id);

                for (Integer a: answers) {
                    if(a > max){
                        max = a;
                    }

                }
            }
        }

        return max;
    }

    public int getMinForQuestion(String surveyTitle, Integer id){
        Survey s = getSurveyByName(surveyTitle);
        int min = Integer.MAX_VALUE;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        List<Integer> answers;
        for (SurveyResponse sr : responseList) {
            //answers for the question got by question id
            if(sr.getResponses().containsKey(id)){
                answers =  sr.getResponses().get(id);
                for (Integer a: answers) {
                    if(a<min)
                        min = a;
                }
            }
        }

        return min;
    }

    public double calculateStdDevForQuestion(String surveyTitle, Integer id){
        Survey s = getSurveyByName(surveyTitle);
        double sum = 0.0;
        double mean = 0;
        double v = 0.0;
        double stdDev = 0.0;
        int count = 0;
        List<SurveyResponse> responseList = s.getSurveyResponses();
        List<Integer> answers;
        for (SurveyResponse sr : responseList) {
            //answers for the question got by question id
            if(sr.getResponses().containsKey(id)){
                answers =  sr.getResponses().get(id);
                count = answers.size();
                for (Integer a: answers) {
                    sum = sum+a;
                }
                mean = (double) sum/count;
                for (Integer a: answers) {
                    v = v + Math.pow(a - mean, 2);
                }
            }
        }

        stdDev = v/count;

        return Math.sqrt(stdDev);
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
        c.createSurveyResponse(1,answersToFirstQ, survey, surveyResponses);

        ArrayList<Integer> answersToSecondQ = new ArrayList<>();
        answersToSecondQ.add(4);
        answersToSecondQ.add(2);
        answersToSecondQ.add(3);

        c.createSurveyResponse(2,answersToSecondQ, survey, surveyResponses);

        ArrayList<Integer> answersToThirdQ = new ArrayList<>();
        answersToThirdQ.add(5);
        answersToThirdQ.add(3);
        answersToThirdQ.add(4);

        c.createSurveyResponse(3,answersToThirdQ, survey, surveyResponses);

        System.out.println("");
        c. displaysResponsesForSurvey(survey);

        System.out.println("");
        double averageFirstSurvey = c.calcultateSurveyAverage("First Survey");
        System.out.println("Average First Survey = "+ averageFirstSurvey);


        System.out.println("");

        //max value for survey
        System.out.println("Maximum score in the First Survey is: "+c.getMaxForSurvey("First Survey"));

        //min value for survey
        System.out.println("Minimum score in the First Survey is: "+c.getMinForSurvey("First Survey"));

        //standard deviation for survey
        System.out.println("");
        double std = c.getStandardDev("First Survey");
        System.out.println("Standard deviation for First Survey: "+std);

        //average score for a question
        System.out.println("");
        double average = c.getAverageForQuestion("First Survey", 1);
        System.out.println("Average for the Question 1 in the First Survey: "+average);

        //max score for a question
        System.out.println("");
        int max  = c.getMaxForQuestion("First Survey", 1);
        System.out.println("Maximum score for the Question 1 in the First Survey: "+max);

        //min score for a question
        int min  = c.getMinForQuestion("First Survey", 1);
        System.out.println("Minimum score for the Question 1 in the First Survey: "+min);

        //standard deviation for survey
        System.out.println("");
        double standardDev = c.calculateStdDevForQuestion("First Survey", 1);
        System.out.println("Standard deviation for Question 1 in First Survey: "+standardDev);

    }


}
