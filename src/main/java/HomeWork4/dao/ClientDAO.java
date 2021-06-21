package HomeWork4.dao;

import HomeWork4.entity.Client;

import java.util.List;

public interface ClientDAO {
    void add(Client client);

    List<Client> getAll();

    Client getById(long id);

    void updateClient(long id, String name, int age, String phone);

    void deleteClient(long id);
}
