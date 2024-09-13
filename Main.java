public class Main {
    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(1000.00);


        ATM atm = new ATM(myAccount);


        atm.displayMenu();
    }
}


