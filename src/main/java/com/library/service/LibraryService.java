package com.library.service;
import com.library.model.Book;
import java.util.*;
public class LibraryService {
    ArrayList<Book> books=new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
        System.out.println("Book addded"+b.getTitle());
    }
    public Book searchbook(String id){
        for(Book b:books){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }
    public Book removebook(String id){
        for(Book b:books){
            if(b.getId().equals(id)){
                books.remove(b);
                return b;
            }
        }
        return null;
    }
    public ArrayList<Book> getAllBooks() {
        return books;
    }
    public Boolean exists(String id){
        for(Book b:books){
            if(b.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public Boolean update(String id,String newTitle){
        for (Book b:books){
            if(b.getId().equals(id)){
                b.setTitle(newTitle);
                return true;
            }
        }
        return false;
    }
    public Boolean updateauthor(String id,String newAuthor){
        for (Book b:books){
            if(b.getId().equals(id)){
                b.setAuthor(newAuthor);
                return true;
            }
        }
        return false;
    }



}
