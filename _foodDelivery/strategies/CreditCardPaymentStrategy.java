package strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPaymentStrategy(String card) {
        this.cardNumber = card;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid \u20B9" + amount + " using Credit Card (" + cardNumber + ")");
        return true;
    }
}