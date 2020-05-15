import model.Survey;

public class Controller {
    Controller(){}

    public String createSurvey(String title){
        Survey survey = new Survey(title);
        return survey.getTitle();
    }

}
