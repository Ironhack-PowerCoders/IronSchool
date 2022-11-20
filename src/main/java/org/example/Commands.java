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
}
