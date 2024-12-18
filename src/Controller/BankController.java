package Controller;

import View.BankView;
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


}
