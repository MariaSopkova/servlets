package ru.innopolis.stc.servlets.greatHall;

import ru.innopolis.stc.dao.house.HouseDao;
import ru.innopolis.stc.dao.house.HouseDaoImpl;
import ru.innopolis.stc.pojo.HousePojo;
import ru.innopolis.stc.pojo.StudentPojo;

import java.util.List;

public class HouseInfo {
    private HouseDao houseDao = new HouseDaoImpl();
    private HousePojo house;
    protected List<StudentPojo> students;

    public HouseInfo(HousePojo house){
        this.house = house;
        students = houseDao.getStudentsByHouse(house.getId());
    }

    public HousePojo getHouse() {
        return house;
    }

    public List<StudentPojo> getStudents() {
        return students;
    }
}
