package ru.innopolis.stc.servlets.greatHall;

import ru.innopolis.stc.dao.house.HouseDao;
import ru.innopolis.stc.dao.house.HouseDaoImpl;
import ru.innopolis.stc.pojo.HousePojo;

import java.util.ArrayList;
import java.util.List;

public class HogwartsInfo {
    private List<HouseInfo> houses;
    private HouseDao houseDao = new HouseDaoImpl();

    public HogwartsInfo(){
        fillHouseInfo();
    }

    private void fillHouseInfo(){
        houses = new ArrayList<>();
        List<HousePojo> housesPojo = houseDao.getHouses();
        if(housesPojo != null){
            for(HousePojo house : housesPojo) {
                houses.add(new HouseInfo(house));
            }
        }
    }

    public List<HouseInfo> getHouses() {
        return houses;
    }
}
