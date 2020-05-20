
import model.Question;
import model.Survey;
import model.SurveyResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller controller = new Controller();
    private static final double DELTA = 1e-15;

    @Test
    public void testCreateSurvey() {
        controller.createSurvey("First Survey");
        assertEquals("First Survey", controller.createSurvey("First Survey").getTitle());
    }

    @Test
    public void testAddQuestion(){
        Question q1 = new Question(1,"Service Quality");
        Question q2 = new Question(2,"Comfort");

        Survey survey = new Survey("First Survey");
        controller.addQuestionToSurvey(q1, survey);
        controller.addQuestionToSurvey(q2, survey);
        int expected = 2;
        int actual = survey.getQuestionList().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testDisplaySurveys(){
        Survey survey = new Survey("First Survey");
        Question q = new Question(1,"Service Quality");
        survey.addQuestion(q);

        Survey survey2 = new Survey("Second Survey");
        Question question = new Question(1, "Cleanliness");
        survey2.addQuestion(question);

        Survey survey3= new Survey("Third Survey");
        Question q2 = new Question(1, "Comfort");
        survey3.addQuestion(q2);


        List<Survey> surveys = new ArrayList<>();
        surveys.add(survey);
        surveys.add(survey2);
        surveys.add(survey3);

        String expected = "Surveys displayed";
        String actual = controller.displaySurveys(surveys);

        assertEquals(expected, actual);

    }

    @Test
    public void testGetSurveyByName(){
        controller.createSurvey("First Survey");
        Survey survey = controller.getSurveyByName("First Survey");
        String expected = "First Survey";
        String actual = survey.getTitle();

        assertEquals(expected, actual);

    }

    @Test
    public void testCreateSurveyResponse(){
        Survey survey =  controller.createSurvey("Test Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        controller.createSurveyResponse(1,answers, survey,surveyResponses);
        ArrayList<Integer> answers2 = new ArrayList<>();
        answers2.add(2);
        controller.createSurveyResponse(2,answers2, survey, surveyResponses);

        int expected = 2;
        int actual =  survey.getSurveyResponses().size();

        assertEquals(expected, actual);

    }

    @Test
    public void testCalculateSurveyAverage(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);
        ArrayList<Integer> answers2 = new ArrayList<>();
        answers2.add(2);
        answers2.add(3);
        controller.createSurveyResponse(2,answers2, survey, surveyResponses);

        double expected = 3;
        double actual = controller.calcultateSurveyAverage("Survey");

       assertEquals(expected, actual, DELTA);

    }


    @Test
    public void testCalculateMaxForSurvey(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);
        ArrayList<Integer> answers2 = new ArrayList<>();
        answers2.add(2);
        answers2.add(3);
        controller.createSurveyResponse(2,answers2, survey, surveyResponses);

        int expected = 4;
        int actual = controller.getMaxForSurvey(survey.getTitle());

        assertEquals(expected, actual);

    }

    @Test
    public void testCalculateMinForSurvey(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);
        ArrayList<Integer> answers2 = new ArrayList<>();
        answers2.add(1);
        answers2.add(3);
        controller.createSurveyResponse(2,answers2, survey, surveyResponses);

        int expected = 1;
        int actual = controller.getMinForSurvey(survey.getTitle());

        assertEquals(expected, actual);

    }

    @Test
    public void calculateStandardDevForSurvey(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);
        ArrayList<Integer> answers2 = new ArrayList<>();
        answers2.add(1);
        answers2.add(3);
        controller.createSurveyResponse(2,answers2, survey, surveyResponses);

        double expected = 1.015504800579495;
        double actual = controller.getStandardDev(survey.getTitle());

        assertEquals(expected, actual, DELTA);

    }


    @Test
    public void testCalculateQuestionAverage(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        answers.add(5);
        answers.add(5);
        answers.add(1);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);

        double expected = 3.6;
        double actual = controller.getAverageForQuestion("Survey", 1);

        assertEquals(expected, actual, DELTA);

    }


    @Test
    public void testGetMaxForQuestion(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        answers.add(5);
        answers.add(5);
        answers.add(1);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);

        int expected = 5;
        int actual = controller.getMaxForQuestion("Survey", 1);

        assertEquals(expected, actual);

    }

    @Test
    public void testGetMinForQuestion(){
        Survey survey = controller.createSurvey("Survey");
        List<SurveyResponse> surveyResponses = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(3);
        answers.add(4);
        answers.add(5);
        answers.add(5);
        answers.add(1);
        controller.createSurveyResponse(1,answers, survey, surveyResponses);

        int expected = 1;
        int actual = controller.getMinForQuestion("Survey", 1);

        assertEquals(expected, actual);

    }



}
