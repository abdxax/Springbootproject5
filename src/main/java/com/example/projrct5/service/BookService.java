package com.example.projrct5.service;

import com.example.projrct5.hadking.ApiException;
import com.example.projrct5.model.Book;
import com.example.projrct5.model.Store;
import com.example.projrct5.repstory.BookRepstory;
import com.example.projrct5.repstory.StoreRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepstory bookRepstory;
    private final StoreRepstory storeRepstory;
    public List<Book> books(){
        return bookRepstory.findAll();
    }

    public void addBook(Book book){
        bookRepstory.save(book);
    }


    public Boolean update(Integer id,Book book ){
        Book s=bookRepstory.findByIdEquals(id);
        if(s==null){
            return  null;
        }
        s.setName(book.getName());
        s.setGenre(book.getGenre());
        s.setBookCount(book.getBookCount());
        s.setStore(book.getStore());
        bookRepstory.save(s);
        return true;
    }

    public Boolean delete(Integer id){
        Book s=bookRepstory.findByIdEquals(id);
        if(s==null){
            return  null;
        }
        bookRepstory.delete(s);
        return true;
    }

    public Boolean assiginToStore(Integer storeId,Integer bookId){
        Store store=storeRepstory.findByIdEquals(storeId);
        Book book=bookRepstory.findByIdEquals(bookId);
        if(store==null||book==null){
            return false;
        }
        book.setStore(store);
        bookRepstory.save(book);
        return true;
    }

    public List<Book> getBooksByStore(Integer id){
        return bookRepstory.findByStore_Id(id);
    }

    public Book getBook(Integer id){
        Book b=bookRepstory.findByIdEquals(id);
        if(b==null){
            throw new ApiException("The id is not correct ");
        }
        return b;
    }

    public List<Book> byGenre(String GEN){
        List<Book> books=bookRepstory.findByGenre(GEN);
        return books;
    }
}
