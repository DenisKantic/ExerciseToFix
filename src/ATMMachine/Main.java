package ATMMachine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int id;
        double deposit;
        double withdraw;
        int choise;


        Scanner s = new Scanner(System.in);

        ATMClass[] atm = new ATMClass[10];

        do {
            System.out.print("Enter your id: ");
            id = s.nextInt();

            if (isValidId(id, atm)) {

                do {
                    choise = displayMainMenu(s);
                    if (isTransaction(choise)) {
                        executeTransaction(choise, atm, id, s);

                    }
                }

                while (choise != 4); // if 4 , exit to main menu.

            } else {
                System.out.println("Please enter valid id.");
            }
        }

        while (true);

    }

    public static boolean isValidId(int id, ATMClass[] atm) {

        for (int i = 0; i < atm.length; i++) {
            if (id == atm[i].getId()) {
                return true;
            }
        }

        return false;
    }

    public static int displayMainMenu(Scanner s) {

        System.out.print("Welcome to the ATM." +
                "\n1. check balance" +
                "\n2. withdraw" +
                "\n3. deposit" +
                "\n4. exit");

        return s.nextInt();
    }

    public static boolean isTransaction(int choise) {

        return choise > 0 && choise < 5;
    }

    public static void executeTransaction(int choise, ATMClass[] atm, int id, Scanner s) {

        switch (choise) {

            case 1:
                System.out.print("Your current balance is: " + atm[id].getBalance());
                break;

            case 2:
                System.out.print("Enter an amount to withdraw: ");
                atm[id].withdrawMethod(s.nextDouble());
                break;

            case 3:
                System.out.print("Enter an amount to deposit: ");
                atm[id].depositMethod(s.nextDouble());
                break;

            default:

                System.out.println("Please enter valid choise.");
        }
    }
}

