import org.example.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {
    @Test
    void add_student_to_school(){
        Student student1 = new Student("Omar Perez","Carrer de Julia Portet","omarjesus@gmail.com");
        School school1 = new School("Ironhack");
        school1.addStudent(student1);
        assertEquals(school1.getStudentMap().get("SOP0220"),student1);
    }

    @Test
    void add_course_to_school(){
        Course course1 = new Course("FrontEnd",3500.50,"morning",2);
        School school1 = new School("Ironhack");
        school1.addCourse(course1);
        //PRIMERO VA DOS PRIMERAS LETRAS DEL CURSO, EL GRADO, UN SEPARADOR 0, EL HORARIO (1,2,3) Y EL AÑO
        assertEquals(school1.getCourseMap().get("FR20122"),course1);
    }

    @Test
    void add_teacher_to_school(){
        Course course1 = new Course("FrontEnd",3500.50,"morning",2);
        School school1 = new School("Ironhack");
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course1);
        school1.addTeacher(teacher1);
        assertEquals(school1.getTeacherMap().get("TAP201220"),teacher1);
    }
}
