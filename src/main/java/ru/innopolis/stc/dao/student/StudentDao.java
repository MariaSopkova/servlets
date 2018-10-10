package ru.innopolis.stc.dao.student;

import ru.innopolis.stc.pojo.StudentPojo;

public interface StudentDao {
    public StudentPojo getStudentByLogin(String login);
}
