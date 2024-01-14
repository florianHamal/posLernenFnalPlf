package at.flori4n.postplfuebung3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "location",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> cars = new ArrayList<>();


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cars=" + cars.toString() +
                '}';
    }
/*
    public static void main(String[] args) {
        Car car = new Car("A","B","C","D",new ArrayList<>());

        Location location = new Location();
        location.setName("A");

        String path = System.getProperty("user.dir")+ File.separator +"src"+File.separator+"main"+File.separator+"resources"+File.separator+"cars.json";
        ObjectMapper mapper = new ObjectMapper();

        location.getCars().add(car);
        List<Location> locations = new ArrayList<>();
        locations.add(location);
        try {
            mapper.writeValue(new File(path),locations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/
}
