package com.library.app;
import com.library.app.LibraryApp;
import com.library.model.Book;
import com.library.service.LibraryService;
import java.util.*;
public class LibraryApp {
    public static void main(String[] args){
        LibraryService service=new LibraryService();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                Book b=new Book();
                System.out.print("Enter Book ID: ");
                b.id = sc.nextLine();

                System.out.print("Enter Title: ");
                b.title = sc.nextLine();

                System.out.print("Enter Author: ");
                b.author = sc.nextLine();
                service.addBook(b);
            } else if (choice==2) {
                System.out.print("Enter The Book ID U Want To Search: ");
                String id=sc.nextLine();
                Book result= service.searchbook(id);
                if(result!=null){
                    System.out.println("Found: " + result.title + " by " + result.author);
                }else {
                    System.out.println("Book not found");
                }
            } else if (choice==3) {
                System.out.print("Enter Book ID to remove: ");
                String id = sc.nextLine();
                Book rem= service.removebook(id);
                if (rem != null) {
                    System.out.println("Removed: " + rem.title);
                } else {
                    System.out.println("Book not found");
                }
            }else if (choice == 4) {
                System.out.println("\nAll Books:");

                ArrayList<Book> list = service.getAllBooks();

                for (Book b : list) {
                    System.out.println(b.id + " - " + b.title + " - " + b.author);
                }
            } else if (choice==5) {
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
