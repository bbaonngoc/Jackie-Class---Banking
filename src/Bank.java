import java.util.ArrayList;
import java.util.List;
public class Bank {
    private List<BankAccount> accounts = new ArrayList<>(); //truong cua Bank - chua tat ca tai khoan

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public Bank() {}
    public Bank(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    private void display (String message) {
        System.out.println(message);
    }

    public void addAccount (BankAccount newAccount) {
        accounts.add(newAccount);
    }

    public BankAccount findAccount (String accountToFind) {
        for (BankAccount bankAccount : accounts) {
            if (accountToFind == bankAccount.getAccountNumber()) {
                return bankAccount;
            }
        }
        display("Khong tim thay tai khoan nao trung khop!");
        return null;
    }

    public void removeAccount (String accountToRemove) {
        for (BankAccount bankAccount : accounts) {
            if (accountToRemove == bankAccount.getAccountNumber()) {
                this.accounts.remove(bankAccount);
            }
        }
        display("Tai khoan khong ton tai!");
    }

    public void listAccounts () {
        for (BankAccount bankAccount : accounts) {
            bankAccount.getAccountInfo();
        }
    }


}
