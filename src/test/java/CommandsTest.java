import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    Course course1; Course course2; Course course3; Course course4;
    Student student1; Student student2; Student student3; Student student4;
    Teacher teacher1; Teacher teacher2; Teacher teacher3; Teacher teacher4;
    School school1;
    @BeforeEach
    void setUp(){
        course1 = new Course("FrontEnd",3500.50,"morning",2);
        student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");
        teacher1 = new Teacher("Alba Pepe", 1250.50, course1);
        school1 = new School("Ironhack");
        school1.addStudent(student1);
        school1.addCourse(course1);
        school1.addTeacher(teacher1);
        course2 = new Course("BackEnd",3500.50,"morning",2);
        course3 = new Course("DataScience",4500.50,"afternoon",2);
        course4 = new Course("CyberSecurity",4500.50,"afternoon",3);
        school1.addCourse(course2); school1.addCourse(course3); school1.addCourse(course4);
        student2 = new Student("Omar Perez", "calle julia", "asdfasdf@blabla.com");
        student3 = new Student("Juan Perez", "calle san blas", "dddd@blabla.com");
        student4 = new Student("Pablo Almejo", "calle san pere", "aaaaa@blabla.com");
        school1.addStudent(student2); school1.addStudent(student3); school1.addStudent(student4);
        teacher2 = new Teacher("Afas Pepe", 1250.50, course2);
        teacher3 = new Teacher("Alalala Pepe", 1250.50, course3);
        teacher4 = new Teacher("Aasdfasdlba Pepe", 1250.50, course4);
        school1.addTeacher(teacher2); school1.addTeacher(teacher3); school1.addTeacher(teacher4);
    }
    @Test
    void enroll_test(){
        setUp();
        Commands.enroll(school1, student1.getStudentId(), course1.getCourseId());
        assertEquals(3500.50,school1.getCourseMap().get("FR20122").getMoney_earned());
    }
    @Test
    //Este test es redundante ya que hemos asignado el curso en el profesor desde el inicio.
    // Lo que voy a hacer es crear un TeacherCourseMap para asignar un COURSE a un ID de teacher.
    void assign_test(){
        setUp();
        // VAMOS A INTRODUCIR UN NUEVO TEACHERCOURSEMAP CON EL METODO ASSIGN
        Commands.assign(school1,teacher1.getTeacherId(),course1.getCourseId());
        System.out.println(school1.getTeacherMap());
        assertEquals("FR20122",school1.getTeacherMap().get("TAP201220").getTeacherCourseMap().get("TAP201220").getCourseId());
    }

    @Test
    //Este test no esta validando nada.
    void show_test(){
        Commands.showCourses(school1);
    }

    @Test
        //Este test no esta validando nada.
    void lookup_course_test(){
        Commands.lookupCourses(school1,course1.getCourseId());
    }

    @Test
    void lookup_students_test(){
        Commands.lookupStudents(school1,student1.getStudentId());
    }

    @Test
    void show_teachers_test(){
        Commands.showTeachers(school1);
    }

    @Test
    void lookup_teachers_test(){
        Commands.assign(school1,teacher1.getTeacherId(),course2.getCourseId());
        Commands.lookupTeachers(school1,teacher1.getTeacherId());
    }

}
