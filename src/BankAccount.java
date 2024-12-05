public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BankAccount() {}
    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    private void display (String message) {
        System.out.println(message);
    }

    private String getFormattedValue (double value) {   // EP DAU EP MO, AI NO EP KIEU
        return String.format("%.0f", value);
    }

    final double minLimit= 5000;
    public void deposit (double amount) {
        if(amount > minLimit) {
            this.balance += amount;
            display("Giao dịch gửi tiền của quý khách đã thành công. Số tiền:" + amount +
                    " VND. Số dư tài khoản: " + this.balance);
        } else {
            display("Số tiền gửi phải lớn hơn " + minLimit + " VND. Giao dịch không thành công.");
        }
    }

    public void withdraw (double amount) {
        if (amount > minLimit) {
            if (amount <= this.balance) {
                this.balance -= amount;
                display("Giao dịch rút tiền của quý khách đã thành công. Số tiền:" + amount +
                        " VND. Số dư tài khoản: " + this.balance);
            } else {
                display("So du khong du de thuc hien giao dich.");
            }
        } else {
            display("Số tiền rút phải lớn hơn " + minLimit + " VND. Giao dịch không thành công.");
        }
    }

    public double checkBalance () {
        return this.balance;
    }

    public void getAccountInfo () {
        display("So tai khoan: " + this.accountNumber + "\n"
                + "Chu tai khoan: " + this.accountHolderName + "\n"
                + "So du kha dung: " + getFormattedValue(this.balance) + "\n"
                + "Loai tai khoan: " + this.accountType + "\n"
                + "-----------------"
        );
    }
}

