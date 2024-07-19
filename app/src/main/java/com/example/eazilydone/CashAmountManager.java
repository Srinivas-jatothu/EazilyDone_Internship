//package com.example.eazilydone;
//
//public class CashAmountManager {
//
//    private static CashAmountManager instance;
//    private int cashAmount;
//
//    // Private constructor to prevent instantiation outside of this class
//    private CashAmountManager() {
//        // Initialize with a default or initial amount
//        this.cashAmount = 10023;  // Example initial amount
//    }
//
//    // Singleton pattern to ensure only one instance of CashAmountManager exists
//    public static CashAmountManager getInstance() {
//        if (instance == null) {
//            instance = new CashAmountManager();
//        }
//        return instance;
//    }
//
//    // Method to get the current cash amount
//    public int getCashAmount() {
//        return cashAmount;
//    }
//
//    // Method to update the cash amount
//    public void setCashAmount(int cashAmount) {
//        this.cashAmount = cashAmount;
//    }
//
//    // Method to increment the cash amount
//    public void incrementCashAmount(int incrementBy) {
//        cashAmount += incrementBy;
//    }
//}



package com.example.eazilydone;

public class CashAmountManager {

    private static CashAmountManager instance;
    private int cashAmount;

    // Private constructor to prevent instantiation outside of this class
    private CashAmountManager() {
        // Initialize with a default or initial amount
        this.cashAmount = 10000;  // Default to 0
    }

    // Singleton pattern to ensure only one instance of CashAmountManager exists
    public static CashAmountManager getInstance() {
        if (instance == null) {
            instance = new CashAmountManager();
        }
        return instance;
    }


    // Method to get the current cash amount
    public int getCashAmount() {
        return cashAmount;
    }

    // Method to set the cash amount (accumulate instead of overwrite)
    public void setCashAmount(double cashAmount) {
        this.cashAmount += cashAmount;  // Accumulate the amount
    }

    public void subtractCashAmount(int i) {
        this.cashAmount -= i;
    }


}
