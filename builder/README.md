# Builder Pattern
To encapsulate the construction of a product and allow it to be constructed in steps.

The builder pattern is a good choice when designing classes whose constructor or static factories would have more than
a handful of parameters, especially if many of the parameters are optional or identical type. More than 4 it would be enough to use.

Problem: A JavaBean may be in an inconsistent state partway through its construction. Another example is telescoping constructor, is hard
to write client code when there are many parameters, and harder still to read it.

The builder is typically a static member class of the class it builds.
```
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private int servingSize;
        private int servings;
        private int calories = 0;
        private int fat = 0;
        
        ...
        
         public Builder sodium(int val){
            sodium = val;
            return this;
        }
    
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }
    
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
     private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
    
}
```

# Covariant return typing
It allows clients to use these builders without the need for casting.

Build method in each subclass's builder is declared to return the correct subclass: the build method
of NyPizza.Builder return NyPizza, while the one in Calzone.Builder return Calzone.
```
NyPizza nyPizza = new NyPizza.Builder(LARGE).addTopping(SAUSAGE).addTopping(ONION).build();
Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
```
This technique, wherein a subclass method is declared to return a subtype of the return type declared in the super-class, is known as
_covariant return typing_


