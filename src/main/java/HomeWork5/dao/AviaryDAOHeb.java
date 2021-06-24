package HomeWork5.dao;

import HomeWork4.entity.Car;
import HomeWork5.entity.Aviary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AviaryDAOHeb implements AviaryDAO {
    @Override
    public void add(Aviary aviary) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(aviary);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Aviary> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        List<Aviary> allAviary = session.createQuery("From Aviary", Aviary.class).list();
        session.close();
        factory.close();
        return allAviary;
    }

    @Override
    public Aviary getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Aviary aviary = factory.openSession().get(Aviary.class, id);
        factory.close();
        return aviary;
    }

    @Override
    public void updateById(long id, Aviary aviary) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Aviary aviary1 = aviary;
        aviary1.setId(id);

        Session session = factory.openSession();
        session.beginTransaction();
        session.update(aviary1);
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

        Aviary aviary = factory.openSession().get(Aviary.class, id);


        Session session = factory.openSession();
        session.beginTransaction();

        aviary.setId(id);

        session.delete(aviary);
        session.flush();
        session.getTransaction().commit();

        session.close();

        factory.close();
    }
}
