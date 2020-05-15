import model.Survey;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller controller = new Controller();

    @Test
    public void testCreateSurvey() {
        controller.createSurvey("Service Quality");
        assertEquals("Service Quality", controller.createSurvey("Service Quality"));
    }
}
