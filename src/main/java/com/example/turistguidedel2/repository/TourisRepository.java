package com.example.turistguidedel2.repository;

import com.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TourisRepository {
    private List<String> tagList = Arrays.asList("Børnevenlig", "Gratis", "Kunst", "Museum", "Natur");
    private final List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("Tivoli", "Forlystelsespark", "København", List.of("Bornevenlig")),
            new TouristAttraction("Zoologiske have", " Har beliggenhed i København.", "København", List.of("Naturlig", "Bornevenlig")),
            new TouristAttraction("Rundetårn", "Rundetårn er et 41,55 meter højt observationstårn, der ligger i Købmagergade i Indre By, København.", "København", List.of("Udstilling", "Koncenter", "Særarrangementer")),
            new TouristAttraction("Legoland", "Legoland Billund Resort er en dansk forlystelsespark i Billund med fokus på LEGO og Legoklodser.", "Billund", List.of("X-treme Racers", "Polar X-plorer", "LEGO Canoe"))
    ));



    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction editAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction findTouristattraction : touristAttractionList) {
            if (findTouristattraction.getName().equals(touristAttraction.getName())) {
                findTouristattraction.setDescription(touristAttraction.getDescription());
                findTouristattraction.setCity(touristAttraction.getCity());
                findTouristattraction.setTagList(touristAttraction.getTagList());
            }
        }
        return touristAttraction;
    }



    public TouristAttraction delete(TouristAttraction touristAttraction) {
        touristAttractionList.removeIf(attraction -> attraction.getName().equals(touristAttraction.getName()));
        return touristAttraction;
    }


    public TouristAttraction findByName(String name) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public List<String> getTagsByName(String name){
        for (TouristAttraction touristAttraction : touristAttractionList){
            if (name.equals(touristAttraction.getName())) {
                return touristAttraction.getTagList();
            }
        }
        return Collections.emptyList();
    }

    public List<String> getCity(){
        List<String> cityList = new ArrayList<>();
        for (TouristAttraction touristAttraction : touristAttractionList){
            cityList.add(touristAttraction.getCity());
        }
        return cityList;
    }


    public List<TouristAttraction> findAllAttractions(){
        return touristAttractionList;
    }


    public List<String> getAllTags(){
        return this.tagList;
    }

}