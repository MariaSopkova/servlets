package ru.innopolis.stc.servlets.student;

import ru.innopolis.stc.dao.group.GroupDao;
import ru.innopolis.stc.dao.group.GroupDaoImpl;
import ru.innopolis.stc.dao.house.HouseDao;
import ru.innopolis.stc.dao.house.HouseDaoImpl;
import ru.innopolis.stc.dao.student.StudentDao;
import ru.innopolis.stc.dao.student.StudentDaoImpl;
import ru.innopolis.stc.pojo.GroupPojo;
import ru.innopolis.stc.pojo.HousePojo;
import ru.innopolis.stc.pojo.StudentPojo;

public class StudentInformation {
    private StudentDao studentDao = new StudentDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();
    private HouseDao houseDao = new HouseDaoImpl();
    private StudentPojo student;
    private GroupPojo group;
    private HousePojo house;

    public StudentInformation(String login) {
        student = studentDao.getStudentByLogin(login);
        if(student != null){
            group = groupDao.getGroupByID(student.getGroupID());
        }
        if(group != null){
            house = houseDao.getHouseById(group.getHouseID());
        }
    }

    public StudentPojo getStudent() {
        return student;
    }

    public GroupPojo getGroup() {
        return group;
    }

    public HousePojo getHouse() {
        return house;
    }

    public boolean isFullObject(){
        return student != null && group != null && house != null;
    }
}
