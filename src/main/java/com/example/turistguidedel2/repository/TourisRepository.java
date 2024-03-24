package com.example.turistguidedel2.repository;

import ConnectionManager.ConnectionManager;
import com.example.turistguidedel2.model.City;
import com.example.turistguidedel2.model.Tag;
import com.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TourisRepository {

   private ConnectionManager connectionManager;
   public  TourisRepository(){
       this.connectionManager = new ConnectionManager();
   }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
      String SQL = "INSERT INTO Attraction (attraction_id, attraction_name, location,  city_id, attraction_description, opening_hours, adult_ticket_price, child_ticket_price, rating) ";
      SQL += " VALUES (?,?,?,?,?,?,?,?,?)";
        Connection con = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setInt(1, touristAttraction.getAttraction_id());
            pstmt.setString(2, touristAttraction.getName());
            pstmt.setString(3, "Lam");
            pstmt.setInt(4, touristAttraction.getCity());
            pstmt.setString(5, touristAttraction.getDescription());
            pstmt.setString(6, touristAttraction.getOpening_hours().toString());
            pstmt.setDouble(7, touristAttraction.getAdult_ticket_price());
            pstmt.setDouble(8, touristAttraction.getChild_ticket_price());
            pstmt.setDouble(9, touristAttraction.getRating());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return touristAttraction;
    }

    public List<City> getCities(){
       List<City> cities = new ArrayList<City>();
        String SQL = "Select city_id, city_name From City";
        Connection con = this.connectionManager.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int city_id = rs.getInt("city_id");
                String city_name = rs.getString("city_name");
                cities.add(new City(city_id, city_name));
            }
            return cities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String getCityNameById(int id){
        String SQL = "Select city_name From City Where city_id = ?";
        Connection con = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("city_name");
            }
            return "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public TouristAttraction editAttraction(int id, TouristAttraction touristAttraction) {
       String SQL  = "Update Attraction Set " +
               "attraction_name = ?, " +
               "location = ?," +
               "attraction_description = ?," +
               "opening_hours = ?," +
               "adult_ticket_price = ?," +
               "child_ticket_price = ?," +
               "rating = ?," +
               "city_id = ?" +
               " Where attraction_id = ?";
        Connection con = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setString(1, touristAttraction.getName());
            pstmt.setString(2, touristAttraction.getLocation());
            pstmt.setString(3, touristAttraction.getDescription());
            pstmt.setString(4, touristAttraction.getOpening_hours().toString());
            pstmt.setDouble(5, touristAttraction.getAdult_ticket_price());
            pstmt.setDouble(6, touristAttraction.getChild_ticket_price());
            pstmt.setDouble(7, touristAttraction.getRating());
            pstmt.setInt(8, touristAttraction.getCity());
            pstmt.setInt(9, id);
            pstmt.execute();
            return touristAttraction;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



     public void delete(int attraction_id) {
       String SQL = "Delete From Attraction Where attraction_id = ?";
       Connection con = this.connectionManager.getConnection();
       try (PreparedStatement pstmt = con.prepareStatement(SQL)){
           pstmt.setInt(1, attraction_id);
           pstmt.execute();
           }
       catch (SQLException e){
           throw new RuntimeException(e);
       }
    }


    public List<Tag> getTagsById(int id){
      List<Tag> tags = new ArrayList<Tag>();
      String SQL = "Select tag_id, attraction_id, tag_name From Attraction_tags Where attraction_id = ?;";
       Connection con = this.connectionManager.getConnection();
       try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
           pstmt.setInt(1, id);
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
               int tag_id = rs.getInt("tag_id");
               int attraction_id = rs.getInt("attraction_id");
               String tag_name = rs.getString("tag_name");
               tags.add(new Tag(tag_id, attraction_id, tag_name));
           }
           return tags;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    public List<Tag>  getAllTags(){
        List<Tag> tags = new ArrayList<Tag>();
        String SQL = "Select tag_id, attraction_id, tag_name From Attraction_tags";
        Connection con = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int tag_id = rs.getInt("tag_id");
                int attraction_id = rs.getInt("attraction_id");
                String tag_name = rs.getString("tag_name");
                tags.add(new Tag(tag_id, attraction_id, tag_name));
            }
            return tags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TouristAttraction getAttractionById(int attraction_id){
       TouristAttraction touristAttraction = null;
        String SQL = "Select attraction_name, location, attraction_description," +
                "opening_hours, adult_ticket_price, child_ticket_price, rating, city_id From Attraction Where attraction_id = ?;";
        Connection con = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setInt(1, attraction_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               String name = rs.getString("attraction_name");
               String location = rs.getString("location");
               String description = rs.getString("attraction_description");
               String opening_hours = rs.getString("opening_hours");
               double adult_ticket_price = rs.getDouble("adult_ticket_price");
               double child_ticket_price = rs.getDouble("child_ticket_price");
               double rating = rs.getDouble("rating");
               int city_id = rs.getInt("city_id");
               touristAttraction = new TouristAttraction(name, description, city_id, getTagsById(attraction_id),
                       location, LocalDateTime.parse(opening_hours), adult_ticket_price, child_ticket_price, rating);
               touristAttraction.setAttraction_id(attraction_id);
            }
            return touristAttraction;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




   public List<TouristAttraction> findAllAttractions(){
       List<TouristAttraction> attractions = new ArrayList<TouristAttraction>();
       String SQL = "Select attraction_id, attraction_name, location, attraction_description," +
               " opening_hours, adult_ticket_price, child_ticket_price, rating, city_id  From Attraction";
       Connection con = this.connectionManager.getConnection();

       try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
               int attraction_id = rs.getInt("attraction_id");
               String  attraction_name = rs.getString("attraction_name");
               String location = rs.getString("location");
               String attraction_description = rs.getString("attraction_description");
               String  opening_hours = rs.getString("opening_hours");
               double adult_ticket_price = rs.getDouble("adult_ticket_price");
               double child_ticket_price = rs.getDouble("child_ticket_price");
               double rating = rs.getDouble("rating");
               int city_id = rs.getInt("city_id");

              TouristAttraction touristAttraction = new TouristAttraction(attraction_name, attraction_description, city_id, getTagsById(attraction_id)
                      , location,  LocalDateTime.parse(opening_hours), adult_ticket_price, child_ticket_price, rating);
              touristAttraction.setAttraction_id(attraction_id);
              attractions.add(touristAttraction);
           }
           return attractions;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}