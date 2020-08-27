public enum Coin {
    EURO(1.0),
    FIFTY_CENT(0.5),
    TWO_EURO(2.0);

    private double value;

    public double getValue() {
        return value;
    }

    private Coin(double value) {
        this.value = value;
    }

}
