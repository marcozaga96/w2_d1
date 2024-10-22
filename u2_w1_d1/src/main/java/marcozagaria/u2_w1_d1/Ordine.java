package marcozagaria.u2_w1_d1;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Ordine {
    private UUID numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private Tavolo tavolo;
    private List<ElementoMenu> elementi = new ArrayList<>();
    private double importoTotale;

    public Ordine(StatoOrdine stato, int numeroCoperti, LocalDateTime oraAcquisizione, Tavolo tavolo, List<ElementoMenu> elementi, double importoTotale) {

        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
        this.tavolo = tavolo;
        this.elementi = elementi;
        this.importoTotale = importoTotale;
    }

    public void calcolaImportoTotale(double costoCoperto) {
        this.importoTotale += costoCoperto * this.numeroCoperti;
    }

    public void aggiungiElemento(ElementoMenu prodotto) {
        this.elementi.add(prodotto);
        this.importoTotale += prodotto.getPrezzo();

    }
}