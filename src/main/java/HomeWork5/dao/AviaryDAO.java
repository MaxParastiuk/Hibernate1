package HomeWork5.dao;

import HomeWork5.entity.Aviary;

import java.util.List;

public interface AviaryDAO {
    void add(Aviary aviary);

    List<Aviary> getAll();

    Aviary getById(long id);

    void updateById(long id, Aviary aviary);

    void removeById(long id);
}
