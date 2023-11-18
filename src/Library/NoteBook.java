package Library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class NoteBook {
    String name;
    String id;
    int price;
    String brand;
    int pageCount;
    String productId;
    String value;

    @Override
    public String toString() {
        return value;
    }

    public boolean equals(NoteBook o) {
        return this.value.equals(o.value);
    }

    public NoteBook(String name, String id, int price, String brand, int pageCount, String productId) {
        stock++;
        this.name = name;
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.pageCount = pageCount;
        this.productId = productId;
        this.value = "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", productId='" + productId;
        list.add(this);
    }

    static int stock;
    static LinkedList<NoteBook> list = new LinkedList<>();

    static void getList(){
        int count = 1;
        for(NoteBook b : list){
            System.out.println(count+" - "+b);
            count++;
        }
    }

    public static boolean addNoteBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the name of the notebook");
        String name = scanner.nextLine();
        System.out.println("Write the id of the notebook");
        String id = scanner.nextLine();
        System.out.println("Write the price of the notebook");
        int price = scanner.nextInt();
        System.out.println("Write the brand of the notebook");
        String brand = scanner.nextLine();
        brand = scanner.nextLine();
        System.out.println("Write the page count of the notebook");
        int pageCount = scanner.nextInt();
        System.out.println("Write the product id of the notebook");
        String productId = scanner.nextLine();

        NoteBook obj = new NoteBook(name,id,price,brand,pageCount,productId);

        for(int i = 0; i<list.size()-1; i++){
            if(obj.equals(list.get(i))){
                System.out.println("such a notebook is already saved, please try again!");
                list.remove(list.size()-1);
                obj = null;
                stock--;
                return false;
            }
        }
        return true;
    }

    public static boolean removeNoteBook(String s){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        int indexes = 0;
        for(NoteBook b : list){
            if(b.value.contains(s)){
                array.add(indexes);
            }
            indexes++;
        }
        if(array.size()==0){
            System.out.println("No matches found! Please try again.");
            return false;
        }else if(array.size()==1){
            int toBeRemoved = array.get(0);
            System.out.println("One result found, would you like to remove this?(1-yes,2-no)");
            System.out.println(list.get(toBeRemoved));
            int x = scanner.nextInt();
            do{
                if(x==1){
                    list.remove(toBeRemoved);
                    System.out.println("Successfully removed!");
                    return true;
                }else if(x==2){
                    return true;
                }else{
                    System.out.println("Invalid entry, try again!");
                }
            }while(true);
        }else{
            System.out.println("Multiple results found, choose the one by the number to remove :");
            int number = 1;
            for(Integer w : array){
                System.out.println(number+" - "+list.get(w));
                number++;
            }
            do{
                int chosen = scanner.nextInt();
                if(chosen>=1 && chosen<=number){
                    System.out.println("Would you like to remove this?(1-yes,2-no)");
                    int cc = scanner.nextInt();
                    do{
                        if(cc==1){
                            int toBeRemoved =array.get(chosen-1);
                            list.remove(toBeRemoved);
                            return true;
                        }else if(cc==2){
                            return true;
                        }else{
                            System.out.println("Invalid entry, try again!");
                        }
                    }while(true);
                }else{
                    System.out.println("There is no such a numbered book to remove, try again");
                }
            }while(true);
        }
    }
}
