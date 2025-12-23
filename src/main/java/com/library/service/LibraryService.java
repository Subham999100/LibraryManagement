package com.library.service;
import com.library.model.Book;
import java.util.*;
import java.io.*;
public class LibraryService {
    ArrayList<Book> books=new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
        savetofile();
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
                savetofile();
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

    public ArrayList<Book> searchbyAuthor(String keyword) {
        ArrayList<Book> result=new ArrayList<>();
        for(Book b:books){
            if(b.getAuthor().toLowerCase().contains(keyword.toLowerCase())){
                result.add(b);
            }
        }
        return result;
    }
    public void savetofile(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("books.txt"))){
            for(Book b:books){
                String line=b.getId()+","+b.getTitle()+","+b.getAuthor();
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("Error saving books to file");
        }
    }
    public  void loadfromfile(){
        File file=new File("books.txt");
        if(!file.exists()) return;
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            while((line= br.readLine())!=null){
                String[] parts=line.split(",");
                String id=parts[0];
                String title=parts[1];
                String author=parts[2];
                Book b=new Book(id,title,author);
                books.add(b);
            }
        }catch (IOException e){
            System.out.println("Error loading books from file");
        }
    }
}
