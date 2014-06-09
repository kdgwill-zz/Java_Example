package com.BOA.ATM;

/**
 * This Class will represent a user's account
 * It will contain all of the needed information that a banking account would typically have
 * @author Kyle D. Williams
 */
public class Account {

    private float checkingAccount = 0;
    private float savingsAccount = 0;
    private int accountNumber;
    private int pinNumber;

    /**
     * This overloaded function is created
     * @param aNum    the account number
     * @param pNum    the pin number
     */
    public Account(int aNum, int pNum) {
        accountNumber = aNum;
        pinNumber = pNum;
    }

    /**
     * This overloaded function is created only for testing purposes
     * @param aNum    the account number
     * @param pNum    the pin number
     * @param cA        the initial checking account balance
     * @param sA        the initial savings account balance
     */
    public Account(int aNum, int pNum, int sA, float cA) {
        this(aNum, pNum);
        savingsAccount = sA;
        checkingAccount = cA;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumer() {
        return accountNumber;
    }

    /**
     * @return the PinNumber
     */
    public int getPin() {
        return pinNumber;
    }

    /**
     * @return the savingsAccount
     */
    public float getSavings() {
        return savingsAccount;
    }

    /**
     * @param sav the amount to deposit to the savings
     */
    public void depositToSavings(float sav) {
        this.savingsAccount += sav;
    }

    /**
     * @param sav the amount to withdraw from the savings
     */
    public void withdrawFromSavings(float sav) {
        this.savingsAccount -= sav;
    }

    /**
     * @return the checkingAccount
     */
    public float getChecking() {
        return checkingAccount;
    }

    /**
     * @param chck the amount to deposit to the checking account
     */
    public void depositToChecking(float chck) {
        checkingAccount += chck;
    }

    /**
     * @param chck the amount to withdraw from the checking account
     */
    public void withdrawFromChecking(float chck) {
        checkingAccount -= chck;
    }
}
