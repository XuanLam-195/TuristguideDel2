package com.example.turistguidedel2.service;

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


    public TouristAttraction editAttraction(TouristAttraction touristAttraction){
        return tourisRepository.editAttraction(touristAttraction);
    }

    public void delete(String name) {
        TouristAttraction touristAttraction = tourisRepository.findByName(name);
        if (touristAttraction != null) {
            tourisRepository.delete(touristAttraction);
        }
    }

    public List<String> getCity(){
        return tourisRepository.getCity();

    }

    public TouristAttraction findByName(String name) {
        return tourisRepository.findByName(name);
    }
    public List<String> getTagsByName(String name){
        return tourisRepository.getTagsByName(name);
    }

    public List<String> getAllTags(){
        return tourisRepository.getAllTags();
    }

}
