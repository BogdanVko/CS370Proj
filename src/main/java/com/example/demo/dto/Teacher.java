package com.example.demo.dto;

public class Teacher {


    private int id;
    private String link;
    private String name;
    private Boolean isFree;


    public Teacher() {

    }

    public Teacher(String link, String name, int id) {
        this.link = link;
        this.name = name;
        this.id = id;
        this.isFree = true;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Boolean isFree() {
        return isFree;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
