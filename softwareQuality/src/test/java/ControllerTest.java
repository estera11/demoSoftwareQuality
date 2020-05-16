
import model.Question;
import model.Survey;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller controller = new Controller();

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

        String expected = "There are 3 surveys";
        String actual = controller.displaySurveys(surveys);

        assertEquals(expected, actual);

    }


}
