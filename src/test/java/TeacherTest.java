import org.example.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    @Test
    void teacher_id(){
        Course course = new Course("lala", 2000.00, "morning", 2);
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course);
        assertEquals("TAP201220", teacher1.getTeacherId());
    }

    @Test
    void teacher_setName_error(){
        Course course = new Course("lala", 2000.00, "morning", 2);
        Exception exception = assertThrows( IllegalArgumentException.class, ()-> new Teacher("Alba", 1250.50, course));
        String actualMessage = exception.getMessage();
        String expectedMessage = "Please press the space bar after the name.";
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
