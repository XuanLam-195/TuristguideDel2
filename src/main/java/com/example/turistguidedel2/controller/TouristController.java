package com.example.turistguidedel2.controller;

import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{name}/tags")
    public String getAttractionTags(Model model, @PathVariable String name) {
        TouristAttraction attraction = touristService.findByName(name);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            model.addAttribute("tags", attraction.getTagList());
        }
        return "tags";
    }


    @GetMapping("/add")
    public String add(Model model) {
        List<String> cityList = Arrays.asList("København", "Aarhus", "Aalborg", "Odense", "Esbjerg");
        List<String> tagsList = Arrays.asList("Børnevenlig", "Gratis", "Kunst", "Museum", "Natur");
        model.addAttribute("addAttraction", new TouristAttraction("", "", "", new ArrayList<>()));
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

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("editAttraction", new TouristAttraction("", "", "", new ArrayList<>()));
        return "editAttraction";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("editAttraction") TouristAttraction touristAttraction){
        touristService.update(touristAttraction);
        return "redirect:/attractions";
    }
    @GetMapping("/delete/{name}")
    public String delete(@PathVariable String name){
        touristService.delete(name);
        return "redirect:/attractions";
    }



}
