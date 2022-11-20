import org.example.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {

    @Test
    void enroll_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",2);
        School school1 = new School("Ironhack");
//        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course1);
        Student student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");

        school1.addStudent(student1);
        school1.addCourse(course1);
        Commands.enroll(school1,student1.getStudentId(),course1.getCourseId());

        assertEquals(3500.50,school1.getCourseMap().get("FR20122").getMoney_earned());
    }
}
