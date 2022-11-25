import org.example.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    void student_id(){
        Student student = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");
        assertEquals("SAP0220", student.getStudentId());
    }

    @Test
    void student_setName_error(){
        Exception exception = assertThrows( IllegalArgumentException.class, ()-> new Student("Alba", "calle rambla", "blabla@blabla.com"));
        String actualMessage = exception.getMessage();
        String expectedMessage = "Please press the space bar after the name.";
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
