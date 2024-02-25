package com.example.turistguidedel2.repository;

import com.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Repository
public class TourisRepository {
    private final List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("Tivoli", "Forlystelsespark", "København", List.of("Bornevenlig")),
            new TouristAttraction("Zoologiske have", " Har beliggenhed i København.", "København", List.of("Naturlig", "Bornevenlig")),
            new TouristAttraction("Rundetårn", "Rundetårn er et 41,55 meter højt observationstårn, der ligger i Købmagergade i Indre By, København.", "København", List.of("Udstilling", "Koncenter", "Særarrangementer")),
            new TouristAttraction("Legoland", "Legoland Billund Resort er en dansk forlystelsespark i Billund med fokus på LEGO og Legoklodser.", "Billund", List.of("X-treme Racers", "Polar X-plorer", "LEGO Canoe"))
    ));


    public List<TouristAttraction> readfil() {
        return touristAttractionList;
    }

    public TouristAttraction createAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
        return touristAttraction;
    }
    public TouristAttraction editAttraction(TouristAttraction updateAttraction){
        for (int i = 0; i < touristAttractionList.size(); i++){
            TouristAttraction attraction = touristAttractionList.get(i);
            if (attraction.getName().equals(updateAttraction.getName())){
                touristAttractionList.set(i, updateAttraction);
                return updateAttraction;
            }
        }
        return  null;
    }

    public TouristAttraction save(TouristAttraction touristAttraction) {
        if (touristAttraction != null) {
            boolean exists = touristAttractionList.contains(touristAttraction);
            if (!exists) {
                touristAttractionList.add(touristAttraction);
            }
        }
        return touristAttraction;
    }


    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().equals(touristAttraction.getName())) {
                attraction.setName(touristAttraction.getName());
                attraction.setDescription(attraction.getDescription());
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.remove(touristAttraction);
        return touristAttraction;
    }

    public List<String> getNameByTags() {
        for (TouristAttraction touristAttraction : touristAttractionList) {
            return touristAttraction.getCategory();
        }
        return Collections.emptyList();
    }

    public List<String> getCity() {
        List<String> cityList = new ArrayList<>();
        for (TouristAttraction touristAttraction : touristAttractionList) {
            cityList.add(touristAttraction.getCity());
        }
        return cityList;
    }

    public void saveAll(List<TouristAttraction> attractions) {

    }


}