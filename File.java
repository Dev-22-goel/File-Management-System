import java.util.Scanner;
import java.util.Random;

public class File {

    public int spaceUsed;
    public String[] fileArray = new String[]{
            "Hello world, this is what I have inside my file ",
            "Hi I am Dev",
            "I use chrome",
            "CSU East Bay is in Hayward,CA",
            "Let's work together"
    };
    Scanner input;
    private int[] SIZE;
    private String[] Name;
    private int[] fileNum;
    private String[] text;
    private int numOfFile;

    public int UsedSpace(int i)
    {
        return this.spaceUsed; //50
    }

    public int ExcessSpace(int i)
    {
        return this.SIZE[i]; //600
    }

    File() {                             // Class constructor
        input = new Scanner(System.in);
        SIZE = new int[20];
        Name = new String[20];
        fileNum = new int[20];
        text = new String[20];
        spaceUsed = 0;
        numOfFile = 0;

    }

    public int createFile(int count) {      // To create newfiles within the list
        System.out.println("\nPlease enter name of the file ");

        this.Name[count] = input.next();
        int space = 1000;
        int leftover=504-this.spaceUsed;
        while (space > this.spaceUsed) {
            if (leftover<0)
            {
                leftover=0;
            }
            else{
                leftover=504-this.spaceUsed;
            }


            System.out.println("There is only " + (leftover) + " Available in the file ");

            System.out.println("\nPlease enter the size of the file: ");
            this.SIZE[count] = input.nextInt();
            space = this.SIZE[count];
            break;
        }

        input.nextLine();
        System.out.println("Please enter the string that you want within the file ");
        this.text[count] = input.nextLine();


        this.spaceUsed = this.spaceUsed + SIZE[count];

        this.fileNum[count] = count;
        this.numOfFile = this.numOfFile + 1;
        return this.spaceUsed;

    }

    public void printFile() {
        for (int i = 0; i < Name.length; i++) {
            if (Name[i] == null) {
                return;
            }

            System.out.println("File number: " + this.fileNum[i]);
            System.out.println("File name: " + this.Name[i]);
            System.out.println("File Size: " + this.SIZE[i] + "\n");
        }
    }

    public void accessFile() {
            Scanner input = new Scanner(System.in);
        printFile();

        System.out.println("Which file would you like to access? (enter file number: )");
        int temp = input.nextInt();
        if (temp > this.numOfFile) {
            return;
        }


        System.out.println("File number " + this.fileNum[temp]);
        System.out.println("File Name: " + this.Name[temp]);
        System.out.println("File Size: " + this.SIZE[temp]);
        System.out.println("\n************* ");
        System.out.println("Contents of the file: " + this.text[temp]);
        System.out.println("************* \n");
        return;
    }

    public int deleteExistingFile(int count) {

        /* There are two ways to delete a file
         * Take the last element on the list and then override it with the last element
         * Illstrate the rest of the list to the certain position of the entire array
         *
         *
         * */
        int i = count;
        int size= this.SIZE[i]; //for spacing
        while (this.Name[i] != null) {

//            System.out.println(this.Name[count + 1]);
            this.Name[i] = this.Name[i + 1];
            this.SIZE[i] = this.SIZE[i + 1];
            this.text[i]=this.text[i+1];
            i++;
        }
        int temp = 0;
        i = 0;
        while (this.Name[i] != null) {
            temp = temp + this.SIZE[i];
            i++;
        }

//hashmap->key as name
//file1= size:60
//
        System.out.println("The total spaces used is " + i);

        System.out.println("The total space uses is: " + temp);

        this.spaceUsed=temp;
        return this.spaceUsed;

//        return temp;
    }

    public void createDefultFile(String name, int size, int count) {
        this.Name[count] = name;
        this.fileNum[count] = count;
        this.SIZE[count] = size;

        Random random = new Random();
        int randomInt = random.nextInt(4);
        this.text[count] = fileArray[randomInt];
//           System.out.println(this.text[count]);
        this.spaceUsed = this.spaceUsed + SIZE[count];

        return;

    }

}

