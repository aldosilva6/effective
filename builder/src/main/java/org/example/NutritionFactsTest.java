package org.example;

/**
 * Created by ainacio on Dec, 2023
 */
public class NutritionFactsTest {

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola.getCalories());
    }
}
