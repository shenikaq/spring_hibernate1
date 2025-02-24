package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("model1", 1);
      Car car2 = new Car("model2", 2);
      Car car3 = new Car("model3", 3);
      Car car4 = new Car("model4", 4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      List<User> users = userService.listUsers();
      List<Car> cars = carService.listCars();

      for (User user : users) {
//         userService.add(user);
         System.out.println(user.toString());
         System.out.println();
      }

      for (Car car : cars) {
//      carService.add(car);
      System.out.println(car.toString());
      System.out.println();
      }

      int i = 0;
      for (User user : users) {
         user.setCar(cars.get(i));
         i++;
      }

      for (User user : users) {
         userService.add(user);
         System.out.println(user);
      }

      System.out.println("Владелец по модели и серии - " + userService.getUserWithCar("model1", 1));

      context.close();
   }
}
