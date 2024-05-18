interface PaymentStrategy {
        void pay(float amount);
}

class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(float amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
}

class InstapayPayment implements PaymentStrategy {
        @Override
        public void pay(float amount) {
            System.out.println("Paid " + amount + " using Instapay.");
        }
}

class CashPayment implements PaymentStrategy {
        @Override
        public void pay(float amount) {
            System.out.println("Paid " + amount + " using Cash.");
        }
}

class Bill {
        private float amount;
        private PaymentStrategy paymentStrategy;

        public Bill(float amount) {
            this.amount = amount;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void pay() {
            paymentStrategy.pay(amount);
        }
}
