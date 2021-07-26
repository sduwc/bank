package com.bank;

public class User {
    private String userName;
    private String cardId;
    private String cardPwd;
    private String call;
    private double account;

    public User(String userName, String cardId, String cardPwd, String call, double account) {
        this.userName = userName;
        this.cardId = cardId;
        this.cardPwd = cardPwd;
        this.call = call;
        this.account = account;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardPwd() {
        return cardPwd;
    }

    public void setCardPwd(String cardPwd) {
        this.cardPwd = cardPwd;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
