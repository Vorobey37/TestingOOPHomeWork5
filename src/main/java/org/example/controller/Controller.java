package org.example.controller;

import org.example.model.*;
import org.example.service.DataService;
import org.example.service.StudyGroupService;
import org.example.view.StudentView;
import org.example.view.StudyGroupView;

import java.util.List;
import java.util.Objects;

public class Controller {

    private final DataService DATASERVICE = new DataService();
    private final StudentView STUDENTVIEW = new StudentView();
    private final StudyGroupService STUDYGROUPSERVICE = new StudyGroupService();
    private final StudyGroupView STUDYGROUPVIEW = new StudyGroupView();

    public void createStudent(String firstName, String lastName, String middleName){
        DATASERVICE.create(firstName, lastName, middleName, Type.STUDENT);

    }

    public void getAllStudents(){
        List<User> users = DATASERVICE.getAllStudents();

        for (User user : users) {
            Student student = (Student) user;
            STUDENTVIEW.printOnConsole(student);
        }
    }

    public void createStudyGroup(Teacher teacher, List<Student> students){
        STUDYGROUPSERVICE.createStudyGroup(teacher, students);
    }

    public void getTeacherAndStudentsByStudyGroupId(int studyGroupId){
        StudyGroup studyGroup = STUDYGROUPSERVICE.getStudentGroupById(studyGroupId);
        if (Objects.isNull(studyGroup)){
            System.out.println("Такой группы не существует");
        } else {
            STUDYGROUPVIEW.printOnConsole(studyGroup);
        }
    }
}
