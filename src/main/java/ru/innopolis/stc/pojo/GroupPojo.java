package ru.innopolis.stc.pojo;

public class GroupPojo {
    private int id;
    private int course;
    private int houseID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public GroupPojo(int id, int course, int houseID) {
        this.id = id;
        this.course = course;
        this.houseID = houseID;
    }
}
