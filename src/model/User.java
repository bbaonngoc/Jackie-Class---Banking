package model;

import java.util.ArrayList;
import java.util.List;

//lop MO HINH DU LIEU dai dien cho doi tuong nguoi dung
// -> luu tru thong tin nguoi dung + getter & setter & toString: de doc khi can in thong tin
public class User {
    private String userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    // constructor
    public User (){}
    public User(String userId, String userName, String email, String phoneNumber, List<BankAccount> bankAccounts) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankAccounts = bankAccounts;
    }

    // getter & setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNUmber) {
        this.phoneNumber = phoneNUmber;
    }

    public List<BankAccount> getBankAccount() {
        return bankAccounts;
    }

    public void setBankAccount(List<BankAccount> bankAccount) {
        this.bankAccounts = bankAccount;
    }

    @Override   //toString
    public String toString() {
        return "model.User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankAccounts=" + bankAccounts +
                '}';
    }

}
