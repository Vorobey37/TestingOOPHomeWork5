package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.model.Type;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<User> users;

    public void create(String firstName, String lastName, String middleName, Type type){
        int id = getFreeId(type);
        if (Type.STUDENT == type){
            Student student = new Student(firstName, lastName, middleName, id);
            users.add(student);
        }
        if (Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            users.add(teacher);
        }
    }

    public User getUserById(Type type, int id){
        boolean isStudent = Type.STUDENT == type;
        User curentUser = null;

        for (User user : users) {
            if (user instanceof Teacher && !isStudent && ((Teacher) user).getTeacherId() == id){
                curentUser = user;
            }
            if (user instanceof Student && isStudent && ((Student) user).getStudentId() == id){
                curentUser = user;
            }
        }
        return curentUser;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public List<User> getAllStudents(){
        List<User> students = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Student){
                students.add(user);
            }
        }
        return students;
    }

    private int getFreeId(Type type){
        boolean isStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user : users) {
            if (user instanceof Teacher && !isStudent){
                lastId = ((Teacher)user).getTeacherId() + 1;
            }
            if (user instanceof Student && isStudent){
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }

}
