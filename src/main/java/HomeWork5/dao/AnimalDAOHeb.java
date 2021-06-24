package HomeWork5.dao;

import HomeWork5.entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AnimalDAOHeb implements AnimalDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public void add(Animal animal) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(animal);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public List<Animal> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Animal> list = session.createQuery("from Animal", Animal.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Animal getAnimal(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = factory.openSession().get(Animal.class, id);
        factory.close();
        return animal;
    }


    @Override
    public void updateAnimal(Animal animal, long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal1 = animal;
            animal1.setId(id);

            Session session = factory.openSession();
            session.beginTransaction();
            session.update(animal1);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();
    }

    @Override
    public void deleteAnimal(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal = factory.openSession().get(Animal.class, id);


            Session session = factory.openSession();
            session.beginTransaction();

            animal.setId(id);

            session.delete(animal);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();
    }
}
