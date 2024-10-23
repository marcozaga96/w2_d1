package marcozagaria.u2_w1_d1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Ordine {
    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private Tavolo tavolo;
    private List<ElementoMenu> elementi;
    private double importoTotale;
    @Value("${costo.coperto}")
    private double costoCoperto;

    public Ordine(int numeroOrdine, StatoOrdine stato, int numeroCoperti, LocalDateTime oraAcquisizione, Tavolo tavolo) {
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
        this.tavolo = tavolo;
        this.elementi = new ArrayList<>();
        this.importoTotale = importoTotale;
    }

    public void aggiungiElemento(ElementoMenu prodotto) {
        elementi.add(prodotto);
    }

    public double calcolaImportoTotale() {
        double totaleProdotti = elementi.stream().mapToDouble(ElementoMenu::getPrezzo).sum();
        return totaleProdotti + (numeroCoperti * costoCoperto);
    }

    @Bean
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordine n. ").append(numeroOrdine)
                .append(" per il tavolo ").append(tavolo.getNumero())
                .append(" (").append(numeroCoperti).append(" coperti)")
                .append("\nStato: ").append(stato)
                .append("\nOra: ").append(oraAcquisizione)
                .append("\nProdotti:\n");

        for (ElementoMenu prodotto : elementi) {
            sb.append(" - ").append(prodotto).append("\n");
        }
        sb.append("Totale: €").append(calcolaImportoTotale());

        return sb.toString();
    }
}