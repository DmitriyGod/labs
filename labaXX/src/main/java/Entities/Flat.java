package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Flat implements Serializable {
    private final int number;
    private final double square;
    private List<Person> villagers;

    Flat(int number, double square) {
        this.number = number;
        this.square = square;
        villagers = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flat flat = (Flat) o;
        return number == flat.number && Double.compare(square, flat.square) == 0 && Objects.equals(villagers, flat.villagers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, square, villagers);
    }

    public int getNumber() {
        return number;
    }

    public double getSquare() {
        return square;
    }

    public List<Person> getVillagers() {
        return villagers;
    }

    public Flat(int number, double square, List<Person> villagers) {
        if (villagers == null) {
            throw new IllegalArgumentException();
        }
        this.number = number;
        this.square = square;
        this.villagers = villagers;
    }
}
