package Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private final String id;
    private final String address;
    private Person houseManager;
    private final List<Flat> flats;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public House(@JsonProperty("id") String id, @JsonProperty("address") String address) {
        this.id = id;
        this.address = address;
        flats = new ArrayList<>();
    }

    public House(String id, String address, Person houseManager, List<Flat> flats) {
        this.id = id;
        this.address = address;
        this.houseManager = houseManager;
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) && Objects.equals(address, house.address) && Objects.equals(houseManager, house.houseManager) && Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, houseManager, flats);
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Person getHouseManager() {
        return houseManager;
    }

    public List<Flat> getFlats() {
        return flats;
    }
}

