package marcozagaria.u2_w1_d1;

import lombok.extern.slf4j.Slf4j;
import marcozagaria.u2_w1_d1.entities.*;
import marcozagaria.u2_w1_d1.enums.StatoOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    CreaMenù tavolo1;

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2W1D1Application.class);
        try {
            Menù m = (Menù) ctx.getBean("menu");
            m.stampaMenu();

            Tavolo t1 = (Tavolo) ctx.getBean(tavolo1.getTable1());

            Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 5, LocalDateTime.now(), t1);

            o1.aggiungiElemento(ctx.getBean("margherita", Pizza.class));
            o1.aggiungiElemento(ctx.getBean("pizza al salame", Pizza.class));
            o1.aggiungiElemento(ctx.getBean("acqua", Bevanda.class));
            o1.aggiungiElemento(ctx.getBean("vino", Bevanda.class));

            System.out.println("DETTAGLI TAVOLO 1:");
            o1.print();

            System.out.println("CONTO TAVOLO 1");
            System.out.println(o1.calcolaImportoTotale());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }


}

