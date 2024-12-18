package model;

import java.io.Serializable;
import java.util.Objects;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    //constructor
    public BankAccount() {}
    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    //getter & setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override    //toString
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    @Override   //equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return Double.compare(getBalance(), that.getBalance()) == 0 && Objects.equals(getAccountNumber(), that.getAccountNumber()) && Objects.equals(getAccountHolderName(), that.getAccountHolderName()) && Objects.equals(getAccountType(), that.getAccountType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getAccountHolderName(), getBalance(), getAccountType());
    }
}

