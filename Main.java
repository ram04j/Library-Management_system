// package EASY.LIBRARYMANAGEMENT;

import java.util.*;
class Books {
    private String bookName;
    private String author;
    private int token;
    private int price;

    Books(String bookName,String author,int token,int price){
        this.bookName = bookName;
        this.author = author;
        this.token =token;
        this.price = price;
    }

    public String getBookName(){
        return bookName;
    }
    public String getBookAuthor(){
        return author;
    }
    public int getBookToken(){
        return token;
    }
    public int getBookPrice(){
        return price;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setBookAuthor(String author){
        this.author = author;
    }
    public void setBookToken(int token){
        this.token = token;
    }
    public void setBookPrice(int price){
        this.price = price;
    }
    public void display() {
        System.out.println("BookName : " + bookName + ", BookAuthor : " + author + ", BookToken : " + token + ", BookPrice : " + price);
    }

}
class BooksMangement{
    ArrayList<Books> list  = new ArrayList<>();
    public void addBooks(String bookName,String author,int token,int price){
        list.add(new Books(bookName, author, token, price));
        System.out.println("books Successfully added");
    }

    public void viewAllBooks(){
        if(list.isEmpty()){
            System.out.println("No Books in the library");
        }
        else{
            for(Books s :list){
                s.display();
            }
        }
    }

    public Books searchBook(int token){
        for(Books s : list){
            if(s.getBookToken()==token){
                return s;
            }
        }
        return null;
    }

    public void updateBooks(String BookName,String author,int token,int price){
        Books s = searchBook(token);
        if(s!=null){
            s.setBookName(BookName);
            s.setBookAuthor(author);
            s.setBookToken(token);
            System.out.println("books are updated successfully");
        }
        System.out.println("books not found");
    }

    public void deleteBooks(int token){
        Books s = searchBook(token);
        if(s!=null){
            list.remove(s);
            System.out.println("Books deleted successfully");
        }
        else{
            System.out.println("books not found");
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BooksMangement o = new BooksMangement();

        while (true) {
            System.out.println("\n---BooksManagement System----");
            System.out.println("1. Add Students");
            System.out.println("2. ViewAll Students");
            System.out.println("3. Search Students");
            System.out.println("4. Update Students");
            System.out.println("5. Delete Student");
            System.out.println("come out from library");
            System.out.println("enter the option");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter BookName: ");
                    sc.nextLine(); 
                    String name = sc.nextLine();
                    System.out.print("Enter BookAuthor: ");
                    String author = sc.nextLine();
                    System.out.print("Enter token: ");
                    int token= sc.nextInt();
                    System.out.print("Enter price: ");
                    int price = sc.nextInt();
                    o.addBooks(name, author, token, price);
                    break;
                case 2:
                    o.viewAllBooks();
                    break;
                case 3:
                    System.out.println("enter the bookname you want: ");
                    Books b = o.searchBook(sc.nextInt());
                    if(b!=null){
                        b.display();
                    }
                    else{
                        System.out.println("books not found");
                    }
                
                case 4:
                    System.out.print("Enter token you want to update: ");
                    int t= sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter New BookName: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter NewBookAuthor: ");
                    String newauthor = sc.nextLine();
                    System.out.print("Enter NewPrice: ");
                    int newprice = sc.nextInt();
                    o.updateBooks(newName, newauthor, t, newprice);
                    break;

                case 5:
                    System.out.println("enter the token you want to delete");
                    o.deleteBooks(sc.nextInt());
                    break;

                case 6:
                    System.out.println("get out from library");
                    sc.close();
                    break;
                default:
                    System.out.println("enter the correct option");
            }

        }
    }
}
