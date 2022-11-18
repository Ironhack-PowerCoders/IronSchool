import org.example.*;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeacherTest {
    @Test
    void teacher_id(){
        Course course = new Course("lala", 2000.00, "Mañana", 2);
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course);

        assertEquals("TJAVAAP201220", teacher1.getTeacherId());
    }

    @Test
    void teacher_setName_error(){
        Course course = new Course("lala", 2000.00, "Mañana", 2);
        assertThrows( IllegalArgumentException.class, ()-> new Teacher("Alba", 1250.50, course));
    }
}
