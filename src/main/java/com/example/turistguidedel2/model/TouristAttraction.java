package com.example.turistguidedel2.model;

import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private final String name;
    private String description;
    private String city;
    private List<String> tagList;




    public TouristAttraction(String name, String description, String city, List<String> tagList){
        this.name = name;
        this.description = description;
        this.city = city;
        this.tagList = tagList;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
    public String getCity() {
        return city;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristAttraction that = (TouristAttraction) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    public String getDescription() {
        return description;
    }



}
