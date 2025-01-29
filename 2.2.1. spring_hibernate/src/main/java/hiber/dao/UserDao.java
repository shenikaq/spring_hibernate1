package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

    void add(Car car);

    List<User> listUsers();

    @SuppressWarnings("unchecked")
    List<Car> listCars();

    User getUserWithCar(String model, int series);
}
