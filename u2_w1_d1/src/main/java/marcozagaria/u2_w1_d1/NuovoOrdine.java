package marcozagaria.u2_w1_d1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class NuovoOrdine {
    @Value("${costo.coperto}")
    private double costoCoperto;

    @Bean
    public double costoCoperto() {
        return costoCoperto;
    }

    @Bean
    public Tavolo tavolo() {
        Tavolo tavolo = new Tavolo(1, 20, StatoTavolo.LIBERO);
        return tavolo;
    }
}
