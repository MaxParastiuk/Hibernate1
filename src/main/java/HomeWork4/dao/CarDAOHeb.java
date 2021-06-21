package HomeWork4.dao;

import HomeWork4.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class CarDAOHeb implements CarDAO {

    public void print(){
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Object []> list = session.createQuery("Select mark,model,price FROM Car").list();

        for (Object [] arr: list) {
            System.out.println(Arrays.toString(arr));
        }

        session.close();
        factory.close();

    }

    @Override
    public void add(Car car) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(car);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Car> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        List<Car> allCar = session.createQuery("From Car", Car.class).list();
        session.close();
        factory.close();
        return allCar;
    }

    @Override
    public Car getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, id);
        factory.close();
        return car;
    }

    @Override
    public void updatePrice(long id, int price) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();


        Session session = factory.openSession();
        session.beginTransaction();

        String hql = "Update Car SET price = :price WHERE id = :id ";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("price",price);
        query.executeUpdate();

        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();
    }


    @Override
    public void removeMark(String mark) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();


        Session session = factory.openSession();
        session.beginTransaction();

        String hql = "Delete from Car WHERE mark = :mark";
        Query query = session.createQuery(hql);
        query.setParameter("mark",mark);
        query.executeUpdate();

        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public void removeModel(String model) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();


        Session session = factory.openSession();
        session.beginTransaction();

        String hql = "Delete from Car WHERE model = :model";
        Query query = session.createQuery(hql);
        query.setParameter("model",model);
        query.executeUpdate();

        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}

