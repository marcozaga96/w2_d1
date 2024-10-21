package marcozagaria.u2_w1_d1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U2W1D1Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CreaMenù.class);
        Menù menù = context.getBean(Menù.class);
        menù.stampaMenu();
    }

}
