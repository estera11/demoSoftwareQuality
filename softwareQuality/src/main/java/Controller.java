import model.Question;
import model.Survey;

public class Controller {
    Controller(){}

    public String createSurvey(String title){
        Survey survey = new Survey(title);
        System.out.println(survey.getTitle());
        return survey.getTitle();
    }

    public int addQuestion(String surveyTitle){
        Question question1 = new Question(1,"Service Quality");
        Question question2 = new Question(2,"Cleanliness");
        Question question3 = new Question(3,"Comfort");

        Survey survey = new Survey(surveyTitle);
        survey.addQuestion(question1);
        survey.addQuestion(question2);
        survey.addQuestion(question3);

        return survey.getQuestionList().size();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.createSurvey("Service Quality");
    }

}
