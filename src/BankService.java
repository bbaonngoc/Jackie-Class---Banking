public class BankService {

    private void display (String message) {
        System.out.println(message);
    }

    final double minLimit = 5000;
    private String getFormattedValue (double value) {   // EP DAU EP MO, AI NO EP KIEU
        return String.format("%.0f", value);
    }

    public void deposit(BankAccount bankAccount, double amount) {
        if (amount > minLimit) {
            double totalMoney = bankAccount.getBalance() + amount;
            bankAccount.setBalance(totalMoney);
            display("Giao dich gui tien thanh cong! So du: " + getFormattedValue(totalMoney));
        } else {
            display("So tien gui phai lon hon 5000");
        }
    }

    public void withdraw (BankAccount bankAccount, double amount) {
        if (amount > minLimit) {
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

    public void transfer (BankAccount bankAccountS, BankAccount bankAccountT, double amount) {
        if (amount > minLimit) {
            if (amount < bankAccountS.getBalance()) {
                double sMoney = bankAccountS.getBalance() - amount;
                bankAccountS.setBalance(sMoney);

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

    public double checkBalance (BankAccount bankAccount) {
        return bankAccount.checkBalance();
    }

}
