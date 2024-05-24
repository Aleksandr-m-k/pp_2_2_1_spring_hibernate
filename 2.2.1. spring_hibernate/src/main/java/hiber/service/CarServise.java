package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarServise {
    void addCar(Car car);

    List<Car> getListCars();
}
