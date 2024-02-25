package com.example.turistguidedel2.model;

import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<String> category;




    public TouristAttraction(String name, String description, String city, List<String> category){
        this.name = name;
        this.description = description;
        this.city = city;
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setCategory(List<String> category) {
        this.category = category;
    }
    public String getCity() {
        return city;
    }

    public List<String> getCategory() {
        return category;
    }
    public void setName(String name) {
        this.name = name;
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
