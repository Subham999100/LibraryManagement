package com.library.service;
import com.library.model.Book;
import java.util.*;
public class LibraryService {
    ArrayList<Book> books=new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
        System.out.println("Book addded"+b.title);
    }
    public Book searchbook(String id){
        for(Book b:books){
            if(b.id.equals(id)){
                return b;
            }
        }
        return null;
    }
    public Book removebook(String id){
        for(Book b:books){
            if(b.id.equals(id)){
                books.remove(b);
                return b;
            }
        }
        return null;
    }
    public ArrayList<Book> getAllBooks() {
        return books;
    }


}
