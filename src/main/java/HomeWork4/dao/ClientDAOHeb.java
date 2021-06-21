package HomeWork4.dao;

import HomeWork4.entity.Car;
import HomeWork4.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

public class ClientDAOHeb implements ClientDAO{
    @Override
    public void add(Client client) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(client);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Client> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        List<Client> allClients = session.createQuery("From Client", Client.class).list();
        session.close();
        factory.close();
        return allClients;
    }

    @Override
    public Client getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Client client = factory.openSession().get(Client.class, id);
        factory.close();
        return client;
    }

    @Override
    public void updateClient(long id, String name, int age, String phone) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();


        Session session = factory.openSession();
        session.beginTransaction();

        String hql = "Update Client SET name = :name, age = :age, phone = :phone  WHERE id = :id ";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",name);
        query.setParameter("age",age);
        query.setParameter("phone",phone);
        query.executeUpdate();

        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public void deleteClient(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Client.class, id) != null) {
            Client client = factory.openSession().get(Client.class, id);


            Session session = factory.openSession();
            session.beginTransaction();

            client.setId(id);

            session.delete(client);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();
    }
}
