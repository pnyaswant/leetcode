package dp.structural.decorator;


public class DecoratorPattern {
    public static void main(String args[]) {
        CheesePizza pizza = new CheesePizza();
        TomatoBusterPizza tomatoBusterPizza = new TomatoBusterPizza(pizza);
        PepperoniBusterPizza pepperoniBusterPizza = new PepperoniBusterPizza(tomatoBusterPizza);

        System.out.println(pepperoniBusterPizza.getCost());
        System.out.println(pepperoniBusterPizza.getDescription());

    }

}


abstract class Pizza {
    String description = "Unknown Pizza";

    String getDescription() {
        return description;
    }

    abstract int getCost();

}

class CheesePizza extends Pizza {

    @Override
    String getDescription() {
        return "Cheese Pizza";
    }

    @Override
    int getCost() {
        return 10;
    }
}

class ChickenPizza extends Pizza {

    @Override
    String getDescription() {
        return "Chicken Pizza";
    }

    @Override
    int getCost() {
        return 20;
    }
}

abstract class ToppingDecorator extends Pizza {
    abstract String getDescription();
}

class TomatoBusterPizza extends ToppingDecorator {

    Pizza pizza;

    public TomatoBusterPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    int getCost() {
        return 20 + pizza.getCost();
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Tomato";
    }

}


class PepperoniBusterPizza extends ToppingDecorator {

    Pizza pizza;

    public PepperoniBusterPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    int getCost() {
        return 30 + pizza.getCost();
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    ;
}