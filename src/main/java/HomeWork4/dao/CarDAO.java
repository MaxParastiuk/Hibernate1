package HomeWork4.dao;

import HomeWork4.entity.Car;

import java.util.List;

public interface CarDAO {
    void add(Car car);

    List<Car> getAll();

    Car getById(long id);

    void updatePrice(long id,int price);

    void removeMark(String mark);

    void removeModel(String model);
}
