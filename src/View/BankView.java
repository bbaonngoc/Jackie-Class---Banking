package View;

import Controller.BankController;
import model.BankAccount;
import service.BankServiceImpl;
import service.service_interface.BankService;

import java.util.Scanner;

public class BankView {

    // injection
    private final BankController bankController;

    public BankView() {
        BankService bankService = new BankServiceImpl(); // tinh da hinh
        this.bankController = new BankController(bankService);
    }

    public void mainViewDisplay() {
        boolean check = true;
        while (check) {
            displayHomeMenu();
            int choose = getUserChoice(0, 2); // Giới hạn input từ 0 đến 2

            switch (choose) {
                case 1:
                    menuBank();
                    break;
                case 2:
                    displayUserMenu();
                    break;
                case 0:
                    check = false;
                    break;
            }
        }
    }

    private void displayHomeMenu() {
        System.out.println("========== HOME MENU ==========");
        System.out.println("1. Menu Bank");
        System.out.println("2. Menu User");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void menuBank() {
        boolean check = true;
        while (check) {
            displayBankMenu();
            int choose = getUserChoice(0, 5); // Giới hạn input từ 0 đến 5

            switch (choose) {
                case 1:
                    BankAccount newAccount = inputAccountInformation();
                    bankController.addAccount(newAccount);
                    break;
                case 2:
                    // nhap stk can thay doi
                    BankAccount bankAccount = null;

                    while (bankAccount == null) {
                        System.out.println("Nhap so tai khoan can update: ");
                        Scanner scanner = new Scanner(System.in);
                        String accountToFind = scanner.nextLine();
                        bankAccount = bankController.getAccountInf(accountToFind);
                    }
                    System.out.println(bankAccount);
                    // goi ham update
                    BankAccount updateAccount = updateAccount();
                    bankController.updateAccountInf(bankAccount, updateAccount);

                    break;
                case 3:
                    System.out.println("Remove account selected");
                    break;
                case 4:
//                    System.out.println("Get account information selected");

                    break;
                case 5:
                    bankController.displayAccounts();
                    break;
                case 0:
                    check = false;
                    break;
            }
        }
    }

    private void displayBankMenu() {
        System.out.println("\n========== MENU BANK ==========");
        System.out.println("1. Add account");
        System.out.println("2. Update account");
        System.out.println("3. Remove account");
        System.out.println("4. Get account information");
        System.out.println("5. Display accounts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void displayUserMenu() {
        System.out.println("\n========== MENU USER ==========");
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Remove User");
        System.out.println("4. Display User Info");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");

        // Tương tự logic menuBank có thể được thêm vào ở đây
    }

    private int getUserChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            }
            System.out.print("Invalid input. Please choose again: ");
            scanner.nextLine(); // Xóa bộ nhớ đệm để tránh lặp vô hạn
        }
    }

    private BankAccount inputAccountInformation () {
        BankAccount bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin nguoi dung");
        System.out.print("So tai khoan: ");
        bankAccount.setAccountNumber(scanner.nextLine());
        System.out.print("Ten chu tai khoan: ");
        bankAccount.setAccountHolderName(scanner.nextLine());
        return bankAccount;
    }

    private BankAccount updateAccount () {
        BankAccount newAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin nguoi dung");
        System.out.print("So tai khoan: ");
        newAccount.setAccountNumber(scanner.nextLine());
        System.out.print("Ten chu tai khoan: ");
        newAccount.setAccountHolderName(scanner.nextLine());
        System.out.print("Loai tai khoan: ");
        newAccount.setAccountType(scanner.nextLine());
        return newAccount;
    }

}
