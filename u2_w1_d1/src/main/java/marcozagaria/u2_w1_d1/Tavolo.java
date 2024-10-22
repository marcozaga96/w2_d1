package marcozagaria.u2_w1_d1;

import lombok.Data;

@Data
public class Tavolo {
    private int numero;
    private int numeroCopertiMax;
    private StatoTavolo stato;

    public Tavolo(int numero, int numeroCopertiMax, StatoTavolo stato) {
        this.numero = numero;
        this.numeroCopertiMax = numeroCopertiMax;
        this.stato = stato;
    }
}


