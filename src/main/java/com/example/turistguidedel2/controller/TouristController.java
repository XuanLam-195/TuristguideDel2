package com.example.turistguidedel2.controller;

import com.example.turistguidedel2.model.City;
import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }


    @GetMapping("")
    public String getAttractions(Model model){
        model.addAttribute("attractions", touristService.getAllAttractions());
        return "attractionList";
    }

    @GetMapping("/{id}/tags")
    public String getAttractionTags(Model model, @PathVariable int id) {
        TouristAttraction attraction = touristService.getAttractionById(id);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            model.addAttribute("tags", attraction.getTagList());
        }
        return "tags";
    }


    @GetMapping("/add")
    public String add(Model model) {
        List<City> cityList = touristService.getCities();
        List<String> tagsList = new ArrayList<String>();
        model.addAttribute("addForm", new TouristAttraction("", "", 0, new ArrayList<>(), "", LocalDateTime.now(), 10.0, 5.0, 4.0));
        model.addAttribute("city", cityList);
        model.addAttribute("tags", tagsList);
        return "addAttraction";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TouristAttraction touristAttraction, Model model) {
        model.addAttribute("add", touristService.addAttraction(touristAttraction));
        //touristService.save(touristAttraction);
        return "redirect:/attractions";
    }



    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        TouristAttraction attraction = touristService.getAttractionById(id);
        List<City> cityList = touristService.getCities();
        model.addAttribute("attraction", attraction);
        model.addAttribute("cities", cityList);
        return "updateAttraction";
    }

    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.editAttraction(touristAttraction.getAttraction_id(), touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        touristService.delete(id);
        return "redirect:/attractions";
    }

}
