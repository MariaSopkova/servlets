package ru.innopolis.stc.pojo;

public class HousePojo {
    private String name;
    private int headID;
    private int id;
    private int points;

    public HousePojo(String name, int headID, int id, int points) {
        this.name = name;
        this.headID = headID;
        this.id = id;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadID() {
        return headID;
    }

    public void setHeadID(int headID) {
        this.headID = headID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
