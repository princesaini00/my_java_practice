public class BankAccountDemo {
    public static void main(String[] args) {
        //creating a new bank account with initial balance of 10,000
        BankAccount account = new BankAccount(10000);

        //Creating two users trying to withdraw some money at the same time
        //using lambda expression to represent the void run() method 
        Thread withdraw_User_1 = new Thread(() -> account.withdrawMoney("Marie", 8000));
        Thread withdraw_User_2 = new Thread(() -> account.withdrawMoney("Bob", 9000));

        //Creating two users trying to deposit some money at the same time
        Thread deposit_User_1 = new Thread(() -> account.depositMoney("Bob", 2000));
        Thread deposit_User_2 = new Thread(() -> account.depositMoney("Marie", 500));
        
        //starting all threads
        withdraw_User_1.start();
        withdraw_User_2.start();
        deposit_User_1.start();
        deposit_User_2.start();
    }
}