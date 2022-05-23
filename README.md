File Management System 

This project is based on an linked list having arrays in it. So, the directories are a linked list, and the files are the arrays inside that linked list node/directory.   

1)	Create a new file system using option 1. It by default creates new 10 fresh directories Option 2 will give an error if run, in different system because it requires to load a  “downloaded” file system (in the form of .txt file). (if you want 35 or 50 directories that is just easy to change value in variable). And as it has 10 directories total disk size is 5000.

 
![image](https://user-images.githubusercontent.com/63224856/169729405-8dcd0263-2c03-4f99-8da6-b962d5e6a8c7.png)

			

2)	It asks user to choose which directory it wants to store file. Each directory has a current size of 504. After choosing directory it will give you options on what you want to do like creating a new file or manipulating with any of the options as shown below.

![image](https://user-images.githubusercontent.com/63224856/169729653-a7124697-fc02-44e4-81fa-6fec12bbb4c2.png)


3)	Now, as I know that there is no file to delete as this scratch so,  I am basicallyn now choosing the option of creating a new file. I have implemented dynamic memory allocation so, it asks user how much space it should allocate in the disk. I assigned a name to it and gave the data stored inside it.

 ![image](https://user-images.githubusercontent.com/63224856/169729627-b55eac63-7750-439d-9bae-8c4a5d459826.png)


4)	 Now, it gives me back to the directory 0, and asks me on what command to do. So, I will repeat the same process and another file of size 100 in the next directory. So,if I see the status of the directory I am able to see it reducing the memory of the directory.

 ![image](https://user-images.githubusercontent.com/63224856/169729616-e4106d6e-25c7-4d44-a99a-194b98bab430.png)



5)	Now, if I want to print I can use the option and it will print all the contents of that specific file, I wish to select.
![image](https://user-images.githubusercontent.com/63224856/169729603-8ba0b9e3-ba1d-40bf-8c2b-0063a61807e7.png)
 
6)	Now, I am going to the toughest part of this assignment, so I am creating a file in directory 0 and it is of Size 1200. This means I will be accomating memory from the other directories and will so on do till it accomodates 1200 in total. And the picture clearly shows, that it is using the space of the other directories.

![image](https://user-images.githubusercontent.com/63224856/169729578-b288bf08-9de0-4a2f-89ef-ff80e8ba02f3.png)



7)	So, now I delete the polar file then it should give me back the memory I need. Which means the memories of directories are deallocated and now should be able to restore the memory that was occupied by the file of 1200 after deleting the file.

![image](https://user-images.githubusercontent.com/63224856/169729570-638104bc-3dd2-487d-b491-5554ed7eca79.png)

8)	So, it is working perfectly and restoring back the space. You might be thinking why directory 1 is 404 and not 504 this is because that directory has a file which is of size 100 (I showed it on the top). To keep the user updated, I programmed it to tell the user of the remaining in the files left in that specific directory.

   
![image](https://user-images.githubusercontent.com/63224856/169729551-b7eb6b3d-d967-45cb-a1ad-8d6f66dfd8ee.png)


9)	So, the important part is to safely exit the program. So, I chose an option to quit it and safely terminates the program.

 
![image](https://user-images.githubusercontent.com/63224856/169729544-08ba3e00-fe46-47f0-b348-518b78375f4a.png)


