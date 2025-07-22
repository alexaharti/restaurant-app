package com.horeca.menu_app;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Product> menu = List.of(
            new Product("Pizza", 100),
            new Product("Paste", 95),
            new Product("Zeama", 45),
            new Product("Burger", 75),
            new Product("Tiramisu", 85)
    );

    @GetMapping("/meniu")
    public List<Product> getMenu() {
        return menu;
    }

    @GetMapping("/meniu-reducere")
    public List<Product> getDiscountMenu() {

        List<Product> menuDiscount = new ArrayList<>();

        for (int i = 0; i < menu.size(); i++) {
            Product p = menu.get(i);
            Product discounted = new Product(p.getName(), p.getPrice()/2);
            menuDiscount.add(discounted);
        }
        return menuDiscount;
    }
}
