public class BankService {

    private void display (String message) {
        System.out.println(message);
    }

    final double minLimit = 5.000;
    public void deposit(BankAccount bankAccount, double amount) {
        if (amount > minLimit) {
            double totalMoney = bankAccount.getBalance() + amount;
            bankAccount.setBalance(totalMoney);
        } else {
            display("So tien gui phai lon hon 5000");
        }
    }

    public void withdraw (BankAccount bankAccount, double amount) {
        if (amount > minLimit) {
            double totalMoney = bankAccount.getBalance();
            bankAccount.setBalance(totalMoney);
        } else {
            display("So tien rut phai lon hon 5000");
        }
    }

    public void transfer (BankAccount bankAccountS, BankAccount bankAccountT, double amount) {
        if (amount > minLimit) {
            if (amount < bankAccountS.getBalance()) {
                double sMoney = bankAccountS.getBalance() - amount;
                bankAccountS.setBalance(sMoney);

                double tMoney = bankAccountT.getBalance() + amount;
                bankAccountT.setBalance(tMoney);
            } else {
                display("So du khong du de thuc hien giao dich");
            }
        } else {
            display("So tien gui phai lon hon 5000");
        }
    }

    public double checkBalance (BankAccount bankAccount) {
        return bankAccount.checkBalance();
    }

}
