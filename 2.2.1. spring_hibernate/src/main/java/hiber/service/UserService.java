package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    void add(User user, Car car);

    List<User> listUsers();

    List<User> getUserByCar(String model, int series);
}
