import org.example.*;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {
    @Test
    void student_id(){
        Course course = new Course("lala", 2000.00, "Mañana", 2);
        Student student = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com", course);

        assertEquals("SJAVAAP201220", student.getStudentId());
    }

    @Test
    void student_setName_error(){
        Course course2 = new Course("lala", 2000.00, "Mañana", 2);

        assertThrows( IllegalArgumentException.class, ()-> new Student("Alba", "calle rambla", "blabla@blabla.com", course2));
    }
}
