package HomeWork5.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aviary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String biome;
    double size;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "aviary")
    List<Animal> animals = new ArrayList<>();

    public Aviary(String biome, double size) {
        this.biome = biome;
        this.size = size;
    }

    public Aviary() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "id=" + id +
                ", biome='" + biome + '\'' +
                ", size=" + size +
                ", animals=" + animals +
                '}';
    }
}
