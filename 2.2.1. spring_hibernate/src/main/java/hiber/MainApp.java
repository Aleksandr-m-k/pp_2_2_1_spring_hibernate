package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServise;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarServise carServise = context.getBean(CarServise.class);
        userService.addUser(new User("User8", "Lastname8", "user8@mail.ru"));
        userService.addUser(new User("User9", "Lastname9", "user9@mail.ru"));

        userService.addUserAndCar(new User("User1", "Lastname1", "user1@mail.ru"),
                new Car("bmw", 5));
        userService.addUserAndCar(new User("User2", "Lastname2", "user2@mail.ru"),
                new Car("mercedes_benz", 123));
        userService.addUserAndCar(new User("User3", "Lastname3", "user3@mail.ru"),
                new Car("WV", 7));
        userService.addUserAndCar(new User("User4", "Lastname4", "user4@mail.ru"),
                new Car("VAZ", 2105));
        carServise.addCar(new Car("bmw", 5));
        carServise.addCar(new Car("mercedes_benz", 123));
        carServise.addCar(new Car("WV", 7));
        carServise.addCar(new Car("VAZ", 2105));
        List<Car> cars = carServise.getListCars();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Model = " + car.getModel());
            System.out.println("Series = " + car.getSeries());
            System.out.println("********************");
        }
        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        System.out.println("***************************");
        System.out.println(userService.getUserByCar("bmw", 5));
        System.out.println(userService.getUserByCar("mercedes_benz", 123));
        System.out.println(userService.getUserByCar("WV", 7));
        System.out.println(userService.getUserByCar("VAZ", 2105));
        System.out.println("***************************");

        context.close();
    }
}
