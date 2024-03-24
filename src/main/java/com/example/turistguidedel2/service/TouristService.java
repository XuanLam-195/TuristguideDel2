package com.example.turistguidedel2.service;

import com.example.turistguidedel2.model.City;
import com.example.turistguidedel2.model.Tag;
import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.repository.TourisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    TourisRepository tourisRepository = new TourisRepository();


    public List<TouristAttraction> getAllAttractions(){
        return tourisRepository.findAllAttractions();
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        tourisRepository.addAttraction(touristAttraction);
        return touristAttraction;
    }

    public List<City> getCities (){
        return tourisRepository.getCities();
    }

    public List<Tag> getTagsById(int id){
        return tourisRepository.getTagsById(id);
    }

    public TouristAttraction getAttractionById(int id){
        return tourisRepository.getAttractionById(id);
    }

    public TouristAttraction editAttraction(int id, TouristAttraction touristAttraction){
        return tourisRepository.editAttraction(id, touristAttraction);
    }

   public void delete(int attraction_id) {
        tourisRepository.delete(attraction_id);
    }

    public List<Tag> getAllTags(){
        return tourisRepository.getAllTags();
    }
}
