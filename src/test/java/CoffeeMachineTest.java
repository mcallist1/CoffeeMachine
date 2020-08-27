import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMachineTest {


    public static final double DELTA = 0.00001;

    @Test
    public void should_create_coffee_machine_with_no_money_inside() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Assert.assertNotNull(coffeeMachine);
        Assert.assertEquals(0.0, coffeeMachine.getBalance(), DELTA);

    }

    @Test
    public void should_increase_balance_when_one_euro_coin_is_inserted() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.EURO);

        Assert.assertEquals(1.0, coffeeMachine.getBalance(), DELTA);

    }

    @Test
    public void should_increase_balance_when_50cent_coin_is_inserted() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.FIFTY_CENT);

        Assert.assertEquals(0.5, coffeeMachine.getBalance(), DELTA);

    }

    @Test
    public void should_increase_balance_when_2Euro_coin_is_inserted() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.TWO_EURO);

        double balance = coffeeMachine.getBalance();

        Assert.assertEquals(2.0, balance, DELTA);

    }


    @Test
    public void should_accumulate_balance_when_two_coins_added_in_succession() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.FIFTY_CENT);
        coffeeMachine.insertCoin(Coin.EURO);
        coffeeMachine.insertCoin(Coin.EURO);

        Assert.assertEquals(2.5, coffeeMachine.getBalance(), DELTA);

    }

    @Test
    public void should_return_money_on_reset_command() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.FIFTY_CENT);

        coffeeMachine.reset();

        Assert.assertEquals(0.0, coffeeMachine.getBalance(), DELTA);

    }


    @Test
    public void should_return_coffee_if_enough_money_inserted() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.EURO);

        boolean success = coffeeMachine.makeCoffee();

        Assert.assertTrue(success);

    }


    @Test
    public void should_not_return_coffee_if_not_enough_money_inserted() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        boolean success = coffeeMachine.makeCoffee();

        Assert.assertFalse(success);

    }

    @Test
    public void should_give_one_euro_change_when_2_euro_provided() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.TWO_EURO);
        coffeeMachine.makeCoffee();

        Assert.assertEquals(1.0, coffeeMachine.getChange(), DELTA);

    }

    @Test
    public void should_give_three_euro_change_when_4_euro_provided() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.insertCoin(Coin.TWO_EURO);
        coffeeMachine.insertCoin(Coin.TWO_EURO);
        coffeeMachine.makeCoffee();

        Assert.assertEquals(3.0, coffeeMachine.getChange(), DELTA);

    }


    @Test
    public void should_give_2_euro_change_when_buying_2_coffees() {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin(Coin.TWO_EURO);
        coffeeMachine.insertCoin(Coin.TWO_EURO);

        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();

        Assert.assertEquals(2.0, coffeeMachine.getChange(), DELTA);

    }

}