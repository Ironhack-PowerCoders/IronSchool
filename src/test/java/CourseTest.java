import org.example.Course;
import org.example.Teacher;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    @Test
    void course_id(){
        Course course = new Course("lala", 2000.00, "morning", 2);
        assertEquals("LA20122", course.getCourseId());
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
