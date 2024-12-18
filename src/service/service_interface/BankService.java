package service.service_interface;

import model.BankAccount;

public interface BankService {

    void addAccount(BankAccount newAccount);

    void displayAccounts();

    void deposit(BankAccount bankAccount, double amount);
}
