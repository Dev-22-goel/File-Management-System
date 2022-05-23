// Devansh Goel
// 421 Project

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {


        Entity a = new Entity();

        int option = 1;

        //getting the directory input info.
        int temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like: ");
        System.out.println("1. Create a new file system from scratch: ");
        System.out.println("2. Use the defualt file system: ");
        System.out.println("Please choose your option: ");
        int i = input.nextInt();

        if (i == 2) {


            Random rand = new Random();

            String file = "testing.txt";
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter("");

            while (scanner.hasNext()) {
                int randInt = rand.nextInt(4);
                String next = scanner.next();
                int num = scanner.nextInt();
                a.defultFile(next, num, randInt);
            }
            scanner.close();
        }

//        else
//        {
//            System.out.println("Wrong input");
//            System.out.println("Safe exiting the program ");
//            return;
//        }

        a.print();                       // print the existing file within the entire file system
        System.out.println(" You have 10 directories, which would you like to access ");     // Enter the directory you would like to enter
        temp = input.nextInt();


        while (a.doesExist(option)) {
            System.out.println(" On Directory " + temp + " Please enter an option ");
            System.out.println("1. Create a new file ");                             // create a new file
            System.out.println("2. Access new Directory ");                         // Access new directory
            System.out.println("3. Deleting file in a directory");                                 // Access a file
            System.out.println("4. Print all the file within directory: ");
            System.out.println("5. Quit ");
            option = input.nextInt();

            //switch statements can function as per the user's input
            switch (option) {
                case 1:                         // Creating a new File
                    a.newFile(temp);
                    break;
                case 2:                         // Access new directory
                    a.print();                       // print the existing file within the entire file system
                    System.out.println(" You have 10 directories, which would you like to access ");     // Enter the directory you would like to enter
                    temp = input.nextInt();
                    break;
                case 3:                         // deleting a file
                    a.deletingFile(temp);
                    break;
                case 4:
                    a.openDirectory(temp);      // opening up the file
                    break;
                case 5:                         // QUIT
                    option = 11;
                    break;
                default:
                    continue;
            }
        }
    }
}

