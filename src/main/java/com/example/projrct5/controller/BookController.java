package com.example.projrct5.controller;

import com.example.projrct5.model.Book;
import com.example.projrct5.model.Store;
import com.example.projrct5.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

   @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookService.books();
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book){
        bookService.addBook(book);
       return ResponseEntity.status(200).body("Added done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Book book){
        Boolean res=bookService.update(id,book);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Update Is Done ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean res=bookService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Delete Is Done ");
    }
    @PutMapping("/{storeId}/book/{bookid}")
    public ResponseEntity assignToStre(@PathVariable Integer storeId,@PathVariable Integer bookid){
       Boolean res=bookService.assiginToStore(storeId,bookid);
       if(!res){
           return ResponseEntity.status(400).body("The id store or book is not correct");
       }
       return ResponseEntity.status(200).body("The assign is Done ");
    }
    @GetMapping("/getByStore/{id}")
    public ResponseEntity getBooksByStore(@PathVariable Integer id){
       List<Book> books=bookService.getBooksByStore(id);
       return ResponseEntity.status(200).body(books);
    }
@GetMapping("/bookAvailble/{id}")
    public ResponseEntity numberOfBooksAvailable(@PathVariable Integer id){
       Book b=bookService.getBook(id);
       if(b==null){
           return ResponseEntity.status(400).body("The id is not correct ");
       }
       return ResponseEntity.status(200).body("The number of books available is "+b.getBookCount());
    }

    @GetMapping("/bookInformation/{id}")
    public ResponseEntity InformationBook(@PathVariable Integer id){
        Book b=bookService.getBook(id);
        if(b==null){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body(b);
    }
@GetMapping("/getByGenre/{grn}")
    public ResponseEntity getByGenrn(@PathVariable String grn){
       List<Book> books=bookService.byGenre(grn);
       return  ResponseEntity.status(200).body(books);
    }


}
