package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void addUserAndCar(User user, Car car);

    List<User> getListUsers();

    List<User> getUserByCar(String model, int series);

}
