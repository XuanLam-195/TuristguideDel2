package com.example.turistguidedel2.service;

import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.repository.TourisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    TourisRepository tourisRepository = new TourisRepository();

    public TouristService(TourisRepository tourisRepository){
        this.tourisRepository = tourisRepository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return tourisRepository.readfil();
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        tourisRepository.addAttraction(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction save(TouristAttraction touristAttraction) {
        return tourisRepository.save(touristAttraction);

    }

    public TouristAttraction editAttraction(TouristAttraction updatedAttraction) {
        List<TouristAttraction> attractions = tourisRepository.readfil();
        for (int i = 0; i < attractions.size(); i++) {
            TouristAttraction attraction = attractions.get(i);
            if (attraction.getName().equals(updatedAttraction.getName())) {
                // Cập nhật các thuộc tính của đối tượng attraction từ updatedAttraction
                attraction.setName(updatedAttraction.getName());
                attraction.setDescription(updatedAttraction.getDescription());
                // Cập nhật các thuộc tính khác tùy thuộc vào cách bạn lưu trữ dữ liệu

                tourisRepository.saveAll(attractions); // Lưu lại danh sách các địa điểm du lịch sau khi cập nhật
                return updatedAttraction;
            }
        }
        return null;
    }


    public TouristAttraction update(TouristAttraction touristAttraction){
        tourisRepository.updateAttraction(touristAttraction);
        return touristAttraction;
    }

    public void create(TouristAttraction touristAttraction){
        tourisRepository.createAttraction(touristAttraction);
    }

    public List<TouristAttraction> readAtrraktioner(){
        return tourisRepository.readfil();
    }

    public void delete(TouristAttraction touristAttraction){
        tourisRepository.deleteAttraction(touristAttraction);
    }


    public TouristAttraction getAttractionByName(TouristAttraction name) {
        return tourisRepository.save(name);
    }
}
