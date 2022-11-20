import org.example.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {

    @Test
    void enroll_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",2);
        School school1 = new School("Ironhack");
        Student student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");

        school1.addStudent(student1);
        school1.addCourse(course1);
        Commands.enroll(school1,student1.getStudentId(),course1.getCourseId());

        assertEquals(3500.50,school1.getCourseMap().get("FR20122").getMoney_earned());
    }
    @Test
    //Este test es redundante ya que hemos asignado el curso en el profesor desde el inicio.
    // Lo que voy a hacer es crear un TeacherCourseMap para asignar un COURSE a un ID de teacher.
    void assign_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",2);
        School school1 = new School("Ironhack");
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course1);

// VAMOS A INTRODUCIR UN NUEVO TEACHERCOURSEMAP CON EL METODO ASSIGN
        school1.addTeacher(teacher1);
        school1.addCourse(course1);
        Commands.assign(school1,teacher1.getTeacherId(),course1.getCourseId());

       assertEquals("FR20122",school1.getTeacherMap().get("TJAVAAP201220").getTeacherCourseMap().get("TJAVAAP201220").getCourseId());
    }

    @Test
    //Este test no esta validando nada.
    void show_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",1);
        Course course2 = new Course("BackEnd",3500.50,"mañana",2);
        Course course3 = new Course("DataScience",4500.50,"tarde",2);
        Course course4 = new Course("CyberSecurity",4500.50,"tarde",3);
        School school1 = new School("Ironhack");
        school1.addCourse(course1);
        school1.addCourse(course2);
        school1.addCourse(course3);
        school1.addCourse(course4);

        Commands.showCourses(school1);
    }

    @Test
        //Este test no esta validando nada.
    void lookup_course_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",1);
        Course course2 = new Course("BackEnd",3500.50,"mañana",2);
        Course course3 = new Course("DataScience",4500.50,"tarde",2);
        Course course4 = new Course("CyberSecurity",4500.50,"tarde",3);
        School school1 = new School("Ironhack");
        school1.addCourse(course1);
        school1.addCourse(course2);
        school1.addCourse(course3);
        school1.addCourse(course4);

        Commands.lookupCourses(school1,course1.getCourseId());
    }

    @Test
    void show_students_test(){
        Student student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");
        Student student2 = new Student("Omar Perez", "calle julia", "asdfasdf@blabla.com");
        Student student3 = new Student("Juan Perez", "calle san blas", "dddd@blabla.com");
        Student student4 = new Student("Pablo Almejo", "calle san pere", "aaaaa@blabla.com");
        School school1 = new School("Ironhack");
        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);
        school1.addStudent(student4);

        Commands.showStudents(school1);
    }

    @Test
    void lookup_students_test(){
        Student student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");
        Student student2 = new Student("Omar Perez", "calle julia", "asdfasdf@blabla.com");
        Student student3 = new Student("Juan Perez", "calle san blas", "dddd@blabla.com");
        Student student4 = new Student("Pablo Almejo", "calle san pere", "aaaaa@blabla.com");
        School school1 = new School("Ironhack");
        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);
        school1.addStudent(student4);

        Commands.lookupStudents(school1,student1.getStudentId());
    }

    @Test
    void show_teachers_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",1);
        Course course2 = new Course("BackEnd",3500.50,"mañana",2);
        Course course3 = new Course("DataScience",4500.50,"tarde",2);
        Course course4 = new Course("CyberSecurity",4500.50,"tarde",3);
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course1);
        Teacher teacher2 = new Teacher("Afas Pepe", 1250.50, course2);
        Teacher teacher3 = new Teacher("Alalala Pepe", 1250.50, course3);
        Teacher teacher4 = new Teacher("Aasdfasdlba Pepe", 1250.50, course4);
        School school1 = new School("Ironhack");
        school1.addCourse(course1);
        school1.addCourse(course2);
        school1.addCourse(course3);
        school1.addCourse(course4);
        school1.addTeacher(teacher1);
        school1.addTeacher(teacher2);
        school1.addTeacher(teacher3);
        school1.addTeacher(teacher4);


        Commands.showTeachers(school1);
    }

    @Test
    void lookup_teachers_test(){
        Course course1 = new Course("FrontEnd",3500.50,"mañana",1);
        Course course2 = new Course("BackEnd",3500.50,"mañana",2);
        Course course3 = new Course("DataScience",4500.50,"tarde",2);
        Course course4 = new Course("CyberSecurity",4500.50,"tarde",3);
        Teacher teacher1 = new Teacher("Alba Pepe", 1250.50, course1);
        Teacher teacher2 = new Teacher("Afas Pepe", 1250.50, course2);
        Teacher teacher3 = new Teacher("Alalala Pepe", 1250.50, course3);
        Teacher teacher4 = new Teacher("Aasdfasdlba Pepe", 1250.50, course4);
        School school1 = new School("Ironhack");
        school1.addCourse(course1);
        school1.addCourse(course2);
        school1.addCourse(course3);
        school1.addCourse(course4);
        school1.addTeacher(teacher1);
        school1.addTeacher(teacher2);
        school1.addTeacher(teacher3);
        school1.addTeacher(teacher4);
        Commands.assign(school1,teacher1.getTeacherId(),course2.getCourseId());


        Commands.lookupTeachers(school1,teacher1.getTeacherId());
    }

    @Test

    void show_profit(){


        Course course1 = new Course("FrontEnd",3500.50,"mañana",1);
        Course course2 = new Course("BackEnd",3500.50,"mañana",2);
        Student student1 = new Student("Alba Pepe", "calle rambla", "blabla@blabla.com");
        Student student2 = new Student("Omar Perez", "calle julia", "asdfasdf@blabla.com");
        Student student3 = new Student("Juan Perez", "calle san blas", "dddd@blabla.com");
        Student student4 = new Student("Pablo Almejo", "calle san pere", "aaaaa@blabla.com");
        School school1 = new School("Ironhack");
        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);
        school1.addStudent(student4);

        //ACA TENEMOS QUE SUMAR TODOS LOS PROFITS POR CURSO Y DE TODOS LOS CURSOS.
        // NO ESTOY SEGURO SI HAY QUE USAR EL HASMAP O DIRECTAMENTE CON EL GETEARNMONEY.

    }
}
