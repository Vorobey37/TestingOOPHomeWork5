package org.example.service;

import org.example.model.Student;
import org.example.model.StudyGroup;
import org.example.model.Teacher;

import java.util.List;

public class StudyGroupService {

    private List<StudyGroup> stream;

    public void createStudyGroup(Teacher teacher, List<Student> students){
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setTeacher(teacher);
        studyGroup.setStudents(students);
        studyGroup.setGroupID(getFreeGroupId());
        stream.add(studyGroup);
    }

    private int getFreeGroupId(){
        int groupId = 2;
        boolean flag = true;
        if (stream.isEmpty()){
            return 1;
        } else {
            while (flag){
                int temp = groupId;
                for (StudyGroup studyGroup : stream) {
                    if (studyGroup.getGroupID() == groupId){
                        groupId++;
                    }
                }
                if (temp == groupId) flag = false;
            }
            return groupId;
        }
    }

    public StudyGroup getStudentGroupById(int studyGroupId){
        for (StudyGroup studyGroup : stream) {
            if (studyGroup.getGroupID() == studyGroupId) return studyGroup;
        }
        return null;
    }


}
