public class BankAccount {
    private int balance;

    //constructor to initialize the bank account
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    //synchronized withdraw method to ensure safety
    public synchronized void withdrawMoney(String user, int amount) {
        System.out.println(user + " is trying to withdraw $" + amount);

        if(balance >= amount) {
            System.out.println(user + " is allowed. Processing...");

            //Simulate some delay to show real world processing time
            try {
                Thread.sleep(1000); // Simulating time to process the withdraw
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount; //Subtracting the withdrawed money
            System.out.println(user + " successfully withdrew $" + amount);
        } 
        else {
            System.out.println(user + " cannot withdraw due to insufficient funds.");
        }

        System.out.println("Current balance: $" + balance + "\n");
    }

    //synchronized deposit method to ensure safety
    public synchronized void depositMoney(String user, int amount) {
        System.out.println(user + " is trying to deposit $" + amount);

        // Simulate some delay to show real-world processing time
        try {
            Thread.sleep(1000); // Simulating time to process the deposit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance += amount; // Adding the deposited amount
        System.out.println(user + " successfully deposited $" + amount);

        System.out.println("Current balance: $" + balance + "\n");
    }
    
}
