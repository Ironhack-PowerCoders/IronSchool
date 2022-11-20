import org.example.*;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {
    @Test
    void student_id(){
        Student student = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");

        assertEquals("SJAVAAP0220", student.getStudentId());
    }

    @Test
    void student_setName_error(){
        assertThrows( IllegalArgumentException.class, ()-> new Student("Alba", "calle rambla", "blabla@blabla.com"));
    }
}
