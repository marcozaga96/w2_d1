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
}