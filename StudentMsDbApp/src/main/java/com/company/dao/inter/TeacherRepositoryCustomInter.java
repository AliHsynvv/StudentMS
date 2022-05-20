package com.company.dao.inter;

import com.company.entity.Student;
import com.company.entity.Teacher;
import org.springframework.stereotype.Repository;

public interface TeacherRepositoryCustomInter {
    public boolean addTeacher(Teacher t);

    public boolean updateTeacher(Teacher t);


}
