package com.bank;

public class Bank {
    public static void saveMoney(User user,double saveAmount) {
        user.setAccount(user.getAccount() + saveAmount);
    }

    public static boolean takeMoney(User user,double takeAmount) {
        double account = user.getAccount();
        if (account < takeAmount) {
            return false;
        }else {
            user.setAccount(account - takeAmount);
            return true;
        }
    }
}
