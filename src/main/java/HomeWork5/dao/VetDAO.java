package HomeWork5.dao;

import HomeWork5.entity.Vet;

import java.util.List;

public interface VetDAO {
    void add(Vet vet);

    List<Vet> getAll();

    Vet getById(long id);

    void updateById(long id, Vet vet);

    void removeById(long id);
}
