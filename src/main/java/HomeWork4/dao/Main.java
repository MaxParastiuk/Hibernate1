package HomeWork4.dao;

import HomeWork4.entity.Car;
import HomeWork4.entity.Client;

public class Main {
    public static void main(String[] args) {
     CarDAOHeb carDAOHeb = new CarDAOHeb();

     carDAOHeb.add(new Car("Audi","A8",190000));
     carDAOHeb.add(new Car("BMW","X5",230000));
     carDAOHeb.add(new Car("Tesla","Model X",130000));

//        carDAOHeb.print();

//        carDAOHeb.updatePrice(2,140000);
//        System.out.println(carDAOHeb.getById(2));


//     carDAOHeb.removeModel("Model X");
//     carDAOHeb.removeMark("BMW");

        ClientDAOHeb clientDAOHeb = new ClientDAOHeb();
//
//        clientDAOHeb.add(new Client("Max",21,"380934324"));
//        clientDAOHeb.add(new Client("Vlad",32,"380234324"));
//        clientDAOHeb.add(new Client("Max",25,"380834344"));

//        clientDAOHeb.updateClient(1,"Anton",33,"380933245");

//        clientDAOHeb.getById(1);
//        clientDAOHeb.deleteClient(1);

//        System.out.println(clientDAOHeb.getAll());
    }
}
