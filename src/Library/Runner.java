package Library;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the system!");
        while(run());
        System.out.println("Thanks for using the system! Goodbye!");
    }
    private static boolean run() {
        System.out.println("\nChoose what you would like to do :\n1- List the products\n2- Add product\n3-remove product\n4-Quit the system");
        Scanner scanner = new Scanner(System.in);
        do{
            int x = scanner.nextInt();
            if(x==1){
                System.out.println("Which one would you like to list?\n1-the books \nthe notebooks");
                int y = scanner.nextInt();
                do{
                    if(y==1){
                        Book.getList();
                        break;
                    }else if(y==2){
                        NoteBook.getList();
                        break;
                    }else{
                        System.out.println("Please enter a valid value!");
                    }
                }while(true);
                break;
            }else if(x==2){
                System.out.println("What would you like to add?\n1-a book \na notebook");
                int y = scanner.nextInt();
                do{
                    if(y==1){
                        while(!Book.addBook());
                        break;
                    }else if(y==2){
                        while(!NoteBook.addNoteBook());
                        break;
                    }else{
                        System.out.println("Please enter a valid value!");
                    }
                }while(true);
                break;
            }else if(x==3){
                System.out.println("What would you like to remove?\n1-a book \na notebook");
                int y = scanner.nextInt();
                String name;
                do{
                    if(y==1){
                        do{
                            System.out.println("Write the name of the book");
                            name = scanner.nextLine();
                        }while(!Book.removeBook(name));
                        break;
                    }else if(y==2){
                        do{
                            System.out.println("Write the name of the notebook");
                            name = scanner.nextLine();
                        }while (!NoteBook.removeNoteBook(name));
                        break;
                    }else{
                        System.out.println("Please enter a valid value!");
                    }
                }while(true);
                break;
            }else if(x==4){
                return false;
            }else{
                System.out.println("Please enter a valid value!");
            }
        }while(true);
        return true;
    }
}
