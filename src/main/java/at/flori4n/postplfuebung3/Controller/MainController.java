package at.flori4n.postplfuebung3.Controller;

import at.flori4n.postplfuebung3.entity.*;
import at.flori4n.postplfuebung3.services.JsonService;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    JsonService jsonService;

    @GetMapping("/home")
    public String getAllCars(){
        return "home";
    }

    @PostMapping("/filter")
    public String filter(LocationSelection locationSelection, Model model){
        System.out.println(locationSelection.getLocation());
        Location location = locationRepository.getById(locationSelection.getLocation());
        System.out.println(location.getName());
        model.addAttribute("cars",location.getCars());
        return "home";
    }

    @ModelAttribute("allLocations")
    public List<Location> allLocations(){
        return locationRepository.findAll();
    }
    @ModelAttribute("cars")
    public List<Car> allCars(){
        return carRepository.findAll();
    }

    @PostMapping("delete")
    public String delete(@RequestParam String name){
        //System.out.println(name);
        carRepository.deleteById(name);
        return "redirect:/home";
    }

    @GetMapping("save")
    public String save(){
        jsonService.saveToJson();
        return "home";
    }
    @ModelAttribute("locationSelection")
    public LocationSelection locationSelection(){
        return new LocationSelection();
    }
    @ModelAttribute("carSelection")
    public CarSelection carSelection(){
        return new CarSelection();
    }
}



