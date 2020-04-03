package com.example.flashcardapp.ui;




public class Tip {
    private Integer id;
    private String name;
    private String link;
    private String description;
    private Integer picture;


    public Tip( String name, String link, String description, Integer picture) {
        this.picture = picture;
        this.name = name;
        this.link = link;
        this.description = description;
    }
    public Tip(Integer id, String name, String link, String description, Integer picture) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPicture() {
        return picture;
    }
    public void setPicture(Integer pic) {
        this.picture = pic;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getlink() {
        return link;
    }
    public String getDescription() {
        return description;
    }
    public void setlink(String link) {
        this.link = link;
    }
    public void setDescription(String definition) {
        this.description = description;
    }
}
