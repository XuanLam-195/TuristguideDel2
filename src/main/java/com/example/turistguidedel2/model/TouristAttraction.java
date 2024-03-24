package com.example.turistguidedel2.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private String name;
    private String description;
    private int city;
    private int attraction_id;
    private String location;
    private LocalDateTime opening_hours;
    private  double adult_ticket_price;
    private  double child_ticket_price;
    private double rating;

    private List<Tag> tagList;

    public TouristAttraction(String name, String description, int city, List<Tag> tagList,
                             String location, LocalDateTime opening_hours, double adult_ticket_price,
                             double child_ticket_price, double rating){
        this.name = name;
        this.description = description;
        this.city = city;
        this.tagList = tagList;
        this.location = location;
        this.opening_hours = opening_hours;
        this.adult_ticket_price = adult_ticket_price;
        this.child_ticket_price = child_ticket_price;
        this.rating = rating;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
    public int getCity() {
        return city;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttraction_id() {
        return attraction_id;
    }

    public void setAttraction_id(int attraction_id) {
        this.attraction_id = attraction_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAdult_ticket_price() {
        return adult_ticket_price;
    }

    public void setAdult_ticket_price(double adult_ticket_price) {
        this.adult_ticket_price = adult_ticket_price;
    }

    public double getChild_ticket_price() {
        return child_ticket_price;
    }

    public void setChild_ticket_price(double child_ticket_price) {
        this.child_ticket_price = child_ticket_price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(LocalDateTime opening_hours) {
        this.opening_hours = opening_hours;
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
