package HomeWork5.dao;

import HomeWork5.entity.Aviary;
import HomeWork5.entity.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VetDAOHeb implements VetDAO {
    @Override
    public void add(Vet vet) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(vet);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Vet> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        List<Vet> allVet = session.createQuery("From Vet", Vet.class).list();
        session.close();
        factory.close();
        return allVet;
    }

    @Override
    public Vet getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Vet vet = factory.openSession().get(Vet.class, id);
        factory.close();
        return vet;
    }

    @Override
    public void updateById(long id, Vet vet) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Vet vet1 = vet;
        vet1.setId(id);

        Session session = factory.openSession();
        session.beginTransaction();
        session.update(vet);
        session.flush();
        session.getTransaction().commit();
        session.close();

        factory.close();
    }

    @Override
    public void removeById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Vet vet = factory.openSession().get(Vet.class, id);


        Session session = factory.openSession();
        session.beginTransaction();

        vet.setId(id);

        session.delete(vet);
        session.flush();
        session.getTransaction().commit();

        session.close();

        factory.close();
    }
}
