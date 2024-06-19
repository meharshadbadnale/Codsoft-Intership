import java.util.Scanner;
 
class Task3Atminterface {
    private double balance;
      
    public  Task3Atminterface(double initialBalance) {
      this.balance = initialBalance;
    }
    public double getBalance() {
      return balance;
    }
    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + "successful. current balance: $" + balance);
        }
        else {
            System.out.println("Invalid deposit amount. ");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("withdraw of $" + amount + "successful. Current balance: $" + balance);
        }
        else {
            System.out.println("Invalid withdraw amount or insufficient balance. ");
        }
    }
}
class ATM {
    private Task3Atminterface bankAccount;

    public ATM(Task3Atminterface bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void displayMenu() {
        System.out.println("ATM Menu ");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice,Scanner scanner) {
        switch(choice) {
            case 1:
              System.out.println("current balacne: $" + bankAccount.getBalance());
              break;
            case 2:
              System.out.println("Enter deposit amount: $");
              double depositAmount = scanner.nextDouble();
              bankAccount.deposit(depositAmount);
              break;
            case 3:
              System.out.println("Enter withdraw amount: $");
              double withdrawlAmount = scanner.nextDouble();
              bankAccount.withdraw(withdrawlAmount);
              break;
            case 4:
              System.out.println("Exiting ATM. Thank you!");
              scanner.close();
              System.exit(0);
            default:
              System.out.println("Invalid choice. please select a valid option.");
        }
    }
}  
class ATM_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();
        Task3Atminterface bankAccount = new Task3Atminterface(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("select an option: ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }

    }
}
