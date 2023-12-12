package hierarchies;

import static hierarchies.NyPizza.Size.LARGE;
import static hierarchies.Pizza.Topping.*;

/**
 * Created by ainacio on Dec, 2023
 */
public class PizzaTest {

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(LARGE).addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
        System.out.println(nyPizza);
        System.out.println(calzone);
    }
}
