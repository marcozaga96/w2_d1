package marcozagaria.u2_w1_d1.entities;

import lombok.Data;

import java.util.List;

@Data
public class ElementoOrdine {
    private ElementoMenu elementoMenu;
    private List<String> variazioni;
    private String nota;

    public ElementoOrdine(ElementoMenu elementoMenu, List<String> variazioni, String nota) {
        this.elementoMenu = elementoMenu;
        this.variazioni = variazioni;
        this.nota = nota;
    }
}