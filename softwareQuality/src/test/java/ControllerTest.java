
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller controller = new Controller();

    @Test
    public void testCreateSurvey() {
        controller.createSurvey("First Survey");
        assertEquals("First Survey", controller.createSurvey("First Survey"));
    }

    @Test
    public void testAddQuestion(){
        int expected = 3;
        int actual = controller.addQuestion("First Survey");
        assertEquals(expected, actual);
    }

    
}
