package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {

        //sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

//    @Override
//    public List<User> getUserByCar(String model, int series) {
//        TypedQuery<User> query1 = sessionFactory.getCurrentSession().createQuery("from User where userCar.model=:model and userCar.series=:series");
//        query1.setParameter("series", series).setParameter("model", model);
//        return query1.getResultList();
//    }

}
