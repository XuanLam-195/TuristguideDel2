package com.example.turistguidedel2.model;

public class Tag {
    private int tag_id;
    private int attraction_id;
    private String tag_name;

    public Tag(int tag_id, int attraction_id, String tag_name) {
        this.tag_id = tag_id;
        this.attraction_id = attraction_id;
        this.tag_name = tag_name;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getAttraction_id() {
        return attraction_id;
    }

    public void setAttraction_id(int attraction_id) {
        this.attraction_id = attraction_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
