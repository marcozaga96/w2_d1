package marcozagaria.u2_w1_d1;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Topping extends ElementoMenu {
    public Topping(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }
}
