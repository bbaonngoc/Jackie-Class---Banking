package Controller;

import model.BankAccount;
import service.service_interface.BankService;

public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    public void addAccount (BankAccount newAccount) {
        bankService.addAccount(newAccount);
    }

    public void displayAccounts () {
        bankService.displayAccounts();
    }

    public boolean check (String accountToCheck) {
        return bankService.check(accountToCheck);
    }

    public BankAccount getAccountInf (String accountToCheck) {
        return bankService.getAccountInf(accountToCheck);
    }

    public void updateAccountInf(BankAccount bankAccount, BankAccount updateAccount) {
        bankService.updateAccountInf(bankAccount, updateAccount);
    }
}
