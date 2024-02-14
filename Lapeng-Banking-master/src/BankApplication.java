import java.util.Scanner;

// Superclass
abstract class BasicAccount {
    String name;
    double balance;
    String pin;

    // Constructor
    public BasicAccount(String name) {
        this.name = name;
        this.balance = 0.0;
        // You might want to generate a pin or provide some default value for pin here
    }

    // Common Methods
    void createAccount() {
        System.out.println("Account created for: " + name);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: R" + amount);
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: R" + amount);
    }

    double getBalance() {
        return balance;
    }

    String getName() {
        return name;
    }

    boolean isValidPin(String enteredPin) {
        // You might want to implement pin validation logic here
        // For simplicity, I'm not modifying this part in the example
        return pin.equals(enteredPin);
    }

    double computeFees() {
        return 0;
    }
}


// Regular Account
class RegularAccount extends BasicAccount {
    double minimumBalance;
    double penalty;

    // Constructor
    public RegularAccount(String name, double balance, String pin, double minimumBalance, double penalty) {
        super(name);
        this.minimumBalance = minimumBalance;
        this.penalty = penalty;
    }

    // Override computeFees for Regular Account
    @Override
    double computeFees() {
        double fees = super.computeFees();
        if (balance < minimumBalance) {
            fees += penalty;
        }
        return fees;
    }
}

// Interest Account
class InterestAccount extends BasicAccount {
    double yearlyInterest;

    // Constructor
    public InterestAccount(String name, double balance, String pin, double yearlyInterest) {
        super(name);
        this.yearlyInterest = yearlyInterest;
    }
}

// Checking Account
class CheckingAccount extends InterestAccount {
    int transactions;

    // Constructor
    public CheckingAccount(String name, double balance, String pin, double yearlyInterest, int transactions) {
        super(name, balance, pin, yearlyInterest);
        this.transactions = transactions;
    }
}

// CD Account
class CDAccount extends InterestAccount {
    double penalty;
    int months;

    // Constructor
    public CDAccount(String name, double balance, String pin, double yearlyInterest, double penalty, int months) {
        super(name, balance, pin, yearlyInterest);
        this.penalty = penalty;
        this.months = months;
    }

    // Override computeFees for CD Account
    @Override
    double computeFees() {
        double fees = super.computeFees();
        if (months < 12) {
            fees += penalty;
        }
        return fees;
    }
}

public class BankApplication {
    public static void main(String[] args) {

        System.out.println("Create Account : ");
        System.out.println("Choose Account Type from {Regular_Account, Check_Account, Interest_Account, CD_Account} ");
        Scanner scanner = new Scanner(System.in);
        String account_type = scanner.nextLine();
        String name;
        String pin;
        Double deposit;
        Double withdraw;

        if(account_type.equals("Regular_Account")){
            System.out.println("Enter Name : ");
            name = scanner.nextLine();
            System.out.println("Enter Pin");
            pin = scanner.nextLine();
            RegularAccount regularAccount = new RegularAccount(name, 0.0, pin, 0.0, 0.0);
            regularAccount.createAccount();
            System.out.println("How much do you wanna deposit : ");
            deposit = scanner.nextDouble();
            regularAccount.deposit(deposit);
            System.out.println("Do you wanna withdraw?yes or No? ");
            scanner.nextLine();
            String yes = scanner.nextLine();
            if(yes.equals("yes")){
                System.out.println("Enter Amount you wanna withdraw: ");
                withdraw = scanner.nextDouble();
                regularAccount.withdraw(withdraw);

            }
            else{
                System.out.println("ok ");
            }
            System.out.println("Balance: R" + regularAccount.getBalance());
            System.out.println("Fees: R" + regularAccount.computeFees());

        }

        if(account_type.equals("Check_Account")){
            System.out.println("Enter Name : ");
            name = scanner.nextLine();
            System.out.println("Enter Pin");
            pin = scanner.nextLine();
            CheckingAccount checkingAccount = new CheckingAccount(name, 0.0,pin, 7.0, 3);
            checkingAccount.createAccount();
            System.out.println("How much do you wanna deposit : ");
            deposit = scanner.nextDouble();
            checkingAccount.deposit(deposit);
            System.out.println("Do you wanna withdraw?yes or No? ");
            scanner.nextLine();
            String yes = scanner.nextLine();
            if(yes.equals("yes")){
                System.out.println("Enter Amount you wanna withdraw: ");
                withdraw = scanner.nextDouble();
                checkingAccount.withdraw(withdraw);

            }
            else{
                System.out.println("ok ");
            }
            System.out.println("Balance: R" + checkingAccount.getBalance());
            System.out.println("Fees: R" + checkingAccount.computeFees());

        }

        if(account_type.equals("Interest_Account")){
            System.out.println("Enter Name : ");
            name = scanner.nextLine();
            System.out.println("Enter Pin");
            pin = scanner.nextLine();
            InterestAccount interestAccount = new InterestAccount(name, 0.0,pin, 7.0);
            interestAccount.createAccount();
            System.out.println("How much do you wanna deposit : ");
            deposit = scanner.nextDouble();
            interestAccount.deposit(deposit);
            System.out.println("Do you wanna withdraw?yes or No? ");
            scanner.nextLine();
            String yes = scanner.nextLine();
            if(yes.equals("yes")){
                System.out.println("Enter Amount you wanna withdraw: ");
                withdraw = scanner.nextDouble();
                interestAccount.withdraw(withdraw);

            }
            else{
                System.out.println("ok ");
            }
            System.out.println("Balance: R" + interestAccount.getBalance());
            System.out.println("Fees: R" + interestAccount.computeFees());

        }

        if(account_type.equals("CD_Account")){
            System.out.println("Enter Name : ");
            name = scanner.nextLine();
            System.out.println("Enter Pin");
            pin = scanner.nextLine();
            CDAccount cdAccount = new CDAccount(name, 0.0,pin, 15.0,20,6);
            cdAccount.createAccount();
            System.out.println("How much do you wanna deposit : ");
            deposit = scanner.nextDouble();
            cdAccount.deposit(deposit);
            System.out.println("Do you wanna withdraw?yes or No? ");
            scanner.nextLine();
            String yes = scanner.nextLine();
            if(yes.equals("yes")){
                System.out.println("Enter Amount you wanna withdraw: ");
                withdraw = scanner.nextDouble();
                cdAccount.withdraw(withdraw);

            }
            else{
                System.out.println("ok ");
            }
            System.out.println("Balance: R" + cdAccount.getBalance());
            System.out.println("Fees: R" + cdAccount.computeFees());

        }


    }
}
