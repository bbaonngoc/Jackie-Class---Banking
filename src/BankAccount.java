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
    public void deposit (double amount) {
        final double minDeposit= 5.000;
        if(amount > minDeposit) {
            this.balance += amount;
            display("Giao dịch gửi tiền của quý khách đã thành công. Số tiền:" + amount +
                    " VND. Số dư tài khoản: " + this.balance);
        } else {
            display("Số tiền gửi phải lớn hơn " + minDeposit + " VND. Giao dịch không thành công.");
        }
    }

    public void withdraw (double amount) {
        final double minWithdraw= 5.000;
        if (amount > minWithdraw) {
            this.balance -= amount;
            display("Giao dịch rút tiền của quý khách đã thành công. Số tiền:" + amount +
                    " VND. Số dư tài khoản: " + this.balance);
        } else {
            display("Số tiền rút phải lớn hơn " + minWithdraw + " VND. Giao dịch không thành công.");
        }
    }

    public double checkBalance () {
        return this.balance;
    }

    public void getAccountInfo () {
        display("So tai khoan: " + this.accountNumber + "\n"
                + "Chu tai khoan: " + this.accountHolderName + "\n"
                + "So du kha dung: " + this.balance + "\n"
                + "Loai tai khoan: " + this.accountType
        );
    }
}

