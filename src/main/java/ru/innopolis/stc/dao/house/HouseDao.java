package ru.innopolis.stc.dao.house;

import ru.innopolis.stc.pojo.HousePojo;
import ru.innopolis.stc.pojo.StudentPojo;

import java.util.List;

public interface HouseDao {
    public HousePojo getHouseById(int id);
    public List<StudentPojo> getStudentsByHouse(int id);
}
