package service;

import file_handles.FileUtil;
import model.BankAccount;
import service.service_interface.BankService;
import temp_store.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
    Bank banks = new Bank();
    BankAccount bankAccount = new BankAccount();
    private List<BankAccount> accounts = new ArrayList<>();

    private final FileUtil<BankAccount> fileBankAccount = new FileUtil<>("banks_accounts.txt");


    // Declare
    private final double MIN_LIMIT = 5000;

    private String getFormattedValue (double value) {
        return String.format("%.0f", value);
    }    //ep kieu

    private void display(String message) {
        System.out.println(message);
    }   //display

    @Override
    public void addAccount(BankAccount newAccount) {
        newAccount.setAccountType("Saving");
        newAccount.setBalance(0.0);
        fileBankAccount.writeObjectToFile(newAccount);
    }


    @Override
    public void displayAccounts() {
        List<BankAccount> temp = fileBankAccount.readObjectsFromFile();
        for (BankAccount bankAccount : temp) {
            System.out.println(bankAccount);
        }
    }

    @Override
    public boolean check (String accountToCheck) {
        List<BankAccount> temp = fileBankAccount.readObjectsFromFile();
        for (BankAccount bankAccount : temp) {
            if (accountToCheck.equals(bankAccount.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BankAccount getAccountInf (String accountToCheck) {
        if (!check(accountToCheck)) {
            System.out.println("Account not found!");
            return null;
        }
        List<BankAccount> temp = fileBankAccount.readObjectsFromFile();
        for (BankAccount bankAccount : temp) {
            if (accountToCheck.equals(bankAccount.getAccountNumber())) {
                return bankAccount;
            }
        }
        return null;
    }

    @Override
    public void updateAccountInf(BankAccount bankAccount, BankAccount updateAccount) {
        updateAccount.setBalance(bankAccount.getBalance());
        // giu nguyen so du
        fileBankAccount.updateObjectInFile(bankAccount, updateAccount);
    }

    public BankAccount findAccount(String accountToFind) {
        for (BankAccount bankAccount : accounts) {
            if (accountToFind == bankAccount.getAccountNumber()) {
                return bankAccount;
            }
        }
        display("Khong tim thay tai khoan nao trung khop!");
        return null;
    }

    public void removeAccount(String accountToRemove) {
        for (BankAccount bankAccount : accounts) {
            if (accountToRemove == bankAccount.getAccountNumber()) {
                this.accounts.remove(bankAccount);
                return;
            }
        }
        display("Tai khoan khong ton tai!");
    }


    public double checkBalance (BankAccount bankAccount) {
        return bankAccount.getBalance();
    }

    public void getAccountInfo () {
        display("So tai khoan: "  + "\n"
                + "Chu tai khoan: " + bankAccount.getAccountNumber() + "\n"
                + "So du kha dung: " + getFormattedValue(bankAccount.getBalance()) + "\n"
                + "Loai tai khoan: " + bankAccount.getAccountType() + "\n"
                + "-------------------"
        );
    }

    public void deposit(BankAccount bankAccount, double amount) {
        // danh sach cac tai khoan o tempstore
        List<BankAccount> bankAccounts = banks.getAccounts();

        if (amount < MIN_LIMIT) {
            System.out.println("Tien gui phai lon hon " + MIN_LIMIT);
            return;
        }

        // Tai khoan ton tai
        for (BankAccount b : bankAccounts) {
            if(b.equals(bankAccount)) {
                b.setBalance(b.getBalance() + amount);
                return;
            }
        }

        System.out.println("Account Not Found");
    }

    public void withdraw (BankAccount bankAccount, double amount) {
        if (amount > MIN_LIMIT) {
            if (amount < bankAccount.getBalance()) {
                double finalMoney = bankAccount.getBalance() - amount;
                bankAccount.setBalance(finalMoney);
                display("Giao dich rut tien thanh cong! So du: " + getFormattedValue(finalMoney));
            } else {
                display("So du khong du de thuc hien giao dich!");
            }
        } else {
            display("So tien rut phai lon hon 5000");
        }
    }

    public void transfer (BankAccount bankAccounts, BankAccount bankAccountT, double amount) {
        if (amount > MIN_LIMIT) {
            if (amount < bankAccounts.getBalance()) {
                double sMoney = bankAccounts.getBalance() - amount;
                bankAccounts.setBalance(sMoney);

                double tMoney = bankAccountT.getBalance() + amount;
                bankAccountT.setBalance(tMoney);
                display("Chuyen tien thanh cong! " + "\n"
                        + "So tien: " + getFormattedValue(amount) + "\n"
                        + "So du: " + getFormattedValue(sMoney));
            } else {
                display("So du khong du de thuc hien giao dich");
            }
        } else {
            display("So tien gui phai lon hon 5000");
        }
    }

}
