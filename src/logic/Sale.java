package logic;

import java.util.concurrent.locks.ReentrantLock;

import Controller.Transaction;

public class Sale extends Transaction {
	static double payment;

    public Sale(double sPayment) {
        payment = sPayment;
    }

    @Override
    public void run() {
        double change = 0.0;
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            if (payment < Order.total) {
                System.out.println("Not enough money");
            } else {

                change = payment - Order.total;
                for (int i = 0; i < ShoppingCart.cart.size(); i++) {
                    for (int j = 0; j < Inventory.inventory.size(); j++) {
                        if (ShoppingCart.cart.get(i).code == Inventory.inventory.get(j).code) {
                            Inventory.inventory.remove(j);
                        }
                    }

                }
                System.out.println("your change is: " + change);
            }
        } finally {
            lock.unlock();
        }
    }

}
