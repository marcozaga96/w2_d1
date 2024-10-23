package marcozagaria.u2_w1_d1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class ElementoMenu {
    private String nome;
    private double prezzo;
    private int calorie;

}
