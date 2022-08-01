package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDaoImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarDaoImpl carDao;

    @GetMapping()
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> carsList = new ArrayList<>();

        if(count != null) {
            if (count >= 5) {
                model.addAttribute("carsInController", carDao.getAllCars());
            } else {
                for (int i = 1; i <= count; i++) {
                    if (i <= count) {
                        carsList.add(carDao.getCar(i));
                    }
                    model.addAttribute("carsInController", carsList);
                }
            }
        } else {
            model.addAttribute("carsInController", carDao.getAllCars());
        }
        return "/cars";
    }

}
