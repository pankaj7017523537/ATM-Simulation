import java.util.*;

class BankAccount {
    private String accountNumber;
    private double balance;
    private String pin;

    public BankAccount(String accountNumber, double balance, String pin){
      this.accountNumber = accountNumber;
      this.pin = pin;
      this.balance = balance;
}

public boolean validatePin(String enteredPin){
    return pin.equals(enteredPin);
}

public double getBalance(){
    return balance;
}

public void deposit(double amount){
    balance += amount;
}

public boolean withdraw(double amount){
    if (amount <= balance) {
        balance -= amount;
        return true;
    } else {
        System.out.println("Insufficient balance");
        return false;
    }
}
}

public class ATM {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BankAccount account = new BankAccount( "1234567890", 10000, "1234");
    System.out.println("Wlcome to the ATM");

    // ATM Loop

    while (true) {
        System.out.println("Enter your PIN");
        String enteredPin = scanner.nextLine();

        if (account.validatePin(enteredPin)) {
            System.out.println("PIN  validated successfully");
            break;
        } else{
            System.out.println("Invalid PIN.please try again.");
        }
    }

    // Main Menu

    while (true) {
        System.out.println("\nATM Main Menu");
        System.out.println("1. chack the Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("Please select an option:");
        int option = scanner.nextInt();

        switch(option){
            case 1:
            System.out.println("your balance is:" +account.getBalance());
            break;

            case 2:
            System.out.println("Enter amount to deposit:");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Deposit successfully. New balance: " + account.getBalance());
            break;

            case 3:
            System.out.println("Enter amount to withdraw:");
            double withdrawAmount = scanner.nextDouble();
            if (account.withdraw(withdrawAmount)) {
                System.out.println("Withradraw successful. New balnce:" + account.getBalance());
                
            }
            break;

            case 4:
            System.out.println("Thank you for using ATM!");
            scanner.close();
            return;

            default:
            System.out.println("Invalid option. Please try again.");
        }
    }
}
    
}