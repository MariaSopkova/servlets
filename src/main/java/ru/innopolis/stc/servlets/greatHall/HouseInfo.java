package ru.innopolis.stc.servlets.greatHall;

import ru.innopolis.stc.pojo.HousePojo;
import ru.innopolis.stc.pojo.StudentPojo;

import java.util.List;

public class HouseInfo {
    private HousePojo house;
    protected List<StudentPojo> students;

    public HouseInfo(HousePojo house){
        this.house = house;

    }
}
