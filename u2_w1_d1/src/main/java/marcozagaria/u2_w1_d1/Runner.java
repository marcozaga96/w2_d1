package marcozagaria.u2_w1_d1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private Ordine newOrdine;

    @Override
    public void run(String... args) throws Exception {


        ApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        Menù menu = context.getBean(Menù.class);
        menu.stampaMenu();

        Ordine newOrdine = context.getBean(Ordine.class);


        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.LIBERO);

        List<ElementoMenu> elementiMenu = new ArrayList<>();
        elementiMenu.add(menu.getPizze().get(0));
        elementiMenu.add(menu.getBevande().get(0));

        Ordine ordine = newOrdine.creaOrdine(tavolo, elementiMenu);
        ordine.toString();
    }


}

