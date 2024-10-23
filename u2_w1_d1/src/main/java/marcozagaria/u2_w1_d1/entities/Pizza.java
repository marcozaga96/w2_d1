package marcozagaria.u2_w1_d1.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class Pizza extends ElementoMenu {

    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }

    public void aggiungiTopping(Topping topping) {
        this.toppings.add(topping);
    }
}
