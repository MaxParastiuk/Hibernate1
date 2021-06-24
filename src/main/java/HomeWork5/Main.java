package HomeWork5;

import HomeWork5.dao.AnimalDAOHeb;
import HomeWork5.dao.AviaryDAOHeb;
import HomeWork5.dao.VetDAOHeb;
import HomeWork5.entity.Animal;
import HomeWork5.entity.Aviary;
import HomeWork5.entity.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VetDAOHeb vet = new VetDAOHeb();
        AviaryDAOHeb aviary = new AviaryDAOHeb();


        aviary.add(new Aviary("Dog", 10));
        aviary.add(new Aviary("Cat", 5));
        aviary.add(new Aviary("Rabbit", 4));

        vet.add(new Vet("Kiril", "380935367", "Dobrobyt"));
        vet.add(new Vet("Sergey", "380695447", "Oxford"));

        
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Vet vets1 = session.get(Vet.class, 1l);
        Vet vets2 = session.get(Vet.class, 2l);

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                Animal animal = new Animal("Barsik" + i, 9 + i, true);
                animal.setVet(vets1);
                session.save(animal);
            } else {
                Animal animal = new Animal("Sharik" + i, 4 + i, true);
                animal.setVet(vets2);
                session.save(animal);
            }
        }

        session.close();
        factory.close();

        List<Animal> list = vets1.getAnimals();
        List<Animal> list2 = vets2.getAnimals();


        System.out.println();
        System.out.println();
        System.out.println(list);
        System.out.println();
        System.out.println();
        System.out.println(list2);


    }
}
