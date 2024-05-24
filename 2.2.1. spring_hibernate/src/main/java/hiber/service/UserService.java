package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    void addUserAndCar(User user, Car car);

    List<User> getListUsers();

    List<User> getUserByCar(String model, int series);
}
