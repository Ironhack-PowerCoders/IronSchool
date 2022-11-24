package org.example;

public class Commands {


    public static void enroll(School school, String studentId, String courseId){

        // BUSCAMOS EL MAPCOURSE DENTRO DE LA ESCUELA SEGUN EL ID, DESPUES SACAMOS EL MAPA DE ESTUDIANTES DEL CURSO
//        Y AÑADIMOS EL ESTUDIANTE CON PUT(.....)
//        PARA LLAMAR UN OBJETO SE USA LA EQUIVALENCIA DEL KEY VALUE COMO SI FUERA UNA ITINERANCIA EN ARRAY.
        school.getCourseMap().get(courseId).getCourseStudentMap().put(studentId,school.getStudentMap().get(studentId));
        school.getStudentMap().get(studentId).getStudentCourseMap().put(courseId,school.getCourseMap().get(courseId));
        school.getCourseMap().get(courseId).setMoney_earned(school.getCourseMap().get(courseId).getPrice());
    }

    public static void assign(School school, String teacherId, String courseId){
        school.getTeacherMap().get(teacherId).getTeacherCourseMap().put(teacherId,school.getCourseMap().get(courseId));
    }

    public static void showCourses(School school){
        school.getCourseMap().forEach((key, value) -> {
            System.out.println(key + ": Name " + value.toString()+ ".");
        });
    }

    public static void lookupCourses(School school, String courseId) {
        System.out.println(school.getCourseMap().get(courseId).toString());
    }

    public static void showStudents(School school){
               school.getStudentMap().forEach((key, value) -> {
            System.out.println(key + ": " + value.toString()+ ".");
        });
    }

    public static void lookupStudents(School school, String studentId) {
        System.out.println(school.getStudentMap().get(studentId).toString());
    }

    public static void showTeachers(School school) {
        school.getTeacherMap().forEach((key, value) -> {
            System.out.println(key + ": " + value.toString()+ ".");
        });
    }

    public static void lookupTeachers(School school, String teacherId) {
        System.out.println(school.getTeacherMap().get(teacherId).toString());
    }

    public static void showProfit(School school) {
        double moneyEarned = school.getCourseMap().values().stream().map(course -> course.getMoney_earned()).reduce((aDouble, aDouble2) -> aDouble + aDouble2).orElse(0D);
        double teacherSalary = school.getTeacherMap().values().stream().map(teacher -> teacher.getSalary()).reduce((aDouble, aDouble2) -> aDouble + aDouble2).orElse(0D);
        System.out.println(moneyEarned - teacherSalary);
    }
}
