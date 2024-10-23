package marcozagaria.u2_w1_d1.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import marcozagaria.u2_w1_d1.enums.StatoOrdine;
import org.springframework.beans.factory.annotation.Value;

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


    @Value("${costo.coperto}")
    private double costoCoperto;

    public Ordine(int numeroOrdine, StatoOrdine stato, int numeroCoperti, LocalDateTime oraAcquisizione, Tavolo tavolo) {
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
        this.tavolo = tavolo;
        this.elementi = new ArrayList<>();

    }

    public void aggiungiElemento(ElementoMenu prodotto) {
        elementi.add(prodotto);
    }

    public double calcolaImportoTotale() {
        double totaleProdotti = elementi.stream().mapToDouble(ElementoMenu::getPrezzo).sum();
        return totaleProdotti + (numeroCoperti * costoCoperto);
    }


    public void print() {
        System.out.println("id ordine--> " + this.numeroOrdine);
        System.out.println("stato--> " + this.stato);
        System.out.println("numero coperti--> " + this.numeroCoperti);
        System.out.println("ora acquisizione--> " + this.oraAcquisizione);
        System.out.println("numero tavolo--> " + this.tavolo.getNumero());
        System.out.println("Lista: ");
        this.elementi.forEach(System.out::println);
        System.out.println("totale--> " + this.calcolaImportoTotale());

    }

}