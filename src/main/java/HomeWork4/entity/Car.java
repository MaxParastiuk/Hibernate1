package HomeWork4.entity;

import javax.persistence.*;

@Entity
public class Car {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private long markid;
    private String mark;
    private String model;
    private int price;

    public Car() { }

    public Car(String mark, String model, int price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }



    public Car(long id, long markid, String mark, String model, int price) {
        this.id = id;
        this.markid = markid;
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getMarkid() {
        return markid;
    }

    public void setMarkid(long markid) {
        this.markid = markid;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", markid=" + markid +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
