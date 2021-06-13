package com.project.interview1.model;

public class model_view_pager {

    private String itemname;

    private Integer picture;


    public model_view_pager(String itemname, Integer picture) {
        this.itemname = itemname;
        this.picture = picture;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }
}
