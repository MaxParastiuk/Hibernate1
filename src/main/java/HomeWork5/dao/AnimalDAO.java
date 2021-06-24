package HomeWork5.dao;

import HomeWork5.entity.Animal;

import java.util.List;

public interface AnimalDAO {
    void add(Animal animal);

    List<Animal> getAll();

    Animal getAnimal(long id);

    void updateAnimal(Animal animal, long id);

    void deleteAnimal(long id);
}
