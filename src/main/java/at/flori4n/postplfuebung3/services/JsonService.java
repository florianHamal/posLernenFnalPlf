package at.flori4n.postplfuebung3.services;

import at.flori4n.postplfuebung3.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsonService {
    private String path = System.getProperty("user.dir")+ File.separator +"src"+File.separator+"main"+File.separator+"resources"+File.separator+"cars.json";
    private LocationRepository locationRepository;
    private CarRepository carRepository;

    public JsonService(LocationRepository locationRepository,CarRepository carRepository){
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;

        Location location = new Location();
        location.setName("Loc1");
        locationRepository.save(location);

        Car car = new Car();
        car.setName("car1");
        car.setBrand(Brand.VW);
        car.setLocation(location);
        carRepository.save(car);


        Car car2 = new Car();
        car2.setName("car2");
        car2.setBrand(Brand.BMW);
        car2.setLocation(location);
        carRepository.save(car2);



        Location location2 = new Location();
        location2.setName("Loc2");
        locationRepository.save(location2);

        Car car3 = new Car();
        car3.setName("car3");
        car3.setBrand(Brand.BMW);
        car3.setLocation(location2);
        carRepository.save(car3);

        readFromJson();


        //saveToJson();
    }

    public void readFromJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Location> locations= mapper.readerForListOf(Location.class).readValue(new File(path));
            //System.out.println(locations.getClass().getName());

            //List<Car> cars = new ArrayList<>();
            //locations.forEach(location -> cars.addAll(location.getCars()));
            //carRepository.saveAll(cars);
            locationRepository.saveAll(locations);

        } catch (IOException e) {

        }


    }
    public void saveToJson(){
        ObjectMapper mapper = new ObjectMapper();
        List<Location> locations = locationRepository.findAll();
        try {
            mapper.writeValue(new File(path),locations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
