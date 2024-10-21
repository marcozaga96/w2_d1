package marcozagaria.u2_w1_d1;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Menù {
    private List<Pizza> pizze = new ArrayList<>();
    private List<Bevanda> bevande = new ArrayList<>();

    public void aggiungiPizza(Pizza pizza) {
        this.pizze.add(pizza);
    }

    public void aggiungiBevanda(Bevanda bevanda) {
        this.bevande.add(bevanda);
    }

    public void stampaMenu() {
        System.out.println("Pizze:");
        for (Pizza pizza : pizze) {
            System.out.println(pizza.getNome() + " - €" + pizza.getPrezzo() + " - " + pizza.getCalorie() + " kcal");
            for (Topping topping : pizza.getToppings()) {
                System.out.println("  + " + topping.getNome() + " - €" + topping.getPrezzo() + " - " + topping.getCalorie() + " kcal");
            }
        }

        System.out.println("\nBevande:");
        for (Bevanda bevanda : bevande) {
            System.out.println(bevanda.getNome() + " - €" + bevanda.getPrezzo() + " - " + bevanda.getCalorie() + " kcal");
        }
    }
}
