package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("order/{id}")
    public CustomerOrder getOrder(@PathVariable int id){
        return orderRepository.findById(id).get();
    }
}
