public class CoffeeMachine {

    public static final int COST_OF_COFFEE = 1;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void insertCoin(Coin coin) {
        balance += coin.getValue();
    }

    public void reset() {
        balance = 0.0;
    }

    public boolean makeCoffee() {
        if(balance >= COST_OF_COFFEE) {
            balance -= COST_OF_COFFEE;
            return true;
        }
        return false;
    }

    public double getChange() {
        return balance;
    }
}
