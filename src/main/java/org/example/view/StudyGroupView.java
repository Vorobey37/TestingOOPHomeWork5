package org.example.view;

import org.example.model.Student;
import org.example.model.StudyGroup;

public class StudyGroupView {

    public void printOnConsole(StudyGroup studyGroup){
        System.out.println("Группа №" + studyGroup.getGroupID() + ":");
        System.out.println("Преподаватель: " + studyGroup.getTeacher().getTeacherId());
        System.out.println("Список студентов: ");
        for (Student student : studyGroup.getStudents()) {
            System.out.println("  " + student.getStudentId());
        }
    }
}
