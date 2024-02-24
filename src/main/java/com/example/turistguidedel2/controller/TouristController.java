package com.example.turistguidedel2.controller;

import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/{name}/tags")
    public String getAttractionTags(Model model, @PathVariable String name ){
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        TouristAttraction attraction = null;
        for(TouristAttraction touristAttraction : touristAttractions){
            if(touristAttraction.getName().equals(name)){
                attraction = touristAttraction;
            }
        }
        model.addAttribute("attraction", attraction);
        return "tags";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("addAttraction", new TouristAttraction("", "", "", new ArrayList<>()));
        return "addAttraction";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("attraction") TouristAttraction touristAttraction) {
        touristService.save(touristAttraction);
        return "attractionList";
    }






}
