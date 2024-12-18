package service.service_interface;

import model.BankAccount;

public interface BankService {

    void addAccount(BankAccount newAccount);

    void displayAccounts();

    boolean check(String accountToCheck);
    
    BankAccount getAccountInf (String accountToCheck);

    void updateAccountInf(BankAccount bankAccount, BankAccount updateAccount);
}
