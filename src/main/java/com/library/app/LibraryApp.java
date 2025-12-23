package com.library.app;
import com.library.app.LibraryApp;
import com.library.model.Book;
import com.library.service.LibraryService;
import java.util.*;
public class LibraryApp {
    public static void main(String[] args){
        LibraryService service=new LibraryService();
        service.loadfromfile();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Edit");
            System.out.println("6.Search books by author");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.print("Enter Book ID: ");
                String id = sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author: ");
                if(service.exists(id)){
                    System.out.println("Book already exists");
                    continue;
                }
                String author = sc.nextLine();
                Book b=new Book(id,title,author);
                service.addBook(b);
            } else if (choice==2) {
                System.out.print("Enter The Book ID U Want To Search: ");
                String id=sc.nextLine();
                Book result= service.searchbook(id);
                if(result!=null){
                    System.out.println("Found: " + result.getTitle() + " by " + result.getAuthor());
                }else {
                    System.out.println("Book not found");
                }
            } else if (choice==3) {
                System.out.print("Enter Book ID to remove: ");
                String id = sc.nextLine();
                Book rem= service.removebook(id);
                if (rem != null) {
                    System.out.println("Removed: " + rem.getTitle());
                } else {
                    System.out.println("Book not found");
                }
            }else if (choice == 4) {
                System.out.println("\nAll Books:");

                ArrayList<Book> list = service.getAllBooks();

                for (Book b : list) {
                    System.out.println(b);
                }
            } else if (choice==7) {
                System.out.println("Exiting...");
                break;
            } else if (choice==5) {
                System.out.println("Enter the book id u want to edit");
                String id= sc.nextLine();
                Book result=service.searchbook(id);
                if(result==null){
                    System.out.println("Book Not Found");
                    continue;
                }
                System.out.println("What do you want to update?");
                System.out.println("1. Title");
                System.out.println("2. Author");
                int opt=sc.nextInt();
                sc.nextLine();
                if (opt == 1) {
                    System.out.print("Enter new Title: ");
                    String newTitle = sc.nextLine();
                    service.update(id, newTitle);
                    System.out.println("Title updated!");
                }
                else if (opt == 2) {
                    System.out.print("Enter new Author: ");
                    String newAuthor = sc.nextLine();
                    service.updateauthor(id, newAuthor);
                    System.out.println("Author updated!");
                }
                else {
                    System.out.println("Invalid option.");
                }
            } else if (choice==6) {
                System.out.println("Enter author name");
                String keyword=sc.nextLine();
                ArrayList<Book> found=service.searchbyAuthor(keyword);
                if(found.isEmpty()){
                    System.out.println("NO books found for this author");
                }else{
                    System.out.println("Books by matching author");
                    for(Book b:found){
                        System.out.println(b);
                    }
                }

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
