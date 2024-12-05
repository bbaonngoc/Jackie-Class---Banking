

public class Main {
    public static void main(String[] args) {

        // Tao cac tai khoan ngan hang mau
        // khai bao objects bankAccount

        BankAccount newAccount1 = new BankAccount("07042005", "Olevia", 15000000, "Saving");
        BankAccount newAccount2 = new BankAccount("06052005", "Oggy", 15000000, "Saving");
        BankAccount newAccount3 = new BankAccount("20062004", "Jack", 0.000, "Saving");
        BankAccount newAccount4 = new BankAccount("01112005", "Bob", 10.000, "Saving");

        Bank bank = new Bank();
        bank.addAccount(newAccount1);
        bank.addAccount(newAccount2);
        bank.addAccount(newAccount3);
        bank.addAccount(newAccount4);

        BankService bankService = new BankService();

        // Gui tien vao tai khoan
        bankService.deposit(newAccount4, 2000);
        bankService.deposit(newAccount3, 500000);
        System.out.println("---------------");

        // Rut tien tu tai khoan
        bankService.withdraw(newAccount1, 2000000);
        bankService.withdraw(newAccount2, 3000);
        System.out.println("---------------");

        // Chuyen tien
        bankService.transfer(newAccount1, newAccount3, 1000000);
        System.out.println("---------------");

        // Kiem tra so du
        System.out.println("So du tai khoan: " +  bankService.checkBalance(newAccount3));
        System.out.println("---------------");

        // Hien thi danh sach tai khoan
        bank.listAccounts();
    }
}

// I'M DONE