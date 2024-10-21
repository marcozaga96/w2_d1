package marcozagaria.u2_w1_d1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreaMenù {


    @Bean
    public Topping pomodoro() {
        return new Topping("pomodoro", 0.0, 70);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("mozzarella", 0.0, 100);

    }

    @Bean
    public Topping prosciutto() {
        return new Topping("prosciutto", 0.5, 50);
    }

    @Bean
    public Topping ananas() {
        return new Topping("ananas", 1.5, 100);
    }

    @Bean
    public Topping salami() {
        return new Topping("salami", 1.00, 150);
    }

    @Bean
    public Pizza margherita() {
        Pizza pizza = new Pizza("margherita", 7.5, 800);
        pizza.aggiungiTopping(pomodoro());
        pizza.aggiungiTopping(mozzarella());
        return pizza;
    }

    @Bean
    public Pizza hawaiian() {
        Pizza pizza = new Pizza("hawaiian", 12.00, 1000);
        pizza.aggiungiTopping(pomodoro());
        pizza.aggiungiTopping(mozzarella());
        pizza.aggiungiTopping(prosciutto());
        pizza.aggiungiTopping(ananas());
        return pizza;
    }

    @Bean
    public Pizza salame() {
        Pizza pizza = new Pizza("pizza al salame", 10.00, 1200);
        pizza.aggiungiTopping(pomodoro());
        pizza.aggiungiTopping(mozzarella());
        pizza.aggiungiTopping(salami());
        return pizza;
    }

    @Bean
    public Bevanda acqua() {
        return new Bevanda("acqua", 1.00, 0);
    }

    @Bean
    public Bevanda vino() {
        return new Bevanda("vino", 15.00, 500);
    }

    @Bean
    public Bevanda coca_cola() {
        return new Bevanda("coca-cola", 2.50, 2000);
    }

    @Bean
    public Menù menu() {
        Menù menu = new Menù();
        menu.aggiungiPizza(margherita());
        menu.aggiungiPizza(hawaiian());
        menu.aggiungiPizza(salame());
        menu.aggiungiBevanda(coca_cola());
        menu.aggiungiBevanda(acqua());
        menu.aggiungiBevanda(vino());
        return menu;
    }

}
