package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImpl {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "tesla", "model_one"));
        cars.add(new Car(2, "bmw", "m5"));
        cars.add(new Car(3, "subaru", "sti"));
        cars.add(new Car(4, "mitsubishi", "evo"));
        cars.add(new Car(5, "toyota", "supra"));
        cars.add(new Car(6, "nissan", "gtr"));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCar(int id) {
        return cars.get(id - 1);
//        return cars.subList(0, id);
    }
}
