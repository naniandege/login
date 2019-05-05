package com.example.day.day_01.bean;

public class Bean {
    private String name;
    private String date;
    private String show;

    public Bean() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public Bean(String name, String date, String show) {

        this.name = name;
        this.date = date;
        this.show = show;
    }
}
