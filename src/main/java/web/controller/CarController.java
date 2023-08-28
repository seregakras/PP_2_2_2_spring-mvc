package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final List<Car> cars = List.of(new Car("Model1", 110, 1000.00),
                                            new Car("Model2", 120, 2000.00),
                                            new Car("Model3", 130, 3000.00),
                                            new Car("Model4", 140, 4000.00),
                                            new Car("Model5", 150, 5000.00));

    @GetMapping("")
    public String getAllCars(Model model, @RequestParam(defaultValue = "5") int count) {
        List<Car> viewCars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            viewCars.add(cars.get(i));
            if (i == 4) {
                break;
            }
        }
        model.addAttribute("cars", viewCars);
        return "cars";
    }

}
