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

            if (isValidID(id,atm)){

                do{
                    choise=displayMainMenu(s);
                }


        }
    }

    public static boolean isValidID(int id ,ATMClass[] a) {

        for (int i = 0; i < a.length; i++) {
            if (id == a[i].getId()) ;
            return true;

        }
        return false;

    }

    public static boolean isValidChoise(int choise){

            return choise > 0   && choise <5;
    }

    public static int displayMainMenu(Scanner s) {

        System.out.print("Welcome to the ATM machine." +
                "\nEnter your choise: " +
                "\n1. check balance" +
                "\n2. withdraw" +
                "\n3. deposit" +
                "\n4. exit");


        return s.nextInt();
    }


    }
}
