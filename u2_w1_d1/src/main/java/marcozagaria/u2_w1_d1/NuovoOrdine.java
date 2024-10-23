package marcozagaria.u2_w1_d1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class NuovoOrdine {
    @Value("${costo.coperto}")
    private double costoCoperto;

    public Ordine creaOrdine(Tavolo tavolo, List<ElementoMenu> elementiMenu) {
        Ordine ordine = new Ordine(1, StatoOrdine.IN_CORSO, 5, LocalDateTime.now(), tavolo);

        double importoTotale = costoCoperto * ordine.getNumeroCoperti();
        for (ElementoMenu item : elementiMenu) {
            importoTotale += item.getPrezzo();
            ordine.getElementi().add(item);
        }
        ordine.setImportoTotale(importoTotale);

        log.info("Ordine creato: {}", ordine);
        return ordine;
    }

    @Bean
    public NuovoOrdine newOrdine() {
        return new NuovoOrdine();
    }

}
