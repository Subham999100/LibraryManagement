package com.library.app;
import com.library.model.Book ;
import com.library.service.LibraryService;

public class TestBook {
  public static void main(String[] args){
      Book b1=new Book();
      Book b2=new Book();
      LibraryService l1=new LibraryService();
      b1.id="101";
      b1.title="Atomic habits";
      b1.author="Subham patnaik";
      b2.id="102";
      b2.title="rich dad";
      b2.author="jamees";
      l1.addBook(b2);

      l1.addBook(b1);

      Book result=l1.searchbook("102");
      if(result!=null){
          System.out.println("Found "+ result.title+result.author);
      }else{
          System.out.println("Not found");
      }
      Book rem=l1.removebook("101");
      if(rem!=null){
          System.out.println("book removed "+ result.title);
      }else{
          System.out.println("Book Not Found");
      }
  }
}
