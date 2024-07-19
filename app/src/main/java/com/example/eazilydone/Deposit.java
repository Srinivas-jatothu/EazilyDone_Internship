package com.example.eazilydone;

public class Deposit {
    private String formName;
    private int depositAmount;

    public Deposit(String formName, int depositAmount) {
        this.formName = formName;
        this.depositAmount = depositAmount;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }
}
