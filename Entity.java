
import java.net.FileNameMap;
import java.util.Scanner;

public class Entity {

    private final int SIZE = 10;                // We are going to start off with 1000 files

    Scanner input = new Scanner(System.in);
    directory root;                              // The root directory

    //Directory Class
    static class directory                       // The actual struct for the file
    {
        int a;
        directory back;
        directory forward;

        int availableSpace = 504;
        int count = 0;
        File file;

        directory() {                         // Default constructor for the stuct
            this.a = 0;
            this.back = null;
            this.forward = null;
            this.file = new File();
        }

    }



    /* Entity Class constructor for building directories */
    Entity() {
        this.root = null;
        // As soon as the program is run, we sould start off with 1000 directory
        for (int temp = 0; temp < SIZE; temp++) {
            create(temp);
        }

    }

    /* The primal focus on this is to create the original file system */
    public void create(int temp) {

        directory newFile = new directory();
        newFile.a = temp;

        directory FilePtr;


        if (root == null) {
            root = newFile;
            root.forward = null;
            root.back = null;
            return;
        }

        FilePtr = root;

        while (FilePtr.forward != null) {
            FilePtr = FilePtr.forward;
        }
        FilePtr.forward = newFile;
        FilePtr = FilePtr.forward;
        FilePtr.forward = null;

        return;

    }



    //Print out the entire list
    public void print() {

        if (root == null)                        // If the root does not exist, then we cannot print anything
        {
            System.out.println("The head does not exist ");
            return;
        }

        directory Fileptr = root;
        while (Fileptr != null) {
            System.out.print(Fileptr.a);
            System.out.print(" ( Available Space " + Fileptr.availableSpace + " ) " + " --> ");
            Fileptr = Fileptr.forward;
        }
        System.out.print(" NULL \n");
    }

    //Observer
    public boolean doesExist(int temp) {
            if ( root == null) {
                System.out.println("The entire file system does not exist ");
                return false;
            } else if (temp > SIZE) {
                return false;
            }

            directory nodeptr = root;
            for(int count = 0; count < temp; count++ ) {
                    nodeptr = nodeptr.forward;
            }
            return true;


    }

    // Creating a new file
    public void newFile(int temp) {
            if(!doesExist(temp)){
                System.out.println("The Directory does not exist ");
                return;
            }
            directory nodeptr = root;
            for(int count = 0; count < temp; count++) {
                nodeptr = nodeptr.forward;
            }
            int space = nodeptr.file.createFile(nodeptr.count);
            nodeptr.count++;
            while (space > 0) {
                if (504 >= space) {
                    nodeptr.availableSpace = 504 - space;
                    break;
                }
                else {
                    // find next directory that has space
                    nodeptr.availableSpace = 0; // used up
                    nodeptr = nodeptr.forward;

                    space = space - 504;
                    if (nodeptr.file.spaceUsed>0)
                    {
                            space=space+nodeptr.file.spaceUsed;
//                            nodeptr.file.spaceUsed
                    }

//                    space = space - 504;
                    nodeptr.availableSpace = space;
                }
            }
            //pointer overlapping

    }

    public void openDirectory(int temp) {

        if (!doesExist(temp)) {
            System.out.println("The file does not exist ");
            return;
        }

        directory nodeptr = root;
        for (int count = 0; count < temp; count++) {
            nodeptr = nodeptr.forward;
        }

        nodeptr.file.accessFile();
    }

    public void defultFile(String name, int size, int directoryNum) {
        if(!doesExist(directoryNum)) {
            System.out.println("The directory does not exist!!!! ");
            return;
        }

        directory nodeptr = root;
        for(int count = 0; count < directoryNum; count++) {
            nodeptr = nodeptr.forward;
        }
        if(nodeptr.availableSpace < nodeptr.file.spaceUsed && nodeptr.availableSpace < size){
            System.out.println("The size of this file cannot fit in " + nodeptr.count + " directory, moving to another directory");
            nodeptr = nodeptr.forward;
        }
        nodeptr.file.createDefultFile(name, size, nodeptr.count);
        nodeptr.count++;
        if (504- nodeptr.file.spaceUsed>=0) {
            nodeptr.availableSpace = 504 - nodeptr.file.spaceUsed;
        }

        else{
            while(nodeptr.availableSpace<=0) {
                System.out.println("Overflow here, now going into the next directory");
                //450 byte means 450 characters
                nodeptr.availableSpace = 0;
                nodeptr = nodeptr.forward;
                if (nodeptr.availableSpace>=0) {
                    nodeptr.availableSpace = 504 - nodeptr.file.spaceUsed;
                }
                nodeptr.availableSpace=nodeptr.availableSpace-nodeptr.file.spaceUsed;
            }
            System.out.println(nodeptr.availableSpace);
        }
        return;

    }

    public void deletingFile(int directoryNum)
    {
        if(!doesExist(directoryNum)) {
            System.out.println("The directory does not exist ");
            return;
        }
        else if(root == null){ //worst case if the file system is not created..
            System.out.println("There is nothing inside the file system ");
            return;
        }

        directory nodeptr = root;

        for(int i = 0; i < directoryNum; i++){
            nodeptr = nodeptr.forward;
        }

        nodeptr.file.printFile();

        System.out.println("Please enter the file number, and we will delete it: ");
        int fileNum = input.nextInt();

        int excess=nodeptr.file.ExcessSpace(fileNum);

        int space = nodeptr.file.deleteExistingFile(fileNum);
        nodeptr.count--;
        System.out.println("Space: "+ space);

        System.out.println("\nDeleting successful ");

        System.out.println("\nCurrent Status of the Directory -> ");

        nodeptr.file.printFile();

        nodeptr.availableSpace = 504 - space; //space keeping

        int used_space=nodeptr.file.UsedSpace(fileNum);
        int difference=excess-504+used_space;

            while (difference>0){
                nodeptr=nodeptr.forward;
                if (nodeptr.availableSpace+difference>504){
                    nodeptr.availableSpace=504-nodeptr.file.spaceUsed;  //-nodeptr.file.spaceUsed
                }
                else {
                    nodeptr.availableSpace = nodeptr.availableSpace + difference;
                }
                used_space = nodeptr.file.UsedSpace(fileNum);
                difference = difference - 504 + used_space;
            }
//            else
//            {
//                nodeptr.availableSpace = 504 - space;
//            }
//            difference=excess-504+used_space;



    }

}



