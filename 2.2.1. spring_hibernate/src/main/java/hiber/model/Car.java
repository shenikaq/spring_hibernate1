package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {}

    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "model = " + model + ", series = " + series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getSeries() == car.getSeries() && Objects.equals(id, car.id) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getUser(), car.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getModel(), getSeries(), getUser());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
